package net.tomsquared.geological;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, "geological");

    public static final DeferredHolder<EntityType<?>, EntityType<CattailSeedProjectile>> CATTAIL_SEED_PROJECTILE =
            ENTITY_TYPES.register("cattail_seed_projectile", () -> EntityType.Builder.<CattailSeedProjectile>of(
                            CattailSeedProjectile::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F) // <-- Fixed here
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build("cattail_seed_projectile")
            );
}