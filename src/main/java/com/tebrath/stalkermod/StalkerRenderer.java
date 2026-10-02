package com.tebrath.stalkermod;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class StalkerRenderer<M extends HierarchicalModel<StalkerEntity>> extends MobRenderer<StalkerEntity, M> {
	private final ResourceLocation texture;

	public StalkerRenderer(EntityRendererProvider.Context context, M model, ResourceLocation texture) {
		super(context, model, 0.5F);
		this.texture = texture;
	}

	@Override
	public ResourceLocation getTextureLocation(StalkerEntity entity) {
		return this.texture;
	}
}
