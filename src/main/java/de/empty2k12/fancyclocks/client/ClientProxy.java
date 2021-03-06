package de.empty2k12.fancyclocks.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import de.empty2k12.fancyclocks.client.renderer.block.RenderDoubleClock;
import de.empty2k12.fancyclocks.client.renderer.block.RenderModernClock;
import de.empty2k12.fancyclocks.client.renderer.block.RenderWoodenClock;
import de.empty2k12.fancyclocks.client.renderer.item.ItemRenderClock;
import de.empty2k12.fancyclocks.client.renderer.item.ItemRenderDoubleClock;
import de.empty2k12.fancyclocks.client.renderer.item.ItemRenderModernClock;
import de.empty2k12.fancyclocks.common.block.ClockBlocks;
import de.empty2k12.fancyclocks.common.block.clocks.double_clock.TileDoubleClock;
import de.empty2k12.fancyclocks.common.block.clocks.modern_clock.TileModernClock;
import de.empty2k12.fancyclocks.common.block.clocks.wooden_clock.TileWoodenClock;
import de.empty2k12.fancyclocks.common.misc.Config;
import de.empty2k12.fancyclocks.common.misc.ModInfo;
import de.empty2k12.fancyclocks.common.proxy.CommonProxy;
import de.empty2k12.fancyclocks.common.world.gen.village.VillageHandlerHorologist;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		TileEntitySpecialRenderer renderClock = new RenderWoodenClock();
		ClientRegistry.bindTileEntitySpecialRenderer(TileWoodenClock.class, renderClock);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ClockBlocks.clock), new ItemRenderClock());

		TileEntitySpecialRenderer renderModernClock = new RenderModernClock();
		ClientRegistry.bindTileEntitySpecialRenderer(TileModernClock.class, renderModernClock);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ClockBlocks.modern_clock), new ItemRenderModernClock());

		TileEntitySpecialRenderer renderDoubleClock = new RenderDoubleClock();
		ClientRegistry.bindTileEntitySpecialRenderer(TileDoubleClock.class, renderDoubleClock);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ClockBlocks.clock_bottom), new ItemRenderDoubleClock());
	}

	@Override
	public void setupVillagers() {
		if(Config.ENABLE_HOROLOGIST)
			VillagerRegistry.instance().registerVillagerSkin(VillageHandlerHorologist.HOROLOGIST_ID, new ResourceLocation(ModInfo.MOD_ID, "textures/entity/villager/horologist.png"));
	}

}
