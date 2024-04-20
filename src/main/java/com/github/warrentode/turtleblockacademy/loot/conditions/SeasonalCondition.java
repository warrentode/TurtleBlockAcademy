package com.github.warrentode.turtleblockacademy.loot.conditions;

import com.github.warrentode.turtleblockacademy.loot.serializers.ModLootItemConditions;
import com.github.warrentode.turtleblockacademy.util.CalendarUtil;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class SeasonalCondition implements LootItemCondition {
    @Nullable
    final String SEASON;

    SeasonalCondition(@Nullable Boolean SEASON) {
        this.SEASON = String.valueOf(SEASON);
    }

    public @NotNull LootItemConditionType getType() {
        return ModLootItemConditions.SEASONAL_CONDITION.get();
    }

    public boolean test(@NotNull LootContext context) {
        if (SEASON != null) {
            return CalendarUtil.check(this.SEASON);
        }
        else {
            return false;
        }
    }

    public static SeasonalCondition.Builder season() {
        return new SeasonalCondition.Builder();
    }

    public static class Builder implements LootItemCondition.Builder {
        @Nullable
        Boolean SEASON;

        public SeasonalCondition.Builder setSeason(@Nullable Boolean SEASON) {
            this.SEASON = SEASON;
            return this;
        }

        public @NotNull SeasonalCondition build() {
            return new SeasonalCondition(this.SEASON);
        }
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<SeasonalCondition> {
        /** Serialize the value by putting its data into the JsonObject. */
        public void serialize(@NotNull JsonObject jsonObject, @NotNull SeasonalCondition check, @NotNull JsonSerializationContext context) {
            jsonObject.addProperty("season", check.SEASON);
        }

        /** Deserialize a value by reading it from the JsonObject. */
        public @NotNull SeasonalCondition deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext context) {
            Boolean booleanValue = jsonObject.has("season") ? GsonHelper.getAsBoolean(jsonObject, "season") : null;
            return new SeasonalCondition(booleanValue);
        }
    }
}
