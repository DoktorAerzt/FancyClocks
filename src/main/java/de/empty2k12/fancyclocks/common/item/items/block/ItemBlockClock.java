package de.empty2k12.fancyclocks.common.item.items.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockClock extends ItemBlock {
	
	//FIXME: Localizse!

	private final static String[] subNames = {"Oak", "Spruce", "Birch", "Jungle", "Acacia", "Dark Oak"};

	public ItemBlockClock(Block block){
		super(block);
		setHasSubtypes(true);
	}

	@Override
	public String getItemStackDisplayName(ItemStack is){
		return subNames[is.getItemDamage()] + " Clock";
	}

	@Override
	public int getMetadata(int meta){
		return meta;
	}
}
