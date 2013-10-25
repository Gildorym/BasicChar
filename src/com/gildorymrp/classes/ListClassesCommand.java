package com.gildorymrp.classes;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ListClassesCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		for (CharacterClass characterClass : CharacterClass.values()) {
			sender.sendMessage(ChatColor.GREEN + characterClass.toString());
		}
		return true;
	}

}
