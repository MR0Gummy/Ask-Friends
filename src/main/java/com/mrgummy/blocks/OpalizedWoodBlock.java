package com.mrgummy.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class OpalizedWoodBlock extends SuggestedBlock {
    private static final VoxelShape BASE_SHAPE;

    public OpalizedWoodBlock(Settings settings) {
        super(settings);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BASE_SHAPE;
    }

    static {
        BASE_SHAPE = Block.createCuboidShape(4, 0, 4, 12, 8, 12);
    }

}
