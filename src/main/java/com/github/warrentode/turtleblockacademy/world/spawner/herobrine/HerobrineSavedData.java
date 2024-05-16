package com.github.warrentode.turtleblockacademy.world.spawner.herobrine;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class HerobrineSavedData extends SavedData {
    private static final String DATA_NAME = MODID + "herobrine";

    private final Map<String, HerobrineData> data = new HashMap<>();

    public HerobrineSavedData() {
    }

    public HerobrineData getHerobrineData(String key) {
        return this.data.computeIfAbsent(key, s -> new HerobrineData(this));
    }

    public HerobrineSavedData read(@NotNull CompoundTag tag) {
        if (tag.contains("HerobrineSpawnDelay", Tag.TAG_INT)) {
            this.getHerobrineData("Herobrine").setHerobrineSpawnDelay(tag.getInt("HerobrineSpawnDelay"));
        }
        if (tag.contains("HerobrineSpawnChance", Tag.TAG_INT)) {
            this.getHerobrineData("Herobrine").setHerobrineSpawnChance(tag.getInt("HerobrineSpawnChance"));
        }
        if (tag.contains("Data", Tag.TAG_LIST)) {
            this.data.clear();
            ListTag list = tag.getList("Data", Tag.TAG_COMPOUND);
            list.forEach(nbt -> {
                CompoundTag todeHerobrineTag = (CompoundTag) nbt;
                String key = todeHerobrineTag.getString("Key");
                HerobrineData data = new HerobrineData(this);
                data.read(todeHerobrineTag);
                this.data.put(key, data);
            });
        }
        return this;
    }

    @Override
    public @NotNull CompoundTag save(@NotNull CompoundTag compound) {
        ListTag list = new ListTag();
        this.data.forEach((s, todeHerobrineData) -> {
            CompoundTag todeHerobrineTag = new CompoundTag();
            todeHerobrineData.write(todeHerobrineTag);
            todeHerobrineTag.putString("Key", s);
            list.add(todeHerobrineTag);
        });
        compound.put("Data", list);
        return compound;
    }

    public static HerobrineSavedData get(@NotNull MinecraftServer server) {
        ServerLevel serverLevel = server.createCommandSourceStack().getLevel();
        assert serverLevel != null;
        return serverLevel.getDataStorage().computeIfAbsent(tag -> new HerobrineSavedData().read(tag), HerobrineSavedData::new, DATA_NAME);
    }
}