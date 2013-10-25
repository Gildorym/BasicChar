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
/*    */ public class GetProfessionCommand
/*    */   implements CommandExecutor
/*    */ {
/*    */   private GildorymClasses plugin;
/*    */ 
/*    */   public GetProfessionCommand(GildorymClasses plugin)
/*    */   {
/* 14 */     this.plugin = plugin;
/*    */   }
/*    */ 
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 19 */     String player = sender.getName();
/* 20 */     if ((sender.hasPermission("basicchar.command.getprofession")) && 
/* 21 */       (args.length >= 1)) {
/* 22 */       if (Bukkit.getServer().getPlayer(args[0]) != null) {
/* 23 */         player = Bukkit.getServer().getPlayer(args[0]).getName();
/*    */       } else {
/* 25 */         sender.sendMessage(ChatColor.RED + "That player is not online!");
/* 26 */         return true;
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 31 */     if (this.plugin.professions.get(player) != null)
/* 32 */       sender.sendMessage(ChatColor.GREEN + player + "'s profession is " + ((CharacterProfession)this.plugin.professions.get(player)).toString());
/*    */     else {
/* 34 */       sender.sendMessage(ChatColor.RED + player + " has not chosen a profession!");
/*    */     }
/* 36 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator.Banditt-PC\Desktop\Coding\Server\plugins\GildorymClasses.jar
 * Qualified Name:     com.gildorymrp.gildorymclasses.GetProfessionCommand
 * JD-Core Version:    0.6.2
 */