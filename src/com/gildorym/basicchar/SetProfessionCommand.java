package com.gildorym.basicchar;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SetProfessionCommand implements CommandExecutor {
	
	private BasicChar plugin;
	
	public SetProfessionCommand(BasicChar plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length >= 2 && sender.hasPermission("basicchar.command.setprofession")) {
			if (CharacterProfession.valueOf(args[1].toUpperCase()) != null) {
				if (Bukkit.getServer().getPlayer(args[0]) != null) {
					sender.sendMessage(ChatColor.GREEN + Bukkit.getServer().getPlayer(args[0]).getName() + "'s profession set to " + CharacterProfession.valueOf(args[1].toUpperCase()).toString());
					plugin.professions.put(Bukkit.getServer().getPlayer(args[0]).getName(), CharacterProfession.valueOf(args[1].toUpperCase()));
				} else {
					sender.sendMessage(ChatColor.RED + "That player is not online!");
				}
			} else {
				sender.sendMessage(ChatColor.RED + "That's not a valid profession!");
			}
		} else if (args.length >= 1) {
			try {
				sender.sendMessage(ChatColor.GREEN + "Profession set to " + CharacterProfession.valueOf(args[0].toUpperCase()).toString());
				plugin.professions.put(sender.getName(), CharacterProfession.valueOf(args[0].toUpperCase()));
			} catch (IllegalArgumentException exception) {
				sender.sendMessage(ChatColor.RED + "That's not a valid profession!");
			}
		} else {
			sender.sendMessage(ChatColor.RED + "You need to specify a profession!");
		}
		return true;
	}

}
