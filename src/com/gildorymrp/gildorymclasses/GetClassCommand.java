package com.gildorymrp.gildorymclasses;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetClassCommand implements CommandExecutor {

	private GildorymClasses plugin;

	public GetClassCommand(GildorymClasses plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (sender.hasPermission("gildorym.classes.command.getclass")) {
			if (args.length >= 1) {
				if (plugin.getServer().getPlayer(args[0]) != null) {
					player = plugin.getServer().getPlayer(args[0]);
				} else {
					sender.sendMessage(GildorymClasses.PREFIX + ChatColor.RED + "That player is not online!");
					return true;
				}
			}
		}
			
		if (plugin.getClass(player) != null) {
			sender.sendMessage(GildorymClasses.PREFIX + ChatColor.GREEN + player + "'s class is " + plugin.getClass(player).toString());
		} else {
			sender.sendMessage(GildorymClasses.PREFIX + ChatColor.RED + player + " has not chosen a class!");
		}
		return true;
	}

}
