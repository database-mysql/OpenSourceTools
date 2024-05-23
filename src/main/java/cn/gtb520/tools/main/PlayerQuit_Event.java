package cn.gtb520.tools.main;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit_Event implements Listener {
    @EventHandler
    public void PlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        main.instance.getConfig().set(player.getName() + "_Temp_TpaPlayerName", null);
        main.instance.getConfig().set(player.getName() + "_Temp_Tpa", null);
        main.instance.getConfig().set(player.getName() + "_Temp_TpaTime", null);
        main.instance.saveConfig();
        main.instance.reloadConfig();
        String PlayerQuitMessage = main.instance.getConfig().getString("PlayerQuitServerMessage").replaceAll("%PlayerName%",player.getPlayerListName());
        String AdminQuitMessage = main.instance.getConfig().getString("AdminQuitServerMessage").replaceAll("%PlayerName%",player.getPlayerListName());
        if (player.isOp()) {
            event.setQuitMessage(ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(player, AdminQuitMessage)));
        } else {
            event.setQuitMessage(ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(player, PlayerQuitMessage)));
        }
    }
}
