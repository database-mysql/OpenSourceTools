package cn.gtb520.tools.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class mute_Command implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            if (args.length == 1) {
                Player senderPlayer = (Player) sender;
                String PlayerName = args[0];

                if (Bukkit.getPlayer(PlayerName) == null) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d这个玩家不存在或不在线！"));
                    return false;
                }

                Player player = Bukkit.getPlayer(PlayerName);

                if (PlayerName.equals(senderPlayer.getName())) {
                    sender.sendMessage(ChatColor.RED + "你不能禁言你自己");
                    return false;
                }
                if (Objects.requireNonNull(player).isOp()) {
                    sender.sendMessage(ChatColor.RED + "你不能禁言管理员");
                    return false;
                }

                List<String> MutePlayerList = new ArrayList<>(main.instance.getConfig().getStringList("MutePlayerList"));

                for (String MutePlayers : MutePlayerList) {
                    if (MutePlayers.equals(Objects.requireNonNull(player).getName())) {
                        sender.sendMessage(ChatColor.RED + "这个玩家已经被禁言过了，请勿重复禁言!");
                        return false;
                    }
                }

                MutePlayerList.add(Objects.requireNonNull(player).getName());
                main.instance.getConfig().set("MutePlayerList", MutePlayerList);
                multi.SaveAndReloadConfig();
                sender.sendMessage(ChatColor.GREEN + "你禁言了" + player.getName());
                player.sendMessage(ChatColor.RED + "你被 " + senderPlayer.getName() + " 禁言了!");
                return false;
            }
        }else {
            if (args.length == 1) {
                String PlayerName = args[0];

                if (Bukkit.getPlayer(PlayerName) == null) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d这个玩家不存在或不在线！"));
                    return false;
                }

                Player player = Bukkit.getPlayer(PlayerName);

                List<String> MutePlayerList = new ArrayList<>(main.instance.getConfig().getStringList("MutePlayerList"));

                for (String MutePlayers : MutePlayerList) {
                    if (MutePlayers.equals(Objects.requireNonNull(player).getName())) {
                        sender.sendMessage(ChatColor.RED + "这个玩家已经被禁言过了，请勿重复禁言!");
                        return false;
                    }
                }

                MutePlayerList.add(Objects.requireNonNull(player).getName());
                main.instance.getConfig().set("MutePlayerList", MutePlayerList);
                multi.SaveAndReloadConfig();
                sender.sendMessage(ChatColor.GREEN + "你禁言了" + player.getName());
                player.sendMessage(ChatColor.RED + "你被 控制台 禁言了!");
                return false;
            }
        }
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&d用法错误,用法：/mute <玩家ID>"));
        return false;
    }
}

