/*    */ package com.gildorymrp.gildorymclasses;
/*    */ 
/*    */ import java.util.Map;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerRespawnEvent;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ 
/*    */ public class PlayerRespawnListener
/*    */   implements Listener
/*    */ {
/*    */   private GildorymClasses plugin;
/*    */ 
/*    */   public PlayerRespawnListener(GildorymClasses plugin)
/*    */   {
/* 13 */     this.plugin = plugin;
/*    */   }
/*    */ 
/*    */   @EventHandler
/*    */   public void onPlayerRespawn(PlayerRespawnEvent event) {
/* 18 */     final Player player = event.getPlayer();
/* 19 */     this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*    */     {
/*    */       public void run()
/*    */       {
/* 23 */         if (PlayerRespawnListener.this.plugin.levels.get(player.getName()) == null) {
/* 24 */           PlayerRespawnListener.this.plugin.levels.put(player.getName(), Integer.valueOf(1));
/*    */         }
/* 26 */         if (PlayerRespawnListener.this.plugin.experience.get(player.getName()) == null) {
/* 27 */           PlayerRespawnListener.this.plugin.experience.put(player.getName(), Integer.valueOf(0));
/*    */         }
/* 29 */         int expToNextLevel = Math.round(1000 * ((Integer)PlayerRespawnListener.this.plugin.levels.get(player.getName())).intValue());
/* 30 */         while (((Integer)PlayerRespawnListener.this.plugin.experience.get(player.getName())).intValue() >= expToNextLevel) {
/* 31 */           PlayerRespawnListener.this.plugin.experience.put(player.getName(), Integer.valueOf(((Integer)PlayerRespawnListener.this.plugin.experience.get(player.getName())).intValue() - expToNextLevel));
/* 32 */           PlayerRespawnListener.this.plugin.levels.put(player.getName(), Integer.valueOf(((Integer)PlayerRespawnListener.this.plugin.levels.get(player.getName())).intValue() + 1));
/* 33 */           expToNextLevel = 1000 * ((Integer)PlayerRespawnListener.this.plugin.levels.get(player.getName())).intValue();
/*    */         }
/* 35 */         player.setExp(((Integer)PlayerRespawnListener.this.plugin.experience.get(player.getName())).intValue() / expToNextLevel);
/* 36 */         player.setLevel(((Integer)PlayerRespawnListener.this.plugin.levels.get(player.getName())).intValue());
/* 37 */         player.setMaxHealth(((Integer)PlayerRespawnListener.this.plugin.levels.get(player.getName())).intValue() * 10);
/*    */       }
/*    */     }
/*    */     , 20L);
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator.Banditt-PC\Desktop\Coding\Server\plugins\GildorymClasses.jar
 * Qualified Name:     com.gildorymrp.gildorymclasses.PlayerRespawnListener
 * JD-Core Version:    0.6.2
 */