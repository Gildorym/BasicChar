/*    */ package com.gildorymrp.gildorymclasses;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.command.PluginCommand;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.plugin.PluginManager;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ public class GildorymClasses extends JavaPlugin
/*    */ {
/* 11 */   public Map<String, CharacterClass> classes = new HashMap();
/* 12 */   public Map<String, CharacterProfession> professions = new HashMap();
/* 13 */   public Map<String, Integer> levels = new HashMap();
/* 14 */   public Map<String, Integer> experience = new HashMap();
/*    */ 
/*    */   public void onEnable() {
/* 17 */     SaveDataManager.loadClassData(this);
/* 18 */     SaveDataManager.loadLevelData(this);
/* 19 */     SaveDataManager.loadExperienceData(this);
/* 20 */     SaveDataManager.loadProfessionData(this);
/* 21 */     getCommand("addexp").setExecutor(new AddExpCommand(this));
/* 22 */     getCommand("setclass").setExecutor(new SetClassCommand(this));
/* 23 */     getCommand("setprofession").setExecutor(new SetProfessionCommand(this));
/* 24 */     getCommand("setlevel").setExecutor(new SetLevelCommand(this));
/* 25 */     getCommand("getclass").setExecutor(new GetClassCommand(this));
/* 26 */     getCommand("getprofession").setExecutor(new GetProfessionCommand(this));
/* 27 */     getCommand("getlevel").setExecutor(new GetLevelCommand(this));
/* 28 */     getCommand("listclasses").setExecutor(new ListClassesCommand());
/* 29 */     getCommand("listprofessions").setExecutor(new ListProfessionsCommand());
/* 30 */     registerListeners(new Listener[] { new PlayerJoinListener(this), new PlayerExpChangeListener(this), new PlayerRespawnListener(this), new EntityDeathListener(this), new EntityDamageListener() });
/*    */   }
/*    */ 
/*    */   public void onDisable() {
/* 34 */     SaveDataManager.saveClassData(this);
/* 35 */     SaveDataManager.saveLevelData(this);
/* 36 */     SaveDataManager.saveExperienceData(this);
/* 37 */     SaveDataManager.saveProfessionData(this);
/*    */   }
/*    */ 
/*    */   private void registerListeners(Listener[] listeners) {
/* 41 */     for (Listener listener : listeners)
/* 42 */       getServer().getPluginManager().registerEvents(listener, this);
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator.Banditt-PC\Desktop\Coding\Server\plugins\GildorymClasses.jar
 * Qualified Name:     com.gildorymrp.gildorymclasses.GildorymClasses
 * JD-Core Version:    0.6.2
 */