package de.empty2k12.fancyclocks.common.item;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import de.empty2k12.fancyclocks.common.item.items.ItemDoubleClock;
import de.empty2k12.fancyclocks.common.item.items.ItemScrewdriver;

public class Items {
	
	public static Item screwdriver;
	
	public static Item doubleClock;
	
	public static void init() {
		screwdriver = new ItemScrewdriver();
		GameRegistry.registerItem(screwdriver, "screwdriver");
		
		doubleClock = new ItemDoubleClock();
		GameRegistry.registerItem(doubleClock, "doubleClock");
	}

}
