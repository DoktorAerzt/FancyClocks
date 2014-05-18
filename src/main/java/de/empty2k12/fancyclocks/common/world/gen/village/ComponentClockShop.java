package de.empty2k12.fancyclocks.common.world.gen.village;

import java.util.List;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;

public class ComponentClockShop extends StructureVillagePieces.Village{

	public ComponentClockShop() {}

	public ComponentClockShop(StructureVillagePieces.Start par1ComponentVillageStartPiece, int par2, Random par3Random, StructureBoundingBox par4StructureBoundingBox, int par5)
	{
		super(par1ComponentVillageStartPiece, par2);
		this.coordBaseMode = par5;
		this.boundingBox = par4StructureBoundingBox;
	}

	/**
	 * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
	 * Mineshafts at the end, it adds Fences...
	 */
	public boolean addComponentParts(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox)
	{
		if (this.field_143015_k < 0)
		{
			this.field_143015_k = this.getAverageGroundLevel(par1World, par3StructureBoundingBox);

			if (this.field_143015_k < 0)
			{
				return true;
			}

			this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 9 - 1, 0);
		}

		this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 1, 1, 7, 5, 4, Blocks.air, Blocks.air, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 0, 0, 8, 0, 5, Blocks.diamond_block, Blocks.diamond_block, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 5, 0, 8, 5, 5, Blocks.diamond_block, Blocks.diamond_block, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 6, 1, 8, 6, 4, Blocks.diamond_block, Blocks.diamond_block, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 7, 2, 8, 7, 3, Blocks.diamond_block, Blocks.diamond_block, false);
		int i = this.getMetadataWithOffset(Blocks.oak_stairs, 3);
		int j = this.getMetadataWithOffset(Blocks.oak_stairs, 2);
		int k;
		int l;

		for (k = -1; k <= 2; ++k)
		{
			for (l = 0; l <= 8; ++l)
			{
				this.placeBlockAtCurrentPosition(par1World, Blocks.oak_stairs, i, l, 6 + k, k, par3StructureBoundingBox);
				this.placeBlockAtCurrentPosition(par1World, Blocks.oak_stairs, j, l, 6 + k, 5 - k, par3StructureBoundingBox);
			}
		}
		
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 1, 0, 0, 1, 5, Blocks.diamond_block, Blocks.diamond_block, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 1, 5, 8, 1, 5, Blocks.diamond_block, Blocks.diamond_block, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 8, 1, 0, 8, 1, 4, Blocks.diamond_block, Blocks.diamond_block, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 2, 1, 0, 7, 1, 0, Blocks.diamond_block, Blocks.diamond_block, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 2, 0, 0, 4, 0, Blocks.diamond_block, Blocks.diamond_block, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 2, 5, 0, 4, 5, Blocks.diamond_block, Blocks.diamond_block, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 8, 2, 5, 8, 4, 5, Blocks.diamond_block, Blocks.diamond_block, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 8, 2, 0, 8, 4, 0, Blocks.diamond_block, Blocks.diamond_block, false);
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
		this.placeBlockAtCurrentPosition(par1World, Blocks.glass_pane, 0, 2, 2, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.glass_pane, 0, 3, 2, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.glass_pane, 0, 5, 2, 5, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.glass_pane, 0, 6, 2, 5, par3StructureBoundingBox);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 4, 1, 7, 4, 1, Blocks.planks, Blocks.planks, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 4, 4, 7, 4, 4, Blocks.planks, Blocks.planks, false);
		this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 3, 4, 7, 3, 4, Blocks.bookshelf, Blocks.bookshelf, false);
		this.placeBlockAtCurrentPosition(par1World, Blocks.planks, 0, 7, 1, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.oak_stairs, this.getMetadataWithOffset(Blocks.oak_stairs, 0), 7, 1, 3, par3StructureBoundingBox);
		k = this.getMetadataWithOffset(Blocks.oak_stairs, 3);
		this.placeBlockAtCurrentPosition(par1World, Blocks.oak_stairs, k, 6, 1, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.oak_stairs, k, 5, 1, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.oak_stairs, k, 4, 1, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.oak_stairs, k, 3, 1, 4, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.fence, 0, 6, 1, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.wooden_pressure_plate, 0, 6, 2, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.fence, 0, 4, 1, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.wooden_pressure_plate, 0, 4, 2, 3, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.crafting_table, 0, 7, 1, 1, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.air, 0, 1, 1, 0, par3StructureBoundingBox);
		this.placeBlockAtCurrentPosition(par1World, Blocks.air, 0, 1, 2, 0, par3StructureBoundingBox);
		this.placeDoorAtCurrentPosition(par1World, par3StructureBoundingBox, par2Random, 1, 1, 0, this.getMetadataWithOffset(Blocks.wooden_door, 1));

		if (this.getBlockAtCurrentPosition(par1World, 1, 0, -1, par3StructureBoundingBox).getMaterial() == Material.air && this.getBlockAtCurrentPosition(par1World, 1, -1, -1, par3StructureBoundingBox).getMaterial() != Material.air)
		{
			this.placeBlockAtCurrentPosition(par1World, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), 1, 0, -1, par3StructureBoundingBox);
		}

		for (l = 0; l < 6; ++l)
		{
			for (int i1 = 0; i1 < 9; ++i1)
			{
				this.clearCurrentPositionBlocksUpwards(par1World, i1, 9, l, par3StructureBoundingBox);
				this.func_151554_b(par1World, Blocks.diamond_block, 0, i1, -1, l, par3StructureBoundingBox);
			}
		}

		this.spawnVillagers(par1World, par3StructureBoundingBox, 2, 1, 2, 1);
		return true;
	}

	/**
	 * Returns the villager type to spawn in this component, based on the number of villagers already spawned.
	 */
	protected int getVillagerType(int par1)
	{
		return 1;
	}

}
