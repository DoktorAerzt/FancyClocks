package de.empty2k12.fancyclocks.common.block;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import de.empty2k12.fancyclocks.common.block.blocks.BlockClock;
import de.empty2k12.fancyclocks.common.block.tile.TileClock;

public class Blocks {
	
	public static Block clock;
	
	public static void init() {
		clock = new BlockClock();
		GameRegistry.registerBlock(clock, "clock");
		
		registerTileEntities();
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileClock.class, "tileClock");
	}

}
