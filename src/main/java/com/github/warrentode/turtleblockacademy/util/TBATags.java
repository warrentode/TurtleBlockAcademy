package com.github.warrentode.turtleblockacademy.util;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.Structure;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.turtleblockacademy.TurtleBlockAcademy.MODID;

public class TBATags {
    public static class Blocks {
        public static final TagKey<Block> PICNIC_BLANKETS = packBlockTag(MODID, "picnic_blankets");
        public static final TagKey<Block> FURNITURE = packBlockTag("forge", "furniture");
        public static final TagKey<Block> BASKETS = packBlockTag(MODID, "baskets");
        public static final TagKey<Block> TBA_MINING_PORTAL_FRAME_BLOCKS = packBlockTag(MODID, "mining_portal_frame_blocks");

        public static final TagKey<Block> DROPS_FOUR_LEAF_CLOVER = packBlockTag("todecoins", "drops_four_leaf_clover");

        public static final TagKey<Block> NEEDS_NETHERITE_TOOL = packBlockTag("minecraft", "needs_netherite_tool");

        public static final TagKey<Block> FD_HEAT_CONDUCTORS = packBlockTag("farmersdelight", "heat_conductors");
        public static final TagKey<Block> FD_HEAT_SOURCES = packBlockTag("farmersdelight", "heat_sources");
        public static final TagKey<Block> FD_TRAY_HEAT_SOURCES = packBlockTag("farmersdelight", "tray_heat_sources");

        public static final TagKey<Block> FR_HEAT_CONDUCTORS = packBlockTag("farmersrespite", "heat_conductors");
        public static final TagKey<Block> FR_HEAT_SOURCES = packBlockTag("farmersrespite", "heat_sources");
        public static final TagKey<Block> FR_TRAY_HEAT_SOURCES = packBlockTag("farmersrespite", "tray_heat_sources");

        public static final TagKey<Block> CARPETS = packBlockTag("minecraft", "carpets");
        public static final TagKey<Block> GLASS = packBlockTag("forge", "glass");
        public static final TagKey<Block> SAND = packBlockTag("forge", "sand");

        public static final TagKey<Block> GINGERBREADS = packBlockTag("snowyspirit", "gingerbreads");

        public static final TagKey<Block> DESKS = packBlockTag(MODID, "desks");
        public static final TagKey<Block> DESK_CABINETS = packBlockTag(MODID, "desk_cabinets");
        public static final TagKey<Block> TABLES = packBlockTag(MODID, "tables");
        public static final TagKey<Block> CHAIRS = packBlockTag(MODID, "chairs");
        public static final TagKey<Block> BENCHES = packBlockTag(MODID, "benches");
        public static final TagKey<Block> LOCKERS = packBlockTag(MODID, "lockers");
        public static final TagKey<Block> PLATES = packBlockTag(MODID, "plates");
        public static final TagKey<Block> BOOKCASES = packBlockTag(MODID, "bookcases");

        public static final TagKey<Block> SERENE_SEASONS_SUMMER_CROPS = packBlockTag("sereneseasons", "summer_crops");
    }

    public static class Items {
        public static final TagKey<Item> ACADEMY_SUPPLIES = packItemTag(MODID, "academy_supplies");
        public static final TagKey<Item> BUCKET_REMAINDERS = packItemTag("forge", "bucket_remainders");
        public static final TagKey<Item> BOWL_REMAINDERS = packItemTag("forge", "bowl_remainders");
        public static final TagKey<Item> BOTTLE_REMAINDERS = packItemTag("forge", "bottle_remainders");
        public static final TagKey<Item> MATCHING_ITEM_REMAINDERS = packItemTag("forge", "matching_item_remainders");
        public static final TagKey<Item> EGG_STAMPS = packItemTag("forge", "egg_stamps");

        public static final TagKey<Item> SLIME_BALLS = packItemTag("forge", "slime_balls");

        public static final TagKey<Item> SEEDS = packItemTag("forge", "seeds");
        public static final TagKey<Item> DYES = packItemTag("forge", "dye");
        public static final TagKey<Item> EASTER_EGGS = packItemTag(MODID, "easter_eggs");
        public static final TagKey<Item> BASKET_ITEMS = packItemTag(MODID, "basket_items");
        public static final TagKey<Item> CHALK = packItemTag("forge", "chalks");
        public static final TagKey<Item> SUPPLEMENTARIES_KEY = packItemTag("supplementaries", "key");

