package de.empty2k12.fancyclocks.client.renderer;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import de.empty2k12.fancyclocks.client.model.ModelDoubleClock;
import de.empty2k12.fancyclocks.common.block.tile.TileDoubleClockTop;
import de.empty2k12.fancyclocks.common.misc.ModInfo;

public class RenderDoubleClock extends TileEntitySpecialRenderer {

	private ModelDoubleClock model;
	private ResourceLocation texture = new ResourceLocation(ModInfo.MOD_ID + ":" + "texture/model/doubleClock1.png");
	
	public RenderDoubleClock() {
		model = new ModelDoubleClock();
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float var8) {
		int meta = ((TileDoubleClockTop)tile).direction;

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

		GL11.glTranslated((float) x + 0.5, (float) y + 0.5, (float) z + 0.5);
		GL11.glRotatef(rotationAngle, 0.0F, 1.0F, 0.0F);	
		GL11.glTranslatef(0.0F, 0.0F, 0.0F);
		GL11.glScalef(1.0F, -1F, -1F);

		GL11.glDisable(GL11.GL_LIGHTING);
		bindTexture(texture);
		GL11.glEnable(GL11.GL_LIGHTING);

		this.model.renderModel(0.0625F);
		
		GL11.glPopMatrix();
	}

}
