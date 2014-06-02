package de.empty2k12.fancyclocks.common.block.blocks.DoubleClock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import de.empty2k12.fancyclocks.FancyClocks;
import de.empty2k12.fancyclocks.api.IScrewdriveable;
import de.empty2k12.fancyclocks.common.block.ClockBlocks;
import de.empty2k12.fancyclocks.common.block.tile.TileClock;
import de.empty2k12.fancyclocks.common.block.tile.TileDoubleClockTop;

public class BlockDoubleClockBottom extends Block {

	public BlockDoubleClockBottom() {
		super(Material.wood);
		setCreativeTab(FancyClocks.tabFancyClocks);
		setBlockName("blockDoubleClock");
		setHarvestLevel("axe", 0);
		setHardness(2F);
		setResistance(2F);
		setBlockTextureName("minecraft:planks_oak");
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {

		if (entity == null)
			return;

		int newMeta = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		world.setBlock(x, y + 1, z, ClockBlocks.clock_top, 0, 2);
		world.setTileEntity(x, y + 1, z, new TileDoubleClockTop());	

		if (newMeta == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
			world.setBlockMetadataWithNotify(x, y + 1, z, 2, 2);
		}

		if (newMeta == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
			world.setBlockMetadataWithNotify(x, y + 1, z, 5, 2);
		}

		if (newMeta == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
			world.setBlockMetadataWithNotify(x, y + 1, z, 3, 2);
		}

		if (newMeta == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
			world.setBlockMetadataWithNotify(x, y + 1, z, 4, 2);
		}
	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		if (world.getBlock(x, y + 1, z) == ClockBlocks.clock_top) {
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
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return (world.isAirBlock(x, y + 1, z) && world.isAirBlock(x, y, z));
	}
	
	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
		return world.getBlock(x, y + 1, z) == ClockBlocks.clock_top;
	}

}
