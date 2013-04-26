package com.gildorymrp.basicchar;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class BasicChar extends JavaPlugin {
	
	public Map<String, CharacterClass> classes = new HashMap<String, CharacterClass>();
	public Map<String, CharacterProfession> professions = new HashMap<String, CharacterProfession>();
	public Map<String, Integer> levels = new HashMap<String, Integer>();
	public Map<String, Integer> experience = new HashMap<String, Integer>();
	
	public void onEnable() {
		SaveDataManager.loadClassData(this);
		SaveDataManager.loadLevelData(this);
		SaveDataManager.loadExperienceData(this);
		SaveDataManager.loadProfessionData(this);
		this.getCommand("addexp").setExecutor(new AddExpCommand(this));
		this.getCommand("setclass").setExecutor(new SetClassCommand(this));
		this.getCommand("setprofession").setExecutor(new SetProfessionCommand(this));
		this.getCommand("setlevel").setExecutor(new SetLevelCommand(this));
		this.getCommand("getclass").setExecutor(new GetClassCommand(this));
		this.getCommand("getprofession").setExecutor(new GetProfessionCommand(this));
		this.getCommand("getlevel").setExecutor(new GetLevelCommand(this));
		this.getCommand("listclasses").setExecutor(new ListClassesCommand());
		this.getCommand("listprofessions").setExecutor(new ListProfessionsCommand());
		this.registerListeners(new PlayerJoinListener(this), new PlayerExpChangeListener(this), new PlayerRespawnListener(this), new EntityDeathListener(this), new EntityDamageListener());
	}
	
	public void onDisable() {
		SaveDataManager.saveClassData(this);
		SaveDataManager.saveLevelData(this);
		SaveDataManager.saveExperienceData(this);
		SaveDataManager.saveProfessionData(this);
	}
	
	private void registerListeners(Listener... listeners) {
		for (Listener listener : listeners) {
			this.getServer().getPluginManager().registerEvents(listener, this);
		}
	}

}
