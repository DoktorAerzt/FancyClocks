package de.empty2k12.fancyclocks.common.block;

import cpw.mods.fml.common.registry.GameRegistry;
import de.empty2k12.fancyclocks.common.block.clocks.double_clock.BlockDoubleClockBottom;
import de.empty2k12.fancyclocks.common.block.clocks.double_clock.BlockDoubleClockTop;
import de.empty2k12.fancyclocks.common.block.clocks.double_clock.TileDoubleClock;
import de.empty2k12.fancyclocks.common.block.clocks.modern_clock.BlockModernClock;
import de.empty2k12.fancyclocks.common.block.clocks.modern_clock.TileModernClock;
import de.empty2k12.fancyclocks.common.block.clocks.wooden_clock.BlockWoodenClock;
import de.empty2k12.fancyclocks.common.block.clocks.wooden_clock.TileWoodenClock;
import de.empty2k12.fancyclocks.common.item.items.block.ItemBlockClock;
import de.empty2k12.fancyclocks.common.item.items.block.ItemBlockDoubleClock;
import net.minecraft.block.Block;

public class ClockBlocks {
	
	public static Block clock;
	public static Block modern_clock;
	
	public static Block clock_top;
	public static Block clock_bottom;
	
	public static void init() {
		clock = new BlockWoodenClock();
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
		GameRegistry.registerTileEntity(TileWoodenClock.class, "tileClock");
		GameRegistry.registerTileEntity(TileDoubleClock.class, "tileDoubleClockTop");
		GameRegistry.registerTileEntity(TileModernClock.class, "tileModernClock");
	}

}
