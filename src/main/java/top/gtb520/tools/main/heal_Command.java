package top.gtb520.tools.main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static top.gtb520.tools.main.main.instance;

public class heal_Command implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            String CommandName = "heal";
            if (player.isOp()) {
                if (!instance.getConfig().getBoolean(CommandName + "CommandSetting.AllowAdminUsed" + CommandName + "Command")) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d这个服务器禁止管理员使用heal命令！"));
                    return false;
                }
            }else {
                if (!instance.getConfig().getBoolean(CommandName + "CommandSetting.AllowPlayerUsed" + CommandName + "Command")) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d这个服务器禁止玩家使用heal命令！"));
                    return false;
                }
            }
            player.setSaturation(20);
            player.setFoodLevel(20);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&a你的血量被神奇的恢复了"));
        }else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&d这个命令只有玩家才能执行"));
        }
        return false;
    }
}
