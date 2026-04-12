package com.mrgummy.blocks;

import com.mrgummy.AskFriends;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.gui.tooltip.TooltipComponent;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;

import java.util.List;
import java.util.function.Function;

import static net.minecraft.block.Blocks.createLightLevelFromLitBlockState;

public class ModBlocks {
    //batch 1
    public static final Block BLOCK_OF_CHEESE = registerBlockWithItem("block_of_cheese", SuggestedBlock::new, AbstractBlock.Settings.create().strength(0.2F).sounds(BlockSoundGroup.CANDLE).mapColor(MapColor.OAK_TAN)).getLeft();
    public static final Block CHISELED_PRISMARINE_BRICKS = registerBlockWithItem("chiseled_prismarine_bricks", SuggestedBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(1.5F, 6.0F)).getLeft();
    public static final Block GLUE = registerBlockWithItem("glue",  GlueBlock::new, AbstractBlock.Settings.create().nonOpaque().mapColor(MapColor.ORANGE).pistonBehavior(PistonBehavior.DESTROY).breakInstantly()).getLeft();
    public static final Block STRAWBERRY_MILK = registerBlockWithItem("strawberry_milk", StrawberryMilkBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.PINK).strength(0.1F).sounds(BlockSoundGroup.CANDLE)).getLeft();
    public static final Block TV_BLOCK = registerBlockWithItem("tv_block", TVBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).requiresTool().strength(3.0F, 6.0F).sounds(BlockSoundGroup.COPPER).nonOpaque().luminance(createLightLevelFromLitBlockState(15)).sounds(BlockSoundGroup.GLASS)).getLeft();

    //batch 2
    public static final Block ASH_BLOCK = registerBlockWithItem("ash_block", AshBlock::new, AbstractBlock.Settings.create().strength(1).sounds(BlockSoundGroup.SAND)).getLeft();
    public static final Block BLOCK_OF_SALT = registerBlockWithItem("block_of_salt", SuggestedBlock::new, AbstractBlock.Settings.create().strength(1).sounds(BlockSoundGroup.STONE)).getLeft();
    public static final Block CONCRETE = registerBlockWithItem("concrete", SuggestedBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(0.75F, 3.0F)).getLeft();
    public static final Block OPALIZED_WOOD = registerBlockWithItem("opalized_wood", OpalizedWoodBlock::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.ANCIENT_DEBRIS).luminance((state)-> {return 2;})).getLeft();
    public static final Block CLOUD_BLOCK = registerBlockWithItem("cloud_block", SuggestedBlock::new , AbstractBlock.Settings.create().mapColor(MapColor.WHITE).nonOpaque().sounds(BlockSoundGroup.WOOL)).getLeft();


    public static <T extends Item> T registerItem(String name, Function<Item.Settings, T> factory) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AskFriends.MOD_ID, name));
        return Registry.register(
                Registries.ITEM,
                key,
                factory.apply(new Item.Settings().component(DataComponentTypes.LORE, new LoreComponent(List.of(Text.translatable("item."+key.getValue().toTranslationKey() + ".tooltip")))).registryKey(key))
        );
    }

    public static <T extends Block> T registerBlock(String name, Function<AbstractBlock.Settings, T> factory, AbstractBlock.Settings base) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AskFriends.MOD_ID, name));
        return Registry.register(
                Registries.BLOCK,
                key,
                factory.apply(base.registryKey(key))
        );
    }

    public static <T extends Block> Pair<T, BlockItem> registerBlockWithItem(String name, Function<AbstractBlock.Settings, T> factory, AbstractBlock.Settings base) {
        T block = registerBlock(name, factory, base);
        return new Pair<>(
                block,
                registerItem(name, settings -> new BlockItem(block, settings))
        );
    }
    public static void init() {
    }

}

