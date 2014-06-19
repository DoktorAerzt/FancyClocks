package de.empty2k12.fancyclocks.common.world.gen.village;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import de.empty2k12.fancyclocks.common.block.ClockBlocks;
import de.empty2k12.fancyclocks.common.block.clocks.double_clock.TileDoubleClock;
import de.empty2k12.fancyclocks.common.block.clocks.modern_clock.TileModernClock;
import de.empty2k12.fancyclocks.common.block.clocks.wooden_clock.TileWoodenClock;

public class ComponentHorologistsShop extends StructureVillagePieces.Village {
	
	Block[] buildingMaterial;

	public ComponentHorologistsShop(StructureVillagePieces.Start par1ComponentVillageStartPiece, int par2, Random par3Random, StructureBoundingBox par4StructureBoundingBox, int par5) {
		super(par1ComponentVillageStartPiece, par2);
		this.coordBaseMode = par5;
		this.boundingBox = par4StructureBoundingBox;
		if(par1ComponentVillageStartPiece.inDesert) {
			this.buildingMaterial = new Block[] {Blocks.sandstone, Blocks.sandstone_stairs, Blocks.iron_bars, Blocks.sandstone};
		} else {
			this.buildingMaterial = new Block[] {Blocks.cobblestone, Blocks.oak_stairs, Blocks.glass_pane, Blocks.planks};
		}
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
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 0, 0, 8, 0, 5, buildingMaterial[0], buildingMaterial[0], false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 5, 0, 8, 5, 5, buildingMaterial[0], buildingMaterial[0], false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 6, 1, 8, 6, 4, buildingMaterial[0], buildingMaterial[0], false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 7, 2, 8, 7, 3, buildingMaterial[0], buildingMaterial[0], false);
		int i = this.getMetadataWithOffset(buildingMaterial[1], 3);
		int j = this.getMetadataWithOffset(buildingMaterial[1], 2);
		int k;
		int l;

		for (k = -1; k <= 2; ++k) {
			for (l = 0; l <= 8; ++l) {
				this.placeBlockAtCurrentPosition(par1World, buildingMaterial[1], i, l, 6 + k, k, par3StructureBoundingBox);
				this.placeBlockAtCurrentPosition(par1World, buildingMaterial[1], j, l, 6 + k, 5 - k, par3StructureBoundingBox);
			}
		}
		//Roof End

