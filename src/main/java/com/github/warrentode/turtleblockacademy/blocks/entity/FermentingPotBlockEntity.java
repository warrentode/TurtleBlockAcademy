package com.github.warrentode.turtleblockacademy.blocks.entity;

import com.github.warrentode.turtleblockacademy.blocks.FermentingPotBlock;
import com.github.warrentode.turtleblockacademy.blocks.entity.gui.FermentingPotMenu;
import com.github.warrentode.turtleblockacademy.mixin.RecipeManagerAccessor;
import com.github.warrentode.turtleblockacademy.recipe.TBARecipes;
import com.github.warrentode.turtleblockacademy.recipe.fermenting.FermentingPotRecipe;
import com.github.warrentode.turtleblockacademy.util.TBATags;
import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Nameable;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeHolder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.fluids.TinkerFluids;
import vectorwing.farmersdelight.common.utility.ItemUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class FermentingPotBlockEntity extends BlockEntity implements MenuProvider, Nameable, RecipeHolder {
    public final ItemStackHandler inventory;
    public static final int COVER_SLOT = 6;
    public static final int CONTAINER_SLOT = 7;
    public static final int RESULT_SLOT = 8;
    public static final int INVENTORY_SIZE = RESULT_SLOT + 1;
    private int fermentingTime;
    private int totalFermentingTime;
    protected final ContainerData data;
    private Component customName;
    private final Object2IntOpenHashMap<ResourceLocation> usedRecipeTracker;
    private ResourceLocation lastRecipeID;
    private ItemStack lastItemCrafted;
    private ItemStack coverStack;
    private ItemStack containerStack;
    private boolean checkNewRecipe;
    public static final Map<Item, Item> INGREDIENT_REMAINDER_OVERRIDES =
            Map.ofEntries(Map.entry(TinkerFluids.beetrootSoup.asItem(), Items.BUCKET),
                    Map.entry(TinkerFluids.venomBottle.asItem(), Items.GLASS_BOTTLE),
                    Map.entry(TinkerFluids.magmaBottle.asItem(), Items.GLASS_BOTTLE),
                    Map.entry(TinkerFluids.meatSoupBowl.asItem(), Items.BOWL),
                    Map.entry(TinkerFluids.earthSlime.asItem(), Items.BUCKET),
                    Map.entry(TinkerFluids.skySlime.asItem(), Items.BUCKET),
                    Map.entry(TinkerFluids.enderSlime.asItem(), Items.BUCKET),
                    Map.entry(TinkerFluids.magma.asItem(), Items.BUCKET),
                    Map.entry(TinkerFluids.honey.asItem(), Items.BUCKET),
                    Map.entry(TinkerFluids.mushroomStew.asItem(), Items.BUCKET),
                    Map.entry(TinkerFluids.rabbitStew.asItem(), Items.BUCKET),
                    Map.entry(TinkerFluids.meatSoup.asItem(), Items.BUCKET),
                    Map.entry(TinkerFluids.potion.asItem(), Items.BUCKET),
                    Map.entry(TinkerFluids.blazingBlood.asItem(), Items.BUCKET),
                    Map.entry(TinkerFluids.liquidSoul.asItem(), Items.BUCKET),
                    Map.entry(Items.WATER_BUCKET, Items.BUCKET),
                    Map.entry(Items.POWDER_SNOW_BUCKET, Items.BUCKET),
                    Map.entry(Items.AXOLOTL_BUCKET, Items.BUCKET),
                    Map.entry(Items.COD_BUCKET, Items.BUCKET),
                    Map.entry(Items.PUFFERFISH_BUCKET, Items.BUCKET),
                    Map.entry(Items.SALMON_BUCKET, Items.BUCKET),
                    Map.entry(Items.TROPICAL_FISH_BUCKET, Items.BUCKET),
                    Map.entry(Items.SUSPICIOUS_STEW, Items.BOWL),
                    Map.entry(Items.MUSHROOM_STEW, Items.BOWL),
                    Map.entry(Items.RABBIT_STEW, Items.BOWL),
                    Map.entry(Items.BEETROOT_SOUP, Items.BOWL),
                    Map.entry(Items.POTION, Items.GLASS_BOTTLE),
                    Map.entry(Items.SPLASH_POTION, Items.GLASS_BOTTLE),
                    Map.entry(Items.LINGERING_POTION, Items.GLASS_BOTTLE),
                    Map.entry(Items.EXPERIENCE_BOTTLE, Items.GLASS_BOTTLE));

    private final ItemStackHandler itemHandler = new ItemStackHandler(9) {
        @Override
        protected void onContentsChanged(int slot) {
            if (slot >= 0 && slot < RESULT_SLOT) {
                checkNewRecipe = true;
            }
            if (level != null) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), Block.UPDATE_CLIENTS);
            }
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) {
                case COVER_SLOT -> stack.is(TBATags.Items.FERMENTING_POT_COVERS);
                case CONTAINER_SLOT -> stack.is(TBATags.Items.FERMENTING_CONTAINERS);
                case RESULT_SLOT -> false;
                default -> super.isItemValid(slot, stack);
            };
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public FermentingPotBlockEntity(BlockPos pos, BlockState state) {
        super(TBABlockEntities.FERMENTING_POT_ENTITY.get(), pos, state);
        this.inventory = itemHandler;
        this.coverStack = ItemStack.EMPTY;
        this.containerStack = ItemStack.EMPTY;
        this.lastItemCrafted = ItemStack.EMPTY;
        this.usedRecipeTracker = new Object2IntOpenHashMap<>();
        this.checkNewRecipe = true;
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> FermentingPotBlockEntity.this.fermentingTime;
                    case 1 -> FermentingPotBlockEntity.this.totalFermentingTime;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> FermentingPotBlockEntity.this.fermentingTime = value;
                    case 1 -> FermentingPotBlockEntity.this.totalFermentingTime = value;
                }
            }

            @Override
            public int getCount() {
                // number of variables being tracked and stored in this container
                return 2;
            }
        };
    }

    public @NotNull Component getName() {
        return customName != null ? customName : Component.translatable("container.turtleblockacademy.fermenting_pot");
    }

    @Override
    public @NotNull Component getDisplayName() {
        return getName();
    }

    public void setCustomName(Component name) {
        customName = name;
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory, @NotNull Player player) {
        return new FermentingPotMenu(id, inventory, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag nbt) {
        super.saveAdditional(nbt);
        if (customName != null) {
            nbt.putString("CustomName", Component.Serializer.toJson(customName));
        }
        nbt.put("inventory", itemHandler.serializeNBT());
        nbt.putInt("fermentingTime", this.fermentingTime);
        nbt.putInt("totalFermentingTime", totalFermentingTime);
        lastItemCrafted = ItemStack.of(nbt.getCompound("lastItemCrafted"));
        CompoundTag compoundRecipes = new CompoundTag();
        this.usedRecipeTracker.forEach((recipeId, craftedAmount) ->
                compoundRecipes.putInt(recipeId.toString(), craftedAmount));
        nbt.put("RecipesUsed", compoundRecipes);
    }

    private CompoundTag writeItems(CompoundTag nbt) {
        super.saveAdditional(nbt);
        nbt.put("inventory", inventory.serializeNBT());
        nbt.put("lastItemCrafted", lastItemCrafted.serializeNBT());
        return nbt;
    }

    @Override
    public @NotNull CompoundTag getUpdateTag() {
        return writeItems(new CompoundTag());
    }

    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
        if (nbt.contains("CustomName", 8)) {
            customName = Component.Serializer.fromJson(nbt.getString("CustomName"));
        }
        inventory.deserializeNBT(nbt.getCompound("inventory"));
        fermentingTime = nbt.getInt("fermentingTime");
        totalFermentingTime = nbt.getInt("totalFermentingTime");
        nbt.put("lastItemCrafted", lastItemCrafted.serializeNBT());
        CompoundTag compoundRecipes = nbt.getCompound("RecipesUsed");
        for (String key : compoundRecipes.getAllKeys()) {
            this.usedRecipeTracker.put(new ResourceLocation(key), compoundRecipes.getInt(key));
        }
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());

        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        assert this.level != null;
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(@NotNull Level level, BlockPos pos, BlockState state, FermentingPotBlockEntity potEntity) {
        if (level.isClientSide()) {
            return;
        }

        boolean didInventoryChange = false;
        boolean flag = potEntity.isFermenting();
        boolean flag1 = false;

        Optional<FermentingPotRecipe> recipe = potEntity.getMatchingRecipe(new RecipeWrapper(potEntity.inventory));
        FermentingPotRecipe presentRecipe;
        boolean hasCover = false;
        boolean hasContainer = false;

        if (recipe.isPresent()) {
            presentRecipe = recipe.get();
            potEntity.coverStack = presentRecipe.getCoverStack();
            potEntity.containerStack = presentRecipe.getOutputContainer();

            if (potEntity.coverStack != null && potEntity.inventory.getStackInSlot(COVER_SLOT).is(potEntity.coverStack.getItem())) {
                hasCover = true;
                setChanged(level, pos, state);
            }
            if (potEntity.containerStack != null && potEntity.inventory.getStackInSlot(CONTAINER_SLOT).is(potEntity.containerStack.getItem())) {
                hasContainer = true;
            }

            if (potEntity.hasInput() && hasCover && potEntity.canProcess(recipe.get()) && (hasContainer && presentRecipe.getOutputContainer() != null)) {
                if (potEntity.coverStack.is(TBATags.Items.PICKLING_STONES)) {
                    state = state.setValue(FermentingPotBlock.HAS_PICKLING_STONE, true);
                    FermentingPotBlock.resetPicklingStoneState(Objects.requireNonNull(potEntity.getLevel()),
                            potEntity.getBlockPos(), potEntity.getBlockState(), true);
                }
                else {
                    state = state.setValue(FermentingPotBlock.HAS_CLOTH_COVER, true);
                    FermentingPotBlock.resetClothCoverState(Objects.requireNonNull(potEntity.getLevel()),
                            potEntity.getBlockPos(), potEntity.getBlockState(), true);
                }

                didInventoryChange =  potEntity.processFermentation(recipe.get(), potEntity);
            }
            else if (potEntity.hasInput() && hasCover && potEntity.canProcess(recipe.get()) && !hasContainer && presentRecipe.getOutputContainer() == null) {
                if (potEntity.coverStack.is(TBATags.Items.PICKLING_STONES)) {
                    state = state.setValue(FermentingPotBlock.HAS_PICKLING_STONE, true);
                    FermentingPotBlock.resetPicklingStoneState(Objects.requireNonNull(potEntity.getLevel()),
                            potEntity.getBlockPos(), potEntity.getBlockState(), true);
                }
                else {
                    state = state.setValue(FermentingPotBlock.HAS_CLOTH_COVER, true);
                    FermentingPotBlock.resetClothCoverState(Objects.requireNonNull(potEntity.getLevel()),
                            potEntity.getBlockPos(), potEntity.getBlockState(), true);
                }
                didInventoryChange = potEntity.processFermentation(recipe.get(), potEntity);
            }
        }
        else {
            potEntity.resetProgress();
            setChanged(level, pos, state);
        }

        if (didInventoryChange) {
            setChanged(level, pos, state);
        }

        if (flag != potEntity.isFermenting()) {
            flag1 = true;
            level.setBlock(pos, state, 3);
        }

        if (!hasCover) {
            setChanged(level, pos, state);
            state = state.setValue(FermentingPotBlock.HAS_PICKLING_STONE, false);
            FermentingPotBlock.resetPicklingStoneState(Objects.requireNonNull(potEntity.getLevel()),
                    potEntity.getBlockPos(), potEntity.getBlockState(), false);
            state = state.setValue(FermentingPotBlock.HAS_CLOTH_COVER, false);
            FermentingPotBlock.resetClothCoverState(Objects.requireNonNull(potEntity.getLevel()),
                    potEntity.getBlockPos(), potEntity.getBlockState(), false);
        }

        if (flag1) {
            setChanged(level, pos, state);
        }
    }

    private boolean canProcess(FermentingPotRecipe recipe) {
        if (hasInput()) {
            ItemStack resultStack = recipe.getResultItem();
            return !resultStack.isEmpty() && canInsertAmountIntoOutputSlot(inventory) && canInsertItemIntoOutputSlot(inventory, recipe.getResultItem());
        }
        else {
            return false;
        }
    }

    private boolean processFermentation(FermentingPotRecipe recipe, FermentingPotBlockEntity potBlockEntity) {
        if (level == null) {
            return false;
        }
        ++fermentingTime;
        totalFermentingTime = recipe.getFermentingTime();
        if (fermentingTime >= totalFermentingTime) {
            craftItem(recipe, potBlockEntity);
        }
        return true;
    }

    private Optional<FermentingPotRecipe> getMatchingRecipe(RecipeWrapper inventory) {
        if (level == null) {
            return Optional.empty();
        }

        if (lastRecipeID != null) {
            Recipe<RecipeWrapper> recipe = ((RecipeManagerAccessor) level.getRecipeManager())
                    .getRecipeMap(TBARecipes.RECIPE_TYPE_FERMENTING.get())
                    .get(lastRecipeID);
            if (recipe instanceof FermentingPotRecipe) {
                if (recipe.matches(inventory, level)) {
                    return Optional.of((FermentingPotRecipe) recipe);
                }
                if (recipe.getResultItem().sameItem(lastItemCrafted)) {
                    return Optional.empty();
                }
            }
        }

        if (checkNewRecipe) {
            Optional<FermentingPotRecipe> recipe = level.getRecipeManager().getRecipeFor(TBARecipes.RECIPE_TYPE_FERMENTING.get(), inventory, level);
            if (recipe.isPresent()) {
                ResourceLocation newRecipeID = recipe.get().getId();
                if (lastRecipeID != null && !lastRecipeID.equals(newRecipeID)) {
                    fermentingTime = 0;
                }
                lastRecipeID = newRecipeID;
                return recipe;
            }
        }

        checkNewRecipe = false;
        return Optional.empty();
    }

    private boolean hasInput() {
        for (int i = 0; i < RESULT_SLOT; ++i) {
            if (!inventory.getStackInSlot(i).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private void resetProgress() {
        this.fermentingTime = 0;
    }

    private void craftItem(FermentingPotRecipe recipe, FermentingPotBlockEntity potBlockEntity) {
        for (int i = 0; i < inventory.getSlots(); i++) {
            inventory.setStackInSlot(i, inventory.getStackInSlot(i));
        }

        // ingredient slots
        ItemStack slotStack0 = this.inventory.getStackInSlot(0);
        potBlockEntity.itemHandler.extractItem(0, 1, false);
        if (slotStack0.hasCraftingRemainingItem()) {
            this.ejectIngredientRemainder(slotStack0.getCraftingRemainingItem());
        }
        else if (INGREDIENT_REMAINDER_OVERRIDES.containsKey(slotStack0.getItem())) {
            this.ejectIngredientRemainder(INGREDIENT_REMAINDER_OVERRIDES.get(slotStack0.getItem()).getDefaultInstance());
        }

        ItemStack slotStack1 = this.inventory.getStackInSlot(1);
        potBlockEntity.itemHandler.extractItem(1, 1, false);
        if (slotStack1.hasCraftingRemainingItem()) {
            this.ejectIngredientRemainder(slotStack1.getCraftingRemainingItem());
        }
        else if (INGREDIENT_REMAINDER_OVERRIDES.containsKey(slotStack1.getItem())) {
            this.ejectIngredientRemainder(INGREDIENT_REMAINDER_OVERRIDES.get(slotStack1.getItem()).getDefaultInstance());
        }

        ItemStack slotStack2 = this.inventory.getStackInSlot(2);
        potBlockEntity.itemHandler.extractItem(2, 1, false);
        if (slotStack2.hasCraftingRemainingItem()) {
            this.ejectIngredientRemainder(slotStack2.getCraftingRemainingItem());
        }
        else if (INGREDIENT_REMAINDER_OVERRIDES.containsKey(slotStack2.getItem())) {
            this.ejectIngredientRemainder(INGREDIENT_REMAINDER_OVERRIDES.get(slotStack2.getItem()).getDefaultInstance());
        }

        ItemStack slotStack3 = this.inventory.getStackInSlot(3);
        potBlockEntity.itemHandler.extractItem(3, 1, false);
        if (slotStack3.hasCraftingRemainingItem()) {
            this.ejectIngredientRemainder(slotStack3.getCraftingRemainingItem());
        }
        else if (INGREDIENT_REMAINDER_OVERRIDES.containsKey(slotStack3.getItem())) {
            this.ejectIngredientRemainder(INGREDIENT_REMAINDER_OVERRIDES.get(slotStack3.getItem()).getDefaultInstance());
        }

        ItemStack slotStack4 = this.inventory.getStackInSlot(4);
        potBlockEntity.itemHandler.extractItem(4, 1, false);
        if (slotStack4.hasCraftingRemainingItem()) {
            this.ejectIngredientRemainder(slotStack4.getCraftingRemainingItem());
        }
        else if (INGREDIENT_REMAINDER_OVERRIDES.containsKey(slotStack4.getItem())) {
            this.ejectIngredientRemainder(INGREDIENT_REMAINDER_OVERRIDES.get(slotStack4.getItem()).getDefaultInstance());
        }

        ItemStack slotStack5 = this.inventory.getStackInSlot(5);
        potBlockEntity.itemHandler.extractItem(5, 1, false);
        if (slotStack5.hasCraftingRemainingItem()) {
            this.ejectIngredientRemainder(slotStack5.getCraftingRemainingItem());
        }
        else if (INGREDIENT_REMAINDER_OVERRIDES.containsKey(slotStack5.getItem())) {
            this.ejectIngredientRemainder(INGREDIENT_REMAINDER_OVERRIDES.get(slotStack5.getItem()).getDefaultInstance());
        }

        // container slot
        potBlockEntity.itemHandler.extractItem(CONTAINER_SLOT, 1, false);
        ItemStack slotStack_CONTAINER_SLOT = this.inventory.getStackInSlot(CONTAINER_SLOT);
        if (slotStack_CONTAINER_SLOT.hasCraftingRemainingItem()) {
            this.ejectIngredientRemainder(slotStack_CONTAINER_SLOT.getCraftingRemainingItem());
        }
        else if (INGREDIENT_REMAINDER_OVERRIDES.containsKey(slotStack_CONTAINER_SLOT.getItem())) {
            this.ejectIngredientRemainder(INGREDIENT_REMAINDER_OVERRIDES.get(slotStack_CONTAINER_SLOT.getItem()).getDefaultInstance());
        }

        inventory.setStackInSlot(RESULT_SLOT, new ItemStack(recipe.getResultItem().getItem(),
                inventory.getStackInSlot(RESULT_SLOT).getCount() + (recipe.getResultItem().getCount())));

        lastItemCrafted = recipe.getResultItem();
        potBlockEntity.setRecipeUsed(recipe);
        potBlockEntity.resetProgress();
        potBlockEntity.setChanged();
    }

    protected void ejectIngredientRemainder(ItemStack remainderStack) {
        Direction direction = this.getBlockState().getValue(FermentingPotBlock.FACING);
        double x = (double) this.worldPosition.getX() + 0.5 + (double) direction.getStepX() * 0.25;
        double y = (double) this.worldPosition.getY() + 0.7;
        double z = (double) this.worldPosition.getZ() + 0.5 + (double) direction.getStepZ() * 0.25;
        assert this.level != null;
        ItemUtils.spawnItemEntity(this.level, remainderStack, x, y, z, (float) direction.getStepX() * 0.08F, 0.25, (float) direction.getStepZ() * 0.08F);
    }

    private static boolean canInsertItemIntoOutputSlot(@NotNull ItemStackHandler inventory, @NotNull ItemStack stack) {
        return inventory.getStackInSlot(RESULT_SLOT).getItem() == stack.getItem() || inventory.getStackInSlot(RESULT_SLOT).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(@NotNull ItemStackHandler inventory) {
        return inventory.getStackInSlot(RESULT_SLOT).getMaxStackSize() > inventory.getStackInSlot(RESULT_SLOT).getCount();
    }

    private boolean isFermenting() {
        return this.fermentingTime > 0;
    }

    public ItemStackHandler getInventory() {
        return inventory;
    }

    @Override
    public void setRecipeUsed(@Nullable Recipe<?> recipe) {
        if (recipe != null) {
            ResourceLocation recipeID = recipe.getId();
            usedRecipeTracker.addTo(recipeID, 1);
        }
    }

    @Nullable
    @Override
    public Recipe<?> getRecipeUsed() {
        return null;
    }

    @Override
    public void awardUsedRecipes(@NotNull Player player) {
        List<Recipe<?>> usedRecipes = this.getUsedRecipesAndPopExperience(player.level, player.position());
        player.awardRecipes(usedRecipes);
        this.usedRecipeTracker.clear();
    }

    public List<Recipe<?>> getUsedRecipesAndPopExperience(Level level, Vec3 pos) {
        List<Recipe<?>> list = Lists.newArrayList();

        for (Object2IntMap.Entry<ResourceLocation> resourceLocationEntry : this.usedRecipeTracker.object2IntEntrySet()) {
            level.getRecipeManager().byKey(resourceLocationEntry.getKey()).ifPresent((recipe) -> {
                list.add(recipe);
                splitAndSpawnExperience((ServerLevel) level, pos, resourceLocationEntry.getIntValue(), ((FermentingPotRecipe) recipe).getExperience());
            });
        }

        return list;
    }

    private static void splitAndSpawnExperience(ServerLevel level, Vec3 pos, int craftedAmount, float experience) {
        int expTotal = Mth.floor((float)craftedAmount * experience);
        float expFraction = Mth.frac((float)craftedAmount * experience);
        if (expFraction != 0.0F && Math.random() < (double)expFraction) {
            ++expTotal;
        }

        ExperienceOrb.award(level, pos, expTotal);
    }


    @Override
    public boolean setRecipeUsed(@NotNull Level pLevel, @NotNull ServerPlayer pPlayer, @NotNull Recipe<?> pRecipe) {
        return RecipeHolder.super.setRecipeUsed(pLevel, pPlayer, pRecipe);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(Connection net, @NotNull ClientboundBlockEntityDataPacket pkt) {
        load(Objects.requireNonNull(pkt.getTag()));
    }
}
