package de.empty2k12.fancyclocks.common.block.blocks.CoubleClock;

import de.empty2k12.fancyclocks.common.block.Blocks;
import de.empty2k12.fancyclocks.common.block.tile.TileDoubleClock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockDoubleClockTop extends BlockContainer {

	public BlockDoubleClockTop() {
		super(Material.wood);
		setCreativeTab(CreativeTabs.tabDecorations);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileDoubleClock();
	}

	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta) {
		//7if(world.getBlock(x, y, z) == Blocks.clock_bottom) {
			world.setBlockToAir(x, y, z);
		//}
	}
	
}
