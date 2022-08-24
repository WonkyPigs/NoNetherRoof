package dev.wonkypigs.nonetherroof;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoNetherRoof extends JavaPlugin {

    public final String prefix = ChatColor.translateAlternateColorCodes('&', "&7[&cNoNetherRoof&7] &r");

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getLogger().info("NoNetherRoof has started up successfully!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("NoNetherRoof has shut down successfully!");
    }

    // Getting values from config with color coding
    public String getConfigValue(String key) {
        String ans = getConfig().getString(key);
        return ChatColor.translateAlternateColorCodes('&', ans);
    }
}
