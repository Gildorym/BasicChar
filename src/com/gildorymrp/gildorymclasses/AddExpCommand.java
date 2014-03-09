package com.gildorymrp.gildorymclasses;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gildorymrp.charactercards.CharacterCard;
import com.gildorymrp.gildorym.Gildorym;
import com.gildorymrp.gildorym.GildorymCharacter;

public class AddExpCommand implements CommandExecutor {
	private GildorymClasses plugin;

	public AddExpCommand(GildorymClasses plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (sender.hasPermission("basicchar.command.addexp")) {
			Player player = this.plugin.getServer().getPlayer(args[0]);
			

			if (player != null) {
				Gildorym gildorym = (Gildorym) Bukkit.getServer().getPluginManager().getPlugin("Gildorym");
				GildorymCharacter gChar = gildorym.getActiveCharacters().get(player.getName());
				gChar.setExperience(gChar.getExperience() + + Integer.parseInt(args[1]));
				int expToNextLevel = 1000 * gChar.getLevel();
				while (gChar.getExperience() >= expToNextLevel) {
					gChar.setExperience(gChar.getExperience() - expToNextLevel);
					gChar.setLevel(gChar.getLevel() + 1);
					expToNextLevel = 1000 * gChar.getLevel();
				}
				
				Integer pvpHealth = CharacterCard.calculateHealth(gChar);
				
				player.setExp((float) (gChar.getExperience() / (double) expToNextLevel));
				player.setLevel(gChar.getLevel());
				player.setMaxHealth(pvpHealth * 5);
				player.sendMessage(ChatColor.YELLOW + "+"
						+ Integer.parseInt(args[1]) + " exp");
				player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE
						+ gChar.getExperience() + "/"
						+ expToNextLevel);
				sender.sendMessage(ChatColor.GREEN + "Gave " + player.getName()
						+ " " + Integer.parseInt(args[1]) + " exp");
			}
		} else
			sender.sendMessage(ChatColor.RED + "You do not have permission.");

		return true;
	}
}