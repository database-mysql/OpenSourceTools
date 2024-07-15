package top.gtb520.tools.main;

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

public class unmute_Command implements CommandExecutor {
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

                List<String> MutePlayerList = new ArrayList<>(main.instance.getConfig().getStringList("MutePlayerList"));

                for (String MutePlayers : MutePlayerList) {
                    if (MutePlayers.equals(Objects.requireNonNull(player).getName())) {
                        MutePlayerList.remove(Objects.requireNonNull(player).getName());
                        main.instance.getConfig().set("MutePlayerList", MutePlayerList);
                        unity.SaveAndReloadConfig();
                        sender.sendMessage(ChatColor.GREEN + "你解除了 " + player.getName() + " 的禁言");
                        player.sendMessage(ChatColor.RED + "你被 " + senderPlayer.getName() + " 解除禁言了!");
                        return false;
                    }
                }
                sender.sendMessage(ChatColor.RED + "这个玩家没有被禁言过!");
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
                        MutePlayerList.add(Objects.requireNonNull(player).getName());
                        main.instance.getConfig().set("MutePlayerList", MutePlayerList);
                        unity.SaveAndReloadConfig();
                        sender.sendMessage(ChatColor.GREEN + "你解除了 控制台 的禁言");
                        player.sendMessage(ChatColor.RED + "你被 控制台 解除禁言了!");
                        return false;
                    }
                }
                sender.sendMessage(ChatColor.RED + "这个玩家没有被禁言过!");
                return false;
            }
        }
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&d用法错误,用法：/unmute <玩家ID>"));
        return false;
    }
}