        public static final TagKey<Item> BLOODSHROOM_LOG = packItemTag("tconstruct", "bloodshroom_log");
        public static final TagKey<Item> BLOODSHROOM_STRIPPED_LOG = packItemTag("tconstruct", "stripped_bloodshroom_log");
        public static final TagKey<Item> BLOODSHROOM_PLANKS = packItemTag("tconstruct", "bloodshroom_planks");
        public static final TagKey<Item> BLOODSHROOM_SLAB = packItemTag("tconstruct", "bloodshroom_slab");
        public static final TagKey<Item> ENDERBARK_LOG = packItemTag("tconstruct", "enderbark_log");
        public static final TagKey<Item> ENDERBARK_STRIPPED_LOG = packItemTag("tconstruct", "stripped_enderbark_log");
        public static final TagKey<Item> ENDERBARK_PLANKS = packItemTag("tconstruct", "enderbark_planks");
        public static final TagKey<Item> ENDERBARK_SLAB = packItemTag("tconstruct", "enderbark_slab");
        public static final TagKey<Item> GREENHEART_LOG = packItemTag("tconstruct", "greenheart_log");
        public static final TagKey<Item> GREENHEART_STRIPPED_LOG = packItemTag("tconstruct", "stripped_greenheart_log");
        public static final TagKey<Item> GREENHEART_PLANKS = packItemTag("tconstruct", "greenheart_planks");
        public static final TagKey<Item> GREENHEART_SLAB = packItemTag("tconstruct", "greenheart_slab");
        public static final TagKey<Item> TINKER_SKYROOT_LOG = packItemTag("tconstruct", "skyroot_log");
        public static final TagKey<Item> TINKER_SKYROOT_STRIPPED_LOG = packItemTag("tconstruct", "stripped_skyroot_log");
        public static final TagKey<Item> TINKER_SKYROOT_PLANKS = packItemTag("tconstruct", "skyroot_planks");
        public static final TagKey<Item> TINKER_SKYROOT_SLAB = packItemTag("tconstruct", "skyroot_slab");

        public static final TagKey<Item> FORGE_BOOKS = packItemTag("forge", "books");
        public static final TagKey<Item> PATCHOULI_BOOKS = packItemTag("patchouli", "books");
        public static final TagKey<Item> LECTERN_BOOKS = packItemTag("minecraft", "lectern_books");
        public static final TagKey<Item> SAND = packItemTag("forge", "sand");
        public static final TagKey<Item> WALLETS = packItemTag("todecoins", "wallets");
        public static final TagKey<Item> BUNDLES = packItemTag("todecoins", "bundles");

        public static final TagKey<Item> CAGERIUM_ITEMS = packItemTag("cagerium", "cagerium_items");
        public static final TagKey<Item> CAGERIUM_BLOCKS = packItemTag("cagerium", "cagerium_blocks");
        public static final TagKey<Item> GOLDEN_HOPPER = packItemTag("goldenhopper", "golden_hopper");
        public static final TagKey<Item> ADVANCEMENT_FRAME_ITEM = packItemTag("advancementframes", "advancement_frame");

        public static final TagKey<Item> GARDEN_ITEMS = packItemTag("justoutdoorstuffs", "garden_items");
        public static final TagKey<Item> PATIO_ITEMS = packItemTag("justoutdoorstuffs", "patio_items");
        public static final TagKey<Item> SLEDS = packItemTag("snowyspirit", "sleds");
        public static final TagKey<Item> STONE_TILE = packItemTag("supplementaries", "stone_tile");
        public static final TagKey<Item> BLACKSTONE_TILE = packItemTag("supplementaries", "blackstone_tile");
        public static final TagKey<Item> LAPIS_BRICKS = packItemTag("supplementaries", "lapis_bricks");
        public static final TagKey<Item> ASH_BRICKS = packItemTag("supplementaries", "ash_bricks");

        public static final TagKey<Item> BRICK = packItemTag(MODID, "brick");
        public static final TagKey<Item> WATER_BUCKETS = packItemTag(MODID, "water_buckets");
        public static final TagKey<Item> STICKS = packItemTag("forge", "rods/wooden");

        public static final TagKey<Item> BACKPACKS = packItemTag(MODID, "backpacks");

        public static final TagKey<Item> CURIO = packItemTag("curios", "curio");
        public static final TagKey<Item> BELT = packItemTag("curios", "belt");
        public static final TagKey<Item> HANDS = packItemTag("curios", "hands");
        public static final TagKey<Item> WEBBING = packItemTag("forge", "webbing");
        public static final TagKey<Item> MUSIC_DISCS = packItemTag("minecraft", "music_discs");
        public static final TagKey<Item> BOOKSHELF_BOOKS = packItemTag("minecraft", "bookshelf_books");

