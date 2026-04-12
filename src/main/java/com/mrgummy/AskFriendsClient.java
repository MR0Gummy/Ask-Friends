package com.mrgummy;

import com.mrgummy.blocks.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.render.BlockRenderLayer;

public class AskFriendsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

       BlockRenderLayerMap.putBlocks(BlockRenderLayer.CUTOUT, ModBlocks.TV_BLOCK, ModBlocks.STRAWBERRY_MILK);
       BlockRenderLayerMap.putBlock(ModBlocks.CLOUD_BLOCK, BlockRenderLayer.TRANSLUCENT);
    }
}
