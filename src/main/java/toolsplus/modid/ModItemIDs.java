package toolsplus.modid;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.core.registries.Registries;
public class ModItemIDs {
    public static ResourceKey<Item> create(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ToolsPlus.MOD_ID, name));
    }
    public static final ResourceKey<Item> WOOD_ULTRA_PICKAXE = create("wood_ultra_pickaxe");
    public static final ResourceKey<Item> STONE_ULTRA_PICKAXE = create("stone_ultra_pickaxe");
    public static final ResourceKey<Item> COPPER_ULTRA_PICKAXE = create("copper_ultra_pickaxe");
    public static final ResourceKey<Item> IRON_ULTRA_PICKAXE = create("iron_ultra_pickaxe");
    public static final ResourceKey<Item> GOLD_ULTRA_PICKAXE = create("gold_ultra_pickaxe");
    public static final ResourceKey<Item> DIAMOND_ULTRA_PICKAXE = create("diamond_ultra_pickaxe");
    public static final ResourceKey<Item> NETHERITE_ULTRA_PICKAXE = create("netherite_ultra_pickaxe");
}
