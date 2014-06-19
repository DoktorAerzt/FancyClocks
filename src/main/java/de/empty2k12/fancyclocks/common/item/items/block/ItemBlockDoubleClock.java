package de.empty2k12.fancyclocks.common.item.items.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemBlockDoubleClock extends ItemBlock {
	
	public ItemBlockDoubleClock(Block block){
		super(block);
		setHasSubtypes(true);
	}

	@Override
	public String getItemStackDisplayName(ItemStack is){
		return StatCollector.translateToLocal("wood.type." + is.getItemDamage()) + " " + StatCollector.translateToLocal("tile.blockDoubleClock.name");
	}

	@Override
	public int getMetadata(int meta){
		return meta;
	}
}
