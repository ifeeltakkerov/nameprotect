package dev.ifeeltakker;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;

class NPCommand {

    public static void register(CommandDispatcher<FabricClientCommandSource> d) {
        d.register(ClientCommandManager.literal("nameprotect")
                .then(ClientCommandManager.literal("toggle")
                        .executes(ctx -> Init.toggle()))
                .then(ClientCommandManager.literal("change")
                        .then(ClientCommandManager.argument("newname", StringArgumentType.greedyString())
                                .executes(ctx -> Init.setName(StringArgumentType.getString(ctx, "newname")))))
        );
    }
}
