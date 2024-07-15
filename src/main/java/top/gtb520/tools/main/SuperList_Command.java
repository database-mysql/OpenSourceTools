package cn.gtb520.tools.main;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SuperList_Command implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> OnlinePlayers = new ArrayList<>();
        String MemUsedMessage = "&a服务器内存占用&f：&e%server_ram_used%/%server_ram_max%";
        MemUsedMessage = PlaceholderAPI.setPlaceholders(null, MemUsedMessage);
        String ServerTPSMessage = "&a服务器TPS&f：&e%server_tps%";
        ServerTPSMessage = PlaceholderAPI.setPlaceholders(null, ServerTPSMessage);
        for (Player OnlinePlayer : Bukkit.getOnlinePlayers()) {
            String PlayerName = OnlinePlayer.getName();
            OnlinePlayers.add(PlayerName);
        }
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', MemUsedMessage));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ServerTPSMessage));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a在线人数&f：&e" + Bukkit.getOnlinePlayers().size() + "&f/&e" + Bukkit.getMaxPlayers()));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a在线玩家列表&f：&e" + OnlinePlayers));
        return false;
    }
}
