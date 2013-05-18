package com.gildorymrp.gildorymclasses;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import com.gildorymrp.api.Gildorym;

public class EntityDeathListener implements Listener {
	
	private GildorymClasses plugin;
	
	public EntityDeathListener(GildorymClasses plugin) {
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
			Random random = new Random();
			if (player != null) {
				int exp = 0;
				int money = 0;
				switch (event.getEntityType()) {
					case BLAZE:
						exp = 6;
						break;
					case CAVE_SPIDER:
						exp = 5;
						break;
					case ENDERMAN:
						exp = 6;
						money = random.nextInt(7) + 6; //Between 6 and 12
						break;
					case ENDER_DRAGON:
						exp = 5000;
						break;
					case GHAST:
						exp = 6;
						break;
					case GIANT:
						exp = 100;
						money = random.nextInt(151) + 50; //Between 50 and 200
						break;
					case MAGMA_CUBE:
						exp = 2;
						break;
					case OCELOT:
						exp = 2;
						break;
					case PIG_ZOMBIE:
						exp = 4;
						money = random.nextInt(3) + 2; //Between 2 and 4
						break;
					case SILVERFISH:
						exp = 1;
						break;
					case SKELETON:
						exp = 3;
						money = random.nextInt(3) + 1; //Between 1 and 3
						break;
					case SLIME:
						exp = 1;
						money = random.nextInt(4);
						break;
					case SPIDER:
						exp = 3;
						break;
					case SQUID:
						exp = 1;
						break;
					case WITCH:
						exp = 5;
						money = random.nextInt(3) + 3; //Between 3 and 5
						break;
					case WITHER:
						exp = 5000;
						break;
					case WOLF:
						exp = 2;
						break;
					case ZOMBIE:
						exp = 3;
						money = random.nextInt(4); //Between 0 and 3
						break;
					default:
						break;
				}
				if (exp > 0) {
					plugin.giveExperience(player, exp);
				}
				if (money > 0) {
					Gildorym.getEconomyPlugin().addMoney(player, money);
				}
				if (money > 1) {
					player.sendMessage(ChatColor.YELLOW + "+" + money + " Gold Coins");
				} else if (money == 1) {
					player.sendMessage(ChatColor.YELLOW + "+" + money + " Gold Coin");
				}
			}
		}
	}

}
