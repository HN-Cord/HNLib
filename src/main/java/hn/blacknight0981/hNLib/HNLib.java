package hn.blacknight0981.hNLib;

import hn.blacknight0981.hNLib.commands.HNCommand;
import hn.blacknight0981.hNLib.commands.HNCommandManager;
import hn.blacknight0981.hNLib.commands.sub.HelpCommand;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class HNLib extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("HNLib 加載中...");

        PluginCommand command = getCommand("hn");
        if (command != null) {
            command.setExecutor(new HNCommand());
            command.setTabCompleter(new HNCommand());
        }

        HNCommandManager.register(new HelpCommand());

        getLogger().info("HNLib 加載完畢...");
    }

    @Override
    public void onDisable() {
        getLogger().info("HNLib 關閉中...");

        getLogger().info("HNLib 關閉完畢...");
    }
}
