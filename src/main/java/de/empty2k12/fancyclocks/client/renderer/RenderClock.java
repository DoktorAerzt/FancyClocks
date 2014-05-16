package de.empty2k12.fancyclocks.client.renderer;

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
		double plusX = 0.5;
		double plusY = 0.5;
		double plusZ = 0.5;

		switch(meta % 4){
		case 0:
			rotationAngle = 90;
			plusX = 0.2;
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

		GL11.glTranslated((float) x + plusX, (float) y + plusY, (float) z + plusZ);
		GL11.glRotatef(rotationAngle, 0.0F, 1.0F, 0.0F);		
		GL11.glScalef(1.0F, -1F, -1F);

		bindTexture(texture);

		GL11.glPushMatrix();
		this.model.renderBlock(0.0625F);
		GL11.glPopMatrix();

		GL11.glPopMatrix();
	}
}
