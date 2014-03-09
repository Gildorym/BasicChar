package com.gildorymrp.gildorymclasses;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.gildorymrp.gildorym.Gildorym;
import com.gildorymrp.gildorym.GildorymCharacter;

public class GetLevelCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (sender.hasPermission("basicchar.command.getlevel")) {
			String player = sender.getName();
			if (args.length >= 1) {
				if (Bukkit.getServer().getPlayer(args[0]) != null) {
					player = Bukkit.getServer().getPlayer(args[0]).getName();
				} else {
					sender.sendMessage(ChatColor.RED
							+ "That player is not online!");
					return true;
				}
			}

			Gildorym gildorym = (Gildorym) Bukkit.getServer().getPluginManager().getPlugin("Gildorym");
			GildorymCharacter gChar = gildorym.getActiveCharacters().get(player);	
			
			sender.sendMessage(ChatColor.GREEN + player + "'s level is "
						+ gChar.getLevel());
		}
		return true;
	}
}