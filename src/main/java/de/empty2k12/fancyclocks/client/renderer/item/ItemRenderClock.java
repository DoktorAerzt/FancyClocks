package de.empty2k12.fancyclocks.client.renderer.item;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import de.empty2k12.fancyclocks.client.model.ModelClock;
import de.empty2k12.fancyclocks.common.block.Blocks;

public class ItemRenderClock implements IItemRenderer {

	private final ModelClock model;

	public ItemRenderClock(){
		this.model = new ModelClock();
	}

	@Override
	public boolean handleRenderType(ItemStack itemStack, ItemRenderType type) {
		return type == ItemRenderType.INVENTORY;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper){
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data){
		TileEntityRenderer.instance.renderTileEntityAt(new TileEntityEngine(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
}