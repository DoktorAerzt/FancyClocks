package de.empty2k12.fancyclocks.client.renderer;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import de.empty2k12.fancyclocks.client.model.ModelClock;
import de.empty2k12.fancyclocks.common.misc.ModInfo;

public class RenderClock extends TileEntitySpecialRenderer {
	
	public static final ResourceLocation texture = new ResourceLocation(ModInfo.MOD_ID + "");
	
	public ModelClock model;
	
	public RenderClock() {
		model = new ModelClock();
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float var8) {
		//TODO: improve/pointer
		GL11.glPushMatrix();
		
			GL11.glColor4f(1F, 1F, 1F, 1f);
			GL11.glTranslated((float) x + 0.5, (float) y + 0.85, (float) z + 0.5);
			GL11.glRotatef(180F, 0F, 0F, 5F);
		
			bindTexture(texture);
		
			GL11.glPopMatrix();
			this.model.renderBlock(0.0625F);
			GL11.glPopMatrix();
		
		GL11.glPopMatrix();
	}

}
