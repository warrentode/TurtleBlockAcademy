package com.github.warrentode.turtleblockacademy.entity;

import com.github.warrentode.turtleblockacademy.blocks.TBABlocks;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class TBAPOIs {
    public static final DeferredRegister<PoiType> TBA_POI =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, MODID);

    public static final RegistryObject<PoiType> MINING_PORTAL_POI =
            TBA_POI.register("mining_portal_poi", () ->
                    new PoiType(getBlockStates(TBABlocks.TBA_MINING_PORTAL.get()),
                            0, 1));

    private static Set<BlockState> getBlockStates(Block block) {
        return ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates());
    }

    public static void register(IEventBus eventBus) {
        TBA_POI.register(eventBus);
    }
}
