package de.empty2k12.fancyclocks.client.renderer.item;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import de.empty2k12.fancyclocks.client.renderer.RenderClock;
import de.empty2k12.fancyclocks.common.block.tile.TileClock;

public class ItemRenderClock implements IItemRenderer {

	private final TileEntitySpecialRenderer renderer;
	private TileClock dummytile;

	public ItemRenderClock(){
		this.renderer = new RenderClock();
	}

	@Override
	public boolean handleRenderType(ItemStack itemStack, ItemRenderType type) {
		return type == ItemRenderType.INVENTORY;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper){
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data){
		this.renderer.renderTileEntityAt(dummytile, 0F, 0F, 0F, 0F);
	}
	
}