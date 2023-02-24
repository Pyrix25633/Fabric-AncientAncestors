package net.rupyber_studios.ancient_ancestors.util;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.rupyber_studios.ancient_ancestors.block.ModBlocks;

public class ModRegistries {
    public static void cutoutBlocks() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ANCIENT_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORAL_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TALL_CORAL_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LOGWEED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WITCH_SPOUT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SHARPBLOSSOM, RenderLayer.getCutout());
    }

    public static void registerAttributes() {
        //FabricDefaultAttributeRegistry.register(ModEntities.Test, Test.setAttributes());
    }

    public static void registerRenderers() {
        //EntityRendererRegistry.register(ModEntities.Test, TestRenderer::new);
    }
}