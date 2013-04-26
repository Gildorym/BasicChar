package com.gildorymrp.basicchar;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GetLevelCommand implements CommandExecutor {

	private BasicChar plugin;

	public GetLevelCommand(BasicChar plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("basicchar.command.getlevel")) {
			String player = sender.getName();
			if (args.length >= 1) {
				if (Bukkit.getServer().getPlayer(args[0]) != null) {
					player = Bukkit.getServer().getPlayer(args[0]).getName();
				} else {
					sender.sendMessage(ChatColor.RED + "That player is not online!");
					return true;
				}
			}
			
			if (plugin.levels.get(player) != null) {
				sender.sendMessage(ChatColor.GREEN + player + "'s level is " + plugin.levels.get(player));
			} else {
				sender.sendMessage(ChatColor.RED + player + " has not been assigned a level!");
			}
		}
		return true;
	}

}
