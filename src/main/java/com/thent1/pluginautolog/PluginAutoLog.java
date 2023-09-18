package com.thent1.pluginautolog;

import net.fabricmc.api.ModInitializer;

import net.minecraft.client.network.ClientPlayerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PluginAutoLog implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "pluginautolog";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
	}

	public static void executeCommand(ClientPlayerEntity player, String command){
		if (command.startsWith("/")) {
			command = command.substring(1);
			player.networkHandler.sendChatCommand(command);
		} else {
			player.networkHandler.sendChatMessage(command);
		}
	}

}