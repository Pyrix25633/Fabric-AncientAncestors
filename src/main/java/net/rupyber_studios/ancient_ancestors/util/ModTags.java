package net.rupyber_studios.ancient_ancestors.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rupyber_studios.ancient_ancestors.AncientAncestors;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> ANCIENTBARK_LOGS = createTag("ancientbark_logs");
        public static final TagKey<Block> ANCIENTBARK_LOGS_COMMON = createCommonTag("ancientbark_logs");

        public static final TagKey<Block> VERTICAL_SLABS = createTag("vertical_slabs");
        public static final TagKey<Block> VERTICAL_SLABS_COMMON = createCommonTag("vertical_slabs_common");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(Registry.BLOCK_KEY, new Identifier(AncientAncestors.MOD_ID, name));
        }

        private static TagKey<Block> createCommonTag(String name) {
            return TagKey.of(Registry.BLOCK_KEY, new Identifier("c", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> ANCIENTBARK_LOGS = createTag("ancientbark_logs");
        public static final TagKey<Item> ANCIENTBARK_LOGS_COMMON = createCommonTag("ancientbark_logs");

        public static final TagKey<Item> VERTICAL_SLABS = createTag("vertical_slabs");
        public static final TagKey<Item> VERTICAL_SLABS_COMMON = createCommonTag("vertical_slabs_common");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier(AncientAncestors.MOD_ID, name));
        }

        private static TagKey<Item> createCommonTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier("c", name));
        }
    }
}