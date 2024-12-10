package hn.blacknight0981.hNLib.commands;

import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;

public class HNCommandManager {
    private static final Map<String, HNCommandIO> commands = new HashMap<>();

    public static void register(HNCommandIO command) {
        commands.put(command.getName(), command);
    }

    public static boolean execute(String name, CommandSender sender, String[] args) {
        HNCommandIO command = commands.get(name.toLowerCase());
        if (command == null) {
            sender.sendMessage("未知的子指令: " + name);
            return true;
        }
        return command.execute(sender, args);
    }

    public static Map<String, HNCommandIO> getCommands() {
        return commands;
    }
}