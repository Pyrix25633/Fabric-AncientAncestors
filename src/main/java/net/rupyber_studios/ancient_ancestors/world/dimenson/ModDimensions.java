package net.rupyber_studios.ancient_ancestors.world.dimenson;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.rupyber_studios.ancient_ancestors.AncientAncestors;

public class ModDimensions {
    //public static final RegistryKey<World> THE_ANCIENT_DIMENSION_KEY = RegistryKey.of(Registry.WORLD_KEY,
    //        new Identifier(AncientAncestors.MOD_ID, "the_ancient"));
    //public static final RegistryKey<DimensionType> THE_ANCIENT_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
    //        THE_ANCIENT_DIMENSION_KEY.getValue());

    public static void register() {
        AncientAncestors.LOGGER.debug("Registering ModDimensions for " + AncientAncestors.MOD_ID);
    }
}