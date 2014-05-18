package de.empty2k12.fancyclocks.common.block.blocks;

import de.empty2k12.fancyclocks.common.block.tile.TileModernClock;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockModernClock extends BlockContainer {

	public BlockModernClock() {
		super(Material.iron);
		setCreativeTab(CreativeTabs.tabDecorations);
		setBlockTextureName("minecraft:iron_block");
		setBlockName("blockModernClock");
		setHardness(2F);
		setResistance(2F);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileModernClock();
	}

}
