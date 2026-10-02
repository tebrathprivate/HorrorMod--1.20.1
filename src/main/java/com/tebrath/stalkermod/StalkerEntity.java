package com.tebrath.stalkermod;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

/** Shared entity class used by both The Whistler and Daddy in Red. */
public class StalkerEntity extends Monster {

	public StalkerEntity(EntityType<? extends Monster> type, Level level) {
		super(type, level);
		this.noCulling = true; // model is far bigger than the hitbox, so never cull it
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 60.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.32D)
				.add(Attributes.ATTACK_DAMAGE, 8.0D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
				// Detection range in blocks. Change this number to see further/closer.
				.add(Attributes.FOLLOW_RANGE, 100.0D);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true)); // chases the target
		this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 0.6D));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 16.0F));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));

		// Spots a player within FOLLOW_RANGE, then keeps chasing even if sight is lost.
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, 10, false, false, null));
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}
}
