package top.gtb520.tools.main;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin_Event implements Listener {
    @EventHandler
    public void PlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        unity.GetLoggerPlus("&e&l" + player.getName() + " IP：" + player.getAddress());
        main.instance.getConfig().set(player.getName() + "_Temp_TpaPlayerName",null);
        main.instance.getConfig().set(player.getName() + "_Temp_Tpa",null);
        main.instance.getConfig().set(player.getName() + "_Temp_TpaTime",null);
        main.instance.saveConfig();
        main.instance.reloadConfig();
        String PlayerJoinMessage = main.instance.getConfig().getString("PlayerJoinServerMessage").replaceAll("%PlayerName%",player.getPlayerListName());
        String AdminJoinMessage = main.instance.getConfig().getString("AdminJoinServerMessage").replaceAll("%PlayerName%",player.getPlayerListName());
        if (player.isOp()) {
            event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(player, AdminJoinMessage)));
        } else {
            event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(player, PlayerJoinMessage)));
        }
    }
}
