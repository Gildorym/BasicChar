package com.gildorymrp.gildorymclasses;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.gildorymrp.gildorym.Gildorym;

public class GildorymClasses extends JavaPlugin {

	public void onEnable() {
		final Gildorym gildorym = (Gildorym) Bukkit.getServer().getPluginManager().getPlugin("Gildorym");
		getCommand("addexp").setExecutor(new AddExpCommand(gildorym, this));
		getCommand("setclass").setExecutor(new SetClassCommand(gildorym));
		getCommand("setprofession").setExecutor(new SetProfessionCommand(gildorym));
		getCommand("setlevel").setExecutor(new SetLevelCommand(gildorym));
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
