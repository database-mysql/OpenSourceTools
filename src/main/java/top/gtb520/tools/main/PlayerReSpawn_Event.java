package top.gtb520.tools.main;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerReSpawn_Event implements Listener {
    @EventHandler
    public void On_Event(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        Location DiedLocation = unity.getLocationTempTemp(player.getName() + "_Back");
        player.sendMessage(unity.ColorMessage("&a&l您的死亡位置是X:" + DiedLocation.getBlockX() + " Y:" + DiedLocation.getBlockY() + "_DiedY" + " Z:" + DiedLocation.getBlockZ()));
    }
}
