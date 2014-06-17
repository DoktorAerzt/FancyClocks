package de.empty2k12.fancyclocks.common.block.blocks.DoubleClock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.empty2k12.fancyclocks.FancyClocks;
import de.empty2k12.fancyclocks.common.block.ClockBlocks;
import de.empty2k12.fancyclocks.common.block.tile.TileDoubleClock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public class BlockDoubleClockBottom extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon[] texture;

	private final static String[] particleTextures = {
		"minecraft:planks_oak", "minecraft:planks_spruce", "minecraft:planks_birch", "minecraft:planks_jungle", "minecraft:planks_acacia", "minecraft:planks_big_oak"
	};

	public BlockDoubleClockBottom() {
		super(Material.wood);
		setCreativeTab(FancyClocks.tabFancyClocks);
		setBlockName("blockDoubleClock");
		setHarvestLevel("axe", 0);
		setHardness(2F);
		setResistance(2F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister){
		texture = new IIcon[7];
		for(int meta = 0; meta < particleTextures.length; meta++) {
			texture[meta] = par1IconRegister.registerIcon(particleTextures[meta]);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return texture[meta];
	}


	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List items) {
		for (int meta = 0; meta < 6; meta++) {
			items.add(new ItemStack(item, 1, meta));
		}
	}

	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase livingBase, ItemStack stack) {
		world.setBlock(x, y + 1, z, ClockBlocks.clock_top, world.getBlockMetadata(x, y, z), 2);
		world.setTileEntity(x, y + 1, z, new TileDoubleClock());	

		TileEntity te = world.getTileEntity(x, y + 1, z);
		if(te != null && te instanceof TileDoubleClock) {
			((TileDoubleClock) te).setOrientation(MathHelper.floor_double((double)((livingBase.rotationYaw * 4F) / 360F) + 0.5D) & 3);
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
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
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
