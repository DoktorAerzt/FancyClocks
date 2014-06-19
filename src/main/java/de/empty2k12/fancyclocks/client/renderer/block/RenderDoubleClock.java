package de.empty2k12.fancyclocks.client.renderer.block;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import de.empty2k12.fancyclocks.client.model.ModelDoubleClock;
import de.empty2k12.fancyclocks.client.renderer.RenderClock;
import de.empty2k12.fancyclocks.common.block.clocks.double_clock.TileDoubleClock;
import de.empty2k12.fancyclocks.common.misc.ModInfo;

public class RenderDoubleClock extends RenderClock {

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

		GL11.glTranslated((float) x + 0.5, (float) y + 0.5, (float) z + 0.5);
		GL11.glRotatef(rotationAngle + 180F, 0.0F, 1.0F, 0.0F);
		GL11.glScalef(1.1F, -1.1F, -1.1F);

		bindTexture(texture);

		GL11.glTranslatef(0.01F, -0.055F, -0.3F);
		drawSecondPointer((TileDoubleClock)tile, tile.getBlockMetadata());
		drawMinutePointer((TileDoubleClock)tile, tile.getBlockMetadata());
		drawHourPointer((TileDoubleClock)tile, tile.getBlockMetadata());
		GL11.glTranslatef(-0.01F, 0.055F, 0.3F);

		bindTextureBasedOnMeta(tile.getBlockMetadata());
		this.model.renderModel(0.0625F);

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		bindTexture(texture);
		this.model.renderOtherStuffs(0.0625F);
		GL11.glDisable(GL11.GL_BLEND);

		GL11.glPopMatrix();
	}
	
}