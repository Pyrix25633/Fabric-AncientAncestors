package net.rupyber_studios.ancient_ancestors.entity.client;

import net.minecraft.util.Identifier;
import net.rupyber_studios.ancient_ancestors.AncientAncestors;
import net.rupyber_studios.ancient_ancestors.entity.custom.FlapperEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class FlapperModel extends AnimatedGeoModel<FlapperEntity> {
    private static final Identifier MODEL_RESOURCE = new Identifier(AncientAncestors.MOD_ID, "geo/flapper.geo.json");
    private static final Identifier TEXTURE_RESOURCE = new Identifier(AncientAncestors.MOD_ID, "textures/entity/flapper.png");
    private static final Identifier ANIMATION_RESOURCE = new Identifier(AncientAncestors.MOD_ID, "animations/flapper.animations.json");

    @Override
    public Identifier getModelResource(FlapperEntity object) {
        return MODEL_RESOURCE;
    }

    @Override
    public Identifier getTextureResource(FlapperEntity object) {
        return TEXTURE_RESOURCE;
    }

    @Override
    public Identifier getAnimationResource(FlapperEntity animatable) {
        return ANIMATION_RESOURCE;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void setCustomAnimations(FlapperEntity entity, int uniqueID, AnimationEvent customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);
        IBone body = this.getAnimationProcessor().getBone("body");

        EntityModelData extraData = (EntityModelData)customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if(body != null) {
            body.setRotationX(extraData.headPitch * ((float)Math.PI / 180F) + (entity.isRoosting() ? -1.5F : 1));
            body.setRotationY((extraData.netHeadYaw + (entity.isRoosting() ? 180 : 0)) * ((float)Math.PI / 180F));
        }
    }
}