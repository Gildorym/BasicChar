package com.gildorymrp.gildorymclasses;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.gildorymrp.gildorym.Gildorym;
import com.gildorymrp.gildorym.GildorymCharacter;

public class GetProfessionCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		String player = sender.getName();
		if ((sender.hasPermission("basicchar.command.getprofession"))
				&& (args.length >= 1)) {
			if (Bukkit.getServer().getPlayer(args[0]) != null) {
				player = Bukkit.getServer().getPlayer(args[0]).getName();
			} else {
				sender.sendMessage(ChatColor.RED + "That player is not online!");
				return true;
			}

		}
		
		Gildorym gildorym = (Gildorym) Bukkit.getServer().getPluginManager().getPlugin("Gildorym");
		GildorymCharacter gChar = gildorym.getActiveCharacters().get(player);	

		if (gChar.getProfession1() != null)
		{
			String professionsList = gChar.getProfession1().toString();
			if(gChar.getProfession2() != null) 
				professionsList += ", " + gChar.getProfession2().toString();
			
			sender.sendMessage(ChatColor.GREEN
					+ player
					+ "'s professions are "
					+ professionsList);
		} else {
			sender.sendMessage(ChatColor.RED + player
					+ " has not chosen a profession!");
		}
		return true;
	}
}
