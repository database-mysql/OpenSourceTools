package cn.gtb520.tools.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class vanish_Command implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1) {
            String PlayerName = args[0];
            if (Bukkit.getPlayer(PlayerName) == null) {
                sender.sendMessage(multi.ColorMessage("&d&l这个玩家不存在或不在线!"));
                return false;
            }
            Player player = Bukkit.getPlayer(PlayerName);
            if (multi.getStringTemp(player.getName() + "_Vanish") != null) {
                for (Player AllPlayer : Bukkit.getOnlinePlayers()) {
                    AllPlayer.showPlayer(main.instance,player);
                }
                player.removePotionEffect(PotionEffectType.INVISIBILITY);
                multi.SetStringTemp(player.getName() + "_Vanish",null);
                sender.sendMessage(multi.ColorMessage("&a&l操作成功!"));
                player.sendMessage(multi.ColorMessage("&e&l隐身模式已关闭"));
            }else {
                for (Player AllPlayer : Bukkit.getOnlinePlayers()) {
                    AllPlayer.hidePlayer(main.instance,player);
                }
                PotionEffect pot = new PotionEffect(PotionEffectType.INVISIBILITY, 99999, 255, true);
                player.addPotionEffect(pot);
                multi.SetStringTemp(player.getName() + "_Vanish","已开启");
                sender.sendMessage(multi.ColorMessage("&a&l操作成功!"));
                player.sendMessage(multi.ColorMessage("&e&l隐身模式已开启"));
            }
        }else {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (multi.getStringTemp(player.getName() + "_Vanish") != null) {
                    for (Player AllPlayer : Bukkit.getOnlinePlayers()) {
                        AllPlayer.showPlayer(main.instance,player);
                    }
                    player.removePotionEffect(PotionEffectType.INVISIBILITY);
                    multi.SetStringTemp(player.getName() + "_Vanish",null);
                    player.sendMessage(multi.ColorMessage("&e&l隐身模式已关闭"));
                }else {
                    for (Player AllPlayer : Bukkit.getOnlinePlayers()) {
                        AllPlayer.hidePlayer(main.instance,player);
                    }
                    PotionEffect pot = new PotionEffect(PotionEffectType.INVISIBILITY, 99999, 255, true);
                    player.addPotionEffect(pot);
                    multi.SetStringTemp(player.getName() + "_Vanish","已开启");
                    player.sendMessage(multi.ColorMessage("&e&l隐身模式已开启"));
                }
            }else {
                sender.sendMessage(multi.ColorMessage("&d&l用法错误,正确用法:/" + label + " [玩家ID]"));
            }
        }
        return false;
    }
}
