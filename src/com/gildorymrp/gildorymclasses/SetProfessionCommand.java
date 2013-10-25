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
/*    */ public class SetProfessionCommand
/*    */   implements CommandExecutor
/*    */ {
/*    */   private GildorymClasses plugin;
/*    */ 
/*    */   public SetProfessionCommand(GildorymClasses plugin)
/*    */   {
/* 14 */     this.plugin = plugin;
/*    */   }
/*    */ 
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 19 */     if ((args.length >= 2) && (sender.hasPermission("basicchar.command.setprofession"))) {
/* 20 */       if (CharacterProfession.valueOf(args[1].toUpperCase()) != null) {
/* 21 */         if (Bukkit.getServer().getPlayer(args[0]) != null) {
/* 22 */           sender.sendMessage(ChatColor.GREEN + Bukkit.getServer().getPlayer(args[0]).getName() + "'s profession set to " + CharacterProfession.valueOf(args[1].toUpperCase()).toString());
/* 23 */           this.plugin.professions.put(Bukkit.getServer().getPlayer(args[0]).getName(), CharacterProfession.valueOf(args[1].toUpperCase()));
/*    */         } else {
/* 25 */           sender.sendMessage(ChatColor.RED + "That player is not online!");
/*    */         }
/*    */       }
/* 28 */       else sender.sendMessage(ChatColor.RED + "That's not a valid profession!");
/*    */     }
/* 30 */     else if (args.length >= 1)
/*    */       try {
/* 32 */         sender.sendMessage(ChatColor.GREEN + "Profession set to " + CharacterProfession.valueOf(args[0].toUpperCase()).toString());
/* 33 */         this.plugin.professions.put(sender.getName(), CharacterProfession.valueOf(args[0].toUpperCase()));
/*    */       } catch (IllegalArgumentException exception) {
/* 35 */         sender.sendMessage(ChatColor.RED + "That's not a valid profession!");
/*    */       }
/*    */     else {
/* 38 */       sender.sendMessage(ChatColor.RED + "You need to specify a profession!");
/*    */     }
/* 40 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator.Banditt-PC\Desktop\Coding\Server\plugins\GildorymClasses.jar
 * Qualified Name:     com.gildorymrp.gildorymclasses.SetProfessionCommand
 * JD-Core Version:    0.6.2
 */