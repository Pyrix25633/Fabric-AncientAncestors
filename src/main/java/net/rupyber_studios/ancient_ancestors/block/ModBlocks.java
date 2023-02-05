package net.rupyber_studios.ancient_ancestors.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rupyber_studios.ancient_ancestors.AncientAncestors;
import net.rupyber_studios.ancient_ancestors.item.ModItemGroup;

public class ModBlocks {
    public static final Block ANCIENT_GRASS_BLOCK = registerBlock("ancient_grass_block",
            new AncientGrassBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).strength(0.6F).sounds(BlockSoundGroup.GRASS)));
    public static final Block ANCIENT_DIRT = registerBlock("ancient_dirt",
            new Block(AbstractBlock.Settings.of(Material.SOIL, MapColor.DIRT_BROWN).strength(0.5F).sounds(BlockSoundGroup.GRAVEL)));
    public static final Block ANCIENT_STONE = registerBlock("ancient_stone",
            new Block(AbstractBlock.Settings.of(Material.STONE, MapColor.STONE_GRAY).strength(1.5F, 6.0F)));
    public static final Block ANCIENT_CLAY = registerBlock("ancient_clay",
            new Block(AbstractBlock.Settings.of(Material.ORGANIC_PRODUCT).strength(0.6F).sounds(BlockSoundGroup.GRAVEL)));

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