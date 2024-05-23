package cn.gtb520.tools.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class KickGUI_ClickGUI_Event implements Listener {

    @EventHandler
    public void ClickGUI(InventoryClickEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',"&a选择你要踢出的玩家"))) {
            event.setCancelled(true);

            if (event.getCurrentItem() == null) {
                return;
            }

            if (event.getCurrentItem().getType().equals(Material.AIR)) {
                return;
            }

            if (Objects.requireNonNull(event.getCurrentItem()).getType().equals(Material.ORANGE_STAINED_GLASS_PANE)) {
                Player player = (Player) event.getWhoClicked();
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&a这只是一个边框,你为什么要点"));
            }

            if (Objects.requireNonNull(event.getCurrentItem()).getType().equals(Material.REDSTONE_BLOCK)) {
                Player player = (Player) event.getWhoClicked();
                player.closeInventory();
            }

            if (Objects.requireNonNull(event.getCurrentItem()).getType().equals(Material.PLAYER_HEAD)) {
                Player player = (Player) event.getWhoClicked();
                String PlayerName = Objects.requireNonNull(event.getCurrentItem().getItemMeta()).getDisplayName();
                Player KickPlayer = Bukkit.getPlayer(PlayerName);
                if(Bukkit.getPlayer(PlayerName) == null) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&d这个玩家不存在或不在线"));
                }else {
                    if (Objects.requireNonNull(KickPlayer).isOnline()) {
                        if (!KickPlayer.isOp()) {
                            if (!KickPlayer.getName().equals(player.getName())) {
                                KickPlayer.kickPlayer(ChatColor.translateAlternateColorCodes('&',"&d你被踢出服务器" ));
                            }else {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&d你不能踢出自己"));
                            }
                        }else {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&d你不能踢出管理员"));
                        }
                    }
                }
            }
        }
    }
}
