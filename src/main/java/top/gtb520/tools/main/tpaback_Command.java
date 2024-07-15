package cn.gtb520.tools.main;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class tpaback_Command implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location BackLocation = multi.getLocationTempTemp(player.getName() + "_Tpa");
            player.teleport(BackLocation);
            player.sendMessage(multi.ColorMessage("&a传送成功!"));
        }
        return false;
    }
}
