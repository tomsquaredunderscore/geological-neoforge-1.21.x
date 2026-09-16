package net.tomsquared.geological;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES =
            DeferredRegister.create(Registries.PARTICLE_TYPE, "geological");

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FLUFF =
            PARTICLES.register("fluff", () -> new SimpleParticleType(false));
}



