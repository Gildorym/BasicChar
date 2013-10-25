/*    */ package com.gildorymrp.gildorymclasses;
/*    */ 
/*    */ import java.util.Map;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class AddExpCommand
/*    */   implements CommandExecutor
/*    */ {
/*    */   private GildorymClasses plugin;
/*    */ 
/*    */   public AddExpCommand(GildorymClasses plugin)
/*    */   {
/* 13 */     this.plugin = plugin;
/*    */   }
/*    */ 
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 18 */     if (sender.hasPermission("basicchar.command.addexp")) {
/* 19 */       if (this.plugin.getServer().getPlayer(args[0]) != null) {
/* 20 */         if (this.plugin.levels.get(this.plugin.getServer().getPlayer(args[0]).getName()) == null) {
/* 21 */           this.plugin.levels.put(this.plugin.getServer().getPlayer(args[0]).getName(), Integer.valueOf(1));
/*    */         }
/* 23 */         if (this.plugin.experience.get(this.plugin.getServer().getPlayer(args[0]).getName()) == null) {
/* 24 */           this.plugin.experience.put(this.plugin.getServer().getPlayer(args[0]).getName(), Integer.valueOf(0));
/*    */         }
/* 26 */         this.plugin.experience.put(this.plugin.getServer().getPlayer(args[0]).getName(), Integer.valueOf(((Integer)this.plugin.experience.get(this.plugin.getServer().getPlayer(args[0]).getName())).intValue() + Integer.parseInt(args[1])));
/* 27 */         int expToNextLevel = 1000 * ((Integer)this.plugin.levels.get(this.plugin.getServer().getPlayer(args[0]).getName())).intValue();
/* 28 */         while (((Integer)this.plugin.experience.get(this.plugin.getServer().getPlayer(args[0]).getName())).intValue() >= expToNextLevel) {
/* 29 */           this.plugin.experience.put(this.plugin.getServer().getPlayer(args[0]).getName(), Integer.valueOf(((Integer)this.plugin.experience.get(this.plugin.getServer().getPlayer(args[0]).getName())).intValue() - expToNextLevel));
/* 30 */           this.plugin.levels.put(this.plugin.getServer().getPlayer(args[0]).getName(), Integer.valueOf(((Integer)this.plugin.levels.get(this.plugin.getServer().getPlayer(args[0]).getName())).intValue() + 1));
/* 31 */           expToNextLevel = 1000 * ((Integer)this.plugin.levels.get(this.plugin.getServer().getPlayer(args[0]).getName())).intValue();
/*    */         }
/* 33 */         this.plugin.getServer().getPlayer(args[0]).setExp(((Integer)this.plugin.experience.get(this.plugin.getServer().getPlayer(args[0]).getName())).intValue() / expToNextLevel);
/* 34 */         this.plugin.getServer().getPlayer(args[0]).setLevel(((Integer)this.plugin.levels.get(this.plugin.getServer().getPlayer(args[0]).getName())).intValue());
/* 35 */         this.plugin.getServer().getPlayer(args[0]).setMaxHealth(((Integer)this.plugin.levels.get(this.plugin.getServer().getPlayer(args[0]).getName())).intValue() * 10);
/* 36 */         this.plugin.getServer().getPlayer(args[0]).sendMessage(ChatColor.YELLOW + "+" + Integer.parseInt(args[1]) + " exp");
/* 37 */         this.plugin.getServer().getPlayer(args[0]).sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + this.plugin.experience.get(this.plugin.getServer().getPlayer(args[0]).getName()) + "/" + expToNextLevel);
/* 38 */         sender.sendMessage(ChatColor.GREEN + "Gave " + this.plugin.getServer().getPlayer(args[0]).getName() + " " + Integer.parseInt(args[1]) + " exp");
/*    */       }
/*    */     }
/* 41 */     else sender.sendMessage(ChatColor.RED + "You do not have permission.");
/*    */ 
/* 43 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator.Banditt-PC\Desktop\Coding\Server\plugins\GildorymClasses.jar
 * Qualified Name:     com.gildorymrp.gildorymclasses.AddExpCommand
 * JD-Core Version:    0.6.2
 */