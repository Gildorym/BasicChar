package com.gildorym.basicchar;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeathListener implements Listener {
	
	private BasicChar plugin;
	
	public EntityDeathListener(BasicChar plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent event) {
		if (event.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent) {
			Player player = null;
			if (((EntityDamageByEntityEvent) event.getEntity().getLastDamageCause()).getDamager() instanceof Player) {
				player = (Player) (((EntityDamageByEntityEvent) event.getEntity().getLastDamageCause()).getDamager());
			}
			if (((EntityDamageByEntityEvent) event.getEntity().getLastDamageCause()).getDamager() instanceof Projectile) {
				LivingEntity shooter = ((Projectile) ((EntityDamageByEntityEvent) event.getEntity().getLastDamageCause()).getDamager()).getShooter();
				if (shooter != null) {
					if (shooter instanceof Player) {
						player = (Player) shooter;
					}
				}
			}
			if (player != null) {
				int expToNextLevel = (int) Math.round(1000 * plugin.levels.get(player.getName()));
				/*if (event.getEntityType() == EntityType.BAT) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 0);
					player.sendMessage(ChatColor.YELLOW + "+0 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}*/
				if (event.getEntityType() == EntityType.BLAZE) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 6);
					player.sendMessage(ChatColor.YELLOW + "+6 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}
				if (event.getEntityType() == EntityType.CAVE_SPIDER) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 5);
					player.sendMessage(ChatColor.YELLOW + "+5 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}
				/*if (event.getEntityType() == EntityType.CHICKEN) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 0);
					player.sendMessage(ChatColor.YELLOW + "+0 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}*/
				/*if (event.getEntityType() == EntityType.COW) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 0);
					player.sendMessage(ChatColor.YELLOW + "+0 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}*/
				if (event.getEntityType() == EntityType.ENDER_DRAGON) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 5000);
					player.sendMessage(ChatColor.YELLOW + "+5000 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}
				if (event.getEntityType() == EntityType.ENDERMAN) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 6);
					player.sendMessage(ChatColor.YELLOW + "+6 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}
				if (event.getEntityType() == EntityType.GHAST) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 6);
					player.sendMessage(ChatColor.YELLOW + "+6 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}
				if (event.getEntityType() == EntityType.GIANT) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 100);
					player.sendMessage(ChatColor.YELLOW + "+100 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}
				/*if (event.getEntityType() == EntityType.IRON_GOLEM) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 0);
					player.sendMessage(ChatColor.YELLOW + "+0 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}*/
				if (event.getEntityType() == EntityType.MAGMA_CUBE) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 2);
					player.sendMessage(ChatColor.YELLOW + "+2 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}
				/*if (event.getEntityType() == EntityType.MUSHROOM_COW) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 0);
					player.sendMessage(ChatColor.YELLOW + "+0 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}*/
				if (event.getEntityType() == EntityType.OCELOT) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 2);
					player.sendMessage(ChatColor.YELLOW + "+2 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}
				/*if (event.getEntityType() == EntityType.PIG) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 0);
					player.sendMessage(ChatColor.YELLOW + "+0 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}*/
				if (event.getEntityType() == EntityType.PIG_ZOMBIE) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 4);
					player.sendMessage(ChatColor.YELLOW + "+4 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}
				/*if (event.getEntityType() == EntityType.SHEEP) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 0);
					player.sendMessage(ChatColor.YELLOW + "+0 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}*/
				if (event.getEntityType() == EntityType.SILVERFISH) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 1);
					player.sendMessage(ChatColor.YELLOW + "+1 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}
				if (event.getEntityType() == EntityType.SKELETON) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 3);
					player.sendMessage(ChatColor.YELLOW + "+3 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}
				if (event.getEntityType() == EntityType.SLIME) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 1);
					player.sendMessage(ChatColor.YELLOW + "+1 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}
				/*if (event.getEntityType() == EntityType.SNOWMAN) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 0);
					player.sendMessage(ChatColor.YELLOW + "+0 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}*/
				if (event.getEntityType() == EntityType.SPIDER) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 3);
					player.sendMessage(ChatColor.YELLOW + "+3 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}
				if (event.getEntityType() == EntityType.SQUID) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 1);
					player.sendMessage(ChatColor.YELLOW + "+1 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}
				/*if (event.getEntityType() == EntityType.VILLAGER) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 0);
					player.sendMessage(ChatColor.YELLOW + "+0 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}*/
				if (event.getEntityType() == EntityType.WITCH) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 5);
					player.sendMessage(ChatColor.YELLOW + "+5 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}
				if (event.getEntityType() == EntityType.WITHER) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 5000);
					player.sendMessage(ChatColor.YELLOW + "+5000 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}
				if (event.getEntityType() == EntityType.WOLF) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 2);
					player.sendMessage(ChatColor.YELLOW + "+2 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}
				if (event.getEntityType() == EntityType.ZOMBIE) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) + 3);
					player.sendMessage(ChatColor.YELLOW + "+3 exp");
					player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + plugin.experience.get(player.getName()) + "/" + expToNextLevel);
				}
				while (plugin.experience.get(player.getName()) >= expToNextLevel) {
					plugin.experience.put(player.getName(), plugin.experience.get(player.getName()) - expToNextLevel);
					plugin.levels.put(player.getName(), plugin.levels.get(player.getName()) + 1);
					expToNextLevel = 1000 * plugin.levels.get(player.getName());
				}
				player.setExp((float) plugin.experience.get(player.getName()) / (float) expToNextLevel);
				player.setLevel(plugin.levels.get(player.getName()));
				player.setMaxHealth(plugin.levels.get(player.getName()) * 10);
			}
		}
	}

}
