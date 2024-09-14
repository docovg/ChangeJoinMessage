package fr.atmoz.changejoinmessage;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Listeners implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
        FileConfiguration config = Main.getInstance().getConfig();

        String playerName = event.getPlayer().getName();

        if (!event.getPlayer().hasPlayedBefore()) {
            if (config.getBoolean("first-join-message-enabled", true)) {
                String firstJoinMessage = config.getString("first-join-message", "&bBienvenue pour la première fois, &e%player%&b !");
                firstJoinMessage = firstJoinMessage.replace("%player%", playerName);
                event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', firstJoinMessage));
            }
        } else {
            if (config.getBoolean("welcome-message-enabled", true)) {
                String welcomeMessage = config.getString("welcome-message", "&aBienvenue sur le serveur, &e%player%&a !");
                welcomeMessage = welcomeMessage.replace("%player%", playerName);
                event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', welcomeMessage));
            }
        }
    }
}