        public static final TagKey<Item> ENDONIAN_INGOT = packItemTag("todecoins", "endonian_ingot");

        public static final TagKey<Item> TOOLS_CARVING = packItemTag(MODID, "tools/carving");
        public static final TagKey<Item> TOOLS_KNIVES = packItemTag("forge", "tools/knives");
        public static final TagKey<Item> SOUL_BINDER = packItemTag(MODID, "soul_binder");

        public static final TagKey<Item> NETHERITE_NUGGET = packItemTag("forge", "nuggets/netherite");
        public static final TagKey<Item> NETHERITE_INGOT = packItemTag("forge", "ingots/netherite");

        public static final TagKey<Item> IRON_NUGGET = packItemTag("forge", "nuggets/iron");
        public static final TagKey<Item> IRON_INGOT = packItemTag("forge", "ingots/iron");

        public static final TagKey<Item> COPPER_INGOT = packItemTag("forge", "ingots/copper");
        public static final TagKey<Item> COPPER_NUGGET = packItemTag("forge", "nuggets/copper");

        public static final TagKey<Item> GOLD_NUGGET = packItemTag("forge", "nuggets/gold");

        public static final TagKey<Item> WALLS = packItemTag(MODID, "walls");
        public static final TagKey<Item> LANTERNS = packItemTag("workshop_for_handsome_adventurer", "lanterns");
        public static final TagKey<Item> CURIO_LIGHT_SOURCE = packItemTag(MODID, "curio_light_source");

        public static final TagKey<Item> SHULKER_BOXES = packItemTag(MODID, "shulker_boxes");
        public static final TagKey<Item> BACKPACK_UPGRADES = packItemTag(MODID, "backpack_upgrades");
        public static final TagKey<Item> DOOR_PATTERNS = packItemTag(MODID, "door_patterns");
        public static final TagKey<Item> TRAPDOOR_PATTERNS = packItemTag(MODID, "trapdoor_patterns");

        public static final TagKey<Item> GEMS = packItemTag("forge", "gems");
        public static final TagKey<Item> GEM_SHARDS = packItemTag("forge", "gems/gem_shards");
        public static final TagKey<Item> PEARL = packItemTag("forge", "gems/pearls");
        public static final TagKey<Item> STAR = packItemTag("forge", "gems/star");
        public static final TagKey<Item> ROSE_QUARTZ = packItemTag("forge", "gems/rose_quartz");
        public static final TagKey<Item> CRYSTAL = packItemTag("forge", "gems/crystal");
        public static final TagKey<Item> ORB = packItemTag("forge", "gems/orb");
        public static final TagKey<Item> GEMSTONE = packItemTag("forge", "gems/gemstone");
        public static final TagKey<Item> SHELL = packItemTag("forge", "gems/shell");

        public static final TagKey<Item> CROPS = packItemTag("forge", "crops");
        public static final TagKey<Item> DILL = packItemTag("forge", "crops/dill");
        public static final TagKey<Item> SHROOMS = packItemTag("forge", "crops/shrooms");
        public static final TagKey<Item> CARROTS = packItemTag("forge", "crops/carrots");
        public static final TagKey<Item> CLOVES = packItemTag("forge", "crops/cloves");
        public static final TagKey<Item> CUCUMBERS = packItemTag("forge", "crops/cucumbers");
        public static final TagKey<Item> RICE = packItemTag("forge", "crops/rice");
        public static final TagKey<Item> CABBAGE = packItemTag("forge", "crops/cabbage");
        public static final TagKey<Item> TOMATO = packItemTag("forge", "crops/tomato");
        public static final TagKey<Item> PUMPKIN = packItemTag("forge", "crops/pumpkin");
        public static final TagKey<Item> MELON = packItemTag("forge", "crops/melon");
        public static final TagKey<Item> COCONUT = packItemTag("forge", "crops/coconut");
        public static final TagKey<Item> CACTUS = packItemTag("forge", "crops/cactus");
        public static final TagKey<Item> ONION = packItemTag("forge", "crops/onion");
        public static final TagKey<Item> VEGETABLES = packItemTag("forge", "crops/vegetables");
        public static final TagKey<Item> FRUITS = packItemTag("forge", "crops/fruits");
        public static final TagKey<Item> APPLES = packItemTag("forge", "crops/apples");
        public static final TagKey<Item> BERRIES = packItemTag("forge", "crops/berries");
        public static final TagKey<Item> TEA_LEAVES = packItemTag("forge", "crops/tea");
        public static final TagKey<Item> FR_TEA_LEAVES = packItemTag("farmersrespite", "tea_leaves");
        public static final TagKey<Item> COFFEE = packItemTag("forge", "crops/coffee");
        public static final TagKey<Item> COCOA = packItemTag("forge", "crops/cocoa");
        public static final TagKey<Item> GREENS = packItemTag("forge", "crops/greens");

