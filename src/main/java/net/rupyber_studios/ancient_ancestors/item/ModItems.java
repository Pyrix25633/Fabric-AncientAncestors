package net.rupyber_studios.ancient_ancestors.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rupyber_studios.ancient_ancestors.AncientAncestors;

public class ModItems {
    private static final FabricItemSettings itemSettings = new FabricItemSettings().group(ModItemGroup.ANCIENT_ANCESTORS);

    public static final Item ANCIENT_CLAY_BALL = registerItem("ancient_clay_ball",
            new Item(itemSettings));
    public static final Item ANCIENT_BRICK = registerItem("ancient_brick",
            new Item(itemSettings));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(AncientAncestors.MOD_ID, name), item);
    }

    public static void registerModItems() {
        System.out.println("Registering ModItems for " + AncientAncestors.MOD_ID);
    }
}