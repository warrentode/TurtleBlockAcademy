package com.github.warrentode.turtleblockacademy.entity.custom;

import com.github.warrentode.turtleblockacademy.util.TBASounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.npc.Npc;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class Herobrine extends PathfinderMob implements Npc {
    private static final EntityDataAccessor<Integer> DATA_IDLE_TIME =
            SynchedEntityData.defineId(Herobrine.class, EntityDataSerializers.INT);
    public static final AnimationState walkAnimationState = new AnimationState();
    public static final AnimationState idleAnimationState = new AnimationState();
    private int idleTimer;
    private boolean invulnerable;
    private boolean silent;
    @Nullable
    private BlockPos wanderTarget;
    private int despawnDelay;

    public Herobrine(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
        this.invulnerable = true;
        this.silent = true;
        this.idleTimer = 0;
    }

    protected int getIdleTime() {
        return this.entityData.get(DATA_IDLE_TIME);
    }

    public void setIdleTime(int idleTime) {
        this.entityData.set(DATA_IDLE_TIME, idleTime);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_IDLE_TIME, 0);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(3, new InteractGoal(this, Player.class, 32.0F, 1.0F));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Mob.class, 32.0F));
        this.goalSelector.addGoal(5, new WanderToPositionGoal(this, 2.0, 0.35));
        this.goalSelector.addGoal(6, new MoveTowardsRestrictionGoal(this, 0.35));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 0.35));
        this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
    }

    public static @NotNull AttributeSupplier setAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 100)
                .add(Attributes.FOLLOW_RANGE, 50)
                .add(Attributes.MOVEMENT_SPEED, 0.5).build();
    }

    protected SoundEvent getAmbientSound() {
        return TBASounds.HEROBRINE_AMBIENT.get();
    }

    @Override
    public int getAmbientSoundInterval() {
        return 1280;
    }

    @Override
    protected boolean isAffectedByFluids() {
        return false;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    protected void doPush(@NotNull Entity entityIn) {}

    @Override
    protected void pushEntities() {}

    @Override
    public boolean canBeAffected(@NotNull MobEffectInstance mobEffectInstance) {
        return false;
    }

    @Override
    public boolean isAttackable() {
        return false;
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag tag) {
        tag.putBoolean("Silent", this.silent);
        tag.putBoolean("Invulnerable", this.invulnerable);
        tag.putInt("DespawnDelay", this.despawnDelay);
        if (this.wanderTarget != null) {
            tag.put("WanderTarget", NbtUtils.writeBlockPos(this.wanderTarget));
        }
        super.addAdditionalSaveData(tag);
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.silent = tag.getBoolean("Silent");
        this.invulnerable = tag.getBoolean("Invulnerable");
        if (tag.contains("DespawnDelay", 99)) {
            this.despawnDelay = tag.getInt("DespawnDelay");
        }
        if (tag.contains("WanderTarget")) {
            this.wanderTarget = NbtUtils.readBlockPos(tag.getCompound("WanderTarget"));
        }
    }

    public void setDespawnDelay(int pDespawnDelay) {
        this.despawnDelay = pDespawnDelay;
    }

    public int getDespawnDelay() {
        return this.despawnDelay;
    }

    public void aiStep() {
        while (this.despawnDelay > 0) {
            despawnDelay--;
        }
        while (this.getIdleTime() > 0 && this.idleTimer > 0) {
            idleTimer--;
            setIdleTime(idleTimer--);
        }

        if (this.isMovingOnLand()) {
            walkAnimationState.startIfStopped(this.tickCount);
        }
        else {
            walkAnimationState.stop();
            idleTimer = this.random.nextInt(40) + 80;
        }
        if (--idleTimer > 0) {
            idleAnimationState.startIfStopped(this.tickCount);
        }
        else {
            idleAnimationState.stop();
        }

        if (!this.level.isClientSide) {
            this.maybeDespawn();
        }

        super.aiStep();
    }

    private boolean isMovingOnLand() {
        return this.onGround && this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6 && !this.isInWaterOrBubble();
    }

    private void maybeDespawn() {
        if (getDespawnDelay() > 0 && --this.despawnDelay == 0) {
            this.discard();
        }
    }

    public void setWanderTarget(@Nullable BlockPos pWanderTarget) {
        this.wanderTarget = pWanderTarget;
    }

    @Nullable
    BlockPos getWanderTarget() {
        return this.wanderTarget;
    }

    class WanderToPositionGoal extends Goal {
        final Herobrine herobrine;
        final double stopDistance;
        final double speedModifier;

        WanderToPositionGoal(Herobrine herobrine, double stopDistance, double speedModifier) {
            this.herobrine = herobrine;
            this.stopDistance = stopDistance;
            this.speedModifier = speedModifier;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public void stop() {
            this.herobrine.setWanderTarget(null);
            Herobrine.this.navigation.stop();
        }

        public boolean canUse() {
            BlockPos pos = this.herobrine.getWanderTarget();
            return pos != null && this.isTooFarAway(pos, this.stopDistance);
        }

        public void tick() {
            BlockPos pos = this.herobrine.getWanderTarget();
            if (pos != null && Herobrine.this.navigation.isDone()) {
                if (this.isTooFarAway(pos, 10.0)) {
                    Vec3 normalize = (new Vec3((double)pos.getX() - this.herobrine.getX(), (double)pos.getY() - this.herobrine.getY(), (double)pos.getZ() - this.herobrine.getZ())).normalize();
                    Vec3 added = normalize.scale(10.0).add(this.herobrine.getX(), this.herobrine.getY(), this.herobrine.getZ());
                    Herobrine.this.navigation.moveTo(added.x, added.y, added.z, this.speedModifier);
                } else {
                    Herobrine.this.navigation.moveTo(pos.getX(), pos.getY(), pos.getZ(), this.speedModifier);
                }
            }

        }

        private boolean isTooFarAway(@NotNull BlockPos pos, double distance) {
            return !pos.closerToCenterThan(this.herobrine.position(), distance);
        }
    }
}