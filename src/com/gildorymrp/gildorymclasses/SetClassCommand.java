package com.gildorymrp.gildorymclasses;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gildorymrp.gildorym.Gildorym;
import com.gildorymrp.gildorym.GildorymCharacter;
import com.gildorymrp.gildorym.MySQLDatabase;

public class SetClassCommand implements CommandExecutor {

	private Gildorym gildorym;
	private MySQLDatabase sqlDB;

	public SetClassCommand(Gildorym gildorym) {
		this.gildorym = gildorym;
		this.sqlDB = gildorym.getMySQLDatabase();
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if ((args.length >= 2)
				&& (sender.hasPermission("basicchar.command.setclass"))) {
			if (CharacterClass.valueOf(args[1].toUpperCase()) != null) {
				if (Bukkit.getServer().getPlayer(args[0]) != null) {
					Player player = Bukkit.getServer().getPlayer(args[0]);
					GildorymCharacter gChar = gildorym.getActiveCharacters().get(player.getName());
					
					try {
					gChar.setCharClass(CharacterClass.valueOf(args[1].toUpperCase()));
					sqlDB.saveCharacter(gChar);
					sender.sendMessage(ChatColor.GREEN
							+ player.getName()
							+ "'s class set to "
							+ CharacterClass.valueOf(args[1].toUpperCase())
							.toString());
					} catch (IllegalArgumentException exception) {
						sender.sendMessage(ChatColor.RED
								+ "That's not a valid class!");
					}
				} else {
					sender.sendMessage(ChatColor.RED
							+ "That player is not online!");
				}
			} else
				sender.sendMessage(ChatColor.RED + "That's not a valid class!");
		} else if (args.length >= 1) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "You must specify both the player and class.");
				return true;
			}
			if (gildorym.getActiveCharacters().get(sender.getName()).getCharClass() != CharacterClass.UNKNOWN
					&& !sender.hasPermission("basicchar.command.setclass")) {
				sender.sendMessage(ChatColor.RED
						+ "You have already set your class!");
			} else {
				try {
					GildorymCharacter gChar = gildorym.getActiveCharacters().get(sender.getName());
					gChar.setCharClass(CharacterClass.valueOf(args[0].toUpperCase()));
					sender.sendMessage(ChatColor.GREEN
							+ "Class set to "
							+ CharacterClass.valueOf(args[0].toUpperCase())
							.toString());
				} catch (IllegalArgumentException exception) {
					sender.sendMessage(ChatColor.RED
							+ "That's not a valid class!");
				}
			}
		} else {
			sender.sendMessage(ChatColor.RED + "You need to specify a class!");
		}
		return true;
	}
}
