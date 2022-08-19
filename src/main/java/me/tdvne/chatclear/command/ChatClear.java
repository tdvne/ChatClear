package me.tdvne.chatclear.command;

import me.tdvne.chatclear.util.CC;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatClear implements CommandExecutor {
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player) sender;
            if (!player.hasPermission("chatclear.admin")) {
                player.sendMessage(CC.translate("&cYou do not have permission to execute this command."));
                return false;
            }
        }
        if (args.length != 0) {
            sender.sendMessage(CC.translate("&cUsage: /chatclear"));
            return true;
        }
        for (final Player all : Bukkit.getOnlinePlayers()) {
            if (all.hasPermission("chatclear.admin")) {
                continue;
            }
            for (int i = 0; i < 1200; ++i) {
                all.sendMessage(" ");
            }
        }
        if (sender instanceof Player) {
            final Player player = (Player) sender;
            Bukkit.broadcastMessage(CC.translate("&c&lThe chat was cleared by &e&l" + player.getDisplayName() + "&c&l!"));
            return true;
        }
        Bukkit.broadcastMessage(CC.translate("&c&lThe chat was cleared by &e&lCONSOLE&c&l!"));
        return false;
    }
}