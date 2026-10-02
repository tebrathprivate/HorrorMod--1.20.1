package com.tebrath.stalkermod;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(StalkerMod.MODID)
public class StalkerMod {
	public static final String MODID = "stalkermod";

	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

	// Hitbox size (width, height). The MODEL is drawn at full Blockbench size; the hitbox is kept
	// smaller for Daddy in Red so pathfinding doesn't get stuck on trees/terrain.
	public static final RegistryObject<EntityType<StalkerEntity>> WHISTLER = ENTITIES.register("the_whistler",
			() -> EntityType.Builder.of(StalkerEntity::new, MobCategory.MONSTER)
					.sized(1.4F, 5.6F).clientTrackingRange(16).build("the_whistler"));

	public static final RegistryObject<EntityType<StalkerEntity>> DADDY_IN_RED = ENTITIES.register("daddy_in_red",
			() -> EntityType.Builder.of(StalkerEntity::new, MobCategory.MONSTER)
					.sized(3.0F, 10.0F).clientTrackingRange(16).build("daddy_in_red"));

	public static final RegistryObject<Item> WHISTLER_EGG = ITEMS.register("the_whistler_spawn_egg",
			() -> new ForgeSpawnEggItem(WHISTLER, 0x111111, 0xFF7A00, new Item.Properties()));
	public static final RegistryObject<Item> DADDY_IN_RED_EGG = ITEMS.register("daddy_in_red_spawn_egg",
			() -> new ForgeSpawnEggItem(DADDY_IN_RED, 0x111111, 0xB00000, new Item.Properties()));

	public StalkerMod() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		ENTITIES.register(bus);
		ITEMS.register(bus);
		bus.addListener(this::onAttributes);
		bus.addListener(this::onCreativeTab);
	}

	private void onAttributes(EntityAttributeCreationEvent event) {
		event.put(WHISTLER.get(), StalkerEntity.createAttributes().build());
		event.put(DADDY_IN_RED.get(), StalkerEntity.createAttributes().build());
	}

	private void onCreativeTab(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			event.accept(WHISTLER_EGG.get());
			event.accept(DADDY_IN_RED_EGG.get());
		}
	}
}
