/*    */ package com.gildorymrp.gildorymclasses;
/*    */ 
/*    */ import java.util.Map;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class SetLevelCommand
/*    */   implements CommandExecutor
/*    */ {
/*    */   private GildorymClasses plugin;
/*    */ 
/*    */   public SetLevelCommand(GildorymClasses plugin)
/*    */   {
/* 15 */     this.plugin = plugin;
/*    */   }
/*    */ 
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 20 */     if (sender.hasPermission("basicchar.command.setlevel")) {
/* 21 */       if (args.length >= 2)
/*    */         try {
/* 23 */           if (Bukkit.getServer().getPlayer(args[0]) != null) {
/* 24 */             this.plugin.levels.put(Bukkit.getServer().getPlayer(args[0]).getName(), Integer.valueOf(Integer.parseInt(args[1])));
/* 25 */             sender.sendMessage(ChatColor.GREEN + Bukkit.getServer().getPlayer(args[0]).getName() + "'s level set to " + args[1]);
/* 26 */             Bukkit.getServer().getPlayer(args[0]).setLevel(Integer.parseInt(args[1]));
/*    */           } else {
/* 28 */             sender.sendMessage(ChatColor.RED + "That player is not online!");
/*    */           }
/*    */         } catch (NumberFormatException exception) {
/* 31 */           sender.sendMessage(ChatColor.RED + "Level must be a number!");
/*    */         }
/* 33 */       else if (args.length >= 1)
/*    */         try {
/* 35 */           this.plugin.levels.put(sender.getName(), Integer.valueOf(Integer.parseInt(args[0])));
/* 36 */           sender.sendMessage(ChatColor.GREEN + "Level set to " + args[0]);
/* 37 */           ((Player)sender).setLevel(Integer.parseInt(args[0]));
/*    */         } catch (NumberFormatException exception) {
/* 39 */           sender.sendMessage(ChatColor.RED + "Level must be a number!");
/*    */         }
/*    */       else
/* 42 */         sender.sendMessage(ChatColor.RED + "You need to specify a level!");
/*    */     }
/*    */     else {
/* 45 */       sender.sendMessage(ChatColor.RED + "You do not have permission!");
/*    */     }
/* 47 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator.Banditt-PC\Desktop\Coding\Server\plugins\GildorymClasses.jar
 * Qualified Name:     com.gildorymrp.gildorymclasses.SetLevelCommand
 * JD-Core Version:    0.6.2
 */