package com.gildorymrp.gildorymclasses;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.gildorymrp.api.Gildorym;
import com.gildorymrp.api.event.classes.GildorymClassChangeEvent;
import com.gildorymrp.api.event.classes.GildorymClassLevelChangeEvent;
import com.gildorymrp.api.plugin.classes.Class;
import com.gildorymrp.api.plugin.classes.GildorymClassesPlugin;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Race;
import com.gildorymrp.api.plugin.core.Skill;

public class GildorymClasses extends JavaPlugin implements GildorymClassesPlugin {
	
	public static final String PREFIX = "" + ChatColor.DARK_GREEN + ChatColor.MAGIC + "|" + ChatColor.RESET + ChatColor.GOLD + "GildorymClasses" + ChatColor.DARK_GREEN + ChatColor.MAGIC + "| " + ChatColor.RESET;
	
	private Map<Character, Class> classes = new HashMap<Character, Class>();
	private Map<Character, Map<Class, Integer>> experience = new HashMap<Character, Map<Class, Integer>>();
	
	public void onEnable() {
		Gildorym.registerClassesPlugin(this);
		SaveDataManager.loadData(this);
		this.getCommand("addexp").setExecutor(new AddExpCommand(this));
		this.getCommand("setclass").setExecutor(new SetClassCommand(this));
		this.getCommand("setlevel").setExecutor(new SetLevelCommand(this));
		this.getCommand("getclass").setExecutor(new GetClassCommand(this));
		this.getCommand("getlevel").setExecutor(new GetLevelCommand(this));
		this.getCommand("listclasses").setExecutor(new ListClassesCommand());
		this.registerListeners(new EntityDamageListener(), new EntityDeathListener(this), new PlayerDeathListener(), new PlayerExpChangeListener(), new PlayerJoinListener(this));
	}
	
	public void onDisable() {
		SaveDataManager.saveData(this);
	}
	
	private void registerListeners(Listener... listeners) {
		for (Listener listener : listeners) {
			this.getServer().getPluginManager().registerEvents(listener, this);
		}
	}

	@Override
	public int getAttackBonus(Class clazz, int level) {
		switch (clazz) {
			case BARBARIAN:
				return this.getBaseAttackBonusGood(level);
			case BARD:
				return this.getBaseAttackBonusAverage(level);
			case CLERIC:
				return this.getBaseAttackBonusAverage(level);
			case DRUID:
				return this.getBaseAttackBonusAverage(level);
			case FIGHTER:
				return this.getBaseAttackBonusGood(level);
			case MONK:
				return this.getBaseAttackBonusAverage(level);
			case PALADIN:
				return this.getBaseAttackBonusGood(level);
			case RANGER:
				return this.getBaseAttackBonusGood(level);
			case ROGUE:
				return this.getBaseAttackBonusAverage(level);
			case SORCERER:
				return this.getBaseAttackBonusPoor(level);
			case WIZARD:
				return this.getBaseAttackBonusPoor(level);
			default:
				return this.getBaseAttackBonusPoor(level);
		}
	}

	@Override
	public int getBaseAttackBonusAverage(int level) {
		return (int) Math.floor(level * 0.75);
	}

	@Override
	public int getBaseAttackBonusGood(int level) {
		return level;
	}

	@Override
	public int getBaseAttackBonusPoor(int level) {
		return (int) Math.floor(level * 0.5);
	}

	@Override
	public int getBaseSaveBonusGood(int level) {
		return 2 + (int) Math.floor(level / 2);
	}

	@Override
	public int getBaseSaveBonusPoor(int level) {
		return (int) Math.floor(level / 3);
	}

	@Override
	public Class getClass(Player player) {
		return this.getClass(Gildorym.getCorePlugin().getActiveCharacter(player));
	}

	@Override
	public Class getClass(Character character) {
		return this.classes.get(character);
	}

	@Override
	public int getClassSkillModifier(Class clazz) {
		switch (clazz) {
			case BARBARIAN:
				return 4;
			case BARD:
				return 6;
			case CLERIC:
				return 2;
			case DRUID:
				return 4;
			case FIGHTER:
				return 2;
			case MONK:
				return 4;
			case PALADIN:
				return 2;
			case RANGER:
				return 6;
			case ROGUE:
				return 8;
			case SORCERER:
				return 2;
			case WIZARD:
				return 2;
			default:
				return 2;
		}
	}

