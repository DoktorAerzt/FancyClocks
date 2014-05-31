package de.empty2k12.fancyclocks.client.renderer.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import de.empty2k12.fancyclocks.client.model.ModelClock;

public class ItemRenderClock implements IItemRenderer {

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		GL11.glPushMatrix();
		
		GL11.glScalef(1, -1, -1);

		if(type == ItemRenderType.FIRST_PERSON_MAP || type == ItemRenderType.EQUIPPED || type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
			GL11.glScalef(5f, 5f, 5f);
			GL11.glRotatef(199, 0, 1, 0);
		} else if (type == ItemRenderType.ENTITY) {
			GL11.glScalef(5f, 5f, 5f);
			GL11.glTranslated(0F, -0.01F, 0F);
		} else if (type == ItemRenderType.INVENTORY) {
			GL11.glScalef(4f, 4f, 4f);
			GL11.glRotatef(90f, 0f, 1f, 0f);
			GL11.glTranslatef(0f, 0.11f, 0f);
		}
		
		new ModelClock().renderModel(0.025F);
		GL11.glPopMatrix();
	}
}