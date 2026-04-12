package com.mrgummy.item;

import com.mrgummy.AskFriends;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;

import java.util.List;
import java.util.function.Function;

public class ModItems {
    //batch 1
    public static final Item BUTTERFLY =registerItem("butterfly", SuggestedItem::new, new Item.Settings().maxCount(16));
    public static final Item CANTALOUPE =registerItem("cantaloupe", SuggestedItem::new, new Item.Settings().food(
            new FoodComponent.Builder()
                    .nutrition(1)
                    .saturationModifier(0.6F)
                    .alwaysEdible()
                    .build()));
    public static final Item COFFEE =registerItem("coffee", SuggestedItem::new, new Item.Settings().food(
            new FoodComponent.Builder()
                    .nutrition(1)
                    .saturationModifier(0.1F)
                    .alwaysEdible()
                    .alwaysEdible()
                    .build()));
    public static final Item CUPCAKE =registerItem("cupcake", SuggestedItem::new, new Item.Settings().food(
            new FoodComponent.Builder()
                    .nutrition(2)
                    .saturationModifier(1F)
                    .build()));
    public static final Item ICE_CREAM =registerItem("ice_cream", SuggestedItem::new, new Item.Settings().food(
            new FoodComponent.Builder()
                    .nutrition(2)
                    .saturationModifier(1F)
                    .build()));
    public static final Item PAINT_BRUSH =registerItem("paint_brush", SuggestedItem::new, new Item.Settings().maxCount(1));
    public static final Item PHONE =registerItem("phone", SuggestedItem::new, new Item.Settings().maxCount(1));
    public static final Item SHARK =registerItem("shark", SuggestedItem::new, new Item.Settings());
    public static final Item SQUID_HAT =registerItem("squid_hat", HatItem::new, new Item.Settings().maxCount(1));
    public static final Item LEO =registerItem("leo", HatItem::new, new Item.Settings().maxCount(1).rarity(Rarity.EPIC).fireproof());
    public static final Item SUNGLASSES =registerItem("sunglasses", HatItem::new, new Item.Settings().maxCount(1));

    //batch 2
    public static final Item BANDANA =registerItem("bandana", HatItem::new, new Item.Settings().maxCount(1));
    public static final Item BUTTER =registerItem("butter", SuggestedItem::new, new Item.Settings().maxCount(32).food(
            new FoodComponent.Builder()

                    .nutrition(2)
                    .saturationModifier(0.75F)
                    .alwaysEdible()
                    .build()
    ));
    public static final Item CHAINSAW =registerItem("chainsaw", ChainsawItem::new, new Item.Settings().axe(ToolMaterial.IRON, 6.0F, -3.1F).maxCount(1));
    public static final Item MANGO =registerItem("mango", SuggestedItem::new, new Item.Settings().food(
            new FoodComponent.Builder()
                    .nutrition(4)
                    .saturationModifier(0.3F)
                    .build()
    ));
    public static final Item MILKSHAKE =registerItem("milkshake", SuggestedItem::new, new Item.Settings().food(
            new FoodComponent.Builder()
                    .nutrition(2)
                    .saturationModifier(1F)
                    .build()));
    public static final Item MUG =registerItem("mug", SuggestedItem::new, new Item.Settings().maxCount(16));
    public static final Item NIGHT_VISION_GOGGLES =registerItem("night_vision_goggles", HatItem::new, new Item.Settings().maxCount(1));
    public static final Item PAINT_BUCKET = registerItem("paint_bucket", SuggestedItem::new, new Item.Settings().maxCount(1));
    public static final Item SPOON = registerItem("spoon", SuggestedItem::new, new Item.Settings().maxCount(1));
    public static final Item TV_REMOTE = registerItem("tv_remote", SuggestedItem::new, new Item.Settings().maxCount(16));

    public static Item registerItem(String id, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, AskFriends.of(id));
        Item item = (Item)factory.apply(settings.component(DataComponentTypes.LORE, new LoreComponent(List.of(Text.translatable("item."+ key.getValue().toTranslationKey() + ".tooltip")))).registryKey(key));
        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        }
        return (Item) Registry.register(Registries.ITEM, key, item);
    }

    public static void init() {

    }
}
