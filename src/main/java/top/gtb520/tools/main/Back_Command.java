package top.gtb520.tools.main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Back_Command implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (unity.getLocationTempTemp(player.getName() + "_Back") == null) {
                sender.sendMessage(unity.ColorMessage("&d&l你没有死亡过！"));
                return false;
            } else {
                player.sendMessage(unity.ColorMessage("&a&l你已返回死亡地点\n传送前的位置是X:" + player.getLocation().getBlockX() + "Y:" + player.getLocation().getBlockY() + "Z:" + player.getLocation().getBlockZ()));
                player.teleport(unity.getLocationTempTemp(player.getName() + "_Back"));
            }
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d这个命令只有玩家才能执行"));
        }
        return false;
    }
}
