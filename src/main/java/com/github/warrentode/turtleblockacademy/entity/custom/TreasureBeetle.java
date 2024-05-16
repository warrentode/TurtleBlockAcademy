package com.github.warrentode.turtleblockacademy.entity.custom;

import com.github.warrentode.turtleblockacademy.loot.tables.PackBuiltInLootTables;
import com.github.warrentode.turtleblockacademy.util.TBASounds;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.MinecraftServer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TreasureBeetle extends Monster {
    private static final EntityDataAccessor<Integer> DATA_TREASURE_TIME =
            SynchedEntityData.defineId(TreasureBeetle.class, EntityDataSerializers.INT);
    public static final AnimationState walkAnimationState = new AnimationState();
    public static final AnimationState idleAnimationState = new AnimationState();
    private int idleTimer;
    private int treasureTime;
    private float health;


    public TreasureBeetle(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.idleTimer = 0;
        this.treasureTime = 0;
        this.health = getHealth();
    }

    protected int getTreasureTime() {
        return this.entityData.get(DATA_TREASURE_TIME);
    }

    public void setTreasureTime(int treasureTime) {
        this.entityData.set(DATA_TREASURE_TIME, treasureTime);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_TREASURE_TIME, 0);
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Player.class, 16.0F, 1.0, 1.5));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
    }

    public static @NotNull AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.MOVEMENT_SPEED, 0.25).build();
    }

    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return TBASounds.TREASURE_BEETLE_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return TBASounds.TREASURE_BEETLE_DEATH.get();
    }

    protected SoundEvent getAmbientSound() {
        return TBASounds.TREASURE_BEETLE_AMBIENT.get();
    }

    protected void playStepSound(@NotNull BlockPos pos, @NotNull BlockState state) {
        this.playSound(TBASounds.TREASURE_BEETLE_AMBIENT.get(), 0.15F, 1.0F);
    }

    public @NotNull MobType getMobType() {
        return MobType.ARTHROPOD;
    }

    public void aiStep() {
        while (getTreasureTime() > 0 && treasureTime > 0) {
            treasureTime--;
            setTreasureTime(treasureTime--);
        }
        while (this.idleTimer > 0) {
            idleTimer--;
        }

        if (!level.isClientSide) {
            if (getTreasureTime() <= 0) {
                walkAnimationState.stop();
                this.playSound(TBASounds.TREASURE_BEETLE_ITEM_DROP.get(), 1.0F,
                        (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);

                MinecraftServer minecraftServer = this.level.getServer();
                if (minecraftServer != null) {
                    LootTable gemTable = minecraftServer.getLootTables()
                            .get(PackBuiltInLootTables.TREASURE_BEETLE_ITEM_DROPS);

                    LootContext lootContext = new LootContext.Builder(minecraftServer.createCommandSourceStack().getLevel())
                            .withParameter(LootContextParams.ORIGIN, this.position())
                            .withParameter(LootContextParams.THIS_ENTITY, this)
                            .withRandom(this.level.random).create(LootContextParamSets.GIFT);

                    List<ItemStack> selected = gemTable.getRandomItems(lootContext);
                    ItemStack droppedGem = new ItemStack(
                            selected.get(random.nextInt(selected.size())).getItem(), 1);
                    this.spawnAtLocation(droppedGem);
                }
                else {
                    this.spawnAtLocation(Items.CLAY_BALL);
                }
                this.gameEvent(GameEvent.ENTITY_PLACE);
                setTreasureTime(random.nextInt(6000) + 6000);
                if (health >= 0) {
                    this.health = getHealth() - 1;
                }
                idleTimer = this.random.nextInt(40) + 80;
            }
        }
        if (--idleTimer > 0) {
            idleAnimationState.startIfStopped(this.tickCount);
        }
        else {
            idleAnimationState.stop();
        }
        if (this.isMovingOnLand()) {
            walkAnimationState.startIfStopped(this.tickCount);
        }
        else {
            walkAnimationState.stop();
            idleTimer = this.random.nextInt(40) + 80;
        }

        super.aiStep();
    }

    private boolean isMovingOnLand() {
        return this.onGround && this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6 && !this.isInWaterOrBubble();
    }
}
