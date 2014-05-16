package de.empty2k12.fancyclocks.client.renderer;

import java.util.Calendar;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import de.empty2k12.fancyclocks.client.model.ModelClock;
import de.empty2k12.fancyclocks.common.block.tile.TileClock;
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
	
		GL11.glTranslatef(-0.0F, -0.3F, -0.0F);
		GL11.glScalef(-1.0F, 1F, 1F);
		//drawSecondPointer((TileClock)tile);
		//drawMinutePointer((TileClock)tile);
		drawHourPointer((TileClock)tile);
		
		GL11.glPopMatrix();
	}

	public static void drawSecondPointer(TileClock tile) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawing(GL11.GL_LINE_STRIP);
		tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
		GL11.glRotatef(tile.getRotationFromSeconds(), 0.0f, 0.0f, 1.0f);
		tessellator.addVertex(-0.01, 0.01, 0.15D);
		tessellator.addVertex(-0.01, -0.15, 0.15D);
		tessellator.addVertex(0.0, -0.15, 0.15D);
		tessellator.addVertex(0.0, 0.01, 0.15D);
		tessellator.draw();
	}
	
	public static void drawMinutePointer(TileClock tile) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawing(GL11.GL_LINE_STRIP);
		tessellator.setColorOpaque_F(255.0F, 1.0F, 1.0F);
		GL11.glRotatef(tile.getRotationFromMinutes(), 0.0f, 0.0f, 1.0f);
		tessellator.addVertex(-0.01, 0.01, 0.15D);
		tessellator.addVertex(-0.01, -0.15, 0.15D);
		tessellator.addVertex(0.0, -0.15, 0.15D);
		tessellator.addVertex(0.0, 0.01, 0.15D);
		tessellator.draw();
	}
	
	public static void drawHourPointer(TileClock tile) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawing(GL11.GL_LINE_STRIP);
		tessellator.setColorOpaque_F(1.0F, 1.0F, 255.0F);
		GL11.glRotatef(tile.getRotationFromHours(), 0.0f, 0.0f, 1.0f);
		tessellator.addVertex(-0.01, 0.01, 0.15D);
		tessellator.addVertex(-0.01, -0.15, 0.15D);
		tessellator.addVertex(0.0, -0.15, 0.15D);
		tessellator.addVertex(0.0, 0.01, 0.15D);
		tessellator.draw();
	}
}
