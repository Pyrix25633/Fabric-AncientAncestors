package net.rupyber_studios.ancient_ancestors.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rupyber_studios.ancient_ancestors.AncientAncestors;
import net.rupyber_studios.ancient_ancestors.entity.custom.FlapperEntity;

public class ModEntities {
    public static final EntityType<FlapperEntity> FLAPPER = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(AncientAncestors.MOD_ID, "flapper"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, FlapperEntity::new)
                    .dimensions(EntityDimensions.fixed(0.9F,0.5F)).build());
}