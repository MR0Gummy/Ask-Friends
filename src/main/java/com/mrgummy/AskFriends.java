package com.mrgummy;

import com.mrgummy.blocks.ModBlocks;
import com.mrgummy.item.ModItemGroups;
import com.mrgummy.item.ModItems;
import com.mrgummy.misc.ModCustomTrades;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AskFriends implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("ask_friends");
	public static String MOD_ID = "ask_friends";

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TV_BLOCK, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STRAWBERRY_MILK, RenderLayer.getCutout());

		LOGGER.info("Hello Fabric world!");
		ModBlocks.regiterModBlock();
		ModItems.registerModItem();
		ModItemGroups.registerItemGroup();
		ModCustomTrades.registerCustomTrades();
	}
}