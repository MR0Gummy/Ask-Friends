package com.mrgummy.misc;

import com.google.common.collect.ImmutableMap;
import com.mrgummy.AskFriends;
import com.mrgummy.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.TradedItem;

public class ModCustomTrades {
    public static void init(){
        TradeOfferHelper.registerWanderingTraderOffers((wanderingTraderOffersBuilder -> {
            wanderingTraderOffersBuilder.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.SELL_SPECIAL_ITEMS_POOL, (world, entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 5),
                    new ItemStack(ModItems.SHARK, 1),
                    12, 5, 0.15f)
            );
        }));

    }
}
