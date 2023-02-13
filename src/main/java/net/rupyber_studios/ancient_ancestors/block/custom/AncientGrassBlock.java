package net.rupyber_studios.ancient_ancestors.block.custom;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldView;
import net.rupyber_studios.ancient_ancestors.block.ModBlocks;

public class AncientGrassBlock extends Block {
    public AncientGrassBlock(Settings settings) {
        super(settings.ticksRandomly());
    }

    private static boolean canSurvive(WorldView world, BlockPos pos) {
        Block block = world.getBlockState(pos.up()).getBlock();
        return !block.getDefaultState().isOpaque() || block instanceof SlabBlock || block instanceof StairsBlock;
    }

    private static boolean canSpread(WorldView world, BlockPos pos) {
        return canSurvive(world, pos) && world.getLightLevel(pos.up()) > 4;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.randomTick(state, world, pos, random);
        if(!canSurvive(world, pos)) {
            world.setBlockState(pos, ModBlocks.ANCIENT_DIRT.getDefaultState());
        } else {
            for(int i = 0; i < 4; ++i) {
                BlockPos blockPos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                if(world.getBlockState(blockPos).isOf(ModBlocks.ANCIENT_DIRT) && canSurvive(world, blockPos) && canSpread(world, pos)) {
                    world.setBlockState(blockPos, state);
                }
            }
        }
    }
}