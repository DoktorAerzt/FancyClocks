package de.empty2k12.fancyclocks.client.renderer;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import de.empty2k12.fancyclocks.client.model.ModelClock;
import de.empty2k12.fancyclocks.client.model.ModelDoubleClock;
import de.empty2k12.fancyclocks.common.block.tile.TileClock;
import de.empty2k12.fancyclocks.common.block.tile.TileDoubleClock;
import de.empty2k12.fancyclocks.common.misc.ModInfo;

public class RenderDoubleClock extends TileEntitySpecialRenderer {

	private ModelDoubleClock model;

	public static ResourceLocation texture = new ResourceLocation(ModInfo.MOD_ID + ":" + "textures/model/doubleClock1.png");

	public RenderDoubleClock() {
		model = new ModelDoubleClock();
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float var8) {

		int rotationAngle = 0;

		switch(((TileDoubleClock)tile).getOrientation()){
		case 0:
			rotationAngle = 0;
			break;
		case 1:
			rotationAngle = -90;
			break;
		case 2:
			rotationAngle = 180;
			break;
		case 3:
			rotationAngle = 90;
			break;
		}

		GL11.glPushMatrix();

		GL11.glTranslated((float) x + 0.5, (float) y + 0.45, (float) z + 0.5);
		GL11.glRotatef(rotationAngle + 180F, 0.0F, 1.0F, 0.0F);
		GL11.glScalef(1.1F, -1.1F, -1.1F);

		bindTextureBasedOnMeta(tile.getBlockMetadata());
		this.model.renderModel(0.0625F);

		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_NORMALIZE);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_DITHER);

		GL11.glShadeModel(GL11.GL_SMOOTH);
		GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		GL11.glDepthFunc(GL11.GL_LEQUAL);
		GL11.glEnable(GL11.GL_DEPTH_TEST);

		bindTexture(texture);
		this.model.renderOtherStuffs(0.0625F);
		GL11.glDisable(GL11.GL_BLEND);

		GL11.glTranslatef(0.01F, -0.055F, -0.3F);
		drawSecondPointer((TileDoubleClock)tile);
		drawMinutePointer((TileDoubleClock)tile);
		drawHourPointer((TileDoubleClock)tile);
		GL11.glTranslatef(-0.01F, 0.055F, 0.3F);

		GL11.glPopMatrix();
	}

	public static void drawSecondPointer(TileDoubleClock tile) {
		GL11.glPushMatrix();
		GL11.glRotatef(tile.getRotationFromSeconds(), 0.0f, 0.0f, 1.0f);
		Tessellator secondTess = Tessellator.instance;
		secondTess.startDrawing(GL11.GL_LINE_STRIP);
		secondTess.setBrightness(1000);
		secondTess.setColorRGBA(255, 0, 0, 100);
		secondTess.setTranslation(0, 0, 0);
		secondTess.addVertex(-0.02, 0.01, 0.15D);
		secondTess.addVertex(-0.02, -0.2, 0.15D);
		secondTess.addVertex(0.0, -0.2, 0.15D);
		secondTess.addVertex(0.0, 0.01, 0.15D);
		secondTess.draw();
		GL11.glPopMatrix();
	}

	public static void drawMinutePointer(TileDoubleClock tile) {
		GL11.glPushMatrix();
		GL11.glRotatef(tile.getRotationFromMinutes(), 0.0f, 0.0f, 1.0f);
		Tessellator minuteTess = Tessellator.instance;
		minuteTess.startDrawing(GL11.GL_LINE_STRIP);
		minuteTess.setBrightness(1000);
		minuteTess.setColorRGBA(0, 0, 255, 100);
		minuteTess.addVertex(-0.02, 0.01, 0.15D);
		minuteTess.addVertex(-0.02, -0.16, 0.15D);
		minuteTess.addVertex(0.0, -0.16, 0.15D);
		minuteTess.addVertex(0.0, 0.01, 0.15D);
		minuteTess.draw();
		GL11.glPopMatrix();
	}

	public static void drawHourPointer(TileDoubleClock tile) {
		GL11.glPushMatrix();
		GL11.glRotatef(tile.getRotationFromHours(), 0.0f, 0.1f, 1.0f);
		Tessellator hourTess = Tessellator.instance;
		hourTess.startDrawing(GL11.GL_LINE_STRIP);
		hourTess.setBrightness(1000);
		hourTess.setColorRGBA(0, 255, 0, 100);
		hourTess.addVertex(-0.02, 0.01, 0.15D);
		hourTess.addVertex(-0.02, -0.15, 0.15D);
		hourTess.addVertex(0.0, -0.15, 0.15D);
		hourTess.addVertex(0.0, 0.01, 0.15D);
		hourTess.draw();
		GL11.glPopMatrix();
	}

	public static void drawPendel(TileDoubleClock tile) {
		GL11.glPushMatrix();
		GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
		Tessellator pendelTess = Tessellator.instance;
		pendelTess.startDrawing(GL11.GL_LINE_STRIP);
		pendelTess.setBrightness(100);
		pendelTess.setColorRGBA(255, 0, 0, 100);
		pendelTess.addVertexWithUV(-0.1, 0.01, 0.15D, 1D, 1D);
		pendelTess.addVertexWithUV(-0.1, -1.2, 0.15D, 1D, 1D);
		pendelTess.addVertexWithUV(0.0, -1.2, 0.15D, 1D, 1D);
		pendelTess.addVertexWithUV(0.0, 0.01, 0.15D, 1D, 1D);
		pendelTess.draw();
		GL11.glPopMatrix();
	}

	public void bindTextureBasedOnMeta(int meta) {
		bindTexture(ModelDoubleClock.textures[meta]);
	}
}