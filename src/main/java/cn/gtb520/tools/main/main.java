package cn.gtb520.tools.main;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class main extends JavaPlugin implements Listener {
    public static YamlFile_Utils Yaml;

    public static main instance;
    private static PluginDescriptionFile descriptionFile;

    public static PluginDescriptionFile getDescriptionFile() {
        return descriptionFile;
    }

    public static main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        descriptionFile = getDescription();

        multi.GetLoggerPlus("\n" +
                "   ___                 ___                      \n" +
                "  / _ \\ _ __  ___ _ _ / __| ___ _  _ _ _ __ ___ \n" +
                " | (_) | '_ \\/ -_) ' \\\\__ \\/ _ \\ || | '_/ _/ -_)\n" +
                "  \\___/| .__/\\___|_||_|___/\\___/\\_,_|_| \\__\\___|\n" +
                "       |_|                                      \n");

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            multi.GetLoggerPlus("&d找不到PlaceholderAPI,请安装PlaceholderAPI后才能使用本插件");
            Bukkit.getPluginManager().disablePlugins();
            try {
                Thread.sleep(2300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.exit(0);
        } else if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            multi.GetLoggerPlus("&2已检测到PlaceholderAPI前置");
        }

        Bukkit.getPluginManager().registerEvents(this, this);
        new PlaceholderAPI(this).register();

        File Folder = new File(String.valueOf(getDataFolder()));
        File Config_File = new File(getDataFolder(), "config.yml");
        Yaml = new YamlFile_Utils();
        if (!Folder.exists() || !Config_File.exists()) {
            Folder.mkdirs();
            Yaml.saveYamlFile(getDataFolder().getPath(), "config.yml", "config.yml",true);
        }

        List<File> Folders = new ArrayList<>();
        Folders.add(new File(getDataFolder().getPath()));
        Makedirs(Folders);

        multi.GetLoggerPlus("&f-----------OpenSourceTools-----------");
        BukkitTask TpaTime = new Tpa_Time(this).runTaskTimer(this, 0L, 20);
        multi.SetIntTemp("TpaTimeTaskId",TpaTime.getTaskId());

        BukkitTask TpaDetect = new Tpa_Detect(this).runTaskTimer(this, 0L, 60*20);
        multi.SetIntTemp("TpaDetectTaskId",TpaDetect.getTaskId());

        if (getConfig().getBoolean("TimeMessageSetting.TimeMessage")) {
            BukkitTask TimeMessage = new TimeMessage(this).runTaskTimer(this, 0L, getConfig().getInt("TimeMessageSetting.TimeMessageTime")*20L);
            multi.SetIntTemp("TimeMessageTaskId",TimeMessage.getTaskId());
        }

        Bukkit.getPluginManager().registerEvents(new KickGUI_ClickGUI_Event(),this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoin_Event(),this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuit_Event(),this);
        Bukkit.getPluginManager().registerEvents(new PlayerChat_Event(),this);
        Bukkit.getPluginManager().registerEvents(new SignChange_Event(),this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeath_Event(),this);
        Bukkit.getPluginManager().registerEvents(new PlayerReSpawn_Event(),this);
        Bukkit.getPluginManager().registerEvents(new PlayerChangedWorld_Event(),this);

        Objects.requireNonNull(getCommand("CTReload")).setExecutor(new Reload_Command());
        Objects.requireNonNull(getCommand("Stop")).setExecutor(new Stop_Command());
        Objects.requireNonNull(getCommand("gamemode")).setExecutor(new gm_Command());
        Objects.requireNonNull(getCommand("gamemode")).setTabCompleter(new gm_Command());
        Objects.requireNonNull(getCommand("day")).setExecutor(new day_Command());
        Objects.requireNonNull(getCommand("sun")).setExecutor(new sun_Command());
        Objects.requireNonNull(getCommand("spawn")).setExecutor(new spawn_Command());
        Objects.requireNonNull(getCommand("setspawn")).setExecutor(new setspawn_Command());
        Objects.requireNonNull(getCommand("tpa")).setExecutor(new Tpa_Command());
        Objects.requireNonNull(getCommand("tpaaccept")).setExecutor(new tpaAccept_Command());
        Objects.requireNonNull(getCommand("tpadefuse")).setExecutor(new tpaDefuse_Command());
        Objects.requireNonNull(getCommand("vanish")).setExecutor(new vanish_Command());
        Objects.requireNonNull(getCommand("fly")).setExecutor(new fly_Command());
        Objects.requireNonNull(getCommand("mute")).setExecutor(new mute_Command());
        Objects.requireNonNull(getCommand("unmute")).setExecutor(new unmute_Command());
        Objects.requireNonNull(getCommand("kick")).setExecutor(new SuperKick_Command());
        Objects.requireNonNull(getCommand("feed")).setExecutor(new feed_Command());
        Objects.requireNonNull(getCommand("heal")).setExecutor(new heal_Command());
        Objects.requireNonNull(getCommand("list")).setExecutor(new SuperList_Command());
        Objects.requireNonNull(getCommand("back")).setExecutor(new Back_Command());
        Objects.requireNonNull(getCommand("testGUI")).setExecutor(new testGUI());
        Objects.requireNonNull(getCommand("PlayerTitle")).setExecutor(new PlayerTitle_Command());

        multi.GetLoggerPlus("插件启动成功");
        multi.GetLoggerPlus("&f-----------OpenSourceTools-----------");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        instance = null;
        multi.GetLoggerPlus("&f-----------OpenSourceTools-----------");
        multi.GetLoggerPlus("插件已卸载");
        multi.GetLoggerPlus("&f-----------OpenSourceTools-----------");
        multi.GetLoggerPlus("\n" +
                "   ___                 ___                      \n" +
                "  / _ \\ _ __  ___ _ _ / __| ___ _  _ _ _ __ ___ \n" +
                " | (_) | '_ \\/ -_) ' \\\\__ \\/ _ \\ || | '_/ _/ -_)\n" +
                "  \\___/| .__/\\___|_||_|___/\\___/\\_,_|_| \\__\\___|\n" +
                "       |_|                                      \n");
    }

    private static void Makedirs(List<File> Folders) {
        for (File EachFolder : Folders) {
            if (!EachFolder.exists()) {
                EachFolder.mkdirs();
            }
        }
    }
}
