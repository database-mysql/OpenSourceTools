package cn.gtb520.tools.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class fly_Command implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1) {
            String PlayerName = args[0];
            if (Bukkit.getPlayer(PlayerName) == null) {
                sender.sendMessage(multi.ColorMessage("&d&l这个玩家不存在或不在线!"));
                return false;
            }
            Player player = Bukkit.getPlayer(PlayerName);
            assert player != null;
            if (player.getAllowFlight()) {
                sender.sendMessage(multi.ColorMessage("&e&l" + player.getName() + "飞行模式已关闭"));
                player.sendMessage(multi.ColorMessage("&e&l飞行模式已关闭"));
                multi.SetStringTemp(player.getName() + "_Fly",null);
            }else {
                sender.sendMessage(multi.ColorMessage("&a&l" + player.getName() + "操作成功!"));
                player.sendMessage(multi.ColorMessage("&e&l飞行模式已开启"));
                multi.SetStringTemp(player.getName() + "_Fly","已开启");
            }
            player.setAllowFlight(!player.getAllowFlight());
        }else {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.getAllowFlight()) {
                    player.sendMessage(multi.ColorMessage("&e&l飞行模式已关闭"));
                    multi.SetStringTemp(player.getName() + "_Fly",null);
                }else {
                    player.sendMessage(multi.ColorMessage("&e&l飞行模式已开启"));
                    multi.SetStringTemp(player.getName() + "_Fly","已开启");
                }
                player.setAllowFlight(!player.getAllowFlight());
            }else {
                sender.sendMessage(multi.ColorMessage("&d&l用法错误,正确用法:/fly [玩家ID]"));
            }
        }
        return false;
    }
}