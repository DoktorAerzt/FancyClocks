package de.empty2k12.fancyclocks.common.world.gen.village;

import java.util.List;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import de.empty2k12.fancyclocks.common.block.ClockBlocks;
import de.empty2k12.fancyclocks.common.block.tile.TileClock;
import de.empty2k12.fancyclocks.common.block.tile.TileDoubleClockTop;

public class ComponentHorologistsShop extends StructureVillagePieces.Village {
	
	//TODO: Bench and Correct Placement of the 2nd Trapdoor!

	public ComponentHorologistsShop(StructureVillagePieces.Start par1ComponentVillageStartPiece, int par2, Random par3Random, StructureBoundingBox par4StructureBoundingBox, int par5) {
		super(par1ComponentVillageStartPiece, par2);
		this.coordBaseMode = par5;
		this.boundingBox = par4StructureBoundingBox;
	}

	public static ComponentHorologistsShop buildComponent(StructureVillagePieces.Start par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
		StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par3, par4, par5, 0, 0, 0, 9, 9, 6, par6);
		return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(par1List, structureboundingbox) == null ? new ComponentHorologistsShop(par0ComponentVillageStartPiece, par7, par2Random, structureboundingbox, par6) : null;
	}

	public boolean addComponentParts(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {

		if (this.field_143015_k < 0) {
			this.field_143015_k = this.getAverageGroundLevel(par1World, par3StructureBoundingBox);

			if (this.field_143015_k < 0) {
				return true;
			}

			this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 9 - 1, 0);
		}

		//Roof Start
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 1, 1, 7, 5, 4, Blocks.air, Blocks.air, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 0, 0, 8, 0, 5, Blocks.cobblestone, Blocks.cobblestone, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 5, 0, 8, 5, 5, Blocks.cobblestone, Blocks.cobblestone, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 6, 1, 8, 6, 4, Blocks.cobblestone, Blocks.cobblestone, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 7, 2, 8, 7, 3, Blocks.cobblestone, Blocks.cobblestone, false);
		int i = this.getMetadataWithOffset(Blocks.oak_stairs, 3);
		int j = this.getMetadataWithOffset(Blocks.oak_stairs, 2);
		int k;
		int l;

		for (k = -1; k <= 2; ++k) {
			for (l = 0; l <= 8; ++l) {
				this.placeBlockAtCurrentPosition(par1World, Blocks.oak_stairs, i, l, 6 + k, k, par3StructureBoundingBox);
				this.placeBlockAtCurrentPosition(par1World, Blocks.oak_stairs, j, l, 6 + k, 5 - k, par3StructureBoundingBox);
			}
		}
		//Roof End

		//Walls Start
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 1, 0, 0, 1, 5, Blocks.cobblestone, Blocks.cobblestone, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 1, 5, 8, 1, 5, Blocks.cobblestone, Blocks.cobblestone, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 8, 1, 0, 8, 1, 4, Blocks.cobblestone, Blocks.cobblestone, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 2, 1, 0, 7, 1, 0, Blocks.cobblestone, Blocks.cobblestone, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 2, 0, 0, 4, 0, Blocks.cobblestone, Blocks.cobblestone, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 2, 5, 0, 4, 5, Blocks.cobblestone, Blocks.cobblestone, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 8, 2, 5, 8, 4, 5, Blocks.cobblestone, Blocks.cobblestone, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 8, 2, 0, 8, 4, 0, Blocks.cobblestone, Blocks.cobblestone, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 2, 1, 0, 4, 4, Blocks.planks, Blocks.planks, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 2, 5, 7, 4, 5, Blocks.planks, Blocks.planks, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 8, 2, 1, 8, 4, 4, Blocks.planks, Blocks.planks, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 2, 0, 7, 4, 0, Blocks.planks, Blocks.planks, false);
		this.placeBlockAtCurrentPosition(par1World, Blocks.glass_pane, 0, 4, 2, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.glass_pane, 0, 5, 2, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.glass_pane, 0, 6, 2, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.glass_pane, 0, 4, 3, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.glass_pane, 0, 5, 3, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.glass_pane, 0, 6, 3, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.glass_pane, 0, 0, 2, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.glass_pane, 0, 0, 2, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.glass_pane, 0, 0, 3, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.glass_pane, 0, 0, 3, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.glass_pane, 0, 8, 2, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.glass_pane, 0, 8, 2, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.glass_pane, 0, 8, 3, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.glass_pane, 0, 8, 3, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.glass_pane, 0, 3, 2, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.glass_pane, 0, 5, 2, 5, par3StructureBoundingBox);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 4, 1, 7, 4, 4, Blocks.planks, Blocks.planks, false);
		//Walls End

		//Clocks Start
		this.placeDoubleClockAtCurrentPosition(par1World, 4, 1, 4, 1);
		this.placeSignWithTextAtCurrentPosition(par1World, par3StructureBoundingBox, 4, 3, 4, new String[] {"", "Price:", "200$", ""});

		this.placeClockAtCurrentPosition(par1World, 2, 2, 4, 1);
		this.placeSignWithTextAtCurrentPosition(par1World, par3StructureBoundingBox, 2, 3, 4, new String[] {"", "Price:", "100$", ""});

		this.placeModernClockAtCurrentPosition(par1World, 6, 2, 4, 1);
		this.placeSignWithTextAtCurrentPosition(par1World, par3StructureBoundingBox, 6, 3, 4, new String[] {"", "Price:", "25$", ""});
		//Clocks End
		
		//Counter Start
		this.placeBlockAtCurrentPosition(par1World, Blocks.planks, 0, 6, 1, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.trapdoor, 11, 6, 1, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.trapdoor, 10, 7, 1, 2, par3StructureBoundingBox);
		
		this.placeBlockAtCurrentPosition(par1World, Blocks.iron_bars, 0, 6, 3, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.iron_bars, 0, 6, 3, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.iron_bars, 0, 7, 3, 2, par3StructureBoundingBox);
		
		this.placeBlockAtCurrentPosition(par1World, Blocks.flower_pot, 11, 6, 2, 2, par3StructureBoundingBox);
		//Counter End
		
		//Easteregg Start DONT TELL ANYONE!
		this.placeSignWithTextAtCurrentPosition(par1World, par3StructureBoundingBox, 7, 5, 1, new String[] {"Here, have", "a cookie!", "You", "rock!"});
		//Easteregg End
		
		//Door Start
		this.placeBlockAtCurrentPosition(par1World, Blocks.air, 0, 1, 1, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.air, 0, 1, 2, 0, par3StructureBoundingBox);
		this.placeDoorAtCurrentPosition(par1World, par3StructureBoundingBox, par2Random, 1, 1, 0, this.getMetadataWithOffset(Blocks.wooden_door, 1));
		//Door End

		//Outside Stairs Start
		if (this.getBlockAtCurrentPosition(par1World, 1, 0, -1, par3StructureBoundingBox).getMaterial() == Material.air && this.getBlockAtCurrentPosition(par1World, 1, -1, -1, par3StructureBoundingBox).getMaterial() != Material.air) {
			this.placeBlockAtCurrentPosition(par1World, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), 1, 0, -1, par3StructureBoundingBox);
		}
		//Outside Stairs End

		//Outside Sign Start
		this.placeSignWithTextAtCurrentPosition(par1World, par3StructureBoundingBox, 1, 3, -1, new String[] {"", "Horologist", "", ""});
		//Outside Sign End

		for (l = 0; l < 6; ++l) {
			for (int i1 = 0; i1 < 9; ++i1) {
				this.clearCurrentPositionBlocksUpwards(par1World, i1, 9, l, par3StructureBoundingBox);
				this.func_151554_b(par1World, Blocks.cobblestone, 0, i1, -1, l, par3StructureBoundingBox);
			}
		}

		this.spawnVillagers(par1World, par3StructureBoundingBox, 7, 1, 1, 1);
		return true;
	}

	protected int getVillagerType(int par1) {
		return VillageHandlerHorologist.HOROLOGIST_ID;
	}

	protected static boolean canVillageGoDeeper(StructureBoundingBox par0StructureBoundingBox) {
		return par0StructureBoundingBox != null && par0StructureBoundingBox.minY > 10;
	}

	protected boolean placeSignWithTextAtCurrentPosition(World par1World, StructureBoundingBox par2StructureBoundingBox, int par4, int par5, int par6, String[] text) {
		int x = this.getXWithOffset(par4, par6);
		int y = this.getYWithOffset(par5);
		int z = this.getZWithOffset(par4, par6);

		if (par2StructureBoundingBox.isVecInside(x, y, z) && par1World.getBlock(x, y, z) != Blocks.wall_sign) {
			par1World.setBlock(x, y, z, Blocks.wall_sign, this.getMetadataWithOffset(Blocks.wall_sign, 5), 2);
			TileEntitySign tilesign = (TileEntitySign)par1World.getTileEntity(x, y, z);

			if (tilesign != null) {
				for(int i = 0; i < text.length; i++) {
					tilesign.signText[i] = text[i];
				}
			}
			return true;
		} else {
			return false;
		}
	}

	protected boolean placeDoubleClockAtCurrentPosition(World world, int x, int y, int z, int meta) {
		int placeX = this.getXWithOffset(x, z);
		int placeY = this.getYWithOffset(y);
		int placeZ = this.getZWithOffset(x, z);

		world.setBlock(placeX, placeY, placeZ, ClockBlocks.clock_bottom, meta, 2);
		world.setBlock(placeX, placeY + 1, placeZ, ClockBlocks.clock_top, meta, 2);
		world.setTileEntity(placeX, placeY + 1, placeZ, new TileDoubleClockTop());
		return true;
	}

	protected boolean placeClockAtCurrentPosition(World world, int x, int y, int z, int meta) {
		int placeX = this.getXWithOffset(x, z);
		int placeY = this.getYWithOffset(y);
		int placeZ = this.getZWithOffset(x, z);

		world.setBlock(placeX, placeY, placeZ, ClockBlocks.clock, meta, 2);
		world.setTileEntity(placeX, placeY, placeZ, new TileClock());
		return true;
	}

	protected boolean placeModernClockAtCurrentPosition(World world, int x, int y, int z, int meta) {
		int placeX = this.getXWithOffset(x, z);
		int placeY = this.getYWithOffset(y);
		int placeZ = this.getZWithOffset(x, z);

		world.setBlock(placeX, placeY, placeZ, ClockBlocks.modern_clock, meta, 2);
		world.setTileEntity(placeX, placeY, placeZ, new TileClock());
		return true;
	}

}