	@Override
	public int getExperienceTowardsNextLevel(Player player) {
		return this.getExperienceTowardsNextLevel(player, this.getClass(player));
	}

	@Override
	public int getExperienceTowardsNextLevel(Player player, Class clazz) {
		return this.getExperienceTowardsNextLevel(Gildorym.getCorePlugin().getActiveCharacter(player), clazz);
	}

	@Override
	public int getExperienceTowardsNextLevel(Character character) {
		return this.getExperienceTowardsNextLevel(character, this.getClass(character));
	}

	@Override
	public int getExperienceTowardsNextLevel(Character character, Class clazz) {
		return this.getTotalExperienceForLevel(this.getLevel(character) + 1) - this.getTotalExperience(character, clazz);
	}

	@Override
	public int getFortitudeSave(Class clazz, int level) {
		switch (clazz) {
			case BARBARIAN:
				return this.getBaseSaveBonusGood(level);
			case BARD:
				return this.getBaseSaveBonusPoor(level);
			case CLERIC:
				return this.getBaseSaveBonusGood(level);
			case DRUID:
				return this.getBaseSaveBonusGood(level);
			case FIGHTER:
				return this.getBaseSaveBonusGood(level);
			case MONK:
				return this.getBaseSaveBonusGood(level);
			case PALADIN:
				return this.getBaseSaveBonusGood(level);
			case RANGER:
				return this.getBaseSaveBonusGood(level);
			case ROGUE:
				return this.getBaseSaveBonusPoor(level);
			case SORCERER:
				return this.getBaseSaveBonusPoor(level);
			case WIZARD:
				return this.getBaseSaveBonusPoor(level);
			default:
				return this.getBaseSaveBonusPoor(level);
		}
	}

	@Override
	public Map<Integer, Collection<Skill>> getGrantedSkills(Class clazz) {
		return new HashMap<Integer, Collection<Skill>>();
	}

	@Override
	public int getHpBonus(Class clazz) {
		switch(clazz) {
			case BARBARIAN:
				return 12;
			case BARD:
				return 6;
			case CLERIC:
				return 8;
			case DRUID:
				return 8;
			case FIGHTER:
				return 10;
			case MONK:
				return 8;
			case PALADIN:
				return 10;
			case RANGER:
				return 8;
			case ROGUE:
				return 6;
			case SORCERER:
				return 4;
			case WIZARD:
				return 4;
			default:
				return 4;
		}
	}

	@Override
	public int getLevel(Player player) {
		return this.getLevel(player, this.getClass(player));
	}

	@Override
	public int getLevel(Character character) {
		return this.getLevel(character, this.getClass(character));
	}

	@Override
	public int getLevel(Player player, Class clazz) {
		return this.getLevel(Gildorym.getCorePlugin().getActiveCharacter(player), clazz);
	}

	@Override
	public int getLevel(Character character, Class clazz) {
		int level = 1;
		while (this.getTotalExperienceForLevel(level) < this.getTotalExperience(character, clazz)) {
			level += 1;
		}
		return level;
	}

	@Override
	public int getMaxClassSkill(int level) {
		return 3 + level;
	}

	@Override
	public int getMaxCrossClassSkill(int level) {
		return (int) Math.floor(this.getMaxClassSkill(level) / 2);
	}

	@Override
	public int getMaxLevel(Class clazz) {
		switch (clazz) {
		case BARBARIAN:
			return 20;
		case BARD:
			return 20;
		case CLERIC:
			return 20;
		case DRUID:
			return 20;
		case FIGHTER:
			return 20;
		case MONK:
			return 20;
		case PALADIN:
			return 20;
		case RANGER:
			return 20;
		case ROGUE:
			return 20;
		case SORCERER:
			return 20;
		case WIZARD:
			return 20;
		default:
			return 1;
		}
	}

	@Override
	public int getReflexSave(Class clazz, int level) {
		switch (clazz) {
			case BARBARIAN:
				return this.getBaseSaveBonusPoor(level);
			case BARD:
				return this.getBaseSaveBonusGood(level);
			case CLERIC:
				return this.getBaseSaveBonusPoor(level);
			case DRUID:
				return this.getBaseSaveBonusPoor(level);
			case FIGHTER:
				return this.getBaseSaveBonusPoor(level);
			case MONK:
				return this.getBaseSaveBonusGood(level);
			case PALADIN:
				return this.getBaseSaveBonusPoor(level);
			case RANGER:
				return this.getBaseSaveBonusGood(level);
			case ROGUE:
				return this.getBaseSaveBonusGood(level);
			case SORCERER:
				return this.getBaseSaveBonusPoor(level);
			case WIZARD:
				return this.getBaseSaveBonusPoor(level);
			default:
				return this.getBaseSaveBonusPoor(level);
		}
	}

