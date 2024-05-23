package cn.gtb520.tools.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class Tpa_Time extends BukkitRunnable {
    main pluginmain;

    public Tpa_Time(main main1) {
        this.pluginmain = main1;
    }

    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            String PlayerName = player.getName();
            if (multi.GetIntTemp(PlayerName + "_ChatTime") != null) {
                int ChatTime = multi.GetIntTemp(PlayerName + "_ChatTime");
                int NewChatTime = ChatTime-1;
                multi.SetIntTemp(PlayerName + "_ChatTime",NewChatTime);
                if (multi.GetIntTemp(PlayerName + "_ChatTime") == 0) {
                    multi.SetIntTemp(PlayerName + "_ChatTime",null);
                }
            }

            if (multi.getStringTemp(PlayerName + "_Temp_TpaPlayerName") != null) {
                if (!multi.getBooleanTemp(PlayerName + "_Temp_Tpa")) {
                    int TpaTime = multi.GetIntTemp(PlayerName + "_Temp_TpaTime");
                    multi.SetIntTemp(PlayerName + "_Temp_TpaTime",TpaTime+1);
                    if (TpaTime+1 >= 60) {
                        String TpaPlayerName = multi.getStringTemp(PlayerName + "_Temp_TpaPlayerName");
                        Player TpaPlayer = Bukkit.getPlayer(Objects.requireNonNull(TpaPlayerName));
                        Objects.requireNonNull(TpaPlayer).sendMessage(ChatColor.translateAlternateColorCodes('&',"&d" + PlayerName + "给你发的的传送请求已超时"));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&d你发给" + TpaPlayerName + "的传送请求已超时"));
                        multi.SetStringTemp(PlayerName + "_Temp_TpaPlayerName",null);
                        multi.SetBooleanTemp(PlayerName + "_Temp_Tpa",false);
                        multi.SetIntTemp(PlayerName + "_Temp_TpaTime",0);
                    }
                }
            }
        }
    }
}