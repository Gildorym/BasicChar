package com.gildorymrp.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.gildorymrp.api.plugin.classes.Class;
import com.gildorymrp.api.plugin.core.Character;

public class SaveDataManager {

	@SuppressWarnings("unchecked")
	public static void loadData(GildorymClasses plugin) {
		try {
			File file = new File(plugin.getDataFolder().getAbsolutePath() + File.separator + "classes.dat");
			if (file.exists()) {
				FileInputStream fis = new FileInputStream(plugin.getDataFolder().getAbsolutePath() + File.separator + "classes.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);
				plugin.getClasses().putAll((Map<? extends Character, ? extends Class>) ois.readObject());
				plugin.getExperience().putAll((Map<? extends Character, ? extends Map<Class, Integer>>) ois.readObject());
				ois.close();
			}
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		}
	}
	
	public static void saveData(GildorymClasses plugin) {
		try {
			if (!plugin.getDataFolder().exists()) {
				plugin.getDataFolder().mkdir();
			}
			File file = new File(plugin.getDataFolder().getAbsolutePath() + File.separator + "classes.dat");
			file.delete();
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(plugin.getClasses());
			oos.writeObject(plugin.getExperience());
			oos.close();
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

}
