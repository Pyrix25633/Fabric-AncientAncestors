package net.rupyber_studios.ancient_ancestors.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rupyber_studios.ancient_ancestors.AncientAncestors;
import net.rupyber_studios.ancient_ancestors.block.custom.*;
import net.rupyber_studios.ancient_ancestors.item.ModItemGroup;
import net.rupyber_studios.ancient_ancestors.util.MinecraftBlocks;

public class ModBlocks {
    //Settings
    private static final FabricBlockSettings DEEPSLATE_SETTINGS = FabricBlockSettings.of(Material.STONE, MapColor.DEEPSLATE_GRAY)
            .requiresTool().strength(3.0F, 6.0F).sounds(BlockSoundGroup.DEEPSLATE);
    private static final FabricBlockSettings WOOD_SETTINGS = FabricBlockSettings.of(Material.WOOD)
            .strength(2F, 3F).sounds(BlockSoundGroup.WOOD);
    private static final FabricBlockSettings GRASS_SETTINGS = FabricBlockSettings.of(Material.REPLACEABLE_PLANT)
            .noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS);
    private static final FabricBlockSettings LEAVES_SETTINGS = FabricBlockSettings.of(Material.LEAVES).strength(0.2F)
            .sounds(BlockSoundGroup.GRASS).nonOpaque().ticksRandomly().allowsSpawning(MinecraftBlocks::canSpawnOnLeaves)
            .suffocates(MinecraftBlocks::never).blockVision(MinecraftBlocks::never);
    private static final FabricBlockSettings BUTTON_SETTINGS = FabricBlockSettings.of(Material.DECORATION)
            .noCollision().strength(0.5F).sounds(BlockSoundGroup.WOOD);
    private static final FabricBlockSettings PRESSURE_PLATE_SETTINGS = FabricBlockSettings.of(Material.WOOD)
            .noCollision().strength(0.5F).sounds(BlockSoundGroup.WOOD);
    private static final FabricBlockSettings FENCE_SETTINGS = FabricBlockSettings.of(Material.WOOD)
            .strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD);
    private static final FabricBlockSettings FLOWER_SETTINGS = (FabricBlockSettings)FabricBlockSettings.of(Material.PLANT).noCollision()
            .breakInstantly().sounds(BlockSoundGroup.GRASS).offsetType(AbstractBlock.OffsetType.XZ);
    private static final FabricBlockSettings FLOWER_POT_SETTINGS = FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque();

    //Pendium
    public static final Block PENDIUM = registerBlock("pendium", new PendiumBlock(DEEPSLATE_SETTINGS));

    //Dirt
    public static final Block ANCIENT_GRASS_BLOCK = registerBlock("ancient_grass_block",
            new AncientGrassBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).strength(0.6F).sounds(BlockSoundGroup.GRASS)));
    public static final Block ANCIENT_DIRT = registerBlock("ancient_dirt",
            new Block(AbstractBlock.Settings.of(Material.SOIL, MapColor.DIRT_BROWN).strength(0.5F).sounds(BlockSoundGroup.GRAVEL)));

    //Stone
    public static final Block ANCIENT_STONE = registerBlock("ancient_stone",
            new Block(AbstractBlock.Settings.of(Material.STONE, MapColor.STONE_GRAY).strength(1.5F, 6.0F).requiresTool()));

    //Clay
    public static final Block ANCIENT_CLAY = registerBlock("ancient_clay",
            new Block(AbstractBlock.Settings.of(Material.ORGANIC_PRODUCT).strength(0.6F).sounds(BlockSoundGroup.GRAVEL)));

    //Logs
    public static final Block ANCIENTBARK_LOG = registerBlock("ancientbark_log",
            new ModLogBlock(WOOD_SETTINGS));
    public static final Block ANCIENTBARK_WOOD = registerBlock("ancientbark_wood",
            new ModLogBlock(WOOD_SETTINGS));
    public static final Block STRIPPED_ANCIENTBARK_LOG = registerBlock("stripped_ancientbark_log",
            new PillarBlock(WOOD_SETTINGS));
    public static final Block STRIPPED_ANCIENTBARK_WOOD = registerBlock("stripped_ancientbark_wood",
            new PillarBlock(WOOD_SETTINGS));

    //Planks
    public static final Block ANCIENTBARK_PLANKS = registerBlock("ancientbark_planks",
            new Block(WOOD_SETTINGS));
    public static final Block ANCIENTBARK_SLAB = registerBlock("ancientbark_slab",
            new SlabBlock(WOOD_SETTINGS));
    public static final Block ANCIENTBARK_STAIRS = registerBlock("ancientbark_stairs",
            new StairsBlock(ModBlocks.ANCIENTBARK_PLANKS.getDefaultState(), WOOD_SETTINGS));
    public static final Block ANCIENTBARK_VERTICAL_SLAB = registerBlock("ancientbark_vertical_slab",
            new VerticalSlabBlock(WOOD_SETTINGS));
    public static final Block ANCIENTBARK_BUTTON = registerBlock("ancientbark_button",
            new WoodenButtonBlock(BUTTON_SETTINGS));
    public static final Block ANCIENTBARK_PRESSURE_PLATE = registerBlock("ancientbark_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, PRESSURE_PLATE_SETTINGS));
    public static final Block ANCIENTBARK_FENCE = registerBlock("ancientbark_fence",
            new FenceBlock(FENCE_SETTINGS));
    public static final Block ANCIENTBARK_FENCE_GATE = registerBlock("ancientbark_fence_gate",
            new FenceGateBlock(FENCE_SETTINGS));
    public static final Block ANCIENTBARK_LEAVES = registerBlock("ancientbark_leaves",
            new LeavesBlock(LEAVES_SETTINGS));

    //Vegetation
    public static final Block ANCIENT_GRASS = registerBlock("ancient_grass",
            new FernBlock(GRASS_SETTINGS));
    public static final Block CORAL_GRASS = registerBlock("coral_grass",
            new FernBlock(GRASS_SETTINGS));
    public static final Block TALL_CORAL_GRASS = registerBlock("tall_coral_grass",
            new TallPlantBlock(GRASS_SETTINGS));
    public static final Block LOGWEED = registerBlock("logweed",
            new TallPlantBlock(GRASS_SETTINGS));
    public static final Block WITCH_SPOUT = registerBlock("witch_spout",
            new TallPlantBlock(GRASS_SETTINGS));
    public static final Block SHARPBLOSSOM = registerBlock("sharpblossom",
            new TallFlowerBlock(GRASS_SETTINGS));

    //Small Flowers and Flower Pots
    public static final Block BLAZEBLOSSOM = registerBlock("blazeblossom",
            new ModFlowerBlock(StatusEffects.FIRE_RESISTANCE, 6, FLOWER_SETTINGS));
    public static final Block GLOWBERRY_BUSH = registerBlock("glowberry_bush",
            new ModFlowerBlock(StatusEffects.FIRE_RESISTANCE, 6, FLOWER_SETTINGS));
    public static final Block IRONVINE = registerBlock("ironvine",
            new ModFlowerBlock(StatusEffects.NIGHT_VISION, 8, FLOWER_SETTINGS));
    public static final Block ANCIENT_FLOWER = registerBlock("ancient_flower",
            new AncientFlowerBlock(StatusEffects.NIGHT_VISION, 8, FLOWER_SETTINGS));
    public static final Block ANCIENT_FLOWER_POT = registerBlock("ancient_flower_pot",
            new AncientFlowerPotBlock(Blocks.AIR, FLOWER_POT_SETTINGS));
    public static final Block POTTED_ANCIENT_FLOWER = registerBlockOnly("potted_ancient_flower",
            new AncientFlowerPotBlock(ANCIENT_FLOWER, FLOWER_POT_SETTINGS));

    private static Block registerBlockOnly(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(AncientAncestors.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block, ModItemGroup.ANCIENT_ANCESTORS);
        return Registry.register(Registry.BLOCK, new Identifier(AncientAncestors.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block, ItemGroup group) {
        Registry.register(Registry.ITEM, new Identifier(AncientAncestors.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        System.out.println("Registering ModBlocks for " + AncientAncestors.MOD_ID);
    }
}