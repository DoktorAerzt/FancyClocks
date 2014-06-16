package de.empty2k12.fancyclocks.common.item;

import cpw.mods.fml.common.registry.GameRegistry;
import de.empty2k12.fancyclocks.common.item.items.ItemScrewdriver;
import net.minecraft.item.Item;

public class ClockItems {
	
	public static Item screwdriver;
	
	public static void init() {
		screwdriver = new ItemScrewdriver();
		GameRegistry.registerItem(screwdriver, "screwdriver");
	}

}
