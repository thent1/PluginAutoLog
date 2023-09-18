package com.thent1.pluginautolog.event;

import com.thent1.pluginautolog.PluginAutoLog;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_PAL = "key.category.pluginautolog";
    public static final String KEY_LOGIN_COMMAND = "key.pluginautolog.login";
    public static KeyBinding loginKey;



    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(loginKey.wasPressed()) {
                PluginAutoLog.executeCommand(MinecraftClient.getInstance().player, "/login ");
            }
        });
    }

    public static void register() {
        loginKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_LOGIN_COMMAND,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_G,
                KEY_CATEGORY_PAL
        ));

        registerKeyInputs();
    }

}
