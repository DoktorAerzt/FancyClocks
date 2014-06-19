package de.empty2k12.fancyclocks.common.block.clocks.wooden_clock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.empty2k12.fancyclocks.FancyClocks;
import de.empty2k12.fancyclocks.api.IScrewdriveable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

import static net.minecraftforge.common.util.ForgeDirection.*;

public class BlockWoodenClock extends BlockContainer implements IScrewdriveable {

	@SideOnly(Side.CLIENT)
	private IIcon[] texture;

	private final static String[] particleTextures = {
		"minecraft:planks_oak", "minecraft:planks_spruce", "minecraft:planks_birch", "minecraft:planks_jungle", "minecraft:planks_acacia", "minecraft:planks_big_oak"
	};

	public BlockWoodenClock() {
		super(Material.wood);
		setCreativeTab(FancyClocks.tabFancyClocks);
		setBlockName("blockClock");
		setStepSound(Block.soundTypeWood);
		setHardness(2F);
		setResistance(1F);
		setHarvestLevel("axe", 0);
	}

	@Override
	public void onScrewDriveTurn(EntityPlayer player, World world, int x, int y, int z) {
		if(world.getTileEntity(x, y, z) instanceof TileWoodenClock) {
			TileWoodenClock tile = (TileWoodenClock) world.getTileEntity(x, y, z);
			tile.toggleSounds();
			player.addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("msg.clock.1") + " " + (tile.getSilent() ? StatCollector.translateToLocal("msg.clock.silent") : StatCollector.translateToLocal("msg.clock.ticking") + "!")));
		}
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
	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z) {
		TileEntity te = blockAccess.getTileEntity(x, y, z);
		if(te != null && te instanceof TileWoodenClock) {
			int orientation = ((TileWoodenClock) te).getOrientation();
			float f = 0.30F;

			if (orientation == 0) {
				this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
			}

			if (orientation == 1) {
				this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
			}

			if (orientation == 2) {
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
			}

			if (orientation == 3) {
				this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			}
		}
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
		return world.isSideSolid(x - 1, y, z, EAST ) ||
				world.isSideSolid(x + 1, y, z, WEST ) ||
				world.isSideSolid(x, y, z - 1, SOUTH) ||
				world.isSideSolid(x, y, z + 1, NORTH);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		TileEntity te = world.getTileEntity(x, y, z);
		if(te != null && te instanceof TileWoodenClock) {
			int orientation = ((TileWoodenClock) te).getOrientation();
			boolean doDrop = true;

			if (orientation == 0 && !world.isAirBlock(x, y, z + 1)) {
				doDrop = false;
			}

			if (orientation == 1 && !world.isAirBlock(x - 1, y, z)) {
				doDrop = false;
			}

			if (orientation == 2 && !world.isAirBlock(x, y, z - 1)) {
				doDrop = false;
			}

			if (orientation == 3 && !world.isAirBlock(x + 1, y, z)) {
				doDrop = false;
			}

			if (doDrop) {
				this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), world.getBlockMetadata(x, y, z));
				world.setBlockToAir(x, y, z);
			}
			super.onNeighborBlockChange(world, x, y, z, block);
		}
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileWoodenClock();
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase livingBase, ItemStack stack) {
		TileEntity te = world.getTileEntity(x, y, z);
		if(te != null && te instanceof TileWoodenClock) {
			((TileWoodenClock) te).setOrientation(MathHelper.floor_double((double)((livingBase.rotationYaw * 4F) / 360F) + 0.5D) & 3);
		}
	}
}
