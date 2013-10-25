package com.gildorymrp.classes;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetLevelCommand implements CommandExecutor {

	private GildorymClasses plugin;

	public GetLevelCommand(GildorymClasses plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (sender.hasPermission("gildorym.classes.command.getlevel")) {
			if (args.length >= 1) {
				if (plugin.getServer().getPlayer(args[0]) != null) {
					player = plugin.getServer().getPlayer(args[0]);
				} else {
					sender.sendMessage(GildorymClasses.PREFIX + ChatColor.RED + "That player is not online!");
					return true;
				}
			}
		}
		sender.sendMessage(GildorymClasses.PREFIX + ChatColor.GREEN + player.getName() + "'s level is " + plugin.getLevel(player));
		sender.sendMessage(GildorymClasses.PREFIX + ChatColor.GREEN + "Progress towards next level: " + plugin.getExperienceTowardsNextLevel(player) + "/" + plugin.getExpToNextLevel(plugin.getLevel(player)));
		return true;
	}

}
