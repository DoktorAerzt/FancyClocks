package de.empty2k12.fancyclocks.common.misc;

import de.empty2k12.fancyclocks.common.block.ClockBlocks;
import de.empty2k12.fancyclocks.common.item.ClockItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TabFancyClocks extends CreativeTabs {

    public TabFancyClocks(String label) {
        super(label);
    }

    @Override
    public Item getTabIconItem() {
        return new ItemStack(ClockBlocks.clock, 1, 6).getItem();
    }

}
