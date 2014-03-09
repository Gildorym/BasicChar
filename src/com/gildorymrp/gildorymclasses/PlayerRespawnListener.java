package com.gildorymrp.gildorymclasses;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.gildorymrp.charactercards.CharacterCard;
import com.gildorymrp.gildorym.Gildorym;
import com.gildorymrp.gildorym.GildorymCharacter;

public class PlayerRespawnListener implements Listener {
	private GildorymClasses plugin;

	public PlayerRespawnListener(GildorymClasses plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		final Player player = event.getPlayer();
		this.plugin.getServer().getScheduler()
		.scheduleSyncDelayedTask(this.plugin, new Runnable() {
			public void run() {
				Gildorym gildorym = (Gildorym) Bukkit.getServer().getPluginManager().getPlugin("Gildorym");
				GildorymCharacter gChar = gildorym.getActiveCharacters().get(player.getName());
				
				int expToNextLevel = 1000 * gChar.getLevel();
				while (gChar.getExperience() >= expToNextLevel) {
					gChar.setExperience(gChar.getExperience() - expToNextLevel);
					gChar.setLevel(gChar.getLevel() + 1);
					expToNextLevel = 1000 * gChar.getLevel();
				}
				
				Integer pvpHealth = CharacterCard.calculateHealth(gChar);
				
				player.setExp((float) (gChar.getExperience() / (double) expToNextLevel));
				player.setLevel(gChar.getLevel());
				player.setMaxHealth(pvpHealth * 5);
			}
		}, 20L);
	}
}
