package de.empty2k12.fancyclocks.common.misc;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import de.empty2k12.fancyclocks.common.item.ClockItems;

public class TabFancyClocks extends CreativeTabs {

	public TabFancyClocks(String lable) {
		super(lable);
	}

	@Override
	public Item getTabIconItem() {
		return ClockItems.screwdriver;
	}

}
