package com.github.warrentode.turtleblockacademy.world.spawner.herobrine;

import com.github.warrentode.turtleblockacademy.entity.TBAEntityTypes;
import com.github.warrentode.turtleblockacademy.entity.custom.Herobrine;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.Heightmap;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class HerobrineSpawner implements CustomSpawner {
    private final HerobrineData herobrineData;
    private final EntityType<Herobrine> herobrine;
    private static final int tickDelayBeforeSpawn = 1200;
    public static final int defaultSpawnDelay = 24000;
    public static final int defaultDespawnDelay = 48000;
    private static final int minSpawnChance = 25;
    private static final int maxSpawnChance = 75;
    private static final int spawnChanceIncrease = minSpawnChance;
    private static final int spawnAttempts = 10;
    private static final int OneInXChanceToSpawn = spawnAttempts;
    private final RandomSource random = RandomSource.create();
    private int tickDelay;
    private int spawnDelay;
    private int spawnChance;

    public HerobrineSpawner(@NotNull MinecraftServer server, String key, EntityType<Herobrine> herobrine) {
        this.herobrineData = HerobrineSavedData.get(server).getHerobrineData(key);
        this.herobrine = herobrine;
        this.tickDelay = tickDelayBeforeSpawn;
        this.spawnDelay = herobrineData.getHerobrineSpawnDelay();
        this.spawnChance = herobrineData.getHerobrineSpawnChance();
        if (this.spawnDelay == 0 && this.spawnChance == 0) {
            this.spawnDelay = defaultSpawnDelay;
            herobrineData.setHerobrineSpawnDelay(this.spawnDelay);
            this.spawnChance = minSpawnChance;
            herobrineData.setHerobrineSpawnChance(this.spawnDelay);
        }
    }

    @Override
    public int tick(@NotNull ServerLevel serverLevel, boolean spawnHostiles, boolean spawnPassives) {
        if (!serverLevel.getGameRules().getBoolean(GameRules.RULE_DO_TRADER_SPAWNING)) {
            return 0;
        }
        else if (--this.tickDelay > 0) {
            return 0;
        }
        else {
            this.tickDelay = tickDelayBeforeSpawn;
            this.spawnDelay -= tickDelayBeforeSpawn;
            this.herobrineData.setHerobrineSpawnDelay(this.spawnDelay);
            if (this.spawnDelay > 0) {
                return 0;
            }
            else {
                this.spawnDelay = defaultSpawnDelay;
                if (!serverLevel.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING)) {
                    return 0;
                }
                else {
                    int i = this.spawnChance;
                    this.spawnChance = Mth.clamp(this.spawnChance + spawnChanceIncrease, minSpawnChance, maxSpawnChance);
                    this.herobrineData.setHerobrineSpawnChance(this.spawnChance);
                    if (this.random.nextInt(100) > i) {
                        return 0;
                    }
                    else if (this.spawn(serverLevel)) {
                        this.spawnChance = minSpawnChance;
                        return 1;
                    }
                    else {
                        return 0;
                    }
                }
            }
        }
    }

    private boolean spawn(@NotNull ServerLevel serverLevel) {
        Player player = serverLevel.getRandomPlayer();
        if (player == null) {
            return true;
        }
        else if (this.random.nextInt(OneInXChanceToSpawn) != 0) {
            return false;
        }
        else {
            BlockPos playerPos = player.blockPosition();
            int maxDistance = 16;
            BlockPos positionNear = this.findSpawnPositionNear(serverLevel, playerPos, maxDistance);
            if (positionNear != null && this.hasEnoughSpace(serverLevel, positionNear)) {
                if (serverLevel.getBiome(positionNear).is(Biomes.THE_VOID)) {
                    return false;
                }

                Herobrine trader = TBAEntityTypes.HEROBRINE.get().spawn(serverLevel, null,
                        null, null, positionNear, MobSpawnType.EVENT, false, false);
                if (trader != null) {
                    trader.setDespawnDelay(defaultDespawnDelay);
                    trader.setWanderTarget(positionNear);
                    trader.restrictTo(positionNear, maxDistance);
                    return true;
                }
            }

            return false;
        }
    }

    @Nullable
    private BlockPos findSpawnPositionNear(LevelReader reader, BlockPos pos, int maxDistance) {
        BlockPos blockPos = null;

        for (int i = 0; i < spawnAttempts; ++i) {
            int j = pos.getX() + this.random.nextInt(maxDistance * 2) - maxDistance;
            int k = pos.getZ() + this.random.nextInt(maxDistance * 2) - maxDistance;
            int l = reader.getHeight(Heightmap.Types.WORLD_SURFACE, j, k);
            BlockPos blockPos1 = new BlockPos(j, l, k);
            if (NaturalSpawner.isSpawnPositionOk(SpawnPlacements.Type.ON_GROUND, reader, blockPos1, TBAEntityTypes.HEROBRINE.get())) {
                blockPos = blockPos1;
                break;
            }
        }

        return blockPos;
    }

    private boolean hasEnoughSpace(BlockGetter getter, BlockPos pos) {
        for (BlockPos pos1 : BlockPos.betweenClosed(pos, pos.offset(1, 2, 1))) {
            if (!getter.getBlockState(pos1).getCollisionShape(getter, pos1).isEmpty()) {
                return false;
            }
        }

        return true;
    }
}
