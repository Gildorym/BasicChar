/*    */ package com.gildorymrp.gildorymclasses;
/*    */ 
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ 
/*    */ public class ListClassesCommand
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 12 */     for (CharacterClass characterClass : CharacterClass.values()) {
/* 13 */       sender.sendMessage(ChatColor.GREEN + characterClass.toString());
/*    */     }
/* 15 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator.Banditt-PC\Desktop\Coding\Server\plugins\GildorymClasses.jar
 * Qualified Name:     com.gildorymrp.gildorymclasses.ListClassesCommand
 * JD-Core Version:    0.6.2
 */