package net.rupyber_studios.ancient_ancestors;

import net.fabricmc.api.ModInitializer;
import net.rupyber_studios.ancient_ancestors.block.ModBlocks;
import net.rupyber_studios.ancient_ancestors.item.ModItems;
import net.rupyber_studios.ancient_ancestors.util.ModRegistries;
import net.rupyber_studios.ancient_ancestors.world.dimenson.ModDimensions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class AncientAncestors implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("ancient_ancestors");

	public static final String MOD_ID = "ancient_ancestors";

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModBlocks.registerModBlocks();

		ModItems.registerModItems();

		GeckoLib.initialize();

		ModRegistries.registerAttributes();

		ModDimensions.register();

		LOGGER.info("Hello Fabric world!");
	}
}