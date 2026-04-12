package com.mrgummy.item;


import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

import java.util.List;


public class HatItem extends SuggestedItem {


    public HatItem(Settings settings) {
        super(settings.equippable(EquipmentSlot.HEAD).component(DataComponentTypes.LORE, new LoreComponent(List.of(Text.translatable("item.ask_friends.hat")))));
    }

    public static boolean isWearingHat(LivingEntity livingEntity) {
        return getWornHat(livingEntity) != ItemStack.EMPTY;
    }

    public static ItemStack getWornHat(LivingEntity livingEntity) {
        Item component = livingEntity.getEquippedStack(EquipmentSlot.HEAD).getItem();
        if (component.asItem() == ModItems.NIGHT_VISION_GOGGLES) {
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 15));
        }
        if (component instanceof HatItem) {
            return component.getDefaultStack();
        }
        return ItemStack.EMPTY;
    }
}

