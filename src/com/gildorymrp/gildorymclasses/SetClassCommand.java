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
/*    */ public class SetClassCommand
/*    */   implements CommandExecutor
/*    */ {
/*    */   private GildorymClasses plugin;
/*    */ 
/*    */   public SetClassCommand(GildorymClasses plugin)
/*    */   {
/* 14 */     this.plugin = plugin;
/*    */   }
/*    */ 
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 19 */     if ((args.length >= 2) && (sender.hasPermission("basicchar.command.setclass"))) {
/* 20 */       if (CharacterClass.valueOf(args[1].toUpperCase()) != null) {
/* 21 */         if (Bukkit.getServer().getPlayer(args[0]) != null) {
/* 22 */           sender.sendMessage(ChatColor.GREEN + Bukkit.getServer().getPlayer(args[0]).getName() + "'s class set to " + CharacterClass.valueOf(args[1].toUpperCase()).toString());
/* 23 */           this.plugin.classes.put(Bukkit.getServer().getPlayer(args[0]).getName(), CharacterClass.valueOf(args[1].toUpperCase()));
/*    */         } else {
/* 25 */           sender.sendMessage(ChatColor.RED + "That player is not online!");
/*    */         }
/*    */       }
/* 28 */       else sender.sendMessage(ChatColor.RED + "That's not a valid class!");
/*    */     }
/* 30 */     else if (args.length >= 1)
/*    */       try {
/* 32 */         sender.sendMessage(ChatColor.GREEN + "Class set to " + CharacterClass.valueOf(args[0].toUpperCase()).toString());
/* 33 */         this.plugin.classes.put(sender.getName(), CharacterClass.valueOf(args[0].toUpperCase()));
/*    */       } catch (IllegalArgumentException exception) {
/* 35 */         sender.sendMessage(ChatColor.RED + "That's not a valid class!");
/*    */       }
/*    */     else {
/* 38 */       sender.sendMessage(ChatColor.RED + "You need to specify a class!");
/*    */     }
/* 40 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator.Banditt-PC\Desktop\Coding\Server\plugins\GildorymClasses.jar
 * Qualified Name:     com.gildorymrp.gildorymclasses.SetClassCommand
 * JD-Core Version:    0.6.2
 */