package com.tebrath.stalkermod;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

/** Blockbench model, converted to HierarchicalModel so the exported animation can play. */
public class WhistlerModel extends HierarchicalModel<StalkerEntity> {
	public static final ModelLayerLocation LAYER_LOCATION =
			new ModelLayerLocation(new ResourceLocation(StalkerMod.MODID, "the_whistler"), "main");
	private final ModelPart root;

	public WhistlerModel(ModelPart root) {
		this.root = root;
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition all = partdefinition.addOrReplaceChild("all", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = all.addOrReplaceChild("head", CubeListBuilder.create().texOffs(44, 34).addBox(-10.0F, -89.0F, -16.0F, 24.0F, 25.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = all.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(44, 0).addBox(-10.0F, -17.0F, 0.0F, 20.0F, 34.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -58.0792F, -7.8497F, 0.48F, 0.0F, 0.0F));

		PartDefinition righthand = all.addOrReplaceChild("righthand", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = righthand.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(22, 0).addBox(1.0F, -2.0F, -6.0F, 0.0F, 67.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -70.0F, -15.0F, 0.125F, -1.1419F, 0.1026F));

		PartDefinition legleft = all.addOrReplaceChild("legleft", CubeListBuilder.create().texOffs(62, 59).addBox(1.0F, -43.0F, 0.0F, 9.0F, 43.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition lefthand = all.addOrReplaceChild("lefthand", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r3 = lefthand.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, -22.0F, -5.0F, 0.0F, 67.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, -50.0F, -13.0F, 0.2182F, 0.9163F, 0.0F));

		PartDefinition legsright = all.addOrReplaceChild("legsright", CubeListBuilder.create().texOffs(44, 59).addBox(-10.0F, -43.0F, 0.0F, 9.0F, 43.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(StalkerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(WhistlerAnimation.WALK, limbSwing, limbSwingAmount, 1.5F, 2.5F);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
