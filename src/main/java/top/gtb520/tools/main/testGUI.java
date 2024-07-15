package top.gtb520.tools.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class testGUI implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.isOp()) {
                if (args.length == 1) {
                    String GUIName = args[0];
                    if (GUIName.equals("KickGUI")) {
                        unity.KickGui(player);
                        return false;
                    }

                    sender.sendMessage(unity.ColorMessage("&d这个命令只有插件作者才能使用"));
                    System.out.println("玩家：" + sender + "使用了内部测试命令");
                }else {
                    sender.sendMessage(unity.ColorMessage("&d这个命令只有插件作者才能使用"));
                    System.out.println("玩家：" + sender + "使用了内部测试命令");
                }
            }else {
                sender.sendMessage(unity.ColorMessage("&d这个命令只有插件作者才能使用"));
                System.out.println("玩家：" + sender + "使用了内部测试命令");
            }
        }else {
            sender.sendMessage(unity.ColorMessage("&d这个命令只有插件作者才能使用"));
            System.out.println("玩家：" + sender + "使用了内部测试命令");
        }
        return false;
    }
}
