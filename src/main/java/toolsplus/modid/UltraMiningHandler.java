package toolsplus.modid;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UltraMiningHandler {
    private static final Set<Item> ULTRA_PICKAXES = Set.of(
            ModItems.WOOD_ULTRA_PICKAXE,
            ModItems.STONE_ULTRA_PICKAXE,
            ModItems.COPPER_ULTRA_PICKAXE,
            ModItems.IRON_ULTRA_PICKAXE,
            ModItems.GOLD_ULTRA_PICKAXE,
            ModItems.DIAMOND_ULTRA_PICKAXE,
            ModItems.NETHERITE_ULTRA_PICKAXE
    );

    // guards against the extra blocks we break re-triggering this same handler
    private static final ThreadLocal<Boolean> MINING_EXTRA = ThreadLocal.withInitial(() -> false);

    public static void initialize() {
        PlayerBlockBreakEvents.AFTER.register(UltraMiningHandler::afterBlockBreak);
    }

    private static void afterBlockBreak(Level level, Player player, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        if (Boolean.TRUE.equals(MINING_EXTRA.get())) {
            return;
        }
        if (!(player instanceof ServerPlayer serverPlayer)) {
            return;
        }

        ItemStack heldStack = player.getMainHandItem();
        if (!ULTRA_PICKAXES.contains(heldStack.getItem())) {
            return;
        }

        Direction.Axis axis = player.getNearestViewDirection().getAxis();

        MINING_EXTRA.set(true);
        try {
            for (BlockPos extraPos : neighborsInPlane(pos, axis)) {
                if (!level.getBlockState(extraPos).isAir()) {
                    serverPlayer.gameMode.destroyBlock(extraPos);
                }
            }
        } finally {
            MINING_EXTRA.set(false);
        }
    }

    private static List<BlockPos> neighborsInPlane(BlockPos center, Direction.Axis axis) {
        List<BlockPos> result = new ArrayList<>(8);
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                BlockPos extraPos = switch (axis) {
                    case X -> center.offset(0, i, j);
                    case Y -> center.offset(i, 0, j);
                    case Z -> center.offset(i, j, 0);
                };
                result.add(extraPos);
            }
        }
        return result;
    }
}
