package de.empty2k12.fancyclocks.client;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import de.empty2k12.fancyclocks.client.renderer.RenderClock;
import de.empty2k12.fancyclocks.client.renderer.RenderDoubleClock;
import de.empty2k12.fancyclocks.client.renderer.RenderModernClock;
import de.empty2k12.fancyclocks.common.block.tile.TileClock;
import de.empty2k12.fancyclocks.common.block.tile.TileDoubleClockTop;
import de.empty2k12.fancyclocks.common.block.tile.TileModernClock;
import de.empty2k12.fancyclocks.common.proxy.CommonProxy;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		TileEntitySpecialRenderer renderClock = new RenderClock();
		ClientRegistry.bindTileEntitySpecialRenderer(TileClock.class, renderClock);
		//MinecraftForgeClient.registerItemRenderer(Items.clock, new ItemRenderClock());
		
		TileEntitySpecialRenderer renderModernClock = new RenderModernClock();
		ClientRegistry.bindTileEntitySpecialRenderer(TileModernClock.class, renderModernClock);
		
		TileEntitySpecialRenderer renderDoubleClock = new RenderDoubleClock();
		ClientRegistry.bindTileEntitySpecialRenderer(TileDoubleClockTop.class, renderDoubleClock);
	}
	
}
