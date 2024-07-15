package top.gtb520.tools.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class TimeMessage extends BukkitRunnable {
    main pluginmain;

    private int i = 0;

    public TimeMessage(main main1) {
        this.pluginmain = main1;
    }

    private static int order(int i) {
        i++;
        return i;
    }

    public void run() {
        if (main.instance.getConfig().getBoolean("TimeMessageSetting.TimeMessage"))
            if (this.i < main.instance.getConfig().getStringList("TimeMessageSetting.Message").size()) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', main.instance.getConfig().getStringList("TimeMessageSetting.Message").get(this.i)));
                this.i = order(this.i);
            } else {
                this.i = 0;
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', main.instance.getConfig().getStringList("TimeMessageSetting.Message").get(this.i)));
                this.i = order(this.i);
            }
    }
}
