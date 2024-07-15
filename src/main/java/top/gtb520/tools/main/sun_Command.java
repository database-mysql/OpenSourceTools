package cn.gtb520.tools.main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class sun_Command implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.getWorld().setStorm(false);
            player.getWorld().setThundering(false);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&a完成!"));
        }else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&d这个命令只能是玩家执行"));
        }
        return false;
    }
}
