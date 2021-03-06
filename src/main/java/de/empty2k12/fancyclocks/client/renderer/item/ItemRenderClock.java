package de.empty2k12.fancyclocks.client.renderer.item;

import de.empty2k12.fancyclocks.client.model.ModelClock;
import de.empty2k12.fancyclocks.client.renderer.block.RenderWoodenClock;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

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
		
		bindTexture(RenderWoodenClock.texture);
		new ModelClock().renderIndicators(0.025F);
		bindTextureBasedOnMeta(item.getItemDamage());
		new ModelClock().renderCorpse(0.025F);
		GL11.glTranslatef(0.0F, 0.0F, 0.0001F);
		new ModelClock().renderRoof1(0.025F);
		GL11.glTranslatef(0.0F, 0.0F, 0.000001F);
		new ModelClock().renderRoof2(0.025F);

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