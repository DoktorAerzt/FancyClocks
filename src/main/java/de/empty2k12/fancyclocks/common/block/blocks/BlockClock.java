package de.empty2k12.fancyclocks.common.block.blocks;

import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.WEST;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import de.empty2k12.fancyclocks.common.block.tile.TileClock;

public class BlockClock extends BlockContainer {

	public BlockClock() {
		super(Material.wood);
		setCreativeTab(CreativeTabs.tabDecorations);
		setBlockName("blockClock");
		setHardness(2F);
		setResistance(1F);
		setHarvestLevel("axe", 0);
	}

	@Override
	public boolean isNormalCube() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int p_149646_5_) {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return world.isSideSolid(x - 1, y, z, EAST ) ||
				world.isSideSolid(x + 1, y, z, WEST ) ||
				world.isSideSolid(x, y, z - 1, SOUTH) ||
				world.isSideSolid(x, y, z + 1, NORTH);
	}

	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
		int j1 = meta;

		if ((meta == 0 || side == 2) && world.isSideSolid(x, y, z + 1, NORTH)) {
			j1 = 2;
		}

		if ((j1 == 0 || side == 3) && world.isSideSolid(x, y, z - 1, SOUTH)) {
			j1 = 3;
		}

		if ((j1 == 0 || side == 4) && world.isSideSolid(x + 1, y, z, WEST)) {
			j1 = 4;
		}

		if ((j1 == 0 || side == 5) && world.isSideSolid(x - 1, y, z, EAST)) {
			j1 = 5;
		}

		return j1;
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		int l = world.getBlockMetadata(x, y, z);
		boolean flag = false;

		if (l == 2 && world.isSideSolid(x, y, z + 1, NORTH)) {
			flag = true;
		}

		if (l == 3 && world.isSideSolid(x, y, z - 1, SOUTH)) {
			flag = true;
		}

		if (l == 4 && world.isSideSolid(x + 1, y, z, WEST)) {
			flag = true;
		}

		if (l == 5 && world.isSideSolid(x - 1, y, z, EAST)) {
			flag = true;
		}

		if (!flag) {
			this.dropBlockAsItem(world, x, y, z, l, 0);
			world.setBlockToAir(x, y, z);
		}

		super.onNeighborBlockChange(world, x, y, z, block);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileClock();
	}

}
