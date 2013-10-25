package com.gildorymrp.classes;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.gildorymrp.api.plugin.classes.Class;

public class ListClassesCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		sender.sendMessage(GildorymClasses.PREFIX + ChatColor.GREEN + "Available classes:");
		for (Class clazz : Class.values()) {
			sender.sendMessage(ChatColor.GREEN + clazz.toString());
		}
		return true;
	}

}
