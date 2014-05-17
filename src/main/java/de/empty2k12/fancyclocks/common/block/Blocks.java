package de.empty2k12.fancyclocks.common.block;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import de.empty2k12.fancyclocks.common.block.blocks.BlockClock;
import de.empty2k12.fancyclocks.common.block.blocks.CoubleClock.BlockDoubleClockBottom;
import de.empty2k12.fancyclocks.common.block.blocks.CoubleClock.BlockDoubleClockTop;
import de.empty2k12.fancyclocks.common.block.tile.TileClock;
import de.empty2k12.fancyclocks.common.block.tile.TileDoubleClock;

public class Blocks {
	
	public static Block clock;
	
	public static Block clock_top;
	public static Block clock_bottom;
	
	public static void init() {
		clock = new BlockClock();
		GameRegistry.registerBlock(clock, "clock");
		
		clock_top = new BlockDoubleClockTop();
		GameRegistry.registerBlock(clock_top, "clock_top");
		
		clock_bottom = new BlockDoubleClockBottom();
		GameRegistry.registerBlock(clock_bottom, "clock_bottom");
		
		registerTileEntities();
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileClock.class, "tileClock");
		GameRegistry.registerTileEntity(TileDoubleClock.class, "tileDoubleClock");
	}

}
