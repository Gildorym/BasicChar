package com.gildorymrp.basicchar;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GetProfessionCommand implements CommandExecutor {

	private BasicChar plugin;

	public GetProfessionCommand(BasicChar plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		String player = sender.getName();
		if (sender.hasPermission("basicchar.command.getprofession")) {
			if (args.length >= 1) {
				if (Bukkit.getServer().getPlayer(args[0]) != null) {
					player = Bukkit.getServer().getPlayer(args[0]).getName();
				} else {
					sender.sendMessage(ChatColor.RED + "That player is not online!");
					return true;
				}
			}
		}
			
		if (plugin.professions.get(player) != null) {
			sender.sendMessage(ChatColor.GREEN + player + "'s profession is " + plugin.professions.get(player).toString());
		} else {
			sender.sendMessage(ChatColor.RED + player + " has not chosen a profession!");
		}
		return true;
	}

}
