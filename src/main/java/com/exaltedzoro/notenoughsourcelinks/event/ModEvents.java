package com.exaltedzoro.notenoughsourcelinks.event;

import com.exaltedzoro.notenoughsourcelinks.NotEnoughSourcelinks;
import com.exaltedzoro.notenoughsourcelinks.block.entity.SculkingSourcelinkBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = NotEnoughSourcelinks.MOD_ID)
    public static class ForgeEvents {
        /**
         * This event method is used to check whether a mob death should be used inside a Sculking Sourcelink
         * @param event A LivingDeathEvent used to tell the code what event this method fires on.
         */
        @SubscribeEvent
        public static void onLivingEntityDeath(LivingDeathEvent event) {
            int experience = event.getEntity().getExperienceReward();
            Level level = event.getEntity().level();
            BlockPos pos = event.getEntity().blockPosition();
            for(BlockPos pPos : BlockPos.betweenClosed(pos.above(5).north(5).east(5), pos.below(5).south(5).west(5))) {
                BlockEntity entity = level.getBlockEntity(pPos);
                if(entity instanceof SculkingSourcelinkBlockEntity sourceLink) {
                    sourceLink.activate(experience);
                    event.getEntity().skipDropExperience();
                    break;
                }
            }
        }
    }
}
