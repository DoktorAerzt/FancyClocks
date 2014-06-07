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
	ModelRenderer MiddleDot1;
	ModelRenderer twelveOClock;
	ModelRenderer nineOClock;
	ModelRenderer threeOClock;
	ModelRenderer sixOClock;
	ModelRenderer elevenOClock;
	ModelRenderer twoOClock;
	ModelRenderer sevenOClock;
	ModelRenderer fiveOClock;

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
		MiddleDot1 = new ModelRenderer(this, 34, 0);
		MiddleDot1.addBox(0F, 0F, 0F, 1, 1, 2);
		MiddleDot1.setRotationPoint(-0.5F, -5.5F, 0.5F);
		MiddleDot1.setTextureSize(64, 32);
		MiddleDot1.mirror = true;
		setRotation(MiddleDot1, 0F, 0F, 0F);
		twelveOClock = new ModelRenderer(this, 34, 0);
		twelveOClock.addBox(0F, -6F, 0F, 1, 1, 1);
		twelveOClock.setRotationPoint(-0.5F, -2F, 1F);
		twelveOClock.setTextureSize(64, 32);
		twelveOClock.mirror = true;
		setRotation(twelveOClock, 0F, 0F, 0F);
		nineOClock = new ModelRenderer(this, 34, 0);
		nineOClock.addBox(0F, 0F, 0F, 1, 1, 1);
		nineOClock.setRotationPoint(2F, -5.5F, 1F);
		nineOClock.setTextureSize(64, 32);
		nineOClock.mirror = true;
		setRotation(nineOClock, 0F, 0F, 0F);
		threeOClock = new ModelRenderer(this, 34, 0);
		threeOClock.addBox(0F, 0F, 0F, 1, 1, 1);
		threeOClock.setRotationPoint(-3F, -5.5F, 1F);
		threeOClock.setTextureSize(64, 32);
		threeOClock.mirror = true;
		setRotation(threeOClock, 0F, 0F, 0F);
		sixOClock = new ModelRenderer(this, 34, 0);
		sixOClock.addBox(0F, 0F, 0F, 1, 1, 1);
		sixOClock.setRotationPoint(-0.5F, -3F, 1F);
		sixOClock.setTextureSize(64, 32);
		sixOClock.mirror = true;
		setRotation(sixOClock, 0F, 0F, 0F);
		elevenOClock = new ModelRenderer(this, 34, 0);
		elevenOClock.addBox(0F, 0F, 0F, 1, 1, 1);
		elevenOClock.setRotationPoint(1F, -7F, 1F);
		elevenOClock.setTextureSize(64, 32);
		elevenOClock.mirror = true;
		setRotation(elevenOClock, 0F, 0F, 0F);
		twoOClock = new ModelRenderer(this, 34, 0);
		twoOClock.addBox(0F, 0F, 0F, 1, 1, 1);
		twoOClock.setRotationPoint(-2F, -7F, 1F);
		twoOClock.setTextureSize(64, 32);
		twoOClock.mirror = true;
		setRotation(twoOClock, 0F, 0F, 0F);
		sevenOClock = new ModelRenderer(this, 34, 0);
		sevenOClock.addBox(0F, 0F, 0F, 1, 1, 1);
		sevenOClock.setRotationPoint(1F, -4F, 1F);
		sevenOClock.setTextureSize(64, 32);
		sevenOClock.mirror = true;
		setRotation(sevenOClock, 0F, 0F, 0F);
		fiveOClock = new ModelRenderer(this, 34, 0);
		fiveOClock.addBox(0F, 0F, 0F, 1, 1, 1);
		fiveOClock.setRotationPoint(-2F, -4F, 1F);
		fiveOClock.setTextureSize(64, 32);
		fiveOClock.mirror = true;
		setRotation(fiveOClock, 0F, 0F, 0F);
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
		MiddleDot1.render(f5);
		twelveOClock.render(f5);
		nineOClock.render(f5);
		threeOClock.render(f5);
		sixOClock.render(f5);
		elevenOClock.render(f5);
		twoOClock.render(f5);
		sevenOClock.render(f5);
		fiveOClock.render(f5);
	}

	public void renderModel(float f) {
		Ground1.render(f);
		SideWall1.render(f);
		SideWall2.render(f);
		Inside1.render(f);
		Roof2.render(f);
		Roof1.render(f);
		Filling1.render(f);
		Filling2.render(f);
		Filling3.render(f);
		MiddleDot1.render(f);
		twelveOClock.render(f);
		nineOClock.render(f);
		threeOClock.render(f);
		sixOClock.render(f);
		elevenOClock.render(f);
		twoOClock.render(f);
		sevenOClock.render(f);
		fiveOClock.render(f);
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
