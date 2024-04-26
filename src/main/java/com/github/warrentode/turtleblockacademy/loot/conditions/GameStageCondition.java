package com.github.warrentode.turtleblockacademy.loot.conditions;

import com.github.warrentode.turtleblockacademy.loot.serializers.ModLootItemConditions;
import com.github.warrentode.turtleblockacademy.util.GameStageUtil;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class GameStageCondition implements LootItemCondition {
    @Nullable
    final String STAGE;

    GameStageCondition(@Nullable Boolean stage) {
        this.STAGE = String.valueOf(stage);
    }

    @Override
    public @NotNull LootItemConditionType getType() {
        return ModLootItemConditions.GAME_STAGE_CONDITION.get();
    }

    @Override
    public boolean test(LootContext context) {
        if (STAGE != null) {
            return GameStageUtil.check(this.STAGE);
        }
        else {
            return false;
        }
    }

    public static GameStageCondition.Builder stage() {
        return new GameStageCondition.Builder();
    }

    public static class Builder implements LootItemCondition.Builder {
        @Nullable
        Boolean STAGE;

        public GameStageCondition.Builder set(@Nullable Boolean STAGE) {
            this.STAGE = STAGE;
            return this;
        }

        public @NotNull GameStageCondition build() {
            return new GameStageCondition(this.STAGE);
        }
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<GameStageCondition> {
        /** Serialize the value by putting its data into the JsonObject. */
        public void serialize(@NotNull JsonObject jsonObject, @NotNull GameStageCondition check, @NotNull JsonSerializationContext context) {
            jsonObject.addProperty("stage", check.STAGE);
        }

        /** Deserialize a value by reading it from the JsonObject. */
        public @NotNull GameStageCondition deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext context) {
            Boolean booleanValue = jsonObject.has("stage") ? GsonHelper.getAsBoolean(jsonObject, "stage") : null;
            return new GameStageCondition(booleanValue);
        }
    }
}