        public static final TagKey<Item> RAW_FISHES = packItemTag("forge", "ingredients/raw_fishes");
        public static final TagKey<Item> RAW_SQUID = packItemTag("forge", "raw_fishes/raw_squid");
        public static final TagKey<Item> RAW_GLOW_SQUID = packItemTag("forge", "raw_fishes/raw_glow_squid");
        public static final TagKey<Item> RAW_CRAB = packItemTag("forge", "raw_fishes/raw_crab");
        public static final TagKey<Item> RAW_CLAM = packItemTag("forge", "raw_fishes/raw_clam");
        public static final TagKey<Item> RAW_SHRIMP = packItemTag("forge", "raw_fishes/raw_shrimp");
        public static final TagKey<Item> RAW_CLAWSTER = packItemTag("forge", "raw_fishes/raw_clawster");
        public static final TagKey<Item> RAW_GUARDIAN = packItemTag("forge", "raw_fishes/raw_guardian");
        public static final TagKey<Item> RAW_ELDER_GUARDIAN = packItemTag("forge", "raw_fishes/raw_elder_guardian");

        public static final TagKey<Item> RAW_MEATS = packItemTag("forge", "ingredients/raw_meats");
        public static final TagKey<Item> RAW_BEEF = packItemTag("forge", "raw_meats/raw_beef");
        public static final TagKey<Item> RAW_CHICKEN = packItemTag("forge", "raw_meats/raw_chicken");
        public static final TagKey<Item> RAW_BACON = packItemTag("forge", "raw_pork/raw_bacon");
        public static final TagKey<Item> RAW_PORK = packItemTag("forge", "raw_meats/raw_pork");
        public static final TagKey<Item> RAW_MUTTON = packItemTag("forge", "raw_meats/raw_mutton");
        public static final TagKey<Item> RAW_RABBIT = packItemTag("forge", "raw_meats/raw_rabbit");
        public static final TagKey<Item> RAW_VENISON = packItemTag("forge", "raw_meats/raw_venison");
        public static final TagKey<Item> RAW_GOAT = packItemTag("forge", "raw_meats/raw_goat");

        public static final TagKey<Item> COOKED_MEATS = packItemTag("forge", "ingredients/cooked_meats");
        public static final TagKey<Item> COOKED_CHICKEN = packItemTag("forge", "cooked_meats/cooked_chicken");
        public static final TagKey<Item> COOKED_MUTTON = packItemTag("forge", "cooked_meats/cooked_mutton");

        public static final TagKey<Item> BOILED_EGGS = packItemTag("forge", "cooked_meats/boiled_eggs");

        public static final TagKey<Item> WILDBERRIES_EDIBLES = packItemTag("wildberries", "edibles");

        public static final TagKey<Item> BLUEBERRIES = packItemTag("forge", "blueberries");
        public static final TagKey<Item> BLACKBERRIES = packItemTag("forge", "blackberries");
        public static final TagKey<Item> RASPBERRIES = packItemTag("forge", "raspberries");
        public static final TagKey<Item> CRANBERRIES = packItemTag("forge", "cranberries");
        public static final TagKey<Item> CLOVER = packItemTag("forge", "clover");

        public static final TagKey<Item> FOX_FOOD = packItemTag("minecraft", "fox_food");

