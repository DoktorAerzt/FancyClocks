package de.empty2k12.fancyclocks.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelModernClock extends ModelBase {
	
	ModelRenderer Main;
	ModelRenderer Border1;
	ModelRenderer Border2;
	ModelRenderer Border3;
	ModelRenderer Border4;

	public ModelModernClock() {
		
		textureWidth = 64;
		textureHeight = 32;

		Main = new ModelRenderer(this, 0, 0);
		Main.addBox(0F, 0F, 0F, 8, 8, 1);
		Main.setRotationPoint(0F, 0F, 0F);
		Main.setTextureSize(64, 32);
		Main.mirror = true;
		setRotation(Main, 0F, 0F, 0F);
		Border1 = new ModelRenderer(this, 0, 0);
		Border1.addBox(0F, 0F, 0F, 6, 1, 1);
		Border1.setRotationPoint(1F, -1F, 0F);
		Border1.setTextureSize(64, 32);
		Border1.mirror = true;
		setRotation(Border1, 0F, 0F, 0F);
		Border2 = new ModelRenderer(this, 0, 0);
		Border2.addBox(0F, 0F, 0F, 1, 6, 1);
		Border2.setRotationPoint(-1F, 1F, 0F);
		Border2.setTextureSize(64, 32);
		Border2.mirror = true;
		setRotation(Border2, 0F, 0F, 0F);
		Border3 = new ModelRenderer(this, 0, 0);
		Border3.addBox(0F, 0F, 0F, 1, 6, 1);
		Border3.setRotationPoint(8F, 1F, 0F);
		Border3.setTextureSize(64, 32);
		Border3.mirror = true;
		setRotation(Border3, 0F, 0F, 0F);
		Border4 = new ModelRenderer(this, 0, 0);
		Border4.addBox(0F, 0F, 0F, 6, 1, 1);
		Border4.setRotationPoint(1F, 8F, 0F);
		Border4.setTextureSize(64, 32);
		Border4.mirror = true;
		setRotation(Border4, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Main.render(f5);
		Border1.render(f5);
		Border2.render(f5);
		Border3.render(f5);
		Border4.render(f5);
	}
	
	public void renderModel(float f) {
		Main.render(f);
		Border1.render(f);
		Border2.render(f);
		Border3.render(f);
		Border4.render(f);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
