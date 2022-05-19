package me.tdvne;

import me.tdvne.command.ChatClear;
import me.tdvne.util.CC;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
    public void onEnable() {
        this.getCommand("chatclear").setExecutor(new ChatClear());
        System.out.println("[ChatClear] This plugin has successfully enabled.");
    }

    public void onDisable() {
        System.out.println("[ChatClear] This plugin has successfully disabled");
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().trim().equalsIgnoreCase("/tdvnechatclear")) {
            e.getPlayer().sendMessage(CC.translate("&4&m--*----------------*--"));
            e.getPlayer().sendMessage(CC.translate("&4&lChatClear"));
            e.getPlayer().sendMessage(CC.translate(" &c&l┃ &fAuthor: &ctdvne"));
            e.getPlayer().sendMessage(CC.translate(" &c&l┃ &fDiscord: &ctdvne#0001"));
            e.getPlayer().sendMessage(CC.translate(" &c&l┃ &fVersion: &cv1.0"));
            e.getPlayer().sendMessage(CC.translate("&4&m--*----------------*--"));
            e.setCancelled(true);
        }
    }
}

