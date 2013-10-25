package com.gildorymrp.gildorymclasses;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SetClassCommand implements CommandExecutor {
	
	private BasicChar plugin;
	
	public SetClassCommand(BasicChar plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length >= 2 && sender.hasPermission("basicchar.command.setclass")) {
			if (CharacterClass.valueOf(args[1].toUpperCase()) != null) {
				if (Bukkit.getServer().getPlayer(args[0]) != null) {
					sender.sendMessage(ChatColor.GREEN + Bukkit.getServer().getPlayer(args[0]).getName() + "'s class set to " + CharacterClass.valueOf(args[1].toUpperCase()).toString());
					plugin.classes.put(Bukkit.getServer().getPlayer(args[0]).getName(), CharacterClass.valueOf(args[1].toUpperCase()));
				} else {
					sender.sendMessage(ChatColor.RED + "That player is not online!");
				}
			} else {
				sender.sendMessage(ChatColor.RED + "That's not a valid class!");
			}
		} else if (args.length >= 1) {
			try {
				sender.sendMessage(ChatColor.GREEN + "Class set to " + CharacterClass.valueOf(args[0].toUpperCase()).toString());
				plugin.classes.put(sender.getName(), CharacterClass.valueOf(args[0].toUpperCase()));
			} catch (IllegalArgumentException exception) {
				sender.sendMessage(ChatColor.RED + "That's not a valid class!");
			}
		} else {
			sender.sendMessage(ChatColor.RED + "You need to specify a class!");
		}
		return true;
	}

}
