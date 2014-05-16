package de.empty2k12.fancyclocks.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelClock extends ModelBase {

	ModelRenderer Ground1;
	ModelRenderer SideWall1;
	ModelRenderer SideWall2;
	ModelRenderer Inside1;
	ModelRenderer Roof2;
	ModelRenderer Roof1;
	ModelRenderer Filling1;
	ModelRenderer Filling2;
	ModelRenderer Filling3;
	ModelRenderer ClockPodest;

	public ModelClock() {

		textureWidth = 64;
		textureHeight = 32;

		Ground1 = new ModelRenderer(this, 0, 0);
		Ground1.addBox(0F, 0F, 0F, 8, 1, 5);
		Ground1.setRotationPoint(-4F, 0F, -2F);
		Ground1.setTextureSize(64, 32);
		Ground1.mirror = true;
		setRotation(Ground1, 0F, 0F, 0F);
		SideWall1 = new ModelRenderer(this, 38, 0);
		SideWall1.addBox(0F, 0F, 0F, 8, 1, 5);
		SideWall1.setRotationPoint(3F, 0F, -2F);
		SideWall1.setTextureSize(64, 32);
		SideWall1.mirror = true;
		setRotation(SideWall1, 0F, 0F, -1.448623F);
		SideWall2 = new ModelRenderer(this, 38, 0);
		SideWall2.addBox(0F, -1F, 0F, 8, 1, 5);
		SideWall2.setRotationPoint(-3F, 0F, -2F);
		SideWall2.setTextureSize(64, 32);
		SideWall2.mirror = true;
		setRotation(SideWall2, 0F, 0F, -1.692969F);
		Inside1 = new ModelRenderer(this, 0, 0);
		Inside1.addBox(0F, 0F, 2F, 8, 7, 3);
		Inside1.setRotationPoint(-4F, -7F, -4F);
		Inside1.setTextureSize(64, 32);
		Inside1.mirror = true;
		setRotation(Inside1, 0F, 0F, 0F);
		Roof2 = new ModelRenderer(this, 0, 19);
		Roof2.addBox(-6F, 0F, 0F, 6, 1, 5);
		Roof2.setRotationPoint(5F, -7.8F, -2F);
		Roof2.setTextureSize(64, 32);
		Roof2.mirror = true;
		setRotation(Roof2, 0F, 0F, 0.6108652F);
		Roof1 = new ModelRenderer(this, 0, 19);
		Roof1.addBox(0F, 0F, 0F, 6, 1, 5);
		Roof1.setRotationPoint(-4.9F, -7.8F, -2F);
		Roof1.setTextureSize(64, 32);
		Roof1.mirror = true;
		setRotation(Roof1, 0F, 0F, -0.6108652F);
		Filling1 = new ModelRenderer(this, 0, 0);
		Filling1.addBox(0F, 0F, 0F, 8, 1, 3);
		Filling1.setRotationPoint(-4F, -8F, -2F);
		Filling1.setTextureSize(64, 32);
		Filling1.mirror = true;
		setRotation(Filling1, 0F, 0F, 0F);
		Filling2 = new ModelRenderer(this, 0, 0);
		Filling2.addBox(0F, 0F, 0F, 6, 1, 3);
		Filling2.setRotationPoint(-3F, -9F, -2F);
		Filling2.setTextureSize(64, 32);
		Filling2.mirror = true;
		setRotation(Filling2, 0F, 0F, 0F);
		Filling3 = new ModelRenderer(this, 0, 0);
		Filling3.addBox(0F, 0F, 0F, 3, 1, 3);
		Filling3.setRotationPoint(-1.5F, -10F, -2F);
		Filling3.setTextureSize(64, 32);
		Filling3.mirror = true;
		setRotation(Filling3, 0F, 0F, 0F);
		ClockPodest = new ModelRenderer(this, 0, 26);
		ClockPodest.addBox(0F, 0F, 0F, 5, 5, 1);
		ClockPodest.setRotationPoint(-2.5F, -7.5F, 1F);
		ClockPodest.setTextureSize(64, 32);
		ClockPodest.mirror = true;
		setRotation(ClockPodest, 0F, 0F, 0F);
	}

	public void renderBlock(float f) {
		Ground1.render(f);
		SideWall1.render(f);
		SideWall2.render(f);
		Inside1.render(f);
		Roof2.render(f);
		Roof1.render(f);
		Filling1.render(f);
		Filling2.render(f);
		Filling3.render(f);
		ClockPodest.render(f);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Ground1.render(f5);
		SideWall1.render(f5);
		SideWall2.render(f5);
		Inside1.render(f5);
		Roof2.render(f5);
		Roof1.render(f5);
		Filling1.render(f5);
		Filling2.render(f5);
		Filling3.render(f5);
		ClockPodest.render(f5);
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
