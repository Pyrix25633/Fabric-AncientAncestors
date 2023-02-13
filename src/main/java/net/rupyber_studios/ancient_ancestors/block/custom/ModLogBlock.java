package net.rupyber_studios.ancient_ancestors.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.rupyber_studios.ancient_ancestors.block.ModBlocks;

public class ModLogBlock extends PillarBlock {
    public ModLogBlock(Settings settings) {
        super(settings);
    }

    @Override
    @SuppressWarnings("deprecation")
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack playerItem = player.getStackInHand(hand);
        boolean finished = false;

        if (state.isOf(this)) {
            Block toPlace;
            if ((playerItem.getItem() == Items.WOODEN_AXE || playerItem.getItem() == Items.STONE_AXE || playerItem.getItem() == Items.GOLDEN_AXE ||
                    playerItem.getItem() == Items.IRON_AXE || playerItem.getItem() == Items.DIAMOND_AXE || playerItem.getItem() == Items.NETHERITE_AXE)) {
                //Strip Log
                finished = true;
                if (state.isOf(ModBlocks.ANCIENTBARK_LOG)) { //Dark
                    toPlace = ModBlocks.STRIPPED_ANCIENTBARK_LOG;
                } else if (state.isOf(ModBlocks.ANCIENTBARK_WOOD)) {
                    toPlace = ModBlocks.STRIPPED_ANCIENTBARK_WOOD;
                } else {
                    finished = false;
                    toPlace = Blocks.AIR;
                }
                if(finished) {
                    world.setBlockState(pos, toPlace.getDefaultState().with(ModLogBlock.AXIS, state.get(ModLogBlock.AXIS)));
                    playerItem.damage(1, player, (p) -> p.sendToolBreakStatus(hand));
                    world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0f, 1.0f);
                }
            }
        }
        if(finished) {
            return ActionResult.success(true);
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }
}