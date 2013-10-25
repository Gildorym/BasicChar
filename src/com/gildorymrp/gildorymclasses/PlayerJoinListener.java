/*    */ package com.gildorymrp.gildorymclasses;
/*    */ 
/*    */ import java.util.Map;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ 
/*    */ public class PlayerJoinListener
/*    */   implements Listener
/*    */ {
/*    */   private GildorymClasses plugin;
/*    */ 
/*    */   public PlayerJoinListener(GildorymClasses plugin)
/*    */   {
/* 12 */     this.plugin = plugin;
/*    */   }
/*    */ 
/*    */   @EventHandler
/*    */   public void onPlayerJoin(PlayerJoinEvent event) {
/* 17 */     if (this.plugin.levels.get(event.getPlayer().getName()) == null) {
/* 18 */       this.plugin.levels.put(event.getPlayer().getName(), Integer.valueOf(1));
/* 19 */       event.getPlayer().setLevel(1);
/*    */     }
/* 21 */     if (this.plugin.experience.get(event.getPlayer().getName()) == null) {
/* 22 */       this.plugin.experience.put(event.getPlayer().getName(), Integer.valueOf(0));
/* 23 */       event.getPlayer().setExp(0.0F);
/*    */     }
/* 25 */     int expToNextLevel = Math.round(1000 * ((Integer)this.plugin.levels.get(event.getPlayer().getName())).intValue());
/* 26 */     while (((Integer)this.plugin.experience.get(event.getPlayer().getName())).intValue() >= expToNextLevel) {
/* 27 */       this.plugin.experience.put(event.getPlayer().getName(), Integer.valueOf(((Integer)this.plugin.experience.get(event.getPlayer().getName())).intValue() - expToNextLevel));
/* 28 */       this.plugin.levels.put(event.getPlayer().getName(), Integer.valueOf(((Integer)this.plugin.levels.get(event.getPlayer().getName())).intValue() + 1));
/* 29 */       expToNextLevel = 1000 * ((Integer)this.plugin.levels.get(event.getPlayer().getName())).intValue();
/*    */     }
/* 31 */     event.getPlayer().setExp(((Integer)this.plugin.experience.get(event.getPlayer().getName())).intValue() / expToNextLevel);
/* 32 */     event.getPlayer().setMaxHealth(((Integer)this.plugin.levels.get(event.getPlayer().getName())).intValue() * 10);
/* 33 */     event.getPlayer().setLevel(((Integer)this.plugin.levels.get(event.getPlayer().getName())).intValue());
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator.Banditt-PC\Desktop\Coding\Server\plugins\GildorymClasses.jar
 * Qualified Name:     com.gildorymrp.gildorymclasses.PlayerJoinListener
 * JD-Core Version:    0.6.2
 */