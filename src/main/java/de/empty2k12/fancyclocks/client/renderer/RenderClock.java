package de.empty2k12.fancyclocks.client.renderer;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import de.empty2k12.fancyclocks.client.model.ModelClock;
import de.empty2k12.fancyclocks.common.block.tile.TileClock;

/*
 * Does not need to be registered, because its only used as a subclass..
 * */
public class RenderClock extends TileEntitySpecialRenderer {
	
	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8) {
		//Non op
	}

	public static void drawSecondPointer(TileClock tile, int meta) {
		GL11.glPushMatrix();
		GL11.glRotatef(tile.getRotationFromSeconds(), 0.0f, 0.0f, 1.0f);
		Tessellator secondTess = Tessellator.instance;
		secondTess.startDrawing(GL11.GL_LINE_STRIP);
		secondTess.setColorRGBA(getColorForMeta(meta), getColorForMeta(meta), getColorForMeta(meta), 100);
		secondTess.addVertex(-0.01, 0.01, 0.15D);
		secondTess.addVertex(-0.01, -0.15, 0.15D);
		secondTess.addVertex(0.0, -0.15, 0.15D);
		secondTess.addVertex(0.0, 0.01, 0.15D);
		secondTess.draw();
		GL11.glPopMatrix();
	}

	public static void drawMinutePointer(TileClock tile, int meta) {
		GL11.glPushMatrix();
		GL11.glRotatef(tile.getRotationFromMinutes(), 0.0f, 0.0f, 1.0f);
		Tessellator minuteTess = Tessellator.instance;
		minuteTess.startDrawing(GL11.GL_LINE_STRIP);
		minuteTess.setColorRGBA(getColorForMeta(meta), getColorForMeta(meta), getColorForMeta(meta), 100);
		minuteTess.addVertex(-0.01, 0.01, 0.15D);
		minuteTess.addVertex(-0.01, -0.12, 0.15D);
		minuteTess.addVertex(0.0, -0.12, 0.15D);
		minuteTess.addVertex(0.0, 0.01, 0.15D);
		minuteTess.draw();
		GL11.glPopMatrix();
	}

	public static void drawHourPointer(TileClock tile, int meta) {
		GL11.glPushMatrix();
		GL11.glRotatef(tile.getRotationFromHours(), 0.0f, 0.0f, 1.0f);
		Tessellator hourTess = Tessellator.instance;
		hourTess.startDrawing(GL11.GL_LINE_STRIP);
		hourTess.setColorRGBA(getColorForMeta(meta), getColorForMeta(meta), getColorForMeta(meta), 100);
		hourTess.addVertex(-0.01, 0.01, 0.15D);
		hourTess.addVertex(-0.01, -0.10, 0.15D);
		hourTess.addVertex(0.0, -0.10, 0.15D);
		hourTess.addVertex(0.0, 0.01, 0.15D);
		hourTess.draw();
		GL11.glPopMatrix();
	}

	public void bindTextureBasedOnMeta(int meta) {
		if (meta >= 0) {
			bindTexture(ModelClock.textures[meta]);
		}
	}
	
	public static int getColorForMeta(int meta) {
		if(meta == 0)
			return 255;
		return meta == 2 || meta == 6 ? 0 : 255;
	}

}
