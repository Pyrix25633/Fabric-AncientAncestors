package net.rupyber_studios.ancient_ancestors.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.rupyber_studios.ancient_ancestors.entity.custom.FlapperEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class FlapperRenderer extends GeoEntityRenderer<FlapperEntity> {
    public FlapperRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new FlapperModel());
    }
}