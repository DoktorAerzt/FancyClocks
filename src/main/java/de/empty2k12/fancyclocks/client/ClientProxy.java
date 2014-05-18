package de.empty2k12.fancyclocks.client;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Items;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import de.empty2k12.fancyclocks.client.renderer.RenderClock;
import de.empty2k12.fancyclocks.client.renderer.RenderDoubleClock;
import de.empty2k12.fancyclocks.client.renderer.item.ItemRenderClock;
import de.empty2k12.fancyclocks.common.block.tile.TileClock;
import de.empty2k12.fancyclocks.common.block.tile.TileDoubleClockTop;
import de.empty2k12.fancyclocks.common.proxy.CommonProxy;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		TileEntitySpecialRenderer renderClock = new RenderClock();
		ClientRegistry.bindTileEntitySpecialRenderer(TileClock.class, renderClock);
		//MinecraftForgeClient.registerItemRenderer(Items.clock, new ItemRenderClock());
		
		TileEntitySpecialRenderer renderDoubleClock = new RenderDoubleClock();
		ClientRegistry.bindTileEntitySpecialRenderer(TileDoubleClockTop.class, renderDoubleClock);
	}
	
}
