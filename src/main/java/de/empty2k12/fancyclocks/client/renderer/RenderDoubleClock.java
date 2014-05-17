package de.empty2k12.fancyclocks.client.renderer;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import de.empty2k12.fancyclocks.client.model.ModelDoubleClock;
import de.empty2k12.fancyclocks.common.block.tile.TileClock;
import de.empty2k12.fancyclocks.common.block.tile.TileDoubleClockTop;
import de.empty2k12.fancyclocks.common.misc.ModInfo;

public class RenderDoubleClock extends TileEntitySpecialRenderer {

	private ModelDoubleClock model;

	private ResourceLocation texture = new ResourceLocation(ModInfo.MOD_ID + ":" + "textures/model/doubleClock1.png");

	public RenderDoubleClock() {
		model = new ModelDoubleClock();
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float var8) {

		int rotationAngle = 0;

		switch(((TileDoubleClockTop)tile).direction){
		case 0:
			rotationAngle = 180;
			break;
		case 1:
			rotationAngle = 90;
			break;
		case 2:
			rotationAngle = 0;
			break;
		case 3:
			rotationAngle = -90;
			break;
		}

		GL11.glPushMatrix();

		GL11.glTranslated((float) x + 0.5, (float) y + 0.5, (float) z + 0.5);
		GL11.glRotatef(rotationAngle, 0.0F, 1.0F, 0.0F);
		GL11.glScalef(1.0F, -1F, -1F);

		bindTexture(texture);

		this.model.renderModel(0.0625F);
		
		GL11.glTranslatef(0F, -0.13F, -0.3F);

		//TODO: if i have time: show indicators for numbers
		drawSecondPointer((TileDoubleClockTop)tile);
		drawMinutePointer((TileDoubleClockTop)tile);
		drawHourPointer((TileDoubleClockTop)tile);
		
		drawPendel((TileDoubleClockTop)tile);

		GL11.glPopMatrix();
	}
	
	public static void drawPendel(TileDoubleClockTop tile) {
		GL11.glPushMatrix();
		GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
		Tessellator pendelTess = Tessellator.instance;
		pendelTess.startDrawing(GL11.GL_LINE_STRIP);
		pendelTess.setBrightness(1);
		pendelTess.addVertexWithUV(-0.1, 0.01, 0.15D, 1D, 1D);
		pendelTess.addVertexWithUV(-0.1, -0.17, 0.15D, 1D, 1D);
		pendelTess.addVertexWithUV(0.0, -0.17, 0.15D, 1D, 1D);
		pendelTess.addVertexWithUV(0.0, 0.01, 0.15D, 1D, 1D);
		pendelTess.draw();
		GL11.glPopMatrix();
	}

	public static void drawSecondPointer(TileDoubleClockTop tile) {
		GL11.glPushMatrix();
		GL11.glRotatef(tile.getRotationFromSeconds(), 0.0f, 0.0f, 1.0f);
		Tessellator secondTess = Tessellator.instance;
		secondTess.startDrawing(GL11.GL_LINE_STRIP);
		secondTess.setBrightness(1);
		secondTess.addVertex(-0.02, 0.01, 0.15D);
		secondTess.addVertex(-0.02, -0.17, 0.15D);
		secondTess.addVertex(0.0, -0.17, 0.15D);
		secondTess.addVertex(0.0, 0.01, 0.15D);
		secondTess.draw();
		GL11.glPopMatrix();
	}

	public static void drawMinutePointer(TileDoubleClockTop tile) {
		GL11.glPushMatrix();
		GL11.glRotatef(tile.getRotationFromMinutes(), 0.0f, 0.0f, 1.0f);
		Tessellator minuteTess = Tessellator.instance;
		minuteTess.startDrawing(GL11.GL_LINE_STRIP);
		minuteTess.setBrightness(1);
		minuteTess.addVertex(-0.02, 0.01, 0.15D);
		minuteTess.addVertex(-0.02, -0.14, 0.15D);
		minuteTess.addVertex(0.0, -0.14, 0.15D);
		minuteTess.addVertex(0.0, 0.01, 0.15D);
		minuteTess.draw();
		GL11.glPopMatrix();
	}

	public static void drawHourPointer(TileDoubleClockTop tile) {
		GL11.glPushMatrix();
		GL11.glRotatef(tile.getRotationFromHours(), 0.0f, 0.0f, 1.0f);
		Tessellator hourTess = Tessellator.instance;
		hourTess.startDrawing(GL11.GL_LINE_STRIP);
		hourTess.setBrightness(1);
		hourTess.addVertex(-0.02, 0.01, 0.15D);
		hourTess.addVertex(-0.02, -0.12, 0.15D);
		hourTess.addVertex(0.0, -0.12, 0.15D);
		hourTess.addVertex(0.0, 0.01, 0.15D);
		hourTess.draw();
		GL11.glPopMatrix();
	}
}
