package de.empty2k12.fancyclocks.client;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import de.empty2k12.fancyclocks.client.renderer.RenderClock;
import de.empty2k12.fancyclocks.client.renderer.RenderDoubleClock;
import de.empty2k12.fancyclocks.client.renderer.RenderModernClock;
import de.empty2k12.fancyclocks.client.renderer.item.ItemRenderClock;
import de.empty2k12.fancyclocks.client.renderer.item.ItemRenderDoubleClock;
import de.empty2k12.fancyclocks.common.block.ClockBlocks;
import de.empty2k12.fancyclocks.common.block.tile.TileClock;
import de.empty2k12.fancyclocks.common.block.tile.TileDoubleClockTop;
import de.empty2k12.fancyclocks.common.block.tile.TileModernClock;
import de.empty2k12.fancyclocks.common.proxy.CommonProxy;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		TileEntitySpecialRenderer renderClock = new RenderClock();
		ClientRegistry.bindTileEntitySpecialRenderer(TileClock.class, renderClock);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ClockBlocks.clock), new ItemRenderClock());

		TileEntitySpecialRenderer renderModernClock = new RenderModernClock();
		ClientRegistry.bindTileEntitySpecialRenderer(TileModernClock.class, renderModernClock);

		TileEntitySpecialRenderer renderDoubleClock = new RenderDoubleClock();
		ClientRegistry.bindTileEntitySpecialRenderer(TileDoubleClockTop.class, renderDoubleClock);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ClockBlocks.clock_top), new ItemRenderDoubleClock(renderDoubleClock, new TileDoubleClockTop()));
	}

}
