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
public class DaddyInRedModel extends HierarchicalModel<StalkerEntity> {
	public static final ModelLayerLocation LAYER_LOCATION =
			new ModelLayerLocation(new ResourceLocation(StalkerMod.MODID, "daddy_in_red"), "main");
	private final ModelPart root;

	public DaddyInRedModel(ModelPart root) {
		this.root = root;
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition All = partdefinition.addOrReplaceChild("All", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Head = All.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-100.0F, -270.0F, -1.0F, 223.0F, 270.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -529.0F, -121.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition Legleft = All.addOrReplaceChild("Legleft", CubeListBuilder.create().texOffs(216, 270).addBox(5.0F, -340.0F, 0.0F, 14.0F, 340.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Legright = All.addOrReplaceChild("Legright", CubeListBuilder.create().texOffs(188, 270).addBox(-19.0F, -255.0F, -3.0F, 14.0F, 340.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -85.0F, 3.0F));

		PartDefinition Body = All.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, -400.0F, -20.0F));

		PartDefinition cube_r2 = Body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(104, 270).addBox(-23.0F, -296.0F, 1.0F, 42.0F, 318.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 47.0F, 13.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition Righthand = All.addOrReplaceChild("Righthand", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r3 = Righthand.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(52, 270).addBox(0.1528F, -108.0F, -11.7884F, 0.0F, 595.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-22.0F, -527.0F, -96.0F, 0.0F, 2.4435F, 0.0F));

		PartDefinition Lefthand = All.addOrReplaceChild("Lefthand", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r4 = Lefthand.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 270).addBox(1.0F, -108.0F, -48.0F, 0.0F, 595.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(48.0F, -527.0F, -84.0F, 0.0F, 0.9599F, 0.0F));

		return LayerDefinition.create(meshdefinition, 1024, 1024);
	}

	@Override
	public void setupAnim(StalkerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(DaddyInRedAnimation.WALK, limbSwing, limbSwingAmount, 1.5F, 2.5F);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
