package de.empty2k12.fancyclocks.common.block.blocks.CoubleClock;

import de.empty2k12.fancyclocks.common.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
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

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
		world.setBlock(x, y + 1, z, Blocks.clock_top, 0, 2);
	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		//FIXME: drop something!
		if (world.getBlock(x, y + 1, z) == Blocks.clock_top) {
			if (!player.capabilities.isCreativeMode) {
				world.func_147480_a(x, y + 1, z, false);
			} else {
				world.func_147480_a(x, y + 1, z, false);
			}
		}
		super.onBlockHarvested(world, x, y, z, meta, player);
	}
}
