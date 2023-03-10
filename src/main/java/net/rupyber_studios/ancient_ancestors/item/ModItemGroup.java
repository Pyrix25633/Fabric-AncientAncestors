package net.rupyber_studios.ancient_ancestors.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.rupyber_studios.ancient_ancestors.AncientAncestors;
import net.rupyber_studios.ancient_ancestors.block.ModBlocks;

public class ModItemGroup {
    public static final ItemGroup ANCIENT_ANCESTORS = FabricItemGroupBuilder.build(new Identifier(AncientAncestors.MOD_ID,
            "ancient_ancestors"), () -> new ItemStack(ModBlocks.ANCIENT_GRASS_BLOCK));
}