package toolsplus.modid;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import java.util.function.Function;


public class ModItems {
    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings){
        // Create the item instance.
        Item item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }
    public static final Item WOOD_ULTRA_PICKAXE = register(
            ModItemIDs.WOOD_ULTRA_PICKAXE,
            Item::new,
            new Item.Properties()
    );
    public static final Item STONE_ULTRA_PICKAXE = register(
            ModItemIDs.STONE_ULTRA_PICKAXE,
            Item::new,
            new Item.Properties()
    );
    public static final Item COPPER_ULTRA_PICKAXE = register(
            ModItemIDs.COPPER_ULTRA_PICKAXE,
            Item::new,
            new Item.Properties()
    );
    public static final Item IRON_ULTRA_PICKAXE = register(
            ModItemIDs.IRON_ULTRA_PICKAXE,
            Item::new,
            new Item.Properties()
    );
    public static final Item GOLD_ULTRA_PICKAXE = register(
            ModItemIDs.GOLD_ULTRA_PICKAXE,
            Item::new,
            new Item.Properties()
    );
    public static final Item DIAMOND_ULTRA_PICKAXE = register(
            ModItemIDs.DIAMOND_ULTRA_PICKAXE,
            Item::new,
            new Item.Properties()
    );
    public static final Item NETHERITE_ULTRA_PICKAXE = register(
            ModItemIDs.NETHERITE_ULTRA_PICKAXE,
            Item::new,
            new Item.Properties()
    );
    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.WOOD_ULTRA_PICKAXE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.STONE_ULTRA_PICKAXE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.COPPER_ULTRA_PICKAXE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.IRON_ULTRA_PICKAXE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.GOLD_ULTRA_PICKAXE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.DIAMOND_ULTRA_PICKAXE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.NETHERITE_ULTRA_PICKAXE));
    }
}




