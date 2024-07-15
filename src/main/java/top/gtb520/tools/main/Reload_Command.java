package cn.gtb520.tools.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

public class Reload_Command implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        main.instance.reloadConfig();
        if (multi.GetIntTemp("TimeMessageTaskId") != null) {
            Bukkit.getScheduler().cancelTask(multi.GetIntTemp("TimeMessageTaskId"));
        }
        if (main.instance.getConfig().getBoolean("TimeMessageSetting.TimeMessage")) {
            BukkitTask TimeMessage = (new TimeMessage(main.instance)).runTaskTimer(main.instance, 0L, (main.instance.getConfig().getInt("TimeMessageSetting.TimeMessageTime") * 20L));
            multi.SetIntTemp("TimeMessageTaskId",TimeMessage.getTaskId());
        }
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&a重载完成!"));
        return false;
    }
}
