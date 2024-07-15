package top.gtb520.tools.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class SuperKick_Command implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1) {
            String PlayerName = args[0];
            Player player = Bukkit.getPlayer(PlayerName);
            if (Bukkit.getPlayer(PlayerName) == null) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d这个玩家不存在或不在线"));
            } else {
                if (Objects.requireNonNull(player).isOnline()) {
                    if (sender instanceof Player) {
                        if (!player.isOp()) {
                            if (!player.getName().equals(player.getName())) {
                                player.kickPlayer(ChatColor.translateAlternateColorCodes('&', "&d你被踢出服务器"));
                            } else {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d你不能踢出自己"));
                            }
                        } else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d你不能踢出管理员"));
                        }
                    } else {
                        player.kickPlayer(ChatColor.translateAlternateColorCodes('&', "&d你被踢出服务器"));
                    }
                }
            }
            return false;
        }

        if (args.length == 2) {
            String PlayerName = args[0];
            String message = args[1];
            Player player = Bukkit.getPlayer(PlayerName);
            if (Bukkit.getPlayer(PlayerName) == null) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d这个玩家不存在或不在线"));
            } else {
                if (Objects.requireNonNull(player).isOnline()) {
                    if (sender instanceof Player) {
                        if (!player.isOp()) {
                            if (!player.getName().equals(player.getName())) {
                                player.kickPlayer(ChatColor.translateAlternateColorCodes('&', message));
                            } else {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d你不能踢出自己"));
                            }
                        } else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d你不能踢出管理员"));
                        }
                    } else {
                        player.kickPlayer(ChatColor.translateAlternateColorCodes('&', message));
                    }
                }
            }
            return false;
        }
        if (sender instanceof Player) {
            Player player = (Player) sender;
            unity.KickGui(player);
        }else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&a正确用法&f: /kick &f<&e玩家ID&f> &f[&e理由&f]"));
        }
        return false;
    }
}
