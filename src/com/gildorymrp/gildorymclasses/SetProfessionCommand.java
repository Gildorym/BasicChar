package com.gildorymrp.gildorymclasses;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gildorymrp.gildorym.Gildorym;
import com.gildorymrp.gildorym.GildorymCharacter;

public class SetProfessionCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Gildorym gildorym = (Gildorym) Bukkit.getServer().getPluginManager().getPlugin("Gildorym");
		if ((args.length >= 2)
				&& (sender.hasPermission("basicchar.command.setprofession"))) {
			if (CharacterProfession.valueOf(args[1].toUpperCase()) != null) {
				if (Bukkit.getServer().getPlayer(args[0]) != null) {
					Player player = Bukkit.getServer().getPlayer(args[0]);
					GildorymCharacter gChar = gildorym.getActiveCharacters()
							.get(player.getName());

					try {
						gChar.setProfessions(new CharacterProfession[] { CharacterProfession
								.valueOf(args[1].toUpperCase()) });
						sender.sendMessage(ChatColor.GREEN
								+ Bukkit.getServer().getPlayer(args[0])
										.getName()
								+ "'s profession set to "
								+ CharacterProfession.valueOf(
										args[1].toUpperCase()).toString());
					} catch (IllegalArgumentException exception) {
						sender.sendMessage(ChatColor.RED
								+ "That's not a valid profession!");
					}
				} else {
					sender.sendMessage(ChatColor.RED
							+ "That player is not online!");
				}
			} else
				sender.sendMessage(ChatColor.RED
						+ "That's not a valid profession!");
		} else if (args.length >= 1) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED
						+ "You must specify both the player and profession.");
				return true;
			}
			if (gildorym.getActiveCharacters().get(sender.getName()) != null
					&& !sender.hasPermission("basicchar.command.setprofession")) {
				sender.sendMessage(ChatColor.RED
						+ "You have already set your profession!");
			} else {
				try {
					GildorymCharacter gChar = gildorym.getActiveCharacters().get(sender.getName());
					gChar.setProfessions(new CharacterProfession[] { CharacterProfession
							.valueOf(args[0].toUpperCase()) });
					sender.sendMessage(ChatColor.GREEN
							+ "Profession set to "
							+ CharacterProfession
									.valueOf(args[0].toUpperCase()).toString());
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