	@Override
	public int getTotalExperience(Player player) {
		return this.getTotalExperience(player, this.getClass(player));
	}

	@Override
	public int getTotalExperience(Player player, Class clazz) {
		return this.getTotalExperience(Gildorym.getCorePlugin().getActiveCharacter(player), clazz);
	}

	@Override
	public int getTotalExperience(Character character) {
		return this.getTotalExperience(character, this.getClass(character));
	}
	
	@Override
	public int getTotalExperience(Character character, Class clazz) {
		if (this.experience.get(character) == null) {
			return 0;
		}
		if (this.experience.get(character).get(clazz) == null) {
			return 0;
		}
		return this.experience.get(character).get(clazz);
	}

	@Override
	public int getWillSave(Class clazz, int level) {
		switch (clazz) {
			case BARBARIAN:
				return this.getBaseSaveBonusPoor(level);
			case BARD:
				return this.getBaseSaveBonusGood(level);
			case CLERIC:
				return this.getBaseSaveBonusGood(level);
			case DRUID:
				return this.getBaseSaveBonusGood(level);
			case FIGHTER:
				return this.getBaseSaveBonusPoor(level);
			case MONK:
				return this.getBaseSaveBonusGood(level);
			case PALADIN:
				return this.getBaseSaveBonusPoor(level);
			case RANGER:
				return this.getBaseSaveBonusPoor(level);
			case ROGUE:
				return this.getBaseSaveBonusPoor(level);
			case SORCERER:
				return this.getBaseSaveBonusGood(level);
			case WIZARD:
				return this.getBaseSaveBonusGood(level);
			default:
				return this.getBaseSaveBonusPoor(level);
		}
	}

	@Override
	public void giveExperience(Player player, int amount) {
		this.giveExperience(player, this.getClass(player), amount);
	}

	@Override
	public void giveExperience(Player player, Class clazz, int amount) {
		this.giveExperience(Gildorym.getCorePlugin().getActiveCharacter(player), clazz, amount);
	}

	@Override
	public void giveExperience(Character character, int amount) {
		this.giveExperience(character, this.getClass(character), amount);
	}
	
	@Override
	public void giveExperience(Character character, Class clazz, int amount) {
		if (character.getPlayer() != null) {
			Player player = character.getPlayer();
			if (player.isOnline()) {
				player.sendMessage(ChatColor.YELLOW + "+" + amount + " exp");
				player.sendMessage(ChatColor.GRAY + "Total: " + ChatColor.WHITE + this.getExperienceTowardsNextLevel(character, clazz) + "/" + this.getTotalExperienceForLevel(this.getLevel(character, clazz)));
			}
		}
		this.setTotalExperience(character, clazz, this.getTotalExperience(character, clazz) + amount);
	}

