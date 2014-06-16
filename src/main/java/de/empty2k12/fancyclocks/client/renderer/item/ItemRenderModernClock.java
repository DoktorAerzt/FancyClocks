package de.empty2k12.fancyclocks.client.renderer.item;

import de.empty2k12.fancyclocks.client.model.ModelModernClock;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class ItemRenderModernClock implements IItemRenderer {

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
		
		bindTexture("textures/model/modernClock1.png");

		if(type == ItemRenderType.FIRST_PERSON_MAP || type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
			GL11.glScalef(5f, 5f, 5f);
			GL11.glRotatef(15, 0, 1, 0);
			GL11.glTranslatef(-0.1f, -0.3f, -0.1f);
		} else if (type == ItemRenderType.ENTITY) {
			GL11.glScalef(5f, 5f, 5f);
			GL11.glTranslated(0F, -0.3F, 0F);
		} else if (type == ItemRenderType.INVENTORY) {
			GL11.glScalef(4f, 4f, 4f);
			GL11.glRotatef(90f, 0f, 1f, 0f);
			GL11.glTranslatef(-0.05f, -0.12f, 0f);
		} else if (type == ItemRenderType.EQUIPPED) {
			GL11.glScalef(5f, 5f, 5f);
			GL11.glRotatef(180, 0, 1, 0);
			GL11.glTranslatef(-0.2f, -0.1f, 0.105f);
		}
		new ModelModernClock().renderModel(0.025F);
		GL11.glPopMatrix();
	}

	public static void bindTexture(String texture) {
		ResourceLocation rl =  new ResourceLocation("fancyclocks", texture);
		Minecraft.getMinecraft().renderEngine.bindTexture(rl);
	}
}