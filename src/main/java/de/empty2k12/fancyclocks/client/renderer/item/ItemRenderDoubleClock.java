package de.empty2k12.fancyclocks.client.renderer.item;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import de.empty2k12.fancyclocks.client.model.ModelClock;
import de.empty2k12.fancyclocks.client.model.ModelDoubleClock;
import de.empty2k12.fancyclocks.client.renderer.RenderDoubleClock;

public class ItemRenderDoubleClock implements IItemRenderer {

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

		if(type == ItemRenderType.FIRST_PERSON_MAP || type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
			GL11.glScalef(2f, 2f, 2f);
			GL11.glRotatef(30, 0, 1, 0);
			GL11.glTranslatef(-0.0f, -0.7f, -0.3f);
		} else if (type == ItemRenderType.ENTITY) {
			GL11.glScalef(5f, 5f, 5f);
			GL11.glTranslated(0F, -0.5F, 0F);
		} else if (type == ItemRenderType.INVENTORY) {
			GL11.glScalef(1.9f, 1.9f, 1.9f);
			GL11.glRotatef(290f, 0f, 1f, 0f);
			GL11.glTranslatef(-0.05f, -0.18f, 0f);
		} else if (type == ItemRenderType.EQUIPPED) {
			GL11.glScalef(5f, 5f, 5f);
			GL11.glRotatef(180, 0, 1, 0);
			GL11.glTranslatef(-0.2f, -0.3f, 0.105f);
		}
		bindTextureBasedOnMeta(item.getItemDamage());
		new ModelDoubleClock().renderModel(0.025F);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		bindTexture(RenderDoubleClock.texture);
		new ModelDoubleClock().renderOtherStuffs(0.025F);
		GL11.glDisable(GL11.GL_BLEND);

		GL11.glPopMatrix();
	}

	public void bindTextureBasedOnMeta(int meta) {
		if (meta >= 0) {
			bindTexture(ModelClock.textures[meta]);
		}
	}

	public static void bindTexture(ResourceLocation texture) {
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
	}
}