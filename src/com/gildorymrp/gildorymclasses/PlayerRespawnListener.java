package com.gildorymrp.gildorymclasses;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawnListener implements Listener {
	
	private BasicChar plugin;
	
	public PlayerRespawnListener(BasicChar plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		final Player player = event.getPlayer();
		plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

			@Override
			public void run() {
				if (plugin.levels.get(player.getName()) == null) {
					plugin.levels.put(player.getName(), 1);
				}
				if (plugin.experience.get(player.getName()) == null) {
					plugin.experience.put(player.getName(), 0);
				}
				int expToNextLevel = (int) Math.round(1000 * plugin.levels.get(player.getName()));
				while (plugin.experience.get(player.getName()) >= expToNextLevel) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) - expToNextLevel);
					plugin.levels.put(player.getName(), plugin.levels.get(player.getName()) + 1);
					expToNextLevel = 1000 * plugin.levels.get(player.getName());
				}
				player.setExp((float) plugin.experience.get(player.getName()) / (float) expToNextLevel);
				player.setLevel(plugin.levels.get(player.getName()));
				player.setMaxHealth(plugin.levels.get(player.getName()) * 10);
			}
			
		}, 20L);
	}

}
