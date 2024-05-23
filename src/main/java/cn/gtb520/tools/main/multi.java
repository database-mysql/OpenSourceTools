package cn.gtb520.tools.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class multi {

    public static void SaveAndReloadConfig() {
        main.instance.saveConfig();
        main.instance.reloadConfig();
    }
    public static String ColorMessage(String String1) {
        return ChatColor.translateAlternateColorCodes('&',String1);
    }

    public static void GetLoggerPlus(String String1) {
        CommandSender Console = Bukkit.getConsoleSender();
        Console.sendMessage(ColorMessage(String1));
    }

    static HashMap<String, Integer> IntTemp = new HashMap<>();

    static HashMap<String, String> StringTemp = new HashMap<>();

    static HashMap<String, Boolean> BooleanTemp = new HashMap<>();

    static HashMap<String, Location> LocationTemp = new HashMap<>();

    public static void SetLocationTempTemp(String String1, Location String2) {
        LocationTemp.put(String1,String2);
    }

    public static Location getLocationTempTemp(String String1) {
        return LocationTemp.get(String1);
    }

    public static void SetStringTemp(String String1,String String2) {
        StringTemp.put(String1,String2);
    }

    public static String getStringTemp(String String1) {
        return StringTemp.get(String1);
    }

    public static void SetIntTemp(String String1, Integer Int1) {
        IntTemp.put(String1,Int1);
    }

    public static Integer GetIntTemp(String String1) {
        return IntTemp.get(String1);
    }

    public static void SetBooleanTemp(String String1, boolean Boolean1) {
        BooleanTemp.put(String1, Boolean1);
    }

    public static boolean getBooleanTemp(String String1) {
        return BooleanTemp.get(String1);
    }

    public static void KickGui(Player player) {
        Inventory UI = Bukkit.createInventory(player,45, ColorMessage("&a选择你要踢出的玩家"));

        ItemStack Bk = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
        ItemMeta Bk_Meta = Bk.getItemMeta();
        Objects.requireNonNull(Bk_Meta).setDisplayName(ColorMessage("&e这只是一个边框"));
        ArrayList<String> Bk_Lore = new ArrayList<>();
        Bk_Lore.add(null);
        Bk_Lore.add(ColorMessage("&e这只是一个边框"));
        Bk_Meta.setLore(Bk_Lore);
        Bk.setItemMeta(Bk_Meta);

        for (int i1 = 0 ; i1 <9 ; i1++) {
            UI.setItem(i1,Bk);
        }

        for (int i2 = 36 ; i2 <40 ; i2++) {
            UI.setItem(i2,Bk);
        }

        for (int i3 = 41 ; i3 <45 ; i3++) {
            UI.setItem(i3,Bk);
        }

        UI.setItem(9,Bk);
        UI.setItem(17,Bk);

        UI.setItem(18,Bk);
        UI.setItem(26,Bk);

        UI.setItem(27,Bk);
        UI.setItem(35,Bk);

        ItemStack Gb = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta Gb_Meta = Gb.getItemMeta();
        Objects.requireNonNull(Gb_Meta).setDisplayName(ColorMessage("&d关闭菜单"));
        ArrayList<String> Gb_Lore = new ArrayList<>();
        Gb_Lore.add(null);
        Gb_Lore.add(ColorMessage("&e点击关闭菜单"));
        Gb_Meta.setLore(Gb_Lore);
        Gb.setItemMeta(Gb_Meta);

        UI.setItem(40,Gb);

        ArrayList<Player> players = new ArrayList<>(player.getServer().getOnlinePlayers());
        for (Player value : players) {
            ItemStack PlayerHead = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta PlayerHead_meta = (SkullMeta) PlayerHead.getItemMeta();
            Objects.requireNonNull(PlayerHead_meta).setOwningPlayer(value);
            Objects.requireNonNull(PlayerHead_meta).setDisplayName(ChatColor.RESET + value.getDisplayName() + ChatColor.RESET);
            ArrayList<String> PlayerHead_Lore = new ArrayList<>();
            PlayerHead_Lore.add(null);
            PlayerHead_Lore.add(ColorMessage( "&e点击踢出玩家"));
            PlayerHead_meta.setLore(PlayerHead_Lore);
            PlayerHead.setItemMeta(PlayerHead_meta);

            UI.addItem(PlayerHead);
        }
        player.openInventory(UI);
    }
}