	@Override
	public boolean isClassSkill(Class clazz, Skill skill) {
		switch (clazz) {
			case BARBARIAN:
				switch (skill) {
					case CLIMB:
					case SURVIVAL:
					case LISTEN:
					case JUMP:
					case SWIM:
					case RIDE:
					case INTIMIDATE:
					case SPOT:
						return true;
					default:
						return false;
				}
			case BARD:
				switch (skill) {
					case DISABLE_DEVICE:
					case FORGERY:
					case HANDLE_ANIMAL:
					case HEAL:
					case INTIMIDATE:
					case OPEN_LOCK:
					case RIDE:
					case SEARCH:
					case SPOT:
					case SURVIVAL:
					case USE_ROPE:
						return false;
					default:
						return true;
				}
			case CLERIC:
				switch (skill) {
					case CONCENTRATION:
					case CRAFT_DEVICES:
					case CRAFT_FOOD: 
					case CRAFT_TOOLS:
					case CRAFT_WEAPONS:
					case CRAFT_ARMOUR:
					case CRAFT_POTIONS:
					case DIPLOMACY:
					case HEAL:
					case KNOWLEDGE:
					case SPELLCRAFT:
						return true;
					default:
						return false;
				}
			case DRUID:
				switch (skill) {
					case CONCENTRATION:
					case CRAFT_DEVICES:
					case CRAFT_FOOD:
					case CRAFT_TOOLS:
					case CRAFT_WEAPONS:
					case CRAFT_ARMOUR:
					case CRAFT_POTIONS:
					case DIPLOMACY:
					case HANDLE_ANIMAL:
					case HEAL:
					case KNOWLEDGE:
					case LISTEN:
					case RIDE:
					case SPELLCRAFT:
					case SPOT:
					case SWIM:
						return true;
					default:
						return false;
				}
			case FIGHTER:
				switch (skill) {
					case CLIMB:
					case CRAFT_DEVICES:
					case CRAFT_FOOD:
					case CRAFT_TOOLS:
					case CRAFT_WEAPONS:
					case CRAFT_ARMOUR:
					case CRAFT_POTIONS:
					case HANDLE_ANIMAL:
					case INTIMIDATE:
					case JUMP:
					case RIDE:
					case SWIM:
						return true;
					default:
						return false;
				}
			case MONK:
				switch (skill) {
					case BALANCE:
					case CLIMB:
					case CONCENTRATION:
					case CRAFT_DEVICES:
					case CRAFT_FOOD:
					case CRAFT_TOOLS:
					case CRAFT_WEAPONS:
					case CRAFT_ARMOUR:
					case CRAFT_POTIONS:
					case DIPLOMACY:
					case ESCAPE_ARTIST:
					case HIDE:
					case JUMP:
					case KNOWLEDGE:
					case LISTEN:
					case MOVE_SILENTLY:
					case PERFORM:
					case SENSE_MOTIVE:
					case SPOT:
					case SWIM:
					case TUMBLE:
						return true;
					default:
						return false;
				}
			case PALADIN:
				switch (skill) {
					case CONCENTRATION:
					case CRAFT_DEVICES:
					case CRAFT_FOOD:
					case CRAFT_TOOLS:
					case CRAFT_WEAPONS:
					case CRAFT_ARMOUR:
					case CRAFT_POTIONS:
					case DIPLOMACY:
					case HANDLE_ANIMAL:
					case HEAL:
					case KNOWLEDGE:
					case RIDE:
					case SENSE_MOTIVE:
						return true;
					default:
						return false;
				}
			case RANGER:
				switch (skill) {
					case CLIMB:
					case CONCENTRATION:
					case CRAFT_DEVICES:
					case CRAFT_FOOD:
					case CRAFT_TOOLS:
					case CRAFT_WEAPONS:
					case CRAFT_ARMOUR:
					case CRAFT_POTIONS:
					case HANDLE_ANIMAL:
					case HEAL:
					case HIDE:
					case JUMP:
					case LISTEN:
					case MOVE_SILENTLY:
					case RIDE:
					case SEARCH:
					case SPOT:
					case SURVIVAL:
					case SWIM:
					case USE_ROPE:
						return true;
					default:
						return false;
				}
			case ROGUE:
				switch (skill) {
					case CONCENTRATION:
					case HANDLE_ANIMAL:
					case HEAL:
					case KNOWLEDGE:
					case RIDE:
					case SPEAK_LANGUAGE:
					case SPELLCRAFT:
					case SURVIVAL:
						return false;
					default:
						return false;
				}
			case SORCERER:
				switch (skill) {
					case BLUFF:
					case CONCENTRATION:
					case CRAFT_DEVICES:
					case CRAFT_FOOD:
					case CRAFT_TOOLS:
					case CRAFT_WEAPONS:
					case CRAFT_ARMOUR:
					case CRAFT_POTIONS:
					case KNOWLEDGE:
					case SPELLCRAFT:
						return true;
					default:
						return false;
				}
			case WIZARD:
				switch (skill) {
					case CONCENTRATION:
					case CRAFT_DEVICES:
					case CRAFT_FOOD:
					case CRAFT_TOOLS:
					case CRAFT_WEAPONS:
					case CRAFT_ARMOUR:
					case CRAFT_POTIONS:
					case DECIPHER_SCRIPT:
					case KNOWLEDGE:
					case SPELLCRAFT:
						return true;
					default:
						return false;
				}
			default:
				return false;
		}
	}

	@Override
	public int maxSkills(Character character) {
		int maxSkills = (this.getClassSkillModifier(this.getClass(character)) + character.getModifier(character.getIntelligence())) * 4 + (this.getLevel(character) - 1) * (this.getClassSkillModifier(this.getClass(character)) + character.getModifier(character.getIntelligence()));
		if (character.getRace() == Race.HUMAN) {
			maxSkills += 4;
			maxSkills += (this.getLevel(character) - 1);
		}
		return maxSkills;
	}

