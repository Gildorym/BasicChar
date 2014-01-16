package com.gildorymrp.gildorymclasses;

import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CheckXPCommand implements CommandExecutor {

	GildorymClasses plugin;
	
	public CheckXPCommand(GildorymClasses plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		
		Player player;
		
		if (sender instanceof Player) {
			player = (Player) sender;
		} else {
			sender.sendMessage(ChatColor.RED + "Only a player can use this command!");
			return true;
		}
		
		Map<String, Integer> experienceMap = this.plugin.experience;
		Map<String, Integer> levelMap = this.plugin.levels;
		int expToNextLevel = Math.round(1000 * ((Integer)levelMap.get(player.getName())).intValue());
		player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + experienceMap.get(player.getName()) + "/" + expToNextLevel);
		return true;
	}

}
