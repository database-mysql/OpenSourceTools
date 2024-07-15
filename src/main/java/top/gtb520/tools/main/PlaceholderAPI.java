package cn.gtb520.tools.main;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

public class PlaceholderAPI extends PlaceholderExpansion {

    public PlaceholderAPI(main main) {}

    @Override
    public @NotNull String getAuthor() {
        return "Open Source";
    }

    @Override
    public @NotNull String getIdentifier() {
        return "OpenSourceTools";
    }

    @Override
    public @NotNull String getVersion() {
        return main.getDescriptionFile().getVersion();
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        if (params.equalsIgnoreCase("Nick")) {
            if (main.instance.getConfig().getString(player.getName() + "_Nick") == null) {
                return player.getName();
            } else {
                return main.instance.getConfig().getString(player.getName() + "_Nick");
            }
        }
        if (params.equalsIgnoreCase("Title")) {
            if (main.instance.getConfig().getString(player.getName() + "_Title") == null) {
                return "";
            } else {
                return multi.ColorMessage("&7[" + main.instance.getConfig().getString(player.getName() + "_Title") + "&7]&f");
            }
        }
        if (params.equalsIgnoreCase("Suffix")) {
            if (main.instance.getConfig().getString(player.getName() + "_Suffix") == null) {
                return "";
            } else {
                return multi.ColorMessage("&7[" + main.instance.getConfig().getString(player.getName() + "_Suffix") + "&7]");
            }
        }
        return null;
    }
}
