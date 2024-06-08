package com.github.warrentode.turtleblockacademy.items.food.eastereggs;

import java.util.function.Supplier;

public class EasterEggProperties {

    public enum Layer {
        BLANK(()-> "blank"),
        CHECKERED(()-> "checkered"),
        CREEPER(()-> "creeper");

        public static final Layer[] EGG_LAYERS = values();

        public static Layer get(int ordinal) {
            return EGG_LAYERS[ordinal];
        }

        private final Supplier<String> layerName;

        Layer(Supplier<String> layerName) {
            this.layerName = layerName;
        }

        public Layer getEggLayer() {
            return get(ordinal());
        }

        public String getLayerName() {
            return this.layerName.get();
        }
    }
}
