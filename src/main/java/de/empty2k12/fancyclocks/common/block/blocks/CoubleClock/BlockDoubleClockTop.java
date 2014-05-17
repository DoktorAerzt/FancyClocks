package de.empty2k12.fancyclocks.common.block.blocks.CoubleClock;

import java.util.ArrayList;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import de.empty2k12.fancyclocks.common.block.Blocks;
import de.empty2k12.fancyclocks.common.block.tile.TileDoubleClockTop;

public class BlockDoubleClockTop extends BlockContainer {

	public BlockDoubleClockTop() {
		super(Material.wood);
		setCreativeTab(CreativeTabs.tabDecorations);
		setHarvestLevel("axe", 0);
		setHardness(2F);
		setResistance(2F);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileDoubleClockTop();
	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		if (world.getBlock(x, y - 1, z) == Blocks.clock_bottom) {
			if (!player.capabilities.isCreativeMode) {
				world.func_147480_a(x, y - 1, z, true);
			} else {
				world.func_147480_a(x, y - 1, z, false);
			}
		}
		super.onBlockHarvested(world, x, y, z, meta, player);
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		return new ArrayList<ItemStack>();
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess acess, int x, int y, int z, int meta) {
		return false;
	}

	@Override
	public boolean isNormalCube() {
		return false;
	}

	@Override
	public boolean isNormalCube(IBlockAccess world, int x, int y, int z) {
		return false;
	}

	@Override
	public int getRenderType() {
		return 0;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	

}
