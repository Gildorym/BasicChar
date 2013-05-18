package com.gildorymrp.gildorymclasses;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
	
	private GildorymClasses plugin;
	
	public PlayerJoinListener(GildorymClasses plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		plugin.setTotalExperience(event.getPlayer(), plugin.getTotalExperience(event.getPlayer())); //This may look pointless, but it's designed to refresh the exp bar and level counter on logging in.
	}

}
