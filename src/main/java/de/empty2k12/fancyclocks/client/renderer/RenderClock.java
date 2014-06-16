package de.empty2k12.fancyclocks.client.renderer;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
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

		int rotationAngle = 0;

		switch(((TileClock)tile).getOrientation()){
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

		GL11.glTranslated((float) x + 0.5, (float) y + 0.1, (float) z + 0.5);
		GL11.glRotatef(rotationAngle, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0.0F, 0.1F, 0.4375F);
		GL11.glScalef(1.0F, -1F, -1F);

		GL11.glPushMatrix();
		bindTextureBasedOnMeta(tile.getBlockMetadata());
		this.model.renderCorpse(0.0625F);
		GL11.glTranslatef(0.0F, 0.0F, 0.0001F);
		this.model.renderRoof1(0.0625F);
		GL11.glTranslatef(0.0F, 0.0F, 0.000001F);
		this.model.renderRoof2(0.0625F);
		bindTexture(texture);
		this.model.renderIndicators(0.0625F);
		GL11.glPopMatrix();

		GL11.glTranslatef(-0.0F, -0.3F, -0.0F);
		GL11.glScalef(-1.0F, 1F, 1F);

		drawSecondPointer((TileClock)tile, tile.getBlockMetadata());
		drawMinutePointer((TileClock)tile, tile.getBlockMetadata());
		drawHourPointer((TileClock)tile, tile.getBlockMetadata());

		GL11.glPopMatrix();
	}

	//Pointer color based on wood color!
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
		return meta == 2 || meta == 6 ? 0 : 255;
	}
}
