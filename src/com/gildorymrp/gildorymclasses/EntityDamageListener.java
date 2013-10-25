/*    */ package com.gildorymrp.gildorymclasses;
/*    */ 
/*    */ import org.bukkit.entity.HumanEntity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageEvent;
/*    */ import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
/*    */ 
/*    */ public class EntityDamageListener
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onEntityDamage(EntityDamageEvent event)
/*    */   {
/* 14 */     if (((event.getEntity() instanceof Player)) && 
/* 15 */       ((event.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) || (event.getCause() == EntityDamageEvent.DamageCause.PROJECTILE)) && 
/* 16 */       (((HumanEntity)event.getEntity()).isBlocking()))
/* 17 */       event.setCancelled(true);
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator.Banditt-PC\Desktop\Coding\Server\plugins\GildorymClasses.jar
 * Qualified Name:     com.gildorymrp.gildorymclasses.EntityDamageListener
 * JD-Core Version:    0.6.2
 */