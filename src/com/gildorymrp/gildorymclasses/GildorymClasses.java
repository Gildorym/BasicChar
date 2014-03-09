package com.gildorymrp.gildorymclasses;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class GildorymClasses extends JavaPlugin {

	public void onEnable() {
		getCommand("addexp").setExecutor(new AddExpCommand(this));
		getCommand("setclass").setExecutor(new SetClassCommand());
		getCommand("setprofession").setExecutor(new SetProfessionCommand());
		getCommand("setlevel").setExecutor(new SetLevelCommand());
		getCommand("getclass").setExecutor(new GetClassCommand());
		getCommand("getprofession").setExecutor(new GetProfessionCommand());
		getCommand("getlevel").setExecutor(new GetLevelCommand());
		getCommand("listclasses").setExecutor(new ListClassesCommand());
		getCommand("listprofessions").setExecutor(new ListProfessionsCommand());
		getCommand("checkexp").setExecutor(new CheckXPCommand(this));
		registerListeners(new Listener[] { new PlayerJoinListener(),
				new PlayerExpChangeListener(),
				new PlayerRespawnListener(this), new EntityDeathListener(this),
				new EntityDamageListener() });
	}

	private void registerListeners(Listener[] listeners) {
		for (Listener listener : listeners)
			getServer().getPluginManager().registerEvents(listener, this);
	}
}
