package com.gildorymrp.gildorymclasses;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;

import com.gildorymrp.charactercards.CharacterCard;
import com.gildorymrp.gildorym.Gildorym;
import com.gildorymrp.gildorym.GildorymCharacter;

public class PlayerExpChangeListener implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerExpChange(PlayerExpChangeEvent event) {
		Player player = event.getPlayer();
		
		Gildorym gildorym = (Gildorym) Bukkit.getServer().getPluginManager().getPlugin("Gildorym");
		GildorymCharacter gChar = gildorym.getActiveCharacters().get(player);	

		event.setAmount(0);
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
}