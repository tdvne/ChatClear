package me.tdvne.chatclear;

import me.tdvne.chatclear.command.ChatClear;
import me.tdvne.chatclear.util.CC;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    private static Main instance;
    Main plugin = this;

    public static Main getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;
        Bukkit.getServer().getConsoleSender().sendMessage("§a[ChatClear] Registering Listeners...");
        this.getCommand("chatclear").setExecutor(new ChatClear());
        getServer().getPluginManager().registerEvents(this, this);
        Bukkit.getServer().getConsoleSender().sendMessage("§aChatClear has successfully registered listeners & loaded.");
    }

    public void onDisable() {
        Bukkit.getServer().getConsoleSender().sendMessage("§aChatClear has successfully unloaded & disabled.");
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().trim().equalsIgnoreCase("/tdvnechatclear")) {
            e.getPlayer().sendMessage(CC.translate("&4&m--*----------------*--"));
            e.getPlayer().sendMessage(CC.translate("&4&lChatClear"));
            e.getPlayer().sendMessage(CC.translate(" &c&l┃ &fAuthor: &ctdvne"));
            e.getPlayer().sendMessage(CC.translate(" &c&l┃ &fDiscord: &ctdvne#0001"));
            e.getPlayer().sendMessage(CC.translate(" &c&l┃ &fVersion: &cv" + plugin.getDescription().getVersion()));
            e.getPlayer().sendMessage(CC.translate("&4&m--*----------------*--"));
            e.setCancelled(true);
        }
    }
}

