package hn.blacknight0981.hNLib.commands;

import hn.blacknight0981.hNLib.HNLib;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

    public class HNCommand implements CommandExecutor, TabCompleter {

        @Override
        public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
            if (strings.length == 0) {
                commandSender.sendMessage(Component.text("請提供一個 子命令").color(NamedTextColor.RED));
                return true;
            }

            String subCommand = strings[0];
            String[] subStrings = new String[strings.length - 1];
            System.arraycopy(strings, 1, subStrings, 0, subStrings.length);

            return HNLib.getCommandManager().execute(subCommand, commandSender, subStrings);
        }

        @Override
        public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
            if (strings.length == 1) {
                List<String> subStrings = new ArrayList<>();
                String partial = strings[0].toLowerCase();
                for (String subCommand : HNLib.getCommandManager().getCommands().keySet()) {
                    if (subCommand.startsWith(partial)) {
                        subStrings.add(subCommand);
                    }
                }
                return subStrings;
            } else if (strings.length > 1){
                // 交給 子命令參數
                HNCommandIO commandIO = HNLib.getCommandManager().getCommands().get(strings[0].toLowerCase());
                if (commandIO != null) {
                    String[] subStrings = new String[strings.length - 1];
                    System.arraycopy(strings, 1, subStrings, 0, subStrings.length);
                    return commandIO.tabComplete(commandSender, subStrings);
                }
            }
            return List.of();
        }
    }
