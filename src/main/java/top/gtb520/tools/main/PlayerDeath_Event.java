package top.gtb520.tools.main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath_Event implements Listener {
    @EventHandler
    public void On_Event(PlayerDeathEvent event) {
        Player player = event.getEntity();
        unity.SetLocationTempTemp(player.getName() + "_Back",player.getLocation());
    }
}
