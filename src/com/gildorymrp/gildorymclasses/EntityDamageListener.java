package com.gildorymrp.gildorymclasses;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class EntityDamageListener implements Listener{

  @EventHandler
  public void onEntityDamage(EntityDamageEvent event){
    if (((event.getEntity() instanceof Player)) && ((event.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) || (event.getCause() == EntityDamageEvent.DamageCause.PROJECTILE)) && (((HumanEntity)event.getEntity()).isBlocking())){
      event.setCancelled(true);
    }
  }
  
}
