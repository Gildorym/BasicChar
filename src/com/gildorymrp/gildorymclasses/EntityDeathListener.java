/*    */ package com.gildorymrp.gildorymclasses;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Random;
/*    */ import net.milkbowl.vault.economy.Economy;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.entity.EntityType;
/*    */ import org.bukkit.entity.LivingEntity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.entity.Projectile;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.event.entity.EntityDeathEvent;
/*    */ import org.bukkit.plugin.RegisteredServiceProvider;
/*    */ import org.bukkit.plugin.ServicesManager;
/*    */ 
/*    */ public class EntityDeathListener
/*    */   implements Listener
/*    */ {
/*    */   private GildorymClasses plugin;
/*    */ 
/*    */   public EntityDeathListener(GildorymClasses plugin)
/*    */   {
/* 22 */     this.plugin = plugin;
/*    */   }
/*    */ 
/*    */   @EventHandler
/*    */   public void onEntityDeath(EntityDeathEvent event) {
/* 27 */     if ((event.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent)) {
/* 28 */       Player player = null;
/* 29 */       if ((((EntityDamageByEntityEvent)event.getEntity().getLastDamageCause()).getDamager() instanceof Player)) {
/* 30 */         player = (Player)((EntityDamageByEntityEvent)event.getEntity().getLastDamageCause()).getDamager();
/*    */       }
/* 32 */       if ((((EntityDamageByEntityEvent)event.getEntity().getLastDamageCause()).getDamager() instanceof Projectile)) {
/* 33 */         LivingEntity shooter = ((Projectile)((EntityDamageByEntityEvent)event.getEntity().getLastDamageCause()).getDamager()).getShooter();
/* 34 */         if ((shooter != null) && 
/* 35 */           ((shooter instanceof Player))) {
/* 36 */           player = (Player)shooter;
/*    */         }
/*    */       }
/*    */ 
/* 40 */       Random random = new Random();
/* 41 */       Integer money = Integer.valueOf(0);
/* 42 */       if (player != null) {
/* 43 */         int expToNextLevel = Math.round(1000 * ((Integer)this.plugin.levels.get(player.getName())).intValue());
/*    */ 
/* 49 */         if (event.getEntityType() == EntityType.BLAZE) {
/* 50 */           this.plugin.experience.put(player.getName(), Integer.valueOf(((Integer)this.plugin.experience.get(player.getName())).intValue() + 6));
/* 51 */           player.sendMessage(ChatColor.YELLOW + "+6 exp");
/* 52 */           player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + this.plugin.experience.get(player.getName()) + "/" + expToNextLevel);
/*    */         }
/* 54 */         if (event.getEntityType() == EntityType.CAVE_SPIDER) {
/* 55 */           this.plugin.experience.put(player.getName(), Integer.valueOf(((Integer)this.plugin.experience.get(player.getName())).intValue() + 5));
/* 56 */           player.sendMessage(ChatColor.YELLOW + "+5 exp");
/* 57 */           player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + this.plugin.experience.get(player.getName()) + "/" + expToNextLevel);
/*    */         }
/*    */ 
/* 69 */         if (event.getEntityType() == EntityType.ENDER_DRAGON) {
/* 70 */           this.plugin.experience.put(player.getName(), Integer.valueOf(((Integer)this.plugin.experience.get(player.getName())).intValue() + 5000));
/* 71 */           player.sendMessage(ChatColor.YELLOW + "+5000 exp");
/* 72 */           player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + this.plugin.experience.get(player.getName()) + "/" + expToNextLevel);
/*    */         }
/* 74 */         if (event.getEntityType() == EntityType.ENDERMAN) {
/* 75 */           this.plugin.experience.put(player.getName(), Integer.valueOf(((Integer)this.plugin.experience.get(player.getName())).intValue() + 6));
/* 76 */           player.sendMessage(ChatColor.YELLOW + "+6 exp");
/* 77 */           player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + this.plugin.experience.get(player.getName()) + "/" + expToNextLevel);
/* 78 */           money = Integer.valueOf(money.intValue() + (random.nextInt(7) + 6));
/*    */         }
/* 80 */         if (event.getEntityType() == EntityType.GHAST) {
/* 81 */           this.plugin.experience.put(player.getName(), Integer.valueOf(((Integer)this.plugin.experience.get(player.getName())).intValue() + 6));
/* 82 */           player.sendMessage(ChatColor.YELLOW + "+6 exp");
/* 83 */           player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + this.plugin.experience.get(player.getName()) + "/" + expToNextLevel);
/*    */         }
/* 85 */         if (event.getEntityType() == EntityType.GIANT) {
/* 86 */           this.plugin.experience.put(player.getName(), Integer.valueOf(((Integer)this.plugin.experience.get(player.getName())).intValue() + 100));
/* 87 */           player.sendMessage(ChatColor.YELLOW + "+100 exp");
/* 88 */           player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + this.plugin.experience.get(player.getName()) + "/" + expToNextLevel);
/* 89 */           money = Integer.valueOf(money.intValue() + (random.nextInt(151) + 50));
/*    */         }
/*    */ 
/* 96 */         if (event.getEntityType() == EntityType.MAGMA_CUBE) {
/* 97 */           this.plugin.experience.put(player.getName(), Integer.valueOf(((Integer)this.plugin.experience.get(player.getName())).intValue() + 2));
/* 98 */           player.sendMessage(ChatColor.YELLOW + "+2 exp");
/* 99 */           player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + this.plugin.experience.get(player.getName()) + "/" + expToNextLevel);
/*    */         }
/*    */ 
/* 106 */         if (event.getEntityType() == EntityType.OCELOT) {
/* 107 */           this.plugin.experience.put(player.getName(), Integer.valueOf(((Integer)this.plugin.experience.get(player.getName())).intValue() + 2));
/* 108 */           player.sendMessage(ChatColor.YELLOW + "+2 exp");
/* 109 */           player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + this.plugin.experience.get(player.getName()) + "/" + expToNextLevel);
/*    */         }
/*    */ 
/* 116 */         if (event.getEntityType() == EntityType.PIG_ZOMBIE) {
/* 117 */           this.plugin.experience.put(player.getName(), Integer.valueOf(((Integer)this.plugin.experience.get(player.getName())).intValue() + 4));
/* 118 */           player.sendMessage(ChatColor.YELLOW + "+4 exp");
/* 119 */           player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + this.plugin.experience.get(player.getName()) + "/" + expToNextLevel);
/* 120 */           money = Integer.valueOf(money.intValue() + (random.nextInt(3) + 2));
/*    */         }
/*    */ 
/* 127 */         if (event.getEntityType() == EntityType.SILVERFISH) {
/* 128 */           this.plugin.experience.put(player.getName(), Integer.valueOf(((Integer)this.plugin.experience.get(player.getName())).intValue() + 1));
/* 129 */           player.sendMessage(ChatColor.YELLOW + "+1 exp");
/* 130 */           player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + this.plugin.experience.get(player.getName()) + "/" + expToNextLevel);
/*    */         }
/* 132 */         if (event.getEntityType() == EntityType.SKELETON) {
/* 133 */           this.plugin.experience.put(player.getName(), Integer.valueOf(((Integer)this.plugin.experience.get(player.getName())).intValue() + 3));
/* 134 */           player.sendMessage(ChatColor.YELLOW + "+3 exp");
/* 135 */           player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + this.plugin.experience.get(player.getName()) + "/" + expToNextLevel);
/* 136 */           money = Integer.valueOf(money.intValue() + (random.nextInt(3) + 1));
/*    */         }
/* 138 */         if (event.getEntityType() == EntityType.SLIME) {
/* 139 */           this.plugin.experience.put(player.getName(), Integer.valueOf(((Integer)this.plugin.experience.get(player.getName())).intValue() + 1));
/* 140 */           player.sendMessage(ChatColor.YELLOW + "+1 exp");
/* 141 */           player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + this.plugin.experience.get(player.getName()) + "/" + expToNextLevel);
/* 142 */           money = Integer.valueOf(money.intValue() + random.nextInt(4));
/*    */         }
/*    */ 
/* 149 */         if (event.getEntityType() == EntityType.SPIDER) {
/* 150 */           this.plugin.experience.put(player.getName(), Integer.valueOf(((Integer)this.plugin.experience.get(player.getName())).intValue() + 3));
/* 151 */           player.sendMessage(ChatColor.YELLOW + "+3 exp");
/* 152 */           player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + this.plugin.experience.get(player.getName()) + "/" + expToNextLevel);
/*    */         }
/* 154 */         if (event.getEntityType() == EntityType.SQUID) {
/* 155 */           this.plugin.experience.put(player.getName(), Integer.valueOf(((Integer)this.plugin.experience.get(player.getName())).intValue() + 1));
/* 156 */           player.sendMessage(ChatColor.YELLOW + "+1 exp");
/* 157 */           player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + this.plugin.experience.get(player.getName()) + "/" + expToNextLevel);
/*    */         }
/*    */ 
/* 164 */         if (event.getEntityType() == EntityType.WITCH) {
/* 165 */           this.plugin.experience.put(player.getName(), Integer.valueOf(((Integer)this.plugin.experience.get(player.getName())).intValue() + 5));
/* 166 */           player.sendMessage(ChatColor.YELLOW + "+5 exp");
/* 167 */           player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + this.plugin.experience.get(player.getName()) + "/" + expToNextLevel);
/* 168 */           money = Integer.valueOf(money.intValue() + (random.nextInt(3) + 3));
/*    */         }
/* 170 */         if (event.getEntityType() == EntityType.WITHER) {
/* 171 */           this.plugin.experience.put(player.getName(), Integer.valueOf(((Integer)this.plugin.experience.get(player.getName())).intValue() + 5000));
/* 172 */           player.sendMessage(ChatColor.YELLOW + "+5000 exp");
/* 173 */           player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + this.plugin.experience.get(player.getName()) + "/" + expToNextLevel);
/*    */         }
/* 175 */         if (event.getEntityType() == EntityType.WOLF) {
/* 176 */           this.plugin.experience.put(player.getName(), Integer.valueOf(((Integer)this.plugin.experience.get(player.getName())).intValue() + 2));
/* 177 */           player.sendMessage(ChatColor.YELLOW + "+2 exp");
/* 178 */           player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + this.plugin.experience.get(player.getName()) + "/" + expToNextLevel);
/*    */         }
/* 180 */         if (event.getEntityType() == EntityType.ZOMBIE) {
/* 181 */           this.plugin.experience.put(player.getName(), Integer.valueOf(((Integer)this.plugin.experience.get(player.getName())).intValue() + 3));
/* 182 */           player.sendMessage(ChatColor.YELLOW + "+3 exp");
/* 183 */           player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + this.plugin.experience.get(player.getName()) + "/" + expToNextLevel);
/* 184 */           money = Integer.valueOf(money.intValue() + random.nextInt(4));
/*    */         }
/* 186 */         while (((Integer)this.plugin.experience.get(player.getName())).intValue() >= expToNextLevel) {
/* 187 */           this.plugin.experience.put(player.getName(), Integer.valueOf(((Integer)this.plugin.experience.get(player.getName())).intValue() - expToNextLevel));
/* 188 */           this.plugin.levels.put(player.getName(), Integer.valueOf(((Integer)this.plugin.levels.get(player.getName())).intValue() + 1));
/* 189 */           expToNextLevel = 1000 * ((Integer)this.plugin.levels.get(player.getName())).intValue();
/*    */         }
/* 191 */         player.setExp(((Integer)this.plugin.experience.get(player.getName())).intValue() / expToNextLevel);
/* 192 */         player.setLevel(((Integer)this.plugin.levels.get(player.getName())).intValue());
/* 193 */         player.setMaxHealth(((Integer)this.plugin.levels.get(player.getName())).intValue() * 10);
/* 194 */         Economy economy = (Economy)this.plugin.getServer().getServicesManager().getRegistration(Economy.class).getProvider();
/* 195 */         economy.depositPlayer(player.getName(), money.intValue());
/* 196 */         if (money.intValue() > 1)
/* 197 */           player.sendMessage(ChatColor.YELLOW + "+" + money + " " + economy.currencyNamePlural());
/* 198 */         else if (money.intValue() == 1)
/* 199 */           player.sendMessage(ChatColor.YELLOW + "+" + money + " " + economy.currencyNameSingular());
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator.Banditt-PC\Desktop\Coding\Server\plugins\GildorymClasses.jar
 * Qualified Name:     com.gildorymrp.gildorymclasses.EntityDeathListener
 * JD-Core Version:    0.6.2
 */