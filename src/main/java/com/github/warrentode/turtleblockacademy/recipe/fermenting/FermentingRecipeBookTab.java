package com.github.warrentode.turtleblockacademy.recipe.fermenting;

import org.jetbrains.annotations.Nullable;

public enum FermentingRecipeBookTab {
    LIQUIDS("liquids"),
    PICKLES("pickles"),
    AGENTS("agents");


    public final String name;

    FermentingRecipeBookTab(String name) {
        this.name = name;
    }

    public static @Nullable FermentingRecipeBookTab findByName(String name) {
        for (FermentingRecipeBookTab value : values()) {
            if (value.name.equals(name)) {
                return value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name;
    }
}