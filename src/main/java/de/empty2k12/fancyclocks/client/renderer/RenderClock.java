package de.empty2k12.fancyclocks.client.renderer;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import de.empty2k12.fancyclocks.client.model.ModelClock;
import de.empty2k12.fancyclocks.common.misc.ModInfo;

public class RenderClock extends TileEntitySpecialRenderer {

	public static final ResourceLocation texture = new ResourceLocation(ModInfo.MOD_ID + ":" + "textures/model/clock1.png");

	public ModelClock model;

	public RenderClock() {
		model = new ModelClock();
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float var8) {
		//TODO: improve/pointer
		int meta = tile.getBlockMetadata();

		int rotationAngle = 0;

		switch(meta % 4){
		case 0:
			rotationAngle = 90;
			break;
		case 1:
			rotationAngle = 270;
			break;
		case 2:
			rotationAngle = 0;
			break;
		case 3:
			rotationAngle = 180;
			break;
		}

		GL11.glPushMatrix();

		GL11.glTranslated((float) x + 0.5, (float) y + 0.2, (float) z + 0.5);
		GL11.glRotatef(rotationAngle, 0.0F, 1.0F, 0.0F);	
		GL11.glTranslatef(0.0F, 0.1F, 0.4375F);
		GL11.glScalef(1.0F, -1F, -1F);

		bindTexture(texture);

		GL11.glPushMatrix();
		this.model.renderBlock(0.0625F);
		GL11.glPopMatrix();

		drawTimePointers();

		GL11.glPopMatrix();
	}

	public static void drawTimePointers() {
		Double d1 = 64.0D;
		Double d2 = 32.0D;
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(d1, -d2, 1.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV(-d1, -d2, 0.9D, 1.0D, 1.0D);
		tessellator.addVertexWithUV(-d1, d2, 0.9D, 1.0D, 0.0D);
		tessellator.addVertexWithUV(d1, d2, 0.9D, 0.0D, 0.0D);
		tessellator.draw();
	}
}
