package de.empty2k12.fancyclocks.common.misc;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

	public static boolean ENABLE_HOROLOGIST = true;
	public static int HOROLOGIST_ID = 11;

	public static void init(File file) {

		Configuration config = new Configuration(file);

		config.load();

		ENABLE_HOROLOGIST =  config.get("Miscellaneous", "Horologist Villager House Enabled:", true).getBoolean(true);
		HOROLOGIST_ID = config.get("Miscellaneous", "Horologist Villager ID:", 11).getInt();

		config.save();
	}

}
