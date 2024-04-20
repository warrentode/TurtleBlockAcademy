package com.github.warrentode.turtleblockacademy;

import com.github.warrentode.turtleblockacademy.blocks.ModBlocks;
import com.github.warrentode.turtleblockacademy.config.AcademyConfig;
import com.github.warrentode.turtleblockacademy.items.ModItems;
import com.github.warrentode.turtleblockacademy.loot.serializers.ModLootItemConditions;
import com.github.warrentode.turtleblockacademy.loot.serializers.ModLootModifiers;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

@Mod(TurtleBlockAcademy.MODID)
public class TurtleBlockAcademy {
    public static final String MODID = "turtleblockacademy";
    public static final Logger LOGGER = LogManager.getLogger();

    public TurtleBlockAcademy() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, AcademyConfig.SPEC,
                "turtleblockacademy_config.toml");
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);

        ModLootModifiers.register(modEventBus);
        ModLootItemConditions.register(modEventBus);
    }

    @SuppressWarnings("deprecation")
    public static final SoundType CERTIFICATE = new SoundType(1.0F, 1.0F,
            SoundEvents.ITEM_FRAME_BREAK, SoundEvents.ITEM_FRAME_ADD_ITEM,
            SoundEvents.ITEM_FRAME_PLACE, SoundEvents.ITEM_FRAME_BREAK,
            SoundEvents.ITEM_FRAME_BREAK);

    public static final CreativeModeTab TAB = new CreativeModeTab(MODID) {
        @Override
        public @NotNull ItemStack makeIcon() {
            return ModBlocks.CERTIFICATE_BLOCK.get().asItem().getDefaultInstance();
        }
    };

    private void commonSetup(final FMLCommonSetupEvent event) {
        // reserved for later use
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // reserved for later use
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // reserved for later use
        }
    }
}
