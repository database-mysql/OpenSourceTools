package top.gtb520.tools.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PlayerTitle_Command implements TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length >= 1) {
            if(sender.isOp()) {
                if (args[0].equals("help")) {
                    sender.sendMessage(unity.ColorMessage("&7---------------&dOpenSourceTitleSystem&7---------------"));
                    sender.sendMessage(unity.ColorMessage("/" + label + " help"));
                    sender.sendMessage(unity.ColorMessage("/" + label + " addTitle <玩家ID> <称号>"));
                    sender.sendMessage(unity.ColorMessage("/" + label + " addSuffix <玩家ID> <后缀>"));
                    sender.sendMessage(unity.ColorMessage("/" + label + " delTitle <玩家ID>"));
                    sender.sendMessage(unity.ColorMessage("/" + label + " delSuffix <玩家ID>"));
                    sender.sendMessage(unity.ColorMessage("&7---------------&dOpenSourceTitleSystem&7---------------"));
                    return false;
                }

                if (args[0].equals("addTitle")) {
                    if (args.length == 3) {
                        String PlayerName = args[1];
                        String Title = args[2];
                        if (Bukkit.getPlayer(PlayerName) == null) {
                            sender.sendMessage(unity.ColorMessage("&d&l这个玩家不存在或不在线"));
                            return false;
                        }
                        sender.sendMessage(unity.ColorMessage("&a操作成功!"));
                        main.instance.getConfig().set(PlayerName + "_Title",Title);
                        main.instance.saveConfig();
                        main.instance.reloadConfig();
                        return false;
                    }else {
                        sender.sendMessage(unity.ColorMessage("&d&l参数错误,用法:/" + label + " addTitle <玩家ID> <称号>"));
                        return false;
                    }
                }

                if (args[0].equals("addSuffix")) {
                    if (args.length == 3) {
                        String PlayerName = args[1];
                        String Suffix = args[2];
                        if (Bukkit.getPlayer(PlayerName) == null) {
                            sender.sendMessage(unity.ColorMessage("&d&l这个玩家不存在或不在线"));
                            return false;
                        }
                        sender.sendMessage(unity.ColorMessage("&a操作成功!"));
                        main.instance.getConfig().set(PlayerName + "_Suffix",Suffix);
                        main.instance.saveConfig();
                        main.instance.reloadConfig();
                        return false;
                    }else {
                        sender.sendMessage(unity.ColorMessage("&d&l参数错误,用法:/" + label + " addSuffix <玩家ID> <后缀>"));
                        return false;
                    }
                }

                if (args[0].equals("delTitle")) {
                    if (args.length == 2) {
                        String PlayerName = args[1];
                        if (Bukkit.getPlayer(PlayerName) == null) {
                            sender.sendMessage(unity.ColorMessage("&d&l这个玩家不存在或不在线"));
                            return false;
                        }
                        sender.sendMessage(unity.ColorMessage("&a操作成功!"));
                        main.instance.getConfig().set(PlayerName + "_Title",null);
                        main.instance.saveConfig();
                        main.instance.reloadConfig();
                        return false;
                    }else {
                        sender.sendMessage(unity.ColorMessage("&d&l参数错误,用法:/" + label + " delTitle <玩家ID>"));
                        return false;
                    }
                }

                if (args[0].equals("delSuffix")) {
                    if (args.length == 2) {
                        String PlayerName = args[1];
                        if (Bukkit.getPlayer(PlayerName) == null) {
                            sender.sendMessage(unity.ColorMessage("&d&l这个玩家不存在或不在线"));
                            return false;
                        }
                        sender.sendMessage(unity.ColorMessage("&a操作成功!"));
                        main.instance.getConfig().set(PlayerName + "_Suffix",null);
                        main.instance.saveConfig();
                        main.instance.reloadConfig();
                        return false;
                    }else {
                        sender.sendMessage(unity.ColorMessage("&d&l参数错误,用法:/" + label + " delSuffix <玩家ID>"));
                        return false;
                    }
                }

                sender.sendMessage(unity.ColorMessage("&7---------------&dOpenSourceTitleSystem&7---------------"));
                sender.sendMessage(unity.ColorMessage("/" + label + " help"));
                sender.sendMessage(unity.ColorMessage("&7---------------&dOpenSourceTitleSystem&7---------------"));
            }
        }else {
            if (sender.isOp()) {
                sender.sendMessage(unity.ColorMessage("&7---------------&dOpenSourceTitleSystem&7---------------"));
                sender.sendMessage(unity.ColorMessage("/" + label + " help"));
                sender.sendMessage(unity.ColorMessage("/" + label + " addTitle <玩家ID> <称号>"));
                sender.sendMessage(unity.ColorMessage("/" + label + " addSuffix <玩家ID> <后缀>"));
                sender.sendMessage(unity.ColorMessage("/" + label + " delTitle <玩家ID>"));
                sender.sendMessage(unity.ColorMessage("/" + label + " delSuffix <玩家ID>"));
                sender.sendMessage(unity.ColorMessage("&7---------------&dOpenSourceTitleSystem&7---------------"));
            }else {
                sender.sendMessage(unity.ColorMessage("&7---------------&dOpenSourceTitleSystem&7---------------"));
                sender.sendMessage(unity.ColorMessage("/" + label + " help"));
                sender.sendMessage(unity.ColorMessage("&7---------------&dOpenSourceTitleSystem&7---------------"));
            }
        }
        return false;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1) {
            List<String> tablist = new ArrayList<>();
            tablist.add("addTitle");
            tablist.add("addSuffix");
            tablist.add("delTitle");
            tablist.add("delSuffix");
            tablist.removeIf(s -> !s.startsWith(args[0]));
            return tablist;
        }
        if (args.length == 2) {
            List<String> tablist = new ArrayList<>();
            for (Player player : Bukkit.getOnlinePlayers()) {
                tablist.add(player.getName());
            }
            tablist.removeIf(s -> !s.startsWith(args[1]));
            return tablist;
        }
        if (args.length == 3) {
            return null;
        }
        return null;
    }
}
