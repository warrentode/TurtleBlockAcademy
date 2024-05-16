package com.github.warrentode.turtleblockacademy.world.spawner.herobrine;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import org.jetbrains.annotations.NotNull;

public class HerobrineData {
    private final HerobrineSavedData herobrineSavedData;
    private int herobrineSpawnDelay;
    private int herobrineSpawnChance;

    public HerobrineData(HerobrineSavedData herobrineSavedData) {
        this.herobrineSavedData = herobrineSavedData;
    }

    public void setHerobrineSpawnDelay(int herobrineSpawnDelay) {
        this.herobrineSpawnDelay = herobrineSpawnDelay;
        this.herobrineSavedData.setDirty(true);
    }

    public void setHerobrineSpawnChance(int herobrineSpawnChance) {
        this.herobrineSpawnChance = herobrineSpawnChance;
        this.herobrineSavedData.setDirty(true);
    }

    public int getHerobrineSpawnDelay() {
        return herobrineSpawnDelay;
    }

    public int getHerobrineSpawnChance() {
        return herobrineSpawnChance;
    }

    public void read(@NotNull CompoundTag compound) {
        if (compound.contains("HerobrineSpawnDelay", Tag.TAG_INT)) {
            this.herobrineSpawnDelay = compound.getInt("HerobrineSpawnDelay");
        }
        if (compound.contains("HerobrineSpawnChance", Tag.TAG_INT)) {
            this.herobrineSpawnChance = compound.getInt("HerobrineSpawnChance");
        }
    }

    public void write(@NotNull CompoundTag compound) {
        compound.putInt("HerobrineSpawnDelay", this.herobrineSpawnDelay);
        compound.putInt("HerobrineSpawnChance", this.herobrineSpawnChance);
    }
}