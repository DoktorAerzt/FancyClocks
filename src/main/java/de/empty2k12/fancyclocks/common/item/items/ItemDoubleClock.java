package de.empty2k12.fancyclocks.common.item.items;

import de.empty2k12.fancyclocks.common.block.Blocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDoubleClock extends Item {

	public ItemDoubleClock() {
		setCreativeTab(CreativeTabs.tabDecorations);
		setUnlocalizedName("blockDoubleClock");
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if(world.isAirBlock(x, y + 1, z) && world.isAirBlock(x, y + 2, z)) {
			world.setBlock(x, y + 2, z, Blocks.clock_top);
			world.setBlock(x, y + 1, z, Blocks.clock_bottom);
			return true;
		}
		return false;
	}
}
