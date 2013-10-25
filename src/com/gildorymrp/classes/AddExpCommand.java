package com.gildorymrp.classes;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddExpCommand implements CommandExecutor {
	
	private GildorymClasses plugin;
	
	public AddExpCommand(GildorymClasses plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("gildorym.classes.command.addexp")) {
			if (plugin.getServer().getPlayer(args[0]) != null) {
				Player player = plugin.getServer().getPlayer(args[0]);
				try {
					plugin.giveExperience(player, Integer.parseInt(args[1]));
					sender.sendMessage(GildorymClasses.PREFIX + ChatColor.GREEN + "Gave " + player.getName() + " " + Integer.parseInt(args[1]) + " exp");
				} catch (NumberFormatException exception) {
					sender.sendMessage(GildorymClasses.PREFIX + GildorymClasses.PREFIX + ChatColor.RED + "Amount of experience must be an integer.");
				}
			} else {
				sender.sendMessage(GildorymClasses.PREFIX + ChatColor.RED + "That player is not online.");
			}
		} else {
			sender.sendMessage(GildorymClasses.PREFIX + ChatColor.RED + "You do not have permission.");
		}
		return true;
	}

}