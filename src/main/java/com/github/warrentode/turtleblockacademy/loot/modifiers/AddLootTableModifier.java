package com.github.warrentode.turtleblockacademy.loot.modifiers;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

/**
 Credits to Commoble for this implementation! */
// modified by me to allow for a random chance to insert loot table
public class AddLootTableModifier extends LootModifier {
    public static final Supplier<Codec<AddLootTableModifier>> ADD_LOOT_TABLE_CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst -> codecStart(inst)
                    .and(ResourceLocation.CODEC.fieldOf("lootTable").forGetter((m) -> m.lootTable))
                    .and(Codec.FLOAT.fieldOf("addChance").forGetter((m) -> m.addChance))
                    .apply(inst, AddLootTableModifier::new)));

    private final ResourceLocation lootTable;
    protected final float addChance;

    public AddLootTableModifier(LootItemCondition[] conditionsIn, ResourceLocation lootTable, float addChance) {
        super(conditionsIn);
        this.lootTable = lootTable;
        this.addChance = addChance;
    }

    @SuppressWarnings("deprecation")
    @Nonnull
    @Override
    protected ObjectArrayList<ItemStack> doApply(@NotNull ObjectArrayList<ItemStack> generatedLoot, @NotNull LootContext context) {
        if (context.getRandom().nextFloat() <= this.addChance) {
            LootTable extraTable = context.getLootTable(this.lootTable);
            extraTable.getRandomItems(context, generatedLoot::add);
        }
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return ADD_LOOT_TABLE_CODEC.get();
    }
}