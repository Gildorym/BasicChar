package com.gildorymrp.gildorymclasses;

import java.util.Random;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import com.gildorymrp.charactercards.CharacterCard;
import com.gildorymrp.gildorym.Gildorym;
import com.gildorymrp.gildorym.GildorymCharacter;

public class EntityDeathListener
implements Listener
{
	private GildorymClasses plugin;

	public EntityDeathListener(GildorymClasses plugin)
	{
		this.plugin = plugin;
	}

	@EventHandler
	public void onEntityDeath(EntityDeathEvent event) {
		if ((event.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent)) {
			Player player = null;
			if ((((EntityDamageByEntityEvent)event.getEntity().getLastDamageCause()).getDamager() instanceof Player)) {
				player = (Player)((EntityDamageByEntityEvent)event.getEntity().getLastDamageCause()).getDamager();
			}
			if ((((EntityDamageByEntityEvent)event.getEntity().getLastDamageCause()).getDamager() instanceof Projectile)) {
				LivingEntity shooter = (LivingEntity) ((Projectile)((EntityDamageByEntityEvent)event.getEntity().getLastDamageCause()).getDamager()).getShooter();
				if ((shooter != null) && 
						(shooter instanceof Player)) {
					player = (Player) shooter;
				}
			}

			Random random = new Random();
			Integer money = Integer.valueOf(0);
			if (player != null) {
				Gildorym gildorym = (Gildorym) Bukkit.getServer().getPluginManager().getPlugin("Gildorym");
				GildorymCharacter gChar = gildorym.getActiveCharacters().get(player.getName());	
				
				int expToNextLevel = Math.round(1000 * gChar.getLevel());

				if (event.getEntityType() == EntityType.BLAZE) {
					//experienceMap.put(player.getName(), Integer.valueOf(((Integer)experienceMap.get(player.getName())).intValue() + 6));
					//player.sendMessage(ChatColor.YELLOW + "+6 exp");
					//player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + experienceMap.get(player.getName()) + "/" + expToNextLevel);
				} else if (event.getEntityType() == EntityType.CAVE_SPIDER) {
					//experienceMap.put(player.getName(), Integer.valueOf(((Integer)experienceMap.get(player.getName())).intValue() + 5));
					//player.sendMessage(ChatColor.YELLOW + "+5 exp");
					//player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + experienceMap.get(player.getName()) + "/" + expToNextLevel);
				} else if (event.getEntityType() == EntityType.ENDER_DRAGON) {
					//experienceMap.put(player.getName(), Integer.valueOf(((Integer)experienceMap.get(player.getName())).intValue() + 5000));
					//player.sendMessage(ChatColor.YELLOW + "+5000 exp");
					//player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + experienceMap.get(player.getName()) + "/" + expToNextLevel);
				} else if (event.getEntityType() == EntityType.ENDERMAN) {
					//experienceMap.put(player.getName(), Integer.valueOf(((Integer)experienceMap.get(player.getName())).intValue() + 6));
					//player.sendMessage(ChatColor.YELLOW + "+6 exp");
					//player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + experienceMap.get(player.getName()) + "/" + expToNextLevel);
					money = Integer.valueOf(money.intValue() + (random.nextInt(7) + 6));
				} else if (event.getEntityType() == EntityType.GHAST) {
					//experienceMap.put(player.getName(), Integer.valueOf(((Integer)experienceMap.get(player.getName())).intValue() + 6));
					//player.sendMessage(ChatColor.YELLOW + "+6 exp");
					//player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + experienceMap.get(player.getName()) + "/" + expToNextLevel);
				} else if (event.getEntityType() == EntityType.GIANT) {
					//experienceMap.put(player.getName(), Integer.valueOf(((Integer)experienceMap.get(player.getName())).intValue() + 100));
					//player.sendMessage(ChatColor.YELLOW + "+100 exp");
					//player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + experienceMap.get(player.getName()) + "/" + expToNextLevel);
					money = Integer.valueOf(money.intValue() + (random.nextInt(151) + 50));
				} else if (event.getEntityType() == EntityType.MAGMA_CUBE) {
					//experienceMap.put(player.getName(), Integer.valueOf(((Integer)experienceMap.get(player.getName())).intValue() + 2));
					//player.sendMessage(ChatColor.YELLOW + "+2 exp");
					//player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + experienceMap.get(player.getName()) + "/" + expToNextLevel);
				} else if (event.getEntityType() == EntityType.OCELOT) {
					//experienceMap.put(player.getName(), Integer.valueOf(((Integer)experienceMap.get(player.getName())).intValue() + 2));
					//player.sendMessage(ChatColor.YELLOW + "+2 exp");
					//player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + experienceMap.get(player.getName()) + "/" + expToNextLevel);
				} else if (event.getEntityType() == EntityType.PIG_ZOMBIE) {
					//experienceMap.put(player.getName(), Integer.valueOf(((Integer)experienceMap.get(player.getName())).intValue() + 4));
					//player.sendMessage(ChatColor.YELLOW + "+4 exp");
					//player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + experienceMap.get(player.getName()) + "/" + expToNextLevel);
					money = Integer.valueOf(money.intValue() + (random.nextInt(3) + 2));
				} else if (event.getEntityType() == EntityType.SILVERFISH) {
					//experienceMap.put(player.getName(), Integer.valueOf(((Integer)experienceMap.get(player.getName())).intValue() + 1));
					//player.sendMessage(ChatColor.YELLOW + "+1 exp");
					//player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + experienceMap.get(player.getName()) + "/" + expToNextLevel);
				} else if (event.getEntityType() == EntityType.SKELETON) {
					//experienceMap.put(player.getName(), Integer.valueOf(((Integer)experienceMap.get(player.getName())).intValue() + 3));
					//player.sendMessage(ChatColor.YELLOW + "+3 exp");
					//player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + experienceMap.get(player.getName()) + "/" + expToNextLevel);
					money = Integer.valueOf(money.intValue() + (random.nextInt(3) + 1));
				} else if (event.getEntityType() == EntityType.SLIME) {
					//experienceMap.put(player.getName(), Integer.valueOf(((Integer)experienceMap.get(player.getName())).intValue() + 1));
					//player.sendMessage(ChatColor.YELLOW + "+1 exp");
					//player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + experienceMap.get(player.getName()) + "/" + expToNextLevel);
					money = Integer.valueOf(money.intValue() + random.nextInt(4));
				} else if (event.getEntityType() == EntityType.SPIDER) {
					//experienceMap.put(player.getName(), Integer.valueOf(((Integer)experienceMap.get(player.getName())).intValue() + 3));
					//player.sendMessage(ChatColor.YELLOW + "+3 exp");
					//player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + experienceMap.get(player.getName()) + "/" + expToNextLevel);
				} else if (event.getEntityType() == EntityType.SQUID) {
					//experienceMap.put(player.getName(), Integer.valueOf(((Integer)experienceMap.get(player.getName())).intValue() + 1));
					//player.sendMessage(ChatColor.YELLOW + "+1 exp");
					//player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + experienceMap.get(player.getName()) + "/" + expToNextLevel);
				} else if (event.getEntityType() == EntityType.WITCH) {
					//experienceMap.put(player.getName(), Integer.valueOf(((Integer)experienceMap.get(player.getName())).intValue() + 5));
					//player.sendMessage(ChatColor.YELLOW + "+5 exp");
					//player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + experienceMap.get(player.getName()) + "/" + expToNextLevel);
					money = Integer.valueOf(money.intValue() + (random.nextInt(3) + 3));
				} else if (event.getEntityType() == EntityType.WITHER) {
					//experienceMap.put(player.getName(), Integer.valueOf(((Integer)experienceMap.get(player.getName())).intValue() + 5000));
					//player.sendMessage(ChatColor.YELLOW + "+5000 exp");
					//player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + experienceMap.get(player.getName()) + "/" + expToNextLevel);
				} else if (event.getEntityType() == EntityType.WOLF) {
					//experienceMap.put(player.getName(), Integer.valueOf(((Integer)experienceMap.get(player.getName())).intValue() + 2));
					//player.sendMessage(ChatColor.YELLOW + "+2 exp");
					//player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + experienceMap.get(player.getName()) + "/" + expToNextLevel);
				} else if (event.getEntityType() == EntityType.ZOMBIE) {
					//experienceMap.put(player.getName(), Integer.valueOf(((Integer)experienceMap.get(player.getName())).intValue() + 3));
					//player.sendMessage(ChatColor.YELLOW + "+3 exp");
					//player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + experienceMap.get(player.getName()) + "/" + expToNextLevel);
					money = Integer.valueOf(money.intValue() + random.nextInt(4));
				}
				while (gChar.getExperience() >= expToNextLevel) {
					gChar.setExperience(gChar.getExperience() - expToNextLevel);
					gChar.setLevel(gChar.getLevel() + 1);
					expToNextLevel = 1000 * gChar.getLevel();
				}
				
				Integer pvpHealth = CharacterCard.calculateHealth(gChar);
				
				player.setExp((float) (gChar.getExperience() / (double) expToNextLevel));
				player.setLevel(gChar.getLevel());
				player.setMaxHealth(pvpHealth * 5);
				Economy economy = (Economy)this.plugin.getServer().getServicesManager().getRegistration(Economy.class).getProvider();
				economy.depositPlayer(player.getName(), money.intValue());
				if (money.intValue() > 1)
					player.sendMessage(ChatColor.YELLOW + "+" + money + " " + economy.currencyNamePlural());
				else if (money.intValue() == 1)
					player.sendMessage(ChatColor.YELLOW + "+" + money + " " + economy.currencyNameSingular());
			}
		}
	}
}