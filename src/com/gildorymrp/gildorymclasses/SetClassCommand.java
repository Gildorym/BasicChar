package com.gildorymrp.gildorymclasses;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gildorymrp.api.plugin.classes.Class;

public class SetClassCommand implements CommandExecutor {
	
	private GildorymClasses plugin;
	
	public SetClassCommand(GildorymClasses plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length >= 2 && sender.hasPermission("gildorym.classes.command.setclass")) {
			if (Class.valueOf(args[1].toUpperCase()) != null) {
				Class clazz = Class.valueOf(args[1].toUpperCase());
				if (plugin.getServer().getPlayer(args[0]) != null) {
					Player player = plugin.getServer().getPlayer(args[0]);
					sender.sendMessage(GildorymClasses.PREFIX + ChatColor.GREEN + player.getName() + "'s class set to " + clazz.toString());
					plugin.setClass(player, clazz);
				} else {
					sender.sendMessage(GildorymClasses.PREFIX + ChatColor.RED + "That player is not online!");
				}
			} else {
				sender.sendMessage(GildorymClasses.PREFIX + ChatColor.RED + "That's not a valid class!");
			}
		} else if (args.length >= 1) {
			try {
				Class clazz = Class.valueOf(args[0].toUpperCase());
				sender.sendMessage(GildorymClasses.PREFIX + ChatColor.GREEN + "Class set to " + clazz.toString());
				plugin.setClass((Player) sender, clazz);
			} catch (IllegalArgumentException exception) {
				sender.sendMessage(GildorymClasses.PREFIX + ChatColor.RED + "That's not a valid class!");
			}
		} else {
			sender.sendMessage(GildorymClasses.PREFIX + ChatColor.RED + "You need to specify a class!");
		}
		return true;
	}

}
