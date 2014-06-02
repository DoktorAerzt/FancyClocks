package de.empty2k12.fancyclocks.common.block.blocks.DoubleClock;

import java.util.ArrayList;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import de.empty2k12.fancyclocks.api.IScrewdriveable;
import de.empty2k12.fancyclocks.common.block.ClockBlocks;
import de.empty2k12.fancyclocks.common.block.tile.TileDoubleClockTop;

public class BlockDoubleClockTop extends BlockContainer implements IScrewdriveable {

	public BlockDoubleClockTop() {
		super(Material.wood);
		setHarvestLevel("axe", 0);
		setHardness(2F);
		setResistance(2F);
		setBlockTextureName("minecraft:planks_oak");
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileDoubleClockTop();
	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		if (world.getBlock(x, y - 1, z) == ClockBlocks.clock_bottom) {
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
		return null;
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
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		return new ItemStack(ClockBlocks.clock_bottom);
	}

	@Override
	public void onScrewDriveTurn(EntityPlayer player, World world, int x, int y, int z) {
		if(world.getTileEntity(x, y, z) instanceof TileDoubleClockTop) {
			TileDoubleClockTop tile = (TileDoubleClockTop) world.getTileEntity(x, y, z);
			tile.toggleSounds();
			player.addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("msg.clock.1") + " " + (tile.getSilent() ? StatCollector.translateToLocal("msg.clock.silent") : StatCollector.translateToLocal("msg.clock.ticking")) + "!"));
		}
	}
	
	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
		return world.getBlock(x, y - 1, z) == ClockBlocks.clock_bottom;
	}
}
