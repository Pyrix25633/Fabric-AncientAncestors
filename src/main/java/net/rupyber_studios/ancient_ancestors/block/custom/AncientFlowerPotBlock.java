package net.rupyber_studios.ancient_ancestors.block.custom;

import com.google.common.collect.Maps;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import net.rupyber_studios.ancient_ancestors.block.ModBlocks;

import java.util.Map;

public class AncientFlowerPotBlock extends Block {
    private static final Map<Block, Block> CONTENT_TO_POTTED = Maps.newHashMap();
    private static final VoxelShape SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 6.0, 14.0);
    private final Block content;

    public AncientFlowerPotBlock(Block content, AbstractBlock.Settings settings) {
        super(settings);
        this.content = content;
        CONTENT_TO_POTTED.put(content, this);
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    @SuppressWarnings("deprecation")
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        Item item = itemStack.getItem();
        BlockState blockState = (item instanceof BlockItem ? CONTENT_TO_POTTED.getOrDefault(((BlockItem)item).getBlock(), Blocks.AIR) : Blocks.AIR).getDefaultState();
        boolean bl = blockState.isOf(Blocks.AIR);
        boolean bl2 = this.isEmpty();
        if (bl != bl2) {
            if (bl2) {
                world.setBlockState(pos, blockState, 3);
                player.incrementStat(Stats.POT_FLOWER);
                if (!player.getAbilities().creativeMode) {
                    itemStack.decrement(1);
                }
            } else {
                ItemStack itemStack2 = new ItemStack(this.content);
                if (itemStack.isEmpty()) {
                    player.setStackInHand(hand, itemStack2);
                } else if (!player.giveItemStack(itemStack2)) {
                    player.dropItem(itemStack2, false);
                }

                world.setBlockState(pos, ModBlocks.ANCIENT_FLOWER_POT.getDefaultState(), 3);
            }

            world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            return ActionResult.success(world.isClient);
        } else {
            return ActionResult.CONSUME;
        }
    }

    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return this.isEmpty() ? super.getPickStack(world, pos, state) : new ItemStack(this.content);
    }

    private boolean isEmpty() {
        return this.content == Blocks.AIR;
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public Block getContent() {
        return this.content;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}