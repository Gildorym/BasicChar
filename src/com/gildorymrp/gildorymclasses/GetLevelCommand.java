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
/*    */ public class GetLevelCommand
/*    */   implements CommandExecutor
/*    */ {
/*    */   private GildorymClasses plugin;
/*    */ 
/*    */   public GetLevelCommand(GildorymClasses plugin)
/*    */   {
/* 14 */     this.plugin = plugin;
/*    */   }
/*    */ 
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 19 */     if (sender.hasPermission("basicchar.command.getlevel")) {
/* 20 */       String player = sender.getName();
/* 21 */       if (args.length >= 1) {
/* 22 */         if (Bukkit.getServer().getPlayer(args[0]) != null) {
/* 23 */           player = Bukkit.getServer().getPlayer(args[0]).getName();
/*    */         } else {
/* 25 */           sender.sendMessage(ChatColor.RED + "That player is not online!");
/* 26 */           return true;
/*    */         }
/*    */       }
/*    */ 
/* 30 */       if (this.plugin.levels.get(player) != null)
/* 31 */         sender.sendMessage(ChatColor.GREEN + player + "'s level is " + this.plugin.levels.get(player));
/*    */       else {
/* 33 */         sender.sendMessage(ChatColor.RED + player + " has not been assigned a level!");
/*    */       }
/*    */     }
/* 36 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator.Banditt-PC\Desktop\Coding\Server\plugins\GildorymClasses.jar
 * Qualified Name:     com.gildorymrp.gildorymclasses.GetLevelCommand
 * JD-Core Version:    0.6.2
 */