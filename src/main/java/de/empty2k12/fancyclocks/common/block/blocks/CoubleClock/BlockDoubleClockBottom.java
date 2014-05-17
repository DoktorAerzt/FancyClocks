package de.empty2k12.fancyclocks.common.block.blocks.CoubleClock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import de.empty2k12.fancyclocks.common.block.Blocks;
import de.empty2k12.fancyclocks.common.block.tile.TileDoubleClockTop;

public class BlockDoubleClockBottom extends Block {

	public BlockDoubleClockBottom() {
		super(Material.wood);
		setCreativeTab(CreativeTabs.tabDecorations);
		setBlockName("blockDoubleClock");
		setHarvestLevel("axe", 0);
		setHardness(2F);
		setResistance(2F);
		setBlockTextureName("minecraft:planks_oak");
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
		world.setBlock(x, y + 1, z, Blocks.clock_top, 0, 2);
		world.setTileEntity(x, y + 1, z, new TileDoubleClockTop());
		if (entity == null)
			return;	

		TileDoubleClockTop tile = (TileDoubleClockTop) world.getTileEntity(x, y + 1, z);
		if(tile != null)
			tile.direction = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		if (world.getBlock(x, y + 1, z) == Blocks.clock_top) {
			if (!player.capabilities.isCreativeMode) {
				world.func_147480_a(x, y, z, true);
				world.func_147480_a(x, y + 1, z, false);
			} else {
				world.func_147480_a(x, y + 1, z, false);
			}
		}
		super.onBlockHarvested(world, x, y, z, meta, player);
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
