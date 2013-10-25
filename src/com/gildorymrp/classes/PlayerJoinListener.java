package com.gildorymrp.classes;

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
		if (plugin.experience.get(event.getPlayer().getName()) == null) {
			plugin.experience.put(event.getPlayer().getName(), 0);
			event.getPlayer().setExp(0);
		}
		int expToNextLevel = (int) Math.round(1000 * plugin.levels.get(event.getPlayer().getName()));
		while (plugin.experience.get(event.getPlayer().getName()) >= expToNextLevel) {
			plugin.experience.put(event.getPlayer().getName(), plugin.experience.get(event.getPlayer().getName()) - expToNextLevel);
			plugin.levels.put(event.getPlayer().getName(), plugin.levels.get(event.getPlayer().getName()) + 1);
			expToNextLevel = 1000 * plugin.levels.get(event.getPlayer().getName());
		}
		event.getPlayer().setExp((float) plugin.experience.get(event.getPlayer().getName()) / (float) expToNextLevel);
		event.getPlayer().setMaxHealth(plugin.levels.get(event.getPlayer().getName()) * 10);
		event.getPlayer().setLevel(plugin.levels.get(event.getPlayer().getName()));
	}

}
