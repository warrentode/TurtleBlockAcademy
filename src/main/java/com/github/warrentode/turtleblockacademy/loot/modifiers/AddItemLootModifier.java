package com.github.warrentode.turtleblockacademy.loot.modifiers;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.function.Supplier;

public class AddItemLootModifier extends LootModifier {
    public static final Supplier<Codec<AddItemLootModifier>> ADD_LOOT_ITEM_CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create((inst) -> codecStart(inst)
                    .and(ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter((g) -> g.item))
                    .and(Codec.INT.fieldOf("minAmount").forGetter((g) -> g.minAmount))
                    .and(Codec.INT.fieldOf("maxAmount").forGetter((g) -> g.maxAmount))
                    .and(Codec.FLOAT.fieldOf("addChance").forGetter((g) -> g.dropChance))
                    .apply(inst, AddItemLootModifier::new)));
    protected final Item item;
    protected final int minAmount;
    protected final int maxAmount;
    protected final float dropChance;

    public AddItemLootModifier(LootItemCondition[] conditionsIn, Item item, int minAmount, int maxAmount, float dropChance) {
        super(conditionsIn);
        this.item = item;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.dropChance = dropChance;
    }


    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, @NotNull LootContext context) {
        if ((context.getRandom().nextFloat() <= this.dropChance) && this.maxAmount >= 1) {
            generatedLoot.add(new ItemStack(item,
                    getRandomAmount(this.minAmount, this.maxAmount)));
        }
        return generatedLoot;
    }

    public int getRandomAmount(int ignoredMin, int ignoredMax) {
        return new Random().nextInt(this.maxAmount) + this.minAmount;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return ADD_LOOT_ITEM_CODEC.get();
    }
}