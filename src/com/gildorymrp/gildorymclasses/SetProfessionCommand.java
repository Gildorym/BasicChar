package com.gildorymrp.gildorymclasses;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SetProfessionCommand implements CommandExecutor {
	private GildorymClasses plugin;

	public SetProfessionCommand(GildorymClasses plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if ((args.length >= 2)
				&& (sender.hasPermission("basicchar.command.setprofession"))) {
			if (CharacterProfession.valueOf(args[1].toUpperCase()) != null) {
				if (Bukkit.getServer().getPlayer(args[0]) != null) {
					sender.sendMessage(ChatColor.GREEN
							+ Bukkit.getServer().getPlayer(args[0]).getName()
							+ "'s profession set to "
							+ CharacterProfession
									.valueOf(args[1].toUpperCase()).toString());
					this.plugin.professions.put(
							Bukkit.getServer().getPlayer(args[0]).getName(),
							CharacterProfession.valueOf(args[1].toUpperCase()));
				} else {
					sender.sendMessage(ChatColor.RED
							+ "That player is not online!");
				}
			} else
				sender.sendMessage(ChatColor.RED
						+ "That's not a valid profession!");
		} else if (args.length >= 1) {
			if (this.plugin.professions.get(sender.getName()) != null
					&& !sender.hasPermission("basicchar.command.setprofession")) {
				sender.sendMessage(ChatColor.RED
						+ "You have already set your profession!");
			} else {
				try {
					sender.sendMessage(ChatColor.GREEN
							+ "Profession set to "
							+ CharacterProfession
									.valueOf(args[0].toUpperCase()).toString());
					this.plugin.professions.put(sender.getName(),
							CharacterProfession.valueOf(args[0].toUpperCase()));
				} catch (IllegalArgumentException exception) {
					sender.sendMessage(ChatColor.RED
							+ "That's not a valid profession!");
				}
			}
		} else {
			sender.sendMessage(ChatColor.RED
					+ "You need to specify a profession!");
		}
		return true;
	}
}
