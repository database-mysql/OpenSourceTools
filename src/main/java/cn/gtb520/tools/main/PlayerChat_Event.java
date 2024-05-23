package cn.gtb520.tools.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayerChat_Event implements Listener {
    @EventHandler
    public void PlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String Message = event.getMessage();
        if (player.isOp()) {
            if (main.instance.getConfig().getBoolean("ColorChatSetting.AllowAdminUsedColorChat")) {
                event.setMessage(multi.ColorMessage(Message));
            }
        }else {
            if (main.instance.getConfig().getBoolean("ColorChatSetting.AllowPlayerUsedColorChat")) {
                event.setMessage(multi.ColorMessage(Message));
            }
        }

        for (String ColorChatPlayers : main.instance.getConfig().getStringList("ColorChatSetting.AllowPlayers")) {
            if (player.getName().equals(ColorChatPlayers)) {
                event.setMessage(multi.ColorMessage(Message));
            }
        }

        List<String> keywords = new ArrayList<>(main.instance.getConfig().getStringList("AntiKeyWords"));
        for (String keyword : keywords) {
            if (Message.toUpperCase().contentEquals(keyword)) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d&l检测到屏蔽词，已阻止发送\n屏蔽词内容:" + keyword));
                event.setCancelled(true);
                for (Player player1 : Bukkit.getOnlinePlayers()) {
                    if (player1.isOp()) {
                        if (!player1.getName().equals(player.getName())) {
                            player1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&l" + player.getName() + "尝试发送屏蔽词，已被阻止发送\n屏蔽词内容:" + keyword));
                        }
                    }
                }
                return;
            }
        }

        // 建议多线程处理。
        if (Objects.equals(multi.getStringTemp(player.getName() + "_Message"), Message)) {
            player.sendMessage(multi.ColorMessage("&d&l请不要刷屏！"));
            event.setCancelled(true);
            return;
        }

        if (multi.GetIntTemp(player.getName() + "_ChatTime") != null) {
            player.sendMessage(multi.ColorMessage("&e&l您发送消息太快了,请在" + multi.GetIntTemp(player.getName() + "_ChatTime") + "后发送"));
            event.setCancelled(true);
            return;
        }

        multi.SetStringTemp(player.getName() + "_Message", Message);
        multi.SetIntTemp(player.getName() + "_ChatTime", main.instance.getConfig().getInt("ChatSetting.ChatTime"));
    }
}
