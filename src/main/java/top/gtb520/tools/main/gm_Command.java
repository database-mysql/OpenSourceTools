package top.gtb520.tools.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class gm_Command implements TabExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1) {
            if (sender instanceof Player) {
                String args1 = args[0];
                String senderName = sender.getName();
                Player player = (Player) sender;
                if (args1.equalsIgnoreCase("1") || args1.equalsIgnoreCase("创造")  || args1.equalsIgnoreCase("creative")) {
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&f你的模式已被更改成 创造模式"));
                    for (Player AllPlayer : Bukkit.getOnlinePlayers()) {
                        if (AllPlayer.isOp()) {
                            if (!AllPlayer.getName().equals(player.getName())) {
                                AllPlayer.sendMessage(ChatColor.GRAY + "[" + senderName + ":更改了玩家" + player.getName() + "的游戏模式为 创造模式]");
                            }
                        }
                    }
                    return false;
                }

                if (args1.equalsIgnoreCase("2") || args1.equalsIgnoreCase("冒险")  || args1.equalsIgnoreCase("adventure")) {
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&f你的模式已被更改成 冒险模式"));
                    for (Player AllPlayer : Bukkit.getOnlinePlayers()) {
                        if (AllPlayer.isOp()) {
                            if (!AllPlayer.getName().equals(player.getName())) {
                                AllPlayer.sendMessage(ChatColor.GRAY + "[" + senderName + ":更改了玩家" + player.getName() + "的游戏模式为 冒险模式]");
                            }
                        }
                    }
                    return false;
                }

                if (args1.equalsIgnoreCase("3") || args1.equalsIgnoreCase("旁观")  || args1.equalsIgnoreCase("spectator")) {
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&f你的模式已被更改成 旁观模式"));
                    for (Player AllPlayer : Bukkit.getOnlinePlayers()) {
                        if (AllPlayer.isOp()) {
                            if (!AllPlayer.getName().equals(player.getName())) {
                                AllPlayer.sendMessage(ChatColor.GRAY + "[" + senderName + ":更改了玩家" + player.getName() + "的游戏模式为 旁观模式]");
                            }
                        }
                    }
                    return false;
                }

                if (args1.equalsIgnoreCase("0") || args1.equalsIgnoreCase("生存")  || args1.equalsIgnoreCase("survival")) {
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&f你的模式已被更改成 生存模式"));
                    for (Player AllPlayer : Bukkit.getOnlinePlayers()) {
                        if (AllPlayer.isOp()) {
                            if (!AllPlayer.getName().equals(player.getName())) {
                                AllPlayer.sendMessage(ChatColor.GRAY + "[" + senderName + ":更改了玩家" + player.getName() + "的游戏模式为 生存模式]");
                            }
                        }
                    }
                    return false;
                }

                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&d" + args1 + "不是一个有效的模式"));
            }else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&d用法错误，用法:/gamemode <模式> [玩家]"));
            }
        }else {
            if (args.length == 2) {
                String args1 = args[0];
                if (Bukkit.getPlayer(args[1]) == null) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&d这个玩家不存在或不在线"));
                    return false;
                }else {
                    String senderName;
                    if (sender instanceof Player) {
                        senderName = sender.getName();
                    }else {
                        senderName = "Server";
                    }
                    Player player = Bukkit.getPlayer(args[1]);
                    if (args1.equalsIgnoreCase("1") || args1.equalsIgnoreCase("创造")  || args1.equalsIgnoreCase("creative")) {
                        Objects.requireNonNull(player).setGameMode(GameMode.CREATIVE);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&f你的模式已被更改成 创造模式"));
                        for (Player AllPlayer : Bukkit.getOnlinePlayers()) {
                            if (AllPlayer.isOp()) {
                                if (!AllPlayer.getName().equals(player.getName())) {
                                    AllPlayer.sendMessage(ChatColor.GRAY + "[" + senderName + ":更改了玩家" + player.getName() + "的游戏模式为 创造模式]");
                                }
                            }
                        }
                        return false;
                    }

                    if (args1.equalsIgnoreCase("2") || args1.equalsIgnoreCase("冒险")  || args1.equalsIgnoreCase("adventure")) {
                        Objects.requireNonNull(player).setGameMode(GameMode.ADVENTURE);
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&a设置成功"));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&f你的模式已被更改成 冒险模式"));
                        for (Player AllPlayer : Bukkit.getOnlinePlayers()) {
                            if (AllPlayer.isOp()) {
                                if (!AllPlayer.getName().equals(player.getName())) {
                                    AllPlayer.sendMessage(ChatColor.GRAY + "[" + senderName + ":更改了玩家" + player.getName() + "的游戏模式为 冒险模式]");
                                }
                            }
                        }
                        return false;
                    }

                    if (args1.equalsIgnoreCase("3") || args1.equalsIgnoreCase("旁观")  || args1.equalsIgnoreCase("spectator")) {
                        Objects.requireNonNull(player).setGameMode(GameMode.SPECTATOR);
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&a设置成功"));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&f你的模式已被更改成 旁观模式"));
                        for (Player AllPlayer : Bukkit.getOnlinePlayers()) {
                            if (AllPlayer.isOp()) {
                                if (!AllPlayer.getName().equals(player.getName())) {
                                    AllPlayer.sendMessage(ChatColor.GRAY + "[" + senderName + ":更改了玩家" + player.getName() + "的游戏模式为 旁观模式]");
                                }
                            }
                        }
                        return false;
                    }

                    if (args1.equalsIgnoreCase("0") || args1.equalsIgnoreCase("生存")  || args1.equalsIgnoreCase("survival")) {
                        Objects.requireNonNull(player).setGameMode(GameMode.SURVIVAL);
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&a设置成功"));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&f你的模式已被更改成 生存模式"));
                        for (Player AllPlayer : Bukkit.getOnlinePlayers()) {
                            if (AllPlayer.isOp()) {
                                if (!AllPlayer.getName().equals(player.getName())) {
                                    AllPlayer.sendMessage(ChatColor.GRAY + "[" + senderName + ":更改了玩家" + player.getName() + "的游戏模式为 生存模式]");
                                }
                            }
                        }
                        return false;
                    }

                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&d" + args1 + "不是一个有效的模式"));
                }
            }else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&d用法错误，用法:/gamemode <模式> [玩家]"));
            }
        }
        return false;
    }

    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, String[] strings) {
        if (strings.length == 1) {
            List<String> tablist = new ArrayList<>();
            tablist.add("冒险");
            tablist.add("创造");
            tablist.add("旁观");
            tablist.add("生存");
            if (!strings[0].equalsIgnoreCase("冒险") && !strings[0].equalsIgnoreCase("创造") && !strings[0].equalsIgnoreCase("旁观") && !strings[0].equalsIgnoreCase("生存")) {
                return tablist;
            }
        }
        return null;
    }
}
