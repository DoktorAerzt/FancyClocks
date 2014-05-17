package de.empty2k12.fancyclocks.common.block.blocks;

import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.WEST;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import de.empty2k12.fancyclocks.api.IScrewdriveable;
import de.empty2k12.fancyclocks.common.block.tile.TileClock;

public class BlockClock extends BlockContainer implements IScrewdriveable {

	public BlockClock() {
		super(Material.wood);
		setCreativeTab(CreativeTabs.tabDecorations);
		setBlockName("blockClock");
		setStepSound(Block.soundTypeWood);
		setHardness(2F);
		setResistance(1F);
		setHarvestLevel("axe", 0);
		setBlockTextureName("minecraft:planks_oak");
	}

	@Override
	public void onScrewDriveTurn(EntityPlayer player, World world, int x, int y, int z) {
		if(world.getTileEntity(x, y, z) instanceof TileClock) {
			TileClock tile = (TileClock) world.getTileEntity(x, y, z);
			tile.toggleSounds();
			//TODO: Translate to Local with StatCollector.translateToLocal();
			player.addChatComponentMessage(new ChatComponentText("The Clock is now" + (tile.getSilent() ? " silent!" : " ticking!")));
		}
	}

	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z) {
		this.setBlockBoundsOnState(blockAccess.getBlockMetadata(x, y, z));
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
	public boolean isNormalCube() {
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
		return new TileClock(false);
	}

	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
		int newMeta = meta;

		if ((meta == 0 || side == 2) && world.isSideSolid(x, y, z + 1, NORTH)) {
			newMeta = 2;
		}

		if ((newMeta == 0 || side == 3) && world.isSideSolid(x, y, z - 1, SOUTH)) {
			newMeta = 3;
		}

		if ((newMeta == 0 || side == 4) && world.isSideSolid(x + 1, y, z, WEST)) {
			newMeta = 4;
		}

		if ((newMeta == 0 || side == 5) && world.isSideSolid(x - 1, y, z, EAST)) {
			newMeta = 5;
		}

		return newMeta;
	}

	//FIXME: if time change these!
	public void setBlockBoundsOnState(int meta) {
		float f = 0.30F;

		if (meta == 2) {
			this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
		}

		if (meta == 3) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
		}

		if (meta == 4) {
			this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}

		if (meta == 5) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
		}
	}
}
