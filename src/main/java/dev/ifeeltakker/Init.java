package dev.ifeeltakker;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;

public enum Init {
    INSTANCE;

    private static boolean enabled = false;
    private static String customName = "ifeeltakker";

    // Инициализация команд
    public void init() {
        ClientCommandRegistrationCallback.EVENT.register(Init::registerCommands);
    }

    private static void registerCommands(CommandDispatcher<FabricClientCommandSource> dispatcher, Object o) {
        NPCommand.register(dispatcher);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public static int toggle() {
        enabled = !enabled;
        String msg = enabled ? "NameProtect §aON" : "NameProtect §cOFF";

        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null) {
            client.player.sendMessage(Text.of(msg), false);
        }

        return 0;
    }

    public static int setName(String newName) {
        customName = newName;

        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null) {
            client.player.sendMessage(Text.of("Name set to: §7§l" + customName), false);
        }

        return 0;
    }

    public static String replaceName(String text) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (text != null && enabled && client.player != null) {
            String playerName = client.player.getName().getString();
            if (playerName != null && !playerName.isEmpty()) {
                return text.replace(playerName, customName);
            }
        }
        return text;
    }
}
