package hn.blacknight0981.hNLib;

import hn.blacknight0981.hNLib.commands.HNCommand;
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

        getLogger().info("HNLib 加載完畢...");
    }

    @Override
    public void onDisable() {
        getLogger().info("HNLib 關閉中...");

        getLogger().info("HNLib 關閉完畢...");
    }
}
