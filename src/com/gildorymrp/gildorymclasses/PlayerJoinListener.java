package com.gildorymrp.gildorymclasses;

import java.util.Map;
import org.bukkit.entity.Player;
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
		Player player = event.getPlayer();
		Map<String, Integer> levelMap = this.plugin.levels;
		Map<String, Integer> experienceMap = this.plugin.experience;
		if (levelMap.get(player.getName()) == null) {
			levelMap.put(player.getName(), Integer.valueOf(1));
			player.setLevel(1);
		}
		if (experienceMap.get(player.getName()) == null) {
			experienceMap.put(player.getName(), Integer.valueOf(0));
			player.setExp(0.0F);
		}
		int expToNextLevel = Math.round(1000 * ((Integer) levelMap.get(player
				.getName())).intValue());
		while (((Integer) experienceMap.get(player.getName())).intValue() >= expToNextLevel) {
			experienceMap.put(
					player.getName(),
					Integer.valueOf(((Integer) experienceMap.get(player
							.getName())).intValue() - expToNextLevel));
			levelMap.put(player.getName(), Integer.valueOf(((Integer) levelMap
					.get(player.getName())).intValue() + 1));
			expToNextLevel = 1000 * ((Integer) levelMap.get(player.getName()))
					.intValue();
		}
		player.setExp(((Integer) experienceMap.get(player.getName()))
				.intValue() / expToNextLevel);
		player.setMaxHealth(((Integer) levelMap.get(player.getName()))
				.intValue() * 10);
		player.setLevel(((Integer) levelMap.get(player.getName())).intValue());
	}
}