package com.gildorymrp.gildorymclasses;

import java.util.Map;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddExpCommand implements CommandExecutor{

  private GildorymClasses plugin;

  public AddExpCommand(GildorymClasses plugin){
    this.plugin = plugin;
  }
 
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
    if (sender.hasPermission("basicchar.command.addexp")) {
      if (this.plugin.getServer().getPlayer(args[0]) != null) {
        if (this.plugin.levels.get(this.plugin.getServer().getPlayer(args[0]).getName()) == null) {
          this.plugin.levels.put(this.plugin.getServer().getPlayer(args[0]).getName(), Integer.valueOf(1));
        }
        if (this.plugin.experience.get(this.plugin.getServer().getPlayer(args[0]).getName()) == null) {
          this.plugin.experience.put(this.plugin.getServer().getPlayer(args[0]).getName(), Integer.valueOf(0));
        }
        this.plugin.experience.put(this.plugin.getServer().getPlayer(args[0]).getName(), Integer.valueOf(((Integer)this.plugin.experience.get(this.plugin.getServer().getPlayer(args[0]).getName())).intValue() + Integer.parseInt(args[1])));
        int expToNextLevel = 1000 * ((Integer)this.plugin.levels.get(this.plugin.getServer().getPlayer(args[0]).getName())).intValue();
        while (((Integer)this.plugin.experience.get(this.plugin.getServer().getPlayer(args[0]).getName())).intValue() >= expToNextLevel) {
this.plugin.experience.put(this.plugin.getServer().getPlayer(args[0]).getName(), Integer.valueOf(((Integer)this.plugin.experience.get(this.plugin.getServer().getPlayer(args[0]).getName())).intValue() - expToNextLevel));
this.plugin.levels.put(this.plugin.getServer().getPlayer(args[0]).getName(), Integer.valueOf(((Integer)this.plugin.levels.get(this.plugin.getServer().getPlayer(args[0]).getName())).intValue() + 1));
expToNextLevel = 1000 * ((Integer)this.plugin.levels.get(this.plugin.getServer().getPlayer(args[0]).getName())).intValue();
}
        this.plugin.getServer().getPlayer(args[0]).setExp(((Integer)this.plugin.experience.get(this.plugin.getServer().getPlayer(args[0]).getName())).intValue() / expToNextLevel);
        this.plugin.getServer().getPlayer(args[0]).setLevel(((Integer)this.plugin.levels.get(this.plugin.getServer().getPlayer(args[0]).getName())).intValue());
        this.plugin.getServer().getPlayer(args[0]).setMaxHealth(((Integer)this.plugin.levels.get(this.plugin.getServer().getPlayer(args[0]).getName())).intValue() * 10);
        this.plugin.getServer().getPlayer(args[0]).sendMessage(ChatColor.YELLOW + "+" + Integer.parseInt(args[1]) + " exp");
        this.plugin.getServer().getPlayer(args[0]).sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + this.plugin.experience.get(this.plugin.getServer().getPlayer(args[0]).getName()) + "/" + expToNextLevel);
        sender.sendMessage(ChatColor.GREEN + "Gave " + this.plugin.getServer().getPlayer(args[0]).getName() + " " + Integer.parseInt(args[1]) + " exp");
    }
  }else{ 
    sender.sendMessage(ChatColor.RED + "You do not have permission.");
    return true;
  }
  
}
