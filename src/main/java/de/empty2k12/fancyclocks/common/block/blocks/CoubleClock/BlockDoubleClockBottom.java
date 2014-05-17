package de.empty2k12.fancyclocks.common.block.blocks.CoubleClock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

public class BlockDoubleClockBottom extends Block {

	public BlockDoubleClockBottom() {
		super(Material.wood);
		setCreativeTab(CreativeTabs.tabDecorations);
		setBlockName("blockDoubleClock");
	}
	
	@Override
	public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
		super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
	}

}
