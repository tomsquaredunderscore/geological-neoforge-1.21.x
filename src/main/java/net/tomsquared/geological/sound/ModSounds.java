package net.tomsquared.geological.sound;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.tomsquared.geological.Geological;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(Registries.SOUND_EVENT, Geological.MOD_ID);

    // General sounds (hit, place, fall)
    public static final DeferredHolder<SoundEvent, SoundEvent> RAW_QUARTZ_SOUNDS = SOUND_EVENTS.register(
            "raw_quartz_sounds",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Geological.MOD_ID, "raw_quartz_sounds"))
    );

    // Breaking sounds
    public static final DeferredHolder<SoundEvent, SoundEvent> RAW_QUARTZ_BREAK = SOUND_EVENTS.register(
            "raw_quartz_break",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Geological.MOD_ID, "raw_quartz_break"))
    );

    // Stepping sounds
    public static final DeferredHolder<SoundEvent, SoundEvent> RAW_QUARTZ_STEP = SOUND_EVENTS.register(
            "raw_quartz_step",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Geological.MOD_ID, "raw_quartz_step"))
    );

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
