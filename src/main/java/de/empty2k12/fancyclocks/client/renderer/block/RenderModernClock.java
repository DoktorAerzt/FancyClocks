package de.empty2k12.fancyclocks.client.renderer.block;

import de.empty2k12.fancyclocks.client.model.ModelModernClock;
import de.empty2k12.fancyclocks.client.renderer.RenderClock;
import de.empty2k12.fancyclocks.common.block.clocks.modern_clock.TileModernClock;
import de.empty2k12.fancyclocks.common.misc.ModInfo;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderModernClock extends RenderClock {

	public static final ResourceLocation texture = new ResourceLocation(ModInfo.MOD_ID + ":" + "textures/model/modernClock1.png");

	public ModelModernClock model;

	public RenderModernClock() {
		model = new ModelModernClock();
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float var8) {

		int rotationAngle = 0;

		int meta = tile.getBlockMetadata();

		switch(meta % 4) {
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
		GL11.glTranslated((float) x + 0.5, (float) y  + 0.5, (float) z + 0.5);
		GL11.glRotatef(rotationAngle, 0.0F, 1.0F, 0.0F);
		GL11.glTranslated(-0.3, -0.3, 0.44);

		GL11.glScalef(1.2f, 1.2f, 1.2f);

		bindTexture(texture);

		GL11.glPushMatrix();
		this.model.renderModel(0.0625F);
		GL11.glPopMatrix();

		GL11.glScalef(-1.2f, -1.2f, -1.2f);
		GL11.glTranslatef(-0.20f, -0.22f, -0.28F);

		drawSecondPointer((TileModernClock)tile);
		drawMinutePointer((TileModernClock)tile);
		drawHourPointer((TileModernClock)tile);

		GL11.glPopMatrix();
	}

	public static void drawSecondPointer(TileModernClock tile) {
		GL11.glPushMatrix();
		GL11.glRotatef(tile.getRotationFromSeconds(), 0.0f, 0.0f, 1.0f);
		Tessellator secondTess = Tessellator.instance;
		secondTess.startDrawing(GL11.GL_LINE_STRIP);
		secondTess.setBrightness(1);
		secondTess.addVertex(-0.01, 0.01, 0.3D);
		secondTess.addVertex(-0.01, -0.2, 0.3D);
		secondTess.addVertex(0.0, -0.2, 0.3D);
		secondTess.addVertex(0.0, 0.01, 0.3D);
		secondTess.draw();
		GL11.glPopMatrix();
	}

	public static void drawMinutePointer(TileModernClock tile) {
		GL11.glPushMatrix();
		GL11.glRotatef(tile.getRotationFromMinutes(), 0.0f, 0.0f, 1.0f);
		Tessellator minuteTess = Tessellator.instance;
		minuteTess.startDrawing(GL11.GL_LINE_STRIP);
		minuteTess.setBrightness(1);
		minuteTess.addVertex(-0.01, 0.01, 0.3D);
		minuteTess.addVertex(-0.01, -0.17, 0.3D);
		minuteTess.addVertex(0.0, -0.17, 0.3D);
		minuteTess.addVertex(0.0, 0.01, 0.3D);
		minuteTess.draw();
		GL11.glPopMatrix();
	}

	public static void drawHourPointer(TileModernClock tile) {
		GL11.glPushMatrix();
		GL11.glRotatef(tile.getRotationFromHours(), 0.0f, 0.0f, 1.0f);
		Tessellator hourTess = Tessellator.instance;
		hourTess.startDrawing(GL11.GL_LINE_STRIP);
		hourTess.setBrightness(1);
		hourTess.addVertex(-0.01, 0.01, 0.3D);
		hourTess.addVertex(-0.01, -0.14, 0.3D);
		hourTess.addVertex(0.0, -0.14, 0.3D);
		hourTess.addVertex(0.0, 0.01, 0.3D);
		hourTess.draw();
		GL11.glPopMatrix();
	}

}
