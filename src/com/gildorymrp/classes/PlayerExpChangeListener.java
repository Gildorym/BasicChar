package com.gildorymrp.classes;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;

public class PlayerExpChangeListener implements Listener {

	private BasicChar plugin;

	public PlayerExpChangeListener(BasicChar plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerExpChange(PlayerExpChangeEvent event) {
		event.setAmount(0);
		if (plugin.levels.get(event.getPlayer().getName()) == null) {
			plugin.levels.put(event.getPlayer().getName(), 1);
		}
		if (plugin.experience.get(event.getPlayer().getName()) == null) {
			plugin.experience.put(event.getPlayer().getName(), 0);
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
