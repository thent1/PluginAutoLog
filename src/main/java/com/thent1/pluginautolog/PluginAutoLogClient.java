package com.thent1.pluginautolog;

import com.thent1.pluginautolog.event.KeyInputHandler;
import net.fabricmc.api.ClientModInitializer;

public class PluginAutoLogClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
    }
}
