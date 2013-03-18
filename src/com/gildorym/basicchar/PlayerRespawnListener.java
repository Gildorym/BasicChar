package com.gildorym.basicchar;

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
				player.setLevel(plugin.levels.get(player.getName()));
			}
			
		}, 20L);
	}

}
