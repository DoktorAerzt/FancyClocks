package de.empty2k12.fancyclocks.common.misc;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

	public static boolean ENABLE_HOROLOGIST = true;
	public static int HOROLOGIST_ID = 11;
	public static boolean LOOT_CHEST = true;

	public static void init(File file) {
		Configuration config = new Configuration(file);
		config.load();

		ENABLE_HOROLOGIST =  config.get("Village Customisation", "Horologist Villager House Enabled:", true).getBoolean(true);
		HOROLOGIST_ID = config.get("Village Customisation", "Horologist Villager ID:", 11).getInt();
		LOOT_CHEST = config.get("Village Customisation", "Enable a lootchest in the village house (Currently unused):", true).getBoolean(true);

		config.save();
	}

}
