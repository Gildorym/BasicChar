package com.gildorymrp.gildorymclasses;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class GildorymClasses extends JavaPlugin {
	public Map<String, CharacterClass> classes = new HashMap<String, CharacterClass>();
	public Map<String, CharacterProfession> professions = new HashMap<String, CharacterProfession>();
	public Map<String, Integer> levels = new HashMap<String, Integer>();
	public Map<String, Integer> experience = new HashMap<String, Integer>();

	public void onEnable() {
		SaveDataManager.loadClassData(this);
		SaveDataManager.loadLevelData(this);
		SaveDataManager.loadExperienceData(this);
		SaveDataManager.loadProfessionData(this);
		getCommand("addexp").setExecutor(new AddExpCommand(this));
		getCommand("setclass").setExecutor(new SetClassCommand(this));
		getCommand("setprofession").setExecutor(new SetProfessionCommand(this));
		getCommand("setlevel").setExecutor(new SetLevelCommand(this));
		getCommand("getclass").setExecutor(new GetClassCommand(this));
		getCommand("getprofession").setExecutor(new GetProfessionCommand(this));
		getCommand("getlevel").setExecutor(new GetLevelCommand(this));
		getCommand("listclasses").setExecutor(new ListClassesCommand());
		getCommand("listprofessions").setExecutor(new ListProfessionsCommand());
		getCommand("checkexp").setExecutor(new CheckXPCommand(this));
		registerListeners(new Listener[] { new PlayerJoinListener(this),
				new PlayerExpChangeListener(this),
				new PlayerRespawnListener(this), new EntityDeathListener(this),
				new EntityDamageListener() });
	}

	public void onDisable() {
		SaveDataManager.saveClassData(this);
		SaveDataManager.saveLevelData(this);
		SaveDataManager.saveExperienceData(this);
		SaveDataManager.saveProfessionData(this);
	}

	private void registerListeners(Listener[] listeners) {
		for (Listener listener : listeners)
			getServer().getPluginManager().registerEvents(listener, this);
	}
}
