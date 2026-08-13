package toolsplus.modid;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

import java.util.function.Function;


public class ModItems {
    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings){
        // Create the item instance.
        Item item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }
    public static final Item WOODEN_ULTRA_PICKAXE = register(
            ModItemIDs.WOODEN_ULTRA_PICKAXE,
            Item::new,
            new Item.Properties().pickaxe(ToolMaterial.WOOD, 1f,1f)
    );
    public static final Item STONE_ULTRA_PICKAXE = register(
            ModItemIDs.STONE_ULTRA_PICKAXE,
            Item::new,
            new Item.Properties().pickaxe(ToolMaterial.STONE, 1f, 1f)
    );
    public static final Item COPPER_ULTRA_PICKAXE = register(
            ModItemIDs.COPPER_ULTRA_PICKAXE,
            Item::new,
            new Item.Properties().pickaxe(ToolMaterial.COPPER,1f,1f)
    );
    public static final Item IRON_ULTRA_PICKAXE = register(
            ModItemIDs.IRON_ULTRA_PICKAXE,
            Item::new,
            new Item.Properties().pickaxe(ToolMaterial.IRON,1f,1f)
    );
    public static final Item GOLDEN_ULTRA_PICKAXE = register(
            ModItemIDs.GOLDEN_ULTRA_PICKAXE,
            Item::new,
            new Item.Properties().pickaxe(ToolMaterial.GOLD,1f,1f)
    );
    public static final Item DIAMOND_ULTRA_PICKAXE = register(
            ModItemIDs.DIAMOND_ULTRA_PICKAXE,
            Item::new,
            new Item.Properties().pickaxe(ToolMaterial.DIAMOND,1f,1f)
    );
    public static final Item NETHERITE_ULTRA_PICKAXE = register(
            ModItemIDs.NETHERITE_ULTRA_PICKAXE,
            Item::new,
            new Item.Properties().pickaxe(ToolMaterial.NETHERITE,1f,1f)
    );

    public static final Item WOODEN_ULTRA_AXE = register(
            ModItemIDs.WOODEN_ULTRA_AXE,
            settings -> new AxeItem(ToolMaterial.WOOD, 1F, 1F, settings),
            new Item.Properties()
    );
    public static final Item STONE_ULTRA_AXE = register(
            ModItemIDs.STONE_ULTRA_AXE,
            settings -> new AxeItem(ToolMaterial.STONE, 1F, 1F, settings),
            new Item.Properties()
    );
    public static final Item COPPER_ULTRA_AXE = register(
            ModItemIDs.COPPER_ULTRA_AXE,
            settings -> new AxeItem(ToolMaterial.COPPER, 1F, 1F, settings),
            new Item.Properties()
    );
    public static final Item IRON_ULTRA_AXE = register(
            ModItemIDs.IRON_ULTRA_AXE,
            settings -> new AxeItem(ToolMaterial.IRON, 1F, 1F, settings),
            new Item.Properties()
    );
    public static final Item GOLDEN_ULTRA_AXE = register(
            ModItemIDs.GOLDEN_ULTRA_AXE,
            settings -> new AxeItem(ToolMaterial.GOLD, 1F, 1F, settings),
            new Item.Properties()
    );
    public static final Item DIAMOND_ULTRA_AXE = register(
            ModItemIDs.DIAMOND_ULTRA_AXE,
            settings -> new AxeItem(ToolMaterial.DIAMOND, 1F, 1F, settings),
            new Item.Properties()
    );
    public static final Item NETHERITE_ULTRA_AXE = register(
            ModItemIDs.NETHERITE_ULTRA_AXE,
            settings -> new AxeItem(ToolMaterial.NETHERITE, 1F, 1F, settings),
            new Item.Properties()
    );
    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.WOODEN_ULTRA_PICKAXE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.STONE_ULTRA_PICKAXE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.COPPER_ULTRA_PICKAXE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.IRON_ULTRA_PICKAXE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.GOLDEN_ULTRA_PICKAXE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.DIAMOND_ULTRA_PICKAXE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.NETHERITE_ULTRA_PICKAXE));

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.WOODEN_ULTRA_AXE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.STONE_ULTRA_AXE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.COPPER_ULTRA_AXE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.IRON_ULTRA_AXE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.GOLDEN_ULTRA_AXE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.DIAMOND_ULTRA_AXE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.NETHERITE_ULTRA_AXE));
    }
}




