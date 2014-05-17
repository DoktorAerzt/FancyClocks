package de.empty2k12.fancyclocks.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDoubleClock extends ModelBase {
	
	ModelRenderer Foot1;
	ModelRenderer Foot2;
	ModelRenderer Foot3;
	ModelRenderer Foot4;
	ModelRenderer Floor1;
	ModelRenderer Wall1;
	ModelRenderer Wall2;
	ModelRenderer Back1;
	ModelRenderer Roof1;
	ModelRenderer Roof2;
	ModelRenderer Movement1;
	ModelRenderer Front1;
	ModelRenderer Shape1;

	public ModelDoubleClock() {
		
		textureWidth = 64;
		textureHeight = 32;

		Foot1 = new ModelRenderer(this, 0, 30);
		Foot1.addBox(0F, 0F, 0F, 1, 1, 1);
		Foot1.setRotationPoint(5F, 20F, -5F);
		Foot1.setTextureSize(64, 32);
		Foot1.mirror = true;
		setRotation(Foot1, 0F, 0F, 0F);
		Foot2 = new ModelRenderer(this, 0, 30);
		Foot2.addBox(0F, 0F, 0F, 1, 1, 1);
		Foot2.setRotationPoint(-6F, 20F, -5F);
		Foot2.setTextureSize(64, 32);
		Foot2.mirror = true;
		setRotation(Foot2, 0F, 0F, 0F);
		Foot3 = new ModelRenderer(this, 0, 30);
		Foot3.addBox(0F, 0F, 0F, 1, 1, 1);
		Foot3.setRotationPoint(-6F, 20F, 4F);
		Foot3.setTextureSize(64, 32);
		Foot3.mirror = true;
		setRotation(Foot3, 0F, 0F, 0F);
		Foot4 = new ModelRenderer(this, 0, 30);
		Foot4.addBox(0F, 0F, 0F, 1, 1, 1);
		Foot4.setRotationPoint(5F, 20F, 4F);
		Foot4.setTextureSize(64, 32);
		Foot4.mirror = true;
		setRotation(Foot4, 0F, 0F, 0F);
		Floor1 = new ModelRenderer(this, 0, 0);
		Floor1.addBox(0F, 0F, 0F, 12, 1, 10);
		Floor1.setRotationPoint(-6F, 19F, -5F);
		Floor1.setTextureSize(64, 32);
		Floor1.mirror = true;
		setRotation(Floor1, 0F, 0F, 0F);
		Wall1 = new ModelRenderer(this, 0, 0);
		Wall1.addBox(0F, 0F, 0F, 1, 24, 8);
		Wall1.setRotationPoint(-5F, -5F, -4F);
		Wall1.setTextureSize(64, 32);
		Wall1.mirror = true;
		setRotation(Wall1, 0F, 0F, 0F);
		Wall2 = new ModelRenderer(this, 0, 0);
		Wall2.addBox(0F, 0F, 0F, 1, 24, 8);
		Wall2.setRotationPoint(4F, -5F, -4F);
		Wall2.setTextureSize(64, 32);
		Wall2.mirror = true;
		setRotation(Wall2, 0F, 0F, 0F);
		Back1 = new ModelRenderer(this, 0, 0);
		Back1.addBox(0F, 0F, 0F, 8, 24, 1);
		Back1.setRotationPoint(-4F, -5F, 3F);
		Back1.setTextureSize(64, 32);
		Back1.mirror = true;
		setRotation(Back1, 0F, 0F, 0F);
		Roof1 = new ModelRenderer(this, 0, 0);
		Roof1.addBox(0F, 0F, 0F, 12, 1, 10);
		Roof1.setRotationPoint(-6F, -6F, -5F);
		Roof1.setTextureSize(64, 32);
		Roof1.mirror = true;
		setRotation(Roof1, 0F, 0F, 0F);
		Roof2 = new ModelRenderer(this, 0, 0);
		Roof2.addBox(0F, 0F, 0F, 14, 1, 12);
		Roof2.setRotationPoint(-7F, -7F, -6F);
		Roof2.setTextureSize(64, 32);
		Roof2.mirror = true;
		setRotation(Roof2, 0F, 0F, 0F);
		Movement1 = new ModelRenderer(this, 0, 0);
		Movement1.addBox(0F, 0F, 1F, 8, 7, 6);
		Movement1.setRotationPoint(-4F, -5F, -4F);
		Movement1.setTextureSize(64, 32);
		Movement1.mirror = true;
		setRotation(Movement1, 0F, 0F, 0F);
		Front1 = new ModelRenderer(this, 48, 8);
		Front1.addBox(0F, 0F, 0F, 8, 24, 0);
		Front1.setRotationPoint(-4F, -5F, -3F);
		Front1.setTextureSize(64, 32);
		Front1.mirror = true;
		setRotation(Front1, 0F, 0F, 0F);
		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 1, 1, 1);
		Shape1.setRotationPoint(0F, 0F, 0F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Foot1.render(f5);
		Foot2.render(f5);
		Foot3.render(f5);
		Foot4.render(f5);
		Floor1.render(f5);
		Wall1.render(f5);
		Wall2.render(f5);
		Back1.render(f5);
		Roof1.render(f5);
		Roof2.render(f5);
		Movement1.render(f5);
		Front1.render(f5);
		Shape1.render(f5);
	}
	
	public void renderModel(float f) {
		Foot1.render(f);
		Foot2.render(f);
		Foot3.render(f);
		Foot4.render(f);
		Floor1.render(f);
		Wall1.render(f);
		Wall2.render(f);
		Back1.render(f);
		Roof1.render(f);
		Roof2.render(f);
		Movement1.render(f);
		Front1.render(f);
		Shape1.render(f);
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
