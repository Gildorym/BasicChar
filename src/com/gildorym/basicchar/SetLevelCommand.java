package com.gildorym.basicchar;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetLevelCommand implements CommandExecutor {
	
	private BasicChar plugin;
	
	public SetLevelCommand(BasicChar plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("basicchar.command.setlevel")) {
			if (args.length >= 2) {
				try {
					if (Bukkit.getServer().getPlayer(args[0]) != null) {
						plugin.levels.put(Bukkit.getServer().getPlayer(args[0]).getName(), Integer.parseInt(args[1]));
						sender.sendMessage(ChatColor.GREEN + Bukkit.getServer().getPlayer(args[0]).getName() + "'s level set to " + args[1]);
						Bukkit.getServer().getPlayer(args[0]).setLevel(Integer.parseInt(args[1]));
					} else {
						sender.sendMessage(ChatColor.RED + "That player is not online!");
					}
				} catch (NumberFormatException exception) {
					sender.sendMessage(ChatColor.RED + "Level must be a number!");
				}
			} else if (args.length >= 1) {
				try {
					plugin.levels.put(sender.getName(), Integer.parseInt(args[0]));
					sender.sendMessage(ChatColor.GREEN + "Level set to " + args[0]);
					((Player) sender).setLevel(Integer.parseInt(args[0]));
				} catch (NumberFormatException exception) {
					sender.sendMessage(ChatColor.RED + "Level must be a number!");
				}
			} else {
				sender.sendMessage(ChatColor.RED + "You need to specify a level!");
			}
		} else {
			sender.sendMessage(ChatColor.RED + "You do not have permission!");
		}
		return true;
	}

}
