package de.empty2k12.fancyclocks.common.item.items.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemBlockClock extends ItemBlock {
	
	public ItemBlockClock(Block block){
		super(block);
		setHasSubtypes(true);
	}

	@Override
	public String getItemStackDisplayName(ItemStack is){
		return StatCollector.translateToLocal("wood.type." + is.getItemDamage()) + " " + StatCollector.translateToLocal("tile.blockClock.name");
	}

	@Override
	public int getMetadata(int meta){
		return meta;
	}
}