        public static final TagKey<Item> INGREDIENTS = packItemTag("forge", "ingredients");
        public static final TagKey<Item> SALT_INGREDIENTS = packItemTag("forge", "ingredients/salt");
        public static final TagKey<Item> SALAD_INGREDIENTS = packItemTag("forge", "ingredients/salad");
        public static final TagKey<Item> STARCH_INGREDIENTS = packItemTag("forge", "ingredients/starch");
        public static final TagKey<Item> APPLE_INGREDIENTS = packItemTag("forge", "ingredients/apple");
        public static final TagKey<Item> CARROT_INGREDIENTS = packItemTag("forge", "ingredients/carrot");
        public static final TagKey<Item> CABBAGE_INGREDIENTS = packItemTag("forge", "ingredients/cabbage");
        public static final TagKey<Item> PUMPKIN_INGREDIENTS = packItemTag("forge", "ingredients/pumpkin");
        public static final TagKey<Item> MELON_INGREDIENTS = packItemTag("forge", "ingredients/melon");
        public static final TagKey<Item> COCOA_INGREDIENTS = packItemTag("forge", "ingredients/cocoa");
        public static final TagKey<Item> CLOVER_INGREDIENTS = packItemTag("forge", "ingredients/clover");
        public static final TagKey<Item> ONION_INGREDIENTS = packItemTag("forge", "ingredients/onion");
        public static final TagKey<Item> COOKED_RICE = packItemTag("forge", "ingredients/cooked_rice");
        public static final TagKey<Item> SPICES_INGREDIENTS = packItemTag("forge", "ingredients/spices");
        public static final TagKey<Item> CUCUMBER_INGREDIENTS = packItemTag("forge", "ingredients/cucumber");
        public static final TagKey<Item> CHEESE_SLICES = packItemTag("forge", "ingredients/cheese_slices");
        public static final TagKey<Item> BREAD = packItemTag("forge", "ingredients/bread");
        public static final TagKey<Item> SWEETENED_CHUNK = packItemTag("rottenleather", "sweetened_chunk");
        public static final TagKey<Item> APPLE_CIDERS = packItemTag(MODID, "apple_ciders");
        public static final TagKey<Item> DILL_INGREDIENTS = packItemTag("forge", "ingredients/dill");
        public static final TagKey<Item> CLOVE_INGREDIENTS = packItemTag("forge", "ingredients/clove");

        public static final TagKey<Item> GLAZES = packItemTag("forge", "ingredients/glazes");
        public static final TagKey<Item> ALCOHOL = packItemTag("forge", "ingredients/alcohol");
        public static final TagKey<Item> FLOUR = packItemTag("forge", "ingredients/flour");
        public static final TagKey<Item> WHEAT_FLOUR = packItemTag("forge", "flour/wheat");

        public static final TagKey<Item> STRAW_FIBERS = packItemTag(MODID, "straw_fibers");

        public static final TagKey<Item> JAR_PLACEABLE = packItemTag(MODID, "jar_placeable");
        public static final TagKey<Item> COOKIES = packItemTag("supplementaries", "cookies");
        public static final TagKey<Item> CHOCOLATE = packItemTag("supplementaries", "chocolate_bars");
        public static final TagKey<Item> CANDY = packItemTag("hauntedharvest", "candy");
        public static final TagKey<Item> SWEETS = packItemTag("hauntedharvest", "sweets");
        public static final TagKey<Item> TRICKS = packItemTag(MODID, "tricks");
        public static final TagKey<Item> CAKES = packItemTag("forge", "cakes");
        public static final TagKey<Item> CAKE_SLICES = packItemTag("forge", "cake_slices");
        public static final TagKey<Item> FLOWER_BOX_PLANTABLE = packItemTag("supplementaries", "flower_box_plantable");

        public static final TagKey<Item> CANDELABRA = packItemTag(MODID, "candelabras");
        public static final TagKey<Item> LAMPS = packItemTag(MODID, "lamps");
        public static final TagKey<Item> FIRE_PITS = packItemTag(MODID, "fire_pits");
        public static final TagKey<Item> LARGE_FIRE_PITS = packItemTag(MODID, "large_fire_pits");
        public static final TagKey<Item> STANDING_TORCHES = packItemTag(MODID, "standing_torches");
        public static final TagKey<Item> TALL_STANDING_TORCHES = packItemTag(MODID, "tall_standing_torches");
        public static final TagKey<Item> WALL_TORCHES = packItemTag(MODID, "wall_torches");

        public static final TagKey<Item> BLINDS = packItemTag(MODID, "blinds");
        public static final TagKey<Item> PICTURE_FRAMES = packItemTag(MODID, "picture_frames");
        public static final TagKey<Item> TRELLIS = packItemTag(MODID, "trellis");

        public static final TagKey<Item> BEEHIVES = packItemTag(MODID, "beehives");
        public static final TagKey<Item> CAMP_CHAIRS = packItemTag(MODID, "camp_chairs");
        public static final TagKey<Item> CHIMES = packItemTag(MODID, "chimes");
        public static final TagKey<Item> MAILBOXES = packItemTag(MODID, "mailboxes");
        public static final TagKey<Item> NEEDLES = packItemTag(MODID, "needles");
        public static final TagKey<Item> STONE_LAMPS = packItemTag(MODID, "stone_lamps");
        public static final TagKey<Item> WAYSTONES = packItemTag(MODID, "waystones");
        public static final TagKey<Item> APPLECRATES = packItemTag(MODID, "applecrates");