	@Override
	public void setClass(Player player, Class clazz) {
		this.setClass(Gildorym.getCorePlugin().getActiveCharacter(player), clazz);
	}

	@Override
	public void setClass(Character character, Class clazz) {
		GildorymClassChangeEvent event = new GildorymClassChangeEvent(character, this.getClass(character), clazz);
		this.getServer().getPluginManager().callEvent(event);
		if (event.isCancelled()) {
			return;
		}
		this.classes.put(event.getCharacter(), event.getClazz());
	}

	@Override
	public void setExperienceTowardsNextLevel(Player player, int amount) {
		this.setExperienceTowardsNextLevel(player, this.getClass(player), amount);
	}

	@Override
	public void setExperienceTowardsNextLevel(Player player, Class clazz, int amount) {
		this.setExperienceTowardsNextLevel(Gildorym.getCorePlugin().getActiveCharacter(player), clazz, amount);
	}

	@Override
	public void setExperienceTowardsNextLevel(Character character, int amount) {
		this.setExperienceTowardsNextLevel(character, this.getClass(character), amount);
	}

	@Override
	public void setExperienceTowardsNextLevel(Character character, Class clazz, int amount) {
		this.setTotalExperience(character, clazz, this.getTotalExperienceForLevel(this.getLevel(character, clazz)) + amount);
	}

	@Override
	public void setLevel(Player player, int level) {
		this.setLevel(player, this.getClass(player), level);
	}

	@Override
	public void setLevel(Player player, Class clazz, int level) {
		this.setLevel(Gildorym.getCorePlugin().getActiveCharacter(player), clazz, level);
	}

	@Override
	public void setLevel(Character character, int level) {
		this.setLevel(character, this.getClass(character), level);
	}

	@Override
	public void setLevel(Character character, Class clazz, int level) {
		this.setTotalExperience(character, clazz, this.getTotalExperienceForLevel(level));
	}

	@Override
	public void setTotalExperience(Player player, int amount) {
		this.setTotalExperience(player, this.getClass(player), amount);
	}

	@Override
	public void setTotalExperience(Player player, Class clazz, int amount) {
		this.setTotalExperience(Gildorym.getCorePlugin().getActiveCharacter(player), clazz, amount);
	}

	@Override
	public void setTotalExperience(Character character, int amount) {
		this.setTotalExperience(character, this.getClass(character), amount);
	}

	@Override
	public void setTotalExperience(Character character, Class clazz, int amount) {
		int i = 0;
		while (this.getTotalExperience(character, clazz) + amount > this.getTotalExperienceForLevel(this.getLevel(character) + i)) {
			i += 1;
		}
		if (i >= 1) {
			GildorymClassLevelChangeEvent event = new GildorymClassLevelChangeEvent(character, clazz, this.getLevel(character), this.getLevel(character) + i);
			this.getServer().getPluginManager().callEvent(event);
			if (event.isCancelled()) {
				return;
			}
		}
		if (this.experience.get(character) == null) {
			this.experience.put(character, new HashMap<Class, Integer>());
		}
		this.experience.get(character).put(clazz, amount);
		if (this.getLevel(character, clazz) > this.getMaxLevel(clazz)) {
			this.setLevel(character, clazz, this.getMaxLevel(clazz));
		}
		if (this.getClass(character) == clazz) {
			if (character.getPlayer() != null) {
				Player player = character.getPlayer();
				if (Gildorym.getCorePlugin().getActiveCharacter(player) == character) {
					if (player.isOnline()) {
						player.setExp((float) this.getExperienceTowardsNextLevel(character, clazz) / (float) this.getExpToNextLevel(this.getLevel(character, clazz)));
						player.setLevel(this.getLevel(character, clazz));
						player.setMaxHealth(Gildorym.getCorePlugin().getActiveCharacter(player).getMaxHealth());
						player.setHealth(Gildorym.getCorePlugin().getActiveCharacter(player).getHealth());
					}
				}
			}
		}
	}
	
	@Override
	public int getTotalExperienceForLevel(int level) {
		return level * (level-1) * 500;
	}

	@Override
	public int getExpToNextLevel(int level) {
		return 1000 * level;
	}
	
	protected Map<Character, Class> getClasses() {
		return classes;
	}
	
	protected Map<Character, Map<Class, Integer>> getExperience() {
		return experience;
	}

}
