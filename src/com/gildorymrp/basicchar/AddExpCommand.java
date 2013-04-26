package com.gildorymrp.basicchar;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AddExpCommand implements CommandExecutor {
	
	private BasicChar plugin;
	
	public AddExpCommand(BasicChar plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("basicchar.command.addexp")) {
			if (plugin.getServer().getPlayer(args[0]) != null) {
				if (plugin.levels.get(plugin.getServer().getPlayer(args[0]).getName()) == null) {
					plugin.levels.put(plugin.getServer().getPlayer(args[0]).getName(), 1);
				}
				if (plugin.experience.get(plugin.getServer().getPlayer(args[0]).getName()) == null) {
					plugin.experience.put(plugin.getServer().getPlayer(args[0]).getName(), 0);
				}
				plugin.experience.put(plugin.getServer().getPlayer(args[0]).getName(), plugin.experience.get(plugin.getServer().getPlayer(args[0]).getName()) + Integer.parseInt(args[1]));
				int expToNextLevel = 1000 * plugin.levels.get(plugin.getServer().getPlayer(args[0]).getName());
				while (plugin.experience.get(plugin.getServer().getPlayer(args[0]).getName()) >= expToNextLevel) {
					plugin.experience.put(plugin.getServer().getPlayer(args[0]).getName(), plugin.experience.get(plugin.getServer().getPlayer(args[0]).getName()) - expToNextLevel);
					plugin.levels.put(plugin.getServer().getPlayer(args[0]).getName(), plugin.levels.get(plugin.getServer().getPlayer(args[0]).getName()) + 1);
					expToNextLevel = 1000 * plugin.levels.get(plugin.getServer().getPlayer(args[0]).getName());
				}
				plugin.getServer().getPlayer(args[0]).setExp((float) plugin.experience.get(plugin.getServer().getPlayer(args[0]).getName()) / (float) expToNextLevel);
				plugin.getServer().getPlayer(args[0]).setLevel(plugin.levels.get(plugin.getServer().getPlayer(args[0]).getName()));
				plugin.getServer().getPlayer(args[0]).setMaxHealth(plugin.levels.get(plugin.getServer().getPlayer(args[0]).getName()) * 10);
				plugin.getServer().getPlayer(args[0]).sendMessage(ChatColor.YELLOW + "+" + Integer.parseInt(args[1]) + " exp");
				plugin.getServer().getPlayer(args[0]).sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(plugin.getServer().getPlayer(args[0]).getName()) + "/" + expToNextLevel);
				sender.sendMessage(ChatColor.GREEN + "Gave " + plugin.getServer().getPlayer(args[0]).getName() + " " + Integer.parseInt(args[1]) + " exp");
			}
		} else {
			sender.sendMessage(ChatColor.RED + "You do not have permission.");
		}
		return true;
	}

}