        public static final TagKey<Item> LOOTBAG_CURRENCY = packItemTag(MODID, "lootbag_currency");
        public static final TagKey<Item> LOOTBAG_SPECIAL_CURRENCY = packItemTag(MODID, "lootbag_special_currency");
        public static final TagKey<Item> CURRENCY = packItemTag("forge", "currency");
        public static final TagKey<Item> PIGLIN_BARTER_ITEMS = packItemTag("forge", "piglin_barter_items");

        public static final TagKey<Item> EGGS = packItemTag("forge", "eggs");
        public static final TagKey<Item> MILK = packItemTag("forge", "milk");
        public static final TagKey<Item> SUGAR = packItemTag("forge", "sugar");

        public static final TagKey<Item> TEXTILES = packItemTag("forge", "textiles");
        public static final TagKey<Item> BARK = packItemTag("forge", "textiles/bark");
        public static final TagKey<Item> STRING = packItemTag("forge", "textiles/string");
        public static final TagKey<Item> FABRIC_TEXTILES = packItemTag("forge", "textiles/fabric");
        public static final TagKey<Item> THREAD = packItemTag("forge", "textiles/thread");

        public static final TagKey<Item> NUGGETS = packItemTag("forge", "nuggets");
        public static final TagKey<Item> INGOTS = packItemTag("forge", "ingots");
        public static final TagKey<Item> GLASS = packItemTag("forge", "glass");

        public static final TagKey<Item> GLASS_INFUSED = packItemTag(MODID, "glass/infused");
        public static final TagKey<Item> GLASS_REINFORCED = packItemTag(MODID, "glass/reinforced");
        public static final TagKey<Item> GLASS_GLOWING = packItemTag(MODID, "glass/glowing");
        public static final TagKey<Item> GLASS_SHIFTING = packItemTag(MODID, "glass/shifting");

        public static final TagKey<Item> CARPETS = packItemTag("minecraft", "carpets");

        public static final TagKey<Item> NO_AI_EGGS = packItemTag("todecoins", "no_ai_spawn_eggs");

        public static final TagKey<Item> FATS = packItemTag(MODID, "fat");
        public static final TagKey<Item> ASH = packItemTag("forge", "ash");

        public static final TagKey<Item> FERMENTING_CONTAINERS = packItemTag(MODID, "fermenting_containers");
        public static final TagKey<Item> FERMENTING_POT_COVERS = packItemTag(MODID, "fermenting_pot_covers");
        public static final TagKey<Item> PICKLING_STONES = packItemTag(MODID, "pickling_stones");
        public static final TagKey<Item> FABRIC_COVERS = packItemTag(MODID, "fabric_covers");
    }

    public static class EntityTypes {
        public static final TagKey<EntityType<?>> BOSSES = packEntityTypeTag("forge", "bosses");
        public static final TagKey<EntityType<?>> CAGERIUM_BOSS_TYPES = packEntityTypeTag("cagerium", "bosses");
        public static final TagKey<EntityType<?>> CAGERIUM_BLACKLIST = packEntityTypeTag("cagerium", "cagerium_blacklist");

        public static final TagKey<EntityType<?>> FLUTE_PET = packEntityTypeTag("supplementaries", "flute_pet");
        public static final TagKey<EntityType<?>> URN_SPAWN = packEntityTypeTag("supplementaries", "urn_spawn");

