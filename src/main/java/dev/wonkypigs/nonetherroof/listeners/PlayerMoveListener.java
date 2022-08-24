package dev.wonkypigs.nonetherroof.listeners;

import dev.wonkypigs.nonetherroof.NoNetherRoof;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerMoveListener implements Listener {

    private final NoNetherRoof plugin = NoNetherRoof.getPlugin(NoNetherRoof.class);

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        if(player.getWorld().getEnvironment().equals(World.Environment.NETHER)) {
            if(!player.hasPermission("nonetherroof.bypass")
                    && player.getLocation().getBlockY() > plugin.getConfig().getInt("nether-roof-level")
                    && !plugin.getConfig().getStringList("whitelisted-worlds").contains(player.getWorld().getName())) {
                if(!plugin.getConfigValue("command-to-run").equalsIgnoreCase("none")) {
                    player.performCommand(plugin.getConfigValue("command-to-run"));
                }
                if(!plugin.getConfigValue("effect-to-give").equalsIgnoreCase("none")) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.getByName(plugin.getConfigValue("effect-to-give")), 9999999, 5));
                }
                player.sendMessage(plugin.prefix + plugin.getConfigValue("message-to-send"));
                e.setCancelled(true);
            }
        }
    }
}
