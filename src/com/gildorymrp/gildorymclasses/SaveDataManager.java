/*     */ package com.gildorymrp.gildorymclasses;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class SaveDataManager
/*     */ {
/*     */   public static void saveClassData(GildorymClasses plugin)
/*     */   {
/*     */     try
/*     */     {
/*  16 */       if (!plugin.getDataFolder().exists()) {
/*  17 */         plugin.getDataFolder().mkdir();
/*     */       }
/*  19 */       File file = new File(plugin.getDataFolder().getAbsolutePath() + File.separator + "classes.dat");
/*  20 */       file.delete();
/*  21 */       file.createNewFile();
/*  22 */       FileOutputStream fos = new FileOutputStream(plugin.getDataFolder().getAbsolutePath() + File.separator + "classes.dat");
/*  23 */       ObjectOutputStream oos = new ObjectOutputStream(fos);
/*  24 */       oos.writeObject(plugin.classes);
/*  25 */       oos.close();
/*     */     } catch (FileNotFoundException e) {
/*  27 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/*  29 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void loadClassData(GildorymClasses plugin)
/*     */   {
/*     */     try {
/*  36 */       File file = new File(plugin.getDataFolder().getAbsolutePath() + File.separator + "classes.dat");
/*  37 */       if (file.exists()) {
/*  38 */         FileInputStream fis = new FileInputStream(plugin.getDataFolder().getAbsolutePath() + File.separator + "classes.dat");
/*  39 */         ObjectInputStream ois = new ObjectInputStream(fis);
/*  40 */         plugin.classes.putAll((Map)ois.readObject());
/*  41 */         ois.close();
/*     */       }
/*     */     } catch (FileNotFoundException e) {
/*  44 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/*  46 */       e.printStackTrace();
/*     */     } catch (ClassNotFoundException e) {
/*  48 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void saveProfessionData(GildorymClasses plugin) {
/*     */     try {
/*  54 */       if (!plugin.getDataFolder().exists()) {
/*  55 */         plugin.getDataFolder().mkdir();
/*     */       }
/*  57 */       File file = new File(plugin.getDataFolder().getAbsolutePath() + File.separator + "professions.dat");
/*  58 */       file.delete();
/*  59 */       file.createNewFile();
/*  60 */       FileOutputStream fos = new FileOutputStream(plugin.getDataFolder().getAbsolutePath() + File.separator + "professions.dat");
/*  61 */       ObjectOutputStream oos = new ObjectOutputStream(fos);
/*  62 */       oos.writeObject(plugin.professions);
/*  63 */       oos.close();
/*     */     } catch (FileNotFoundException e) {
/*  65 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/*  67 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void loadProfessionData(GildorymClasses plugin)
/*     */   {
/*     */     try {
/*  74 */       File file = new File(plugin.getDataFolder().getAbsolutePath() + File.separator + "professions.dat");
/*  75 */       if (file.exists()) {
/*  76 */         FileInputStream fis = new FileInputStream(plugin.getDataFolder().getAbsolutePath() + File.separator + "professions.dat");
/*  77 */         ObjectInputStream ois = new ObjectInputStream(fis);
/*  78 */         plugin.professions.putAll((Map)ois.readObject());
/*  79 */         ois.close();
/*     */       }
/*     */     } catch (FileNotFoundException e) {
/*  82 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/*  84 */       e.printStackTrace();
/*     */     } catch (ClassNotFoundException e) {
/*  86 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void saveLevelData(GildorymClasses plugin) {
/*     */     try {
/*  92 */       if (!plugin.getDataFolder().exists()) {
/*  93 */         plugin.getDataFolder().mkdir();
/*     */       }
/*  95 */       File file = new File(plugin.getDataFolder().getAbsolutePath() + File.separator + "levels.dat");
/*  96 */       file.delete();
/*  97 */       file.createNewFile();
/*  98 */       FileOutputStream fos = new FileOutputStream(plugin.getDataFolder().getAbsolutePath() + File.separator + "levels.dat");
/*  99 */       ObjectOutputStream oos = new ObjectOutputStream(fos);
/* 100 */       oos.writeObject(plugin.levels);
/* 101 */       oos.close();
/*     */     } catch (FileNotFoundException e) {
/* 103 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 105 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void loadLevelData(GildorymClasses plugin)
/*     */   {
/*     */     try {
/* 112 */       File file = new File(plugin.getDataFolder().getAbsolutePath() + File.separator + "levels.dat");
/* 113 */       if (file.exists()) {
/* 114 */         FileInputStream fis = new FileInputStream(plugin.getDataFolder().getAbsolutePath() + File.separator + "levels.dat");
/* 115 */         ObjectInputStream ois = new ObjectInputStream(fis);
/* 116 */         plugin.levels.putAll((Map)ois.readObject());
/* 117 */         ois.close();
/*     */       }
/*     */     } catch (FileNotFoundException e) {
/* 120 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 122 */       e.printStackTrace();
/*     */     } catch (ClassNotFoundException e) {
/* 124 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void saveExperienceData(GildorymClasses plugin) {
/*     */     try {
/* 130 */       if (!plugin.getDataFolder().exists()) {
/* 131 */         plugin.getDataFolder().mkdir();
/*     */       }
/* 133 */       File file = new File(plugin.getDataFolder().getAbsolutePath() + File.separator + "experience.dat");
/* 134 */       file.delete();
/* 135 */       file.createNewFile();
/* 136 */       FileOutputStream fos = new FileOutputStream(plugin.getDataFolder().getAbsolutePath() + File.separator + "experience.dat");
/* 137 */       ObjectOutputStream oos = new ObjectOutputStream(fos);
/* 138 */       oos.writeObject(plugin.experience);
/* 139 */       oos.close();
/*     */     } catch (FileNotFoundException e) {
/* 141 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 143 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void loadExperienceData(GildorymClasses plugin)
/*     */   {
/*     */     try {
/* 150 */       File file = new File(plugin.getDataFolder().getAbsolutePath() + File.separator + "experience.dat");
/* 151 */       if (file.exists()) {
/* 152 */         FileInputStream fis = new FileInputStream(plugin.getDataFolder().getAbsolutePath() + File.separator + "experience.dat");
/* 153 */         ObjectInputStream ois = new ObjectInputStream(fis);
/* 154 */         plugin.experience.putAll((Map)ois.readObject());
/* 155 */         ois.close();
/*     */       }
/*     */     } catch (FileNotFoundException e) {
/* 158 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 160 */       e.printStackTrace();
/*     */     } catch (ClassNotFoundException e) {
/* 162 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator.Banditt-PC\Desktop\Coding\Server\plugins\GildorymClasses.jar
 * Qualified Name:     com.gildorymrp.gildorymclasses.SaveDataManager
 * JD-Core Version:    0.6.2
 */