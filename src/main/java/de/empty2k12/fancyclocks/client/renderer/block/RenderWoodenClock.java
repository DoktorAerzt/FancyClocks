package de.empty2k12.fancyclocks.client.renderer.block;

import de.empty2k12.fancyclocks.client.model.ModelClock;
import de.empty2k12.fancyclocks.client.renderer.RenderClock;
import de.empty2k12.fancyclocks.common.block.clocks.wooden_clock.TileWoodenClock;
import de.empty2k12.fancyclocks.common.misc.ModInfo;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderWoodenClock extends RenderClock {

	public static final ResourceLocation texture = new ResourceLocation(ModInfo.MOD_ID + ":" + "textures/model/clock1.png");

	public ModelClock model;

	public RenderWoodenClock() {
		model = new ModelClock();
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float var8) {

		int rotationAngle = 0;

		switch(((TileWoodenClock)tile).getOrientation()){
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

		drawSecondPointer((TileWoodenClock)tile, tile.getBlockMetadata());
		drawMinutePointer((TileWoodenClock)tile, tile.getBlockMetadata());
		drawHourPointer((TileWoodenClock)tile, tile.getBlockMetadata());

		GL11.glPopMatrix();
	}
}