		//Walls Start
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 1, 0, 0, 1, 5, buildingMaterial[0], buildingMaterial[0], false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 1, 5, 8, 1, 5, buildingMaterial[0], buildingMaterial[0], false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 8, 1, 0, 8, 1, 4, buildingMaterial[0], buildingMaterial[0], false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 2, 1, 0, 7, 1, 0, buildingMaterial[0], buildingMaterial[0], false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 2, 0, 0, 4, 0, buildingMaterial[0], buildingMaterial[0], false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 2, 5, 0, 4, 5, buildingMaterial[0], buildingMaterial[0], false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 8, 2, 5, 8, 4, 5, buildingMaterial[0], buildingMaterial[0], false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 8, 2, 0, 8, 4, 0, buildingMaterial[0], buildingMaterial[0], false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 2, 1, 0, 4, 4, buildingMaterial[3], buildingMaterial[3], false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 2, 5, 7, 4, 5, buildingMaterial[3], buildingMaterial[3], false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 8, 2, 1, 8, 4, 4, buildingMaterial[3], buildingMaterial[3], false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 2, 0, 7, 4, 0, buildingMaterial[3], buildingMaterial[3], false);
		this.placeBlockAtCurrentPosition(par1World, buildingMaterial[2], 0, 4, 2, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, buildingMaterial[2], 0, 5, 2, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, buildingMaterial[2], 0, 6, 2, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, buildingMaterial[2], 0, 4, 3, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, buildingMaterial[2], 0, 5, 3, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, buildingMaterial[2], 0, 6, 3, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, buildingMaterial[2], 0, 0, 2, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, buildingMaterial[2], 0, 0, 2, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, buildingMaterial[2], 0, 0, 3, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, buildingMaterial[2], 0, 0, 3, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, buildingMaterial[2], 0, 8, 2, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, buildingMaterial[2], 0, 8, 2, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, buildingMaterial[2], 0, 8, 3, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, buildingMaterial[2], 0, 8, 3, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, buildingMaterial[2], 0, 3, 2, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, buildingMaterial[2], 0, 5, 2, 5, par3StructureBoundingBox);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 4, 1, 7, 4, 4, buildingMaterial[3], buildingMaterial[3], false);
		//Walls End

		//Clocks Start
		this.placeDoubleClockAtCurrentPosition(par1World, 4, 1, 4);
		this.placeSignWithTextAtCurrentPosition(par1World, 4, 3, 4, new String[] {"", "Price:", "200$", ""});

		this.placeClockAtCurrentPosition(par1World, 2, 2, 4);
		this.placeSignWithTextAtCurrentPosition(par1World, 2, 3, 4, new String[] {"", "Price:", "100$", ""});

		this.placeModernClockAtCurrentPosition(par1World, 6, 2, 4);
		this.placeSignWithTextAtCurrentPosition(par1World, 6, 3, 4, new String[] {"", "Price:", "25$", ""});
		//Clocks End

		//Counter Start
		this.placeBlockAtCurrentPosition(par1World, buildingMaterial[3], 0, 6, 1, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.trapdoor, 11, 6, 1, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.trapdoor, 10, 7, 1, 2, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, Blocks.iron_bars, 0, 6, 3, 2, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.iron_bars, 0, 6, 3, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.iron_bars, 0, 7, 3, 2, par3StructureBoundingBox);

		this.placeBlockAtCurrentPosition(par1World, Blocks.flower_pot, 11, 6, 2, 2, par3StructureBoundingBox);
		//Counter End

		//Easteregg Start DONT TELL ANYONE!
		this.placeSignWithTextAtCurrentPosition(par1World, 7, 5, 1, new String[] {"Here, have", "a cookie!", "You", "rock!"});
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
		this.placeSignWithTextAtCurrentPosition(par1World, 1, 3, -1, new String[] {"", "Horologist", "", ""});
		//Outside Sign End

		for (l = 0; l < 6; ++l) {
			for (int i1 = 0; i1 < 9; ++i1) {
				this.clearCurrentPositionBlocksUpwards(par1World, i1, 9, l, par3StructureBoundingBox);
				this.func_151554_b(par1World, buildingMaterial[0], 0, i1, -1, l, par3StructureBoundingBox);
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

	protected boolean placeSignWithTextAtCurrentPosition(World world, int x, int y, int z, String[] text) {
		int m = getCustomMetaOffset();
		int placeX = this.getXWithOffset(x, z);
		int placeY = this.getYWithOffset(y);
		int placeZ = this.getZWithOffset(x, z);
		world.setBlock(placeX, placeY, placeZ, Blocks.wall_sign, m, 2);
		TileEntitySign tilesign = (TileEntitySign) world.getTileEntity(placeX, placeY, placeZ);
		if (tilesign != null) {
			for(int i = 0; i < text.length; i++) {
				tilesign.signText[i] = text[i];
			}
		}
		return true;
	}

	///tp empty2k12 -693 5 1884
	
	protected boolean placeDoubleClockAtCurrentPosition(World world, int x, int y, int z) {
		int woodType = world.rand.nextInt(6);
		this.placeBlockAtCurrentPosition(world, ClockBlocks.clock_bottom, woodType, x, y, z, getBoundingBox());
		this.placeBlockAtCurrentPosition(world, ClockBlocks.clock_top, woodType, x, y + 1, z, getBoundingBox());
		int placeX = this.getXWithOffset(x, z);
		int placeY = this.getYWithOffset(y);
		int placeZ = this.getZWithOffset(x, z);
		world.setTileEntity(placeX, placeY + 1, placeZ, new TileDoubleClock());
        TileDoubleClock tileDoubleClock = (TileDoubleClock) world.getTileEntity(placeX, placeY + 1, placeZ);
        if (tileDoubleClock != null) {
            tileDoubleClock.setOrientation(this.coordBaseMode);
        }
		return true;
	}

	protected boolean placeClockAtCurrentPosition(World world, int x, int y, int z) {
		int woodType = world.rand.nextInt(6);
		this.placeBlockAtCurrentPosition(world, ClockBlocks.clock, woodType, x, y, z, getBoundingBox());
		int placeX = this.getXWithOffset(x, z);
		int placeY = this.getYWithOffset(y);
		int placeZ = this.getZWithOffset(x, z);
		world.setTileEntity(placeX, placeY, placeZ, new TileWoodenClock());
		TileWoodenClock tileDoubleClock = (TileWoodenClock) world.getTileEntity(placeX, placeY, placeZ);
        if (tileDoubleClock != null) {
            tileDoubleClock.setOrientation(this.coordBaseMode);
        }
		return true;
	}

	protected boolean placeModernClockAtCurrentPosition(World world, int x, int y, int z) {
		int m = this.getCustomMetaOffset();
		this.placeBlockAtCurrentPosition(world, ClockBlocks.modern_clock, m, x, y, z, getBoundingBox());
		int placeX = this.getXWithOffset(x, z);
		int placeY = this.getYWithOffset(y);
		int placeZ = this.getZWithOffset(x, z);
		world.setTileEntity(placeX, placeY, placeZ, new TileModernClock());
		return true;
	}

	public int getCustomMetaOffset() {
		switch (this.coordBaseMode) {
		case 0:
			return 2;
		case 1:
			return 5;
		case 3:
			return 4;
		case 2:
			return 3;
		default:
			return 5;
		}
	}
	
}
