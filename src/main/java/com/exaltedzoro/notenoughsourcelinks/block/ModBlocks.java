package com.exaltedzoro.notenoughsourcelinks.block;

import com.exaltedzoro.notenoughsourcelinks.NotEnoughSourcelinks;
import com.exaltedzoro.notenoughsourcelinks.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, NotEnoughSourcelinks.MOD_ID);

    public static final RegistryObject<Block> SCULKING_SOURCELINK = registerBlock("sculking_sourcelink", () -> new SculkingSourcelinkBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2, 1)));
    public static final RegistryObject<Block> SOLAR_SOURCELINK = registerBlock("solar_sourcelink", () -> new SolarSourcelinkBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2, 1)));
    public static final RegistryObject<Block> LUNAR_SOURCELINK = registerBlock("lunar_sourcelink", () -> new LunarSourcelinkBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2, 1)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
