package hn.blacknight0981.hNLib.commands.sub;

import hn.blacknight0981.hNLib.commands.HNCommandIO;
import hn.blacknight0981.hNLib.commands.HNCommandManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.JoinConfiguration;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class HelpCommand implements HNCommandIO {
    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "顯示可用的指令列表";
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        List<Component> commandLines = new ArrayList<>();

        HNCommandManager.getCommands().forEach((name, command) -> {
            if (command.hasPermission(sender)) {
                String description = command.getDescription();
                if (description == null) {
                    description = "尚未說明";
                }

                Component commandLine = Component.text("/hn " + name)
                        .color(NamedTextColor.WHITE)
                        .append(Component.text(" - ").color(NamedTextColor.DARK_GRAY))
                        .append(Component.text(description).color(NamedTextColor.GRAY));

                commandLines.add(commandLine);
            }
        });

        Component message = Component.join(JoinConfiguration.separator(Component.text("\n")), commandLines);

        sender.sendMessage(message);
        return true;
    }
}
