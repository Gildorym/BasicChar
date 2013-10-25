package com.gildorymrp.classes;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetLevelCommand implements CommandExecutor {
	
	private GildorymClasses plugin;
	
	public SetLevelCommand(GildorymClasses plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("gildorym.classes.command.setlevel")) {
			if (args.length >= 2) {
				try {
					if (plugin.getServer().getPlayer(args[0]) != null) {
						plugin.setLevel(plugin.getServer().getPlayer(args[0]), Integer.parseInt(args[1]));
					} else {
						sender.sendMessage(GildorymClasses.PREFIX + ChatColor.RED + "That player is not online!");
					}
				} catch (NumberFormatException exception) {
					sender.sendMessage(GildorymClasses.PREFIX + ChatColor.RED + "Level must be an integer!");
				}
			} else if (args.length >= 1) {
				try {
					plugin.setLevel((Player) sender, Integer.parseInt(args[0]));
					sender.sendMessage(GildorymClasses.PREFIX + ChatColor.GREEN + "Level set to " + args[0]);
				} catch (NumberFormatException exception) {
					sender.sendMessage(GildorymClasses.PREFIX + ChatColor.RED + "Level must be a number!");
				}
			} else {
				sender.sendMessage(GildorymClasses.PREFIX + ChatColor.RED + "You need to specify a level!");
			}
		} else {
			sender.sendMessage(GildorymClasses.PREFIX + ChatColor.RED + "You do not have permission!");
		}
		return true;
	}

}
