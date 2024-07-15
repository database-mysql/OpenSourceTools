package top.gtb520.tools.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Stop_Command implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1) {
            String ServerName = main.instance.getConfig().getString("ServerName");
            String StopMessage = args[0];
            if (Bukkit.getOnlinePlayers().size() != 0) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.kickPlayer(ChatColor.translateAlternateColorCodes('&',ServerName + "\n" +StopMessage));
                }
                Bukkit.shutdown();
            }else {
                Bukkit.shutdown();
            }
        }else {
            String ServerName = main.instance.getConfig().getString("ServerName");
            String StopMessage = main.instance.getConfig().getString("DefaultStopMessage");
            if (Bukkit.getOnlinePlayers().size() != 0) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.kickPlayer(ChatColor.translateAlternateColorCodes('&',ServerName + "\n" +StopMessage));
                }
                Bukkit.shutdown();
            }else {
                Bukkit.shutdown();
            }
        }
        return false;
    }
}
