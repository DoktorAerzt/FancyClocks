package de.empty2k12.fancyclocks.common.block.blocks.CoubleClock;

import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.WEST;
import de.empty2k12.fancyclocks.common.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDoubleClockBottom extends Block {

	public BlockDoubleClockBottom() {
		super(Material.wood);
		setCreativeTab(CreativeTabs.tabDecorations);
		setBlockName("blockDoubleClock");
		setHarvestLevel("axe", 0);
		setHardness(2F);
		setResistance(2F);
	}

//	@Override
//	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
//		world.setBlock(x, y + 1, z, Blocks.clock_top, 0, 2);
//	}

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
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
		int newMeta = meta;

		if ((meta == 0 || side == 2) && world.isSideSolid(x, y, z + 1, NORTH)) {
			newMeta = 2;
			world.setBlock(x, y + 1, z, Blocks.clock_top, newMeta, 2);
		}

		if ((newMeta == 0 || side == 3) && world.isSideSolid(x, y, z - 1, SOUTH)) {
			newMeta = 3;
			world.setBlock(x, y + 1, z, Blocks.clock_top, newMeta, 2);
		}

		if ((newMeta == 0 || side == 4) && world.isSideSolid(x + 1, y, z, WEST)) {
			newMeta = 4;
			world.setBlock(x, y + 1, z, Blocks.clock_top, newMeta, 2);
		}

		if ((newMeta == 0 || side == 5) && world.isSideSolid(x - 1, y, z, EAST)) {
			newMeta = 5;
			world.setBlock(x, y + 1, z, Blocks.clock_top, newMeta, 2);
		}

		return newMeta;
	}

}
