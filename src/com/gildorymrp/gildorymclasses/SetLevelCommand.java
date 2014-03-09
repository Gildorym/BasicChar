package com.gildorymrp.gildorymclasses;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gildorymrp.gildorym.Gildorym;
import com.gildorymrp.gildorym.GildorymCharacter;

public class SetLevelCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Gildorym gildorym = (Gildorym) Bukkit.getServer().getPluginManager().getPlugin("Gildorym");
		if (sender.hasPermission("basicchar.command.setlevel")) {
			if (args.length >= 2)
				try {
					if (Bukkit.getServer().getPlayer(args[0]) != null) {
						Player player = Bukkit.getServer().getPlayer(args[0]);
						GildorymCharacter gChar = gildorym.getActiveCharacters().get(player.getName());
						gChar.setLevel(Integer.parseInt(args[1]));
						sender.sendMessage(ChatColor.GREEN
								+ player.getName() + "'s level set to "
								+ args[1]);
						player.setLevel(Integer.parseInt(args[1]));
					} else {
						sender.sendMessage(ChatColor.RED
								+ "That player is not online!");
					}
				} catch (NumberFormatException exception) {
					sender.sendMessage(ChatColor.RED
							+ "Level must be a number!");
				}
			else if (args.length >= 1) {
				if (!(sender instanceof Player)) {
					sender.sendMessage(ChatColor.RED + "You must specify both player and level.");
					return true;
				}
				try {
					GildorymCharacter gChar = gildorym.getActiveCharacters().get(sender.getName());
					gChar.setLevel(Integer.parseInt(args[0]));
					sender.sendMessage(ChatColor.GREEN + "Level set to "
							+ args[0]);
					((Player) sender).setLevel(Integer.parseInt(args[0]));
				} catch (NumberFormatException exception) {
					sender.sendMessage(ChatColor.RED
							+ "Level must be a number!");
				}
			} else {
				sender.sendMessage(ChatColor.RED
						+ "You need to specify a level!");
			}
		} else {
			sender.sendMessage(ChatColor.RED + "You do not have permission!");
		}
		return true;
	}
}