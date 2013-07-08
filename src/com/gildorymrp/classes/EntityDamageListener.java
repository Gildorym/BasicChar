package com.gildorymrp.classes;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import com.gildorymrp.api.Gildorym;

public class EntityDamageListener implements Listener {
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			if (event.getCause() == DamageCause.ENTITY_ATTACK || event.getCause() == DamageCause.PROJECTILE) {
				if (((Player) event.getEntity()).isBlocking()) {
					event.setCancelled(true);
				} else {
					Gildorym.getCorePlugin().getActiveCharacter((Player) event.getEntity()).setHealth(((Player) event.getEntity()).getHealth());
				}
			}
		}
	}

}