        public static final TagKey<EntityType<?>> DROPS_CURRENCY = packEntityTypeTag("forge", "drops_currency");
        public static final TagKey<EntityType<?>> WILD_GAME = packEntityTypeTag("forge", "wild_game");
        public static final TagKey<EntityType<?>> ILLAGERS = packEntityTypeTag("forge", "illagers");
        public static final TagKey<EntityType<?>> EVOKER_TYPES = packEntityTypeTag("forge", "evoker");
        public static final TagKey<EntityType<?>> ICEOLOGER_TYPES = packEntityTypeTag("forge", "iceologer");
        public static final TagKey<EntityType<?>> ILLUSIONER_TYPES = packEntityTypeTag("forge", "illusioner");
        public static final TagKey<EntityType<?>> VINDICATOR_TYPES = packEntityTypeTag("forge", "vindicator");
        public static final TagKey<EntityType<?>> IRON_GOLEM_TYPES = packEntityTypeTag("forge", "iron_golem");
        public static final TagKey<EntityType<?>> WILDFIRE_TYPES = packEntityTypeTag("forge", "wildfire");
        public static final TagKey<EntityType<?>> ZOMBIE_TYPES = packEntityTypeTag("forge", "zombie");
        public static final TagKey<EntityType<?>> SKELETON_TYPES = packEntityTypeTag("forge", "skeleton");
        public static final TagKey<EntityType<?>> CREEPER_TYPES = packEntityTypeTag("forge", "creeper");
        public static final TagKey<EntityType<?>> PHANTOM_TYPES = packEntityTypeTag("forge", "phantom");
        public static final TagKey<EntityType<?>> SLIME_TYPES = packEntityTypeTag("forge", "slime");
        public static final TagKey<EntityType<?>> PIGLIN_TYPES = packEntityTypeTag("forge", "piglin");
        public static final TagKey<EntityType<?>> ZOMBIFIED_PIGLIN_TYPES = packEntityTypeTag("forge", "zombified_piglin");
        public static final TagKey<EntityType<?>> ENDERMAN_TYPES = packEntityTypeTag("forge", "enderman");
    }

    public interface StructureTags {
        TagKey<Structure> ON_ANCIENT_CITY_EXPLORER_MAPS = packStructureTag("forge", "worldgen/structure/ancient_city");
        TagKey<Structure> ON_BASTION_REMNANT_EXPLORER_MAPS = packStructureTag("forge", "worldgen/structure/bastion_remnant");
        TagKey<Structure> ON_DESERT_PYRAMID_EXPLORER_MAPS = packStructureTag("forge", "worldgen/structure/desert_pyramid");
        TagKey<Structure> ON_END_CITY_EXPLORER_MAPS = packStructureTag("forge", "worldgen/structure/end_city");
        TagKey<Structure> ON_IGLOO_EXPLORER_MAPS = packStructureTag("forge", "worldgen/structure/igloo");
        TagKey<Structure> ON_JUNGLE_TEMPLE_EXPLORER_MAPS = packStructureTag("forge", "worldgen/structure/jungle_temple");
        TagKey<Structure> ON_MINESHAFT_EXPLORER_MAPS = packStructureTag("forge", "worldgen/structure/mineshaft");
        TagKey<Structure> ON_NETHER_FORTRESS_EXPLORER_MAPS = packStructureTag("forge", "worldgen/structure/nether_fortress");
        TagKey<Structure> ON_NETHER_FOSSIL_EXPLORER_MAPS = packStructureTag("forge", "worldgen/structure/nether_fossil");
        TagKey<Structure> ON_NETHER_RUINED_PORTAL_EXPLORER_MAPS = packStructureTag("forge", "worldgen/structure/nether_ruined_portal");
        TagKey<Structure> ON_OCEAN_RUIN_EXPLORER_MAPS = packStructureTag("forge", "worldgen/structure/ocean_ruin");
        TagKey<Structure> ON_OCEAN_MONUMENT_EXPLORER_MAPS = packStructureTag("forge", "worldgen/structure/monument");
        TagKey<Structure> ON_OVERWORLD_RUINED_PORTAL_EXPLORER_MAPS = packStructureTag("forge", "worldgen/structure/overworld_ruined_portal");
        TagKey<Structure> ON_PILLAGER_OUTPOST_EXPLORER_MAPS = packStructureTag("forge", "worldgen/structure/pillager_outpost");
        TagKey<Structure> ON_WOODLAND_EXPLORER_MAPS = packStructureTag("forge", "worldgen/structure/mansion");
        TagKey<Structure> ON_SHIPWRECK_EXPLORER_MAPS = packStructureTag("forge", "worldgen/structure/shipwreck");
        TagKey<Structure> ON_STRONGHOLD_EXPLORER_MAPS = packStructureTag("forge", "worldgen/structure/stronghold");
        TagKey<Structure> ON_SWAMP_HUT_EXPLORER_MAPS = packStructureTag("forge", "worldgen/structure/swamp_hut");
        TagKey<Structure> ON_VILLAGE_EXPLORER_MAPS = packStructureTag("forge", "worldgen/structure/village");
        TagKey<Structure> ON_TREASURE_MAPS = packStructureTag("forge", "worldgen/structure/treasure");

