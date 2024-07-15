package top.gtb520.tools.main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class PlayerChangedWorld_Event implements Listener {
    @EventHandler
    public void On_Event(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("OpenSourceTools.FLY")) {
            if (unity.getStringTemp(player.getName() + "_Fly").equals("已开启")) {
                player.setAllowFlight(true);
            }
        }
    }
}
