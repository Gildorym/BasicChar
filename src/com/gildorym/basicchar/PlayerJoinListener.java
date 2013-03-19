package com.gildorym.basicchar;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
	
	private BasicChar plugin;
	
	public PlayerJoinListener(BasicChar plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		if (plugin.levels.get(event.getPlayer().getName()) == null) {
			plugin.levels.put(event.getPlayer().getName(), 1);
			event.getPlayer().setLevel(1);
		}
		if (plugin.experience.get(event.getPlayer()) == null) {
			plugin.experience.put(event.getPlayer().getName(), 0);
			event.getPlayer().setLevel(0);
		}
	}

}
