package com.skygridsupport;

import com.budgienet.chatutil.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class SkyGridSupport extends JavaPlugin {

    public static SkyGridSupport instance;
    public static boolean gpLoaded;
    public static boolean wgLoaded;

    @Override
    public void onEnable() {
        ChatUtil.init(this);
        instance = this;
        gpLoaded = Bukkit.getPluginManager().isPluginEnabled("GriefPrevention");
        if (gpLoaded) Log("GriefPrevention support loaded.");
        wgLoaded = Bukkit.getPluginManager().isPluginEnabled("WorldGuard");
        if (wgLoaded) Log("WorldGuard support loaded.");

        Bukkit.getPluginManager().registerEvents(new SkyGridListeners(), this);
        getCommand("gridrtp").setExecutor(new SkyGridRTPCommand());

    }

    public static void Log(String s) {
        ChatUtil.log(Level.INFO, s);
    }
    public static void Log(Level l, String s) {
        ChatUtil.log(l, s);
    }
}
