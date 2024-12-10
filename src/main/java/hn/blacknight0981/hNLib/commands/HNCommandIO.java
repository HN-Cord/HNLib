package hn.blacknight0981.hNLib.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;

import java.util.List;

public interface HNCommandIO {
    String getName();

    boolean execute(CommandSender sender, String[] args);

    default List<String> tabComplete(CommandSender sender, String[] args) {
        return List.of();
    }

    default String getPermission() {
        return null;
    }

    default boolean hasPermission(CommandSender sender) {
        String permission = getPermission();
        return permission == null || sender.hasPermission(permission);
    }

    default Component getDescription() {
        return Component.text(" ");
    }
}