        TagKey<Structure> OVERWORLD_POI = packStructureTag(MODID, "worldgen/structure/overworld_poi");
        TagKey<Structure> OVERWORLD_END_POI = packStructureTag(MODID, "worldgen/structure/overworld_end_poi");
        TagKey<Structure> OVERWORLD_NETHER_POI = packStructureTag(MODID, "worldgen/structure/overworld_nether_poi");

        TagKey<Structure> DESERT_POI = packStructureTag(MODID, "worldgen/structure/desert_poi");
        TagKey<Structure> JUNGLE_POI = packStructureTag(MODID, "worldgen/structure/jungle_poi");
        TagKey<Structure> OCEAN_POI = packStructureTag(MODID, "worldgen/structure/ocean_poi");
        TagKey<Structure> PILLAGER_POI = packStructureTag(MODID, "worldgen/structure/pillager_poi");
        TagKey<Structure> MISC_POI = packStructureTag(MODID, "worldgen/structure/misc_poi");
        TagKey<Structure> TREASURE_POI = packStructureTag(MODID, "worldgen/structure/treasure_poi");
        TagKey<Structure> UNDERGROUND_POI = packStructureTag(MODID, "worldgen/structure/underground_poi");
        TagKey<Structure> NETHER_POI = packStructureTag(MODID, "worldgen/structure/nether_poi");
        TagKey<Structure> END_POI = packStructureTag(MODID, "worldgen/structure/end_poi");
        TagKey<Structure> SETTLEMENT = packStructureTag(MODID, "worldgen/structure/settlement");
        TagKey<Structure> WITCH_SIGHTING = packStructureTag(MODID, "worldgen/structure/witch_sighting");
        TagKey<Structure> WAY_SIGN_DESTINATIONS = packStructureTag("supplementaries", "worldgen/structure/way_sign_destinations");
        TagKey<Structure> OVERWORLD_SLIME_ISLANDS = packStructureTag("tconstruct", "worldgen/structure/overworld_slime_islands");
        TagKey<Structure> NETHER_SLIME_ISLANDS = packStructureTag("tconstruct", "worldgen/structure/nether_slime_islands");
        TagKey<Structure> END_SLIME_ISLANDS = packStructureTag("tconstruct", "worldgen/structure/end_slime_islands");
    }

    public interface Biomes {
        TagKey<Biome> IS_CAVE = packBiomeTag("forge","is_cave");
        TagKey<Biome> IS_UNDERGROUND = packBiomeTag("forge","is_underground");
        TagKey<Biome> TBA_MINING_BIOMES = packBiomeTag(MODID,"tba_mining_biomes");
        TagKey<Biome> UNDERGROUND_BUT_NOT_DEEP_DARK = packBiomeTag(MODID,"underground_but_not_deep_dark");
        TagKey<Biome> IS_TROPICAL = packBiomeTag("forge","is_tropical");
        TagKey<Biome> IS_ARID = packBiomeTag("forge","is_arid");


        TagKey<Biome> HAS_CLAY_SLIME_POOLS = packBiomeTag(MODID,"has_structure/clay_slime_pools");
        TagKey<Biome> HAS_EARTH_SLIME_POOLS = packBiomeTag(MODID,"has_structure/earth_slime_pools");
        TagKey<Biome> HAS_ENDER_SLIME_POOLS = packBiomeTag(MODID,"has_structure/ender_slime_pools");
        TagKey<Biome> HAS_ICHOR_SLIME_POOLS = packBiomeTag(MODID,"has_structure/ichor_slime_pools");
        TagKey<Biome> HAS_SKY_SLIME_POOLS = packBiomeTag(MODID,"has_structure/sky_slime_pools");
        TagKey<Biome> HAS_SWET_POOLS = packBiomeTag(MODID,"has_structure/swet_pools");
        TagKey<Biome> HAS_CAMP_UNDERGROUND = packBiomeTag(MODID,"has_structure/camp_underground");
        TagKey<Biome> HAS_NETHER_FOSSIL = packBiomeTag(MODID,"has_structure/nether_fossil");
    }

    private static @NotNull TagKey<Biome> packBiomeTag(String modid, String name) {
        return TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(modid, name));
    }

    private static @NotNull TagKey<Block> packBlockTag(String id, String path) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(id, path));
    }

    private static @NotNull TagKey<Item> packItemTag(String id, String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(id, path));
    }

    private static @NotNull TagKey<Structure> packStructureTag(String id, String path) {
        return TagKey.create(Registry.STRUCTURE_REGISTRY, new ResourceLocation(id, path));
    }

    private static @NotNull TagKey<EntityType<?>> packEntityTypeTag(String id, String path) {
        return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(id, path));
    }
}