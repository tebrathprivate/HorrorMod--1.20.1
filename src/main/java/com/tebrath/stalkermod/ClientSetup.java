package com.tebrath.stalkermod;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = StalkerMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {

	@SubscribeEvent
	public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(WhistlerModel.LAYER_LOCATION, WhistlerModel::createBodyLayer);
		event.registerLayerDefinition(DaddyInRedModel.LAYER_LOCATION, DaddyInRedModel::createBodyLayer);
	}

	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(StalkerMod.WHISTLER.get(), ctx -> new StalkerRenderer<>(ctx,
				new WhistlerModel(ctx.bakeLayer(WhistlerModel.LAYER_LOCATION)),
				new ResourceLocation(StalkerMod.MODID, "textures/entity/whistler.png")));

		event.registerEntityRenderer(StalkerMod.DADDY_IN_RED.get(), ctx -> new StalkerRenderer<>(ctx,
				new DaddyInRedModel(ctx.bakeLayer(DaddyInRedModel.LAYER_LOCATION)),
				new ResourceLocation(StalkerMod.MODID, "textures/entity/daddy_in_red.png")));
	}
}
