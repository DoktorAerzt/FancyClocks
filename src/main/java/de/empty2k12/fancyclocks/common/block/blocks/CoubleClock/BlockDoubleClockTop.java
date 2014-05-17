package de.empty2k12.fancyclocks.common.block.blocks.CoubleClock;

import de.empty2k12.fancyclocks.common.block.Blocks;
import de.empty2k12.fancyclocks.common.block.tile.TileDoubleClock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
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
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		if (world.getBlock(x, y - 1, z) == Blocks.clock_bottom) {
			if (!player.capabilities.isCreativeMode) {
				world.func_147480_a(x, y - 1, z, true);
			} else {
				world.func_147480_a(x, y - 1, z, true);
			}
		}
		super.onBlockHarvested(world, x, y, z, meta, player);
	}

	
}
