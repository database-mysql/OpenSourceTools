package cn.gtb520.tools.main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static cn.gtb520.tools.main.main.instance;

public class feed_Command implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            String CommandName = "Feed";
            if (player.isOp()) {
                if (!instance.getConfig().getBoolean(CommandName + "CommandSetting.AllowAdminUsed" + CommandName + "Command")) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d这个服务器禁止管理员使用Feed命令！"));
                    return false;
                }
            }else {
                if (!instance.getConfig().getBoolean(CommandName + "CommandSetting.AllowPlayerUsed" + CommandName + "Command")) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d这个服务器禁止玩家使用Feed命令！"));
                    return false;
                }
            }
            player.setSaturation(20);
            player.setFoodLevel(20);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&a你的饱食度被神奇的恢复了"));
        }else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&d这个命令只有玩家才能执行"));
        }
        return false;
    }
}
