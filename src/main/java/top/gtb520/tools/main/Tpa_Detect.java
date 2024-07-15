package top.gtb520.tools.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class Tpa_Detect extends BukkitRunnable {
    main pluginmain;

    public Tpa_Detect(main main1) {
        this.pluginmain = main1;
    }

    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            String PlayerName = player.getName();
            if (unity.getStringTemp(PlayerName + "_Temp_TpaPlayerName") != null) {
                if (unity.getBooleanTemp(PlayerName + "_Temp_Tpa")) {
                    if (Bukkit.getPlayer(Objects.requireNonNull(unity.getStringTemp(PlayerName + "_Temp_TpaPlayerName"))) == null) {
                        player.sendMessage(ChatColor.RED + "错误,那个玩家突然下线了!传送已取消");
                    }else {
                        Player TpaPlayer = Bukkit.getPlayer(Objects.requireNonNull(unity.getStringTemp(PlayerName + "_Temp_TpaPlayerName")));
                        Location TpaLocation = Objects.requireNonNull(TpaPlayer).getLocation();
                        unity.SetLocationTempTemp(player.getName() + "_Tpa",player.getLocation());
                        player.teleport(TpaLocation);
                        player.sendMessage(ChatColor.GREEN + "传送成功！");
                        TpaPlayer.sendMessage(ChatColor.GREEN + player.getName() + "传送到了你这里!");
                    }
                    unity.SetStringTemp(PlayerName + "_Temp_TpaPlayerName",null);
                    unity.SetBooleanTemp(PlayerName + "_Temp_Tpa",false);
                    unity.SetIntTemp(PlayerName + "_Temp_TpaTime",0);
                }
            }
        }
    }
}
