package com.github.warrentode.turtleblockacademy.loot.serializers;

import com.github.warrentode.turtleblockacademy.loot.conditions.*;
import net.minecraft.core.Registry;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class TBALootItemConditions extends LootItemConditions {
    private static final DeferredRegister<LootItemConditionType> REGISTER
            = DeferredRegister.create(Registry.LOOT_ITEM_REGISTRY, MODID);

    public static final RegistryObject<LootItemConditionType> MODLOADED_CONDITION
            = REGISTER.register("modloaded_condition",
            () -> new LootItemConditionType(new ModCheckCondition.Serializer()));

    public static final RegistryObject<LootItemConditionType> BIOMETAG_CONDITION
            = REGISTER.register("biometag_condition",
            () -> new LootItemConditionType(new BiomeTagCondition.Serializer()));
    public static final RegistryObject<LootItemConditionType> BLOCKTAG_CONDITION
            = REGISTER.register("blocktag_condition",
            () -> new LootItemConditionType(new BlockTagCondition.Serializer()));
    public static final RegistryObject<LootItemConditionType> ENTITY_TYPE_TAG_CONDITION
            = REGISTER.register("entity_type_tag_condition",
            () -> new LootItemConditionType(new EntityTypeTagCondition.Serializer()));

    public static final RegistryObject<LootItemConditionType> SEASONAL_CONDITION
            = REGISTER.register("seasonal_condition",
            () -> new LootItemConditionType(new SeasonalCondition.Serializer()));

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}