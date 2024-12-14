package com.exaltedzoro.notenoughsourcelinks.block.entity;

import com.exaltedzoro.notenoughsourcelinks.NotEnoughSourcelinks;
import com.exaltedzoro.notenoughsourcelinks.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, NotEnoughSourcelinks.MOD_ID);

    public static final RegistryObject<BlockEntityType<SculkingSourcelinkBlockEntity>> SCULKING_SOURCELINK =
            BLOCK_ENTITIES.register("sculking_sourcelink", () ->
                    BlockEntityType.Builder.of(SculkingSourcelinkBlockEntity::new, ModBlocks.SCULKING_SOURCELINK.get()).build(null));

    public static final RegistryObject<BlockEntityType<SolarSourcelinkBlockEntity>> SOLAR_SOURCELINK =
            BLOCK_ENTITIES.register("solar_sourcelink", () ->
                    BlockEntityType.Builder.of(SolarSourcelinkBlockEntity::new, ModBlocks.SOLAR_SOURCELINK.get()).build(null));

    public static final RegistryObject<BlockEntityType<LunarSourcelinkBlockEntity>> LUNAR_SOURCELINK =
            BLOCK_ENTITIES.register("lunar_sourcelink", () ->
                    BlockEntityType.Builder.of(LunarSourcelinkBlockEntity::new, ModBlocks.LUNAR_SOURCELINK.get()).build(null));

    public static void register (IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
