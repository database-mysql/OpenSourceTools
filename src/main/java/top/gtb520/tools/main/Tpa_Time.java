package top.gtb520.tools.main;

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
            if (unity.GetIntTemp(PlayerName + "_ChatTime") != null) {
                int ChatTime = unity.GetIntTemp(PlayerName + "_ChatTime");
                int NewChatTime = ChatTime-1;
                unity.SetIntTemp(PlayerName + "_ChatTime",NewChatTime);
                if (unity.GetIntTemp(PlayerName + "_ChatTime") == 0) {
                    unity.SetIntTemp(PlayerName + "_ChatTime",null);
                }
            }

            if (unity.getStringTemp(PlayerName + "_Temp_TpaPlayerName") != null) {
                if (!unity.getBooleanTemp(PlayerName + "_Temp_Tpa")) {
                    int TpaTime = unity.GetIntTemp(PlayerName + "_Temp_TpaTime");
                    unity.SetIntTemp(PlayerName + "_Temp_TpaTime",TpaTime+1);
                    if (TpaTime+1 >= 60) {
                        String TpaPlayerName = unity.getStringTemp(PlayerName + "_Temp_TpaPlayerName");
                        Player TpaPlayer = Bukkit.getPlayer(Objects.requireNonNull(TpaPlayerName));
                        Objects.requireNonNull(TpaPlayer).sendMessage(ChatColor.translateAlternateColorCodes('&',"&d" + PlayerName + "给你发的的传送请求已超时"));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&d你发给" + TpaPlayerName + "的传送请求已超时"));
                        unity.SetStringTemp(PlayerName + "_Temp_TpaPlayerName",null);
                        unity.SetBooleanTemp(PlayerName + "_Temp_Tpa",false);
                        unity.SetIntTemp(PlayerName + "_Temp_TpaTime",0);
                    }
                }
            }
        }
    }
}