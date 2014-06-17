package de.empty2k12.fancyclocks.common.block;

import cpw.mods.fml.common.registry.GameRegistry;
import de.empty2k12.fancyclocks.common.block.blocks.BlockClock;
import de.empty2k12.fancyclocks.common.block.blocks.BlockModernClock;
import de.empty2k12.fancyclocks.common.block.blocks.DoubleClock.BlockDoubleClockBottom;
import de.empty2k12.fancyclocks.common.block.blocks.DoubleClock.BlockDoubleClockTop;
import de.empty2k12.fancyclocks.common.block.tile.TileClock;
import de.empty2k12.fancyclocks.common.block.tile.TileDoubleClock;
import de.empty2k12.fancyclocks.common.block.tile.TileModernClock;
import de.empty2k12.fancyclocks.common.item.items.block.ItemBlockClock;
import de.empty2k12.fancyclocks.common.item.items.block.ItemBlockDoubleClock;
import net.minecraft.block.Block;

public class ClockBlocks {
	
	public static Block clock;
	public static Block modern_clock;
	
	public static Block clock_top;
	public static Block clock_bottom;
	
	public static void init() {
		clock = new BlockClock();
		GameRegistry.registerBlock(clock, ItemBlockClock.class, "clock");
		
		modern_clock = new BlockModernClock();
		GameRegistry.registerBlock(modern_clock, "modern_clock");
		
		clock_top = new BlockDoubleClockTop();
		GameRegistry.registerBlock(clock_top, "clock_top");
		
		clock_bottom = new BlockDoubleClockBottom();
		GameRegistry.registerBlock(clock_bottom, ItemBlockDoubleClock.class, "clock_bottom");
		
		registerTileEntities();
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileClock.class, "tileClock");
		GameRegistry.registerTileEntity(TileDoubleClock.class, "tileDoubleClockTop");
		GameRegistry.registerTileEntity(TileModernClock.class, "tileModernClock");
	}

}
