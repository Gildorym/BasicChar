package com.gildorymrp.gildorymclasses;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gildorymrp.gildorym.Gildorym;
import com.gildorymrp.gildorym.GildorymCharacter;

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
		
		Gildorym gildorym = (Gildorym) Bukkit.getServer().getPluginManager().getPlugin("Gildorym");
		GildorymCharacter gChar = gildorym.getActiveCharacters().get(player.getName());
		
		int expToNextLevel = Math.round(1000 * gChar.getLevel());
		player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + gChar.getExperience() + "/" + expToNextLevel);
		return true;
	}

}
