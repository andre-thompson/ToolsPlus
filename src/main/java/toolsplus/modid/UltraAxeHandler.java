package toolsplus.modid;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class UltraAxeHandler {
    private static final Set<Item> ULTRA_AXES = Set.of(
            ModItems.WOODEN_ULTRA_AXE,
            ModItems.STONE_ULTRA_AXE,
            ModItems.COPPER_ULTRA_AXE,
            ModItems.IRON_ULTRA_AXE,
            ModItems.GOLDEN_ULTRA_AXE,
            ModItems.DIAMOND_ULTRA_AXE,
            ModItems.NETHERITE_ULTRA_AXE
    );

    // safety cap so a log connected to something enormous can't stall the server
    private static final int MAX_LOGS = 256;

    // guards against the extra logs we break re-triggering this same handler
    private static final ThreadLocal<Boolean> CHOPPING_EXTRA = ThreadLocal.withInitial(() -> false);

    public static void initialize() {
        PlayerBlockBreakEvents.AFTER.register(UltraAxeHandler::afterBlockBreak);
    }

    private static void afterBlockBreak(Level level, Player player, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        if (Boolean.TRUE.equals(CHOPPING_EXTRA.get())) {
            return;
        }
        if (!(player instanceof ServerPlayer serverPlayer)) {
            return;
        }
        if (!state.is(BlockTags.LOGS)) {
            return;
        }

        ItemStack heldStack = player.getMainHandItem();
        if (!ULTRA_AXES.contains(heldStack.getItem())) {
            return;
        }

        Set<BlockPos> visited = new HashSet<>();
        visited.add(pos);
        Deque<BlockPos> queue = new ArrayDeque<>();
        queue.add(pos);

        Set<BlockPos> toBreak = new HashSet<>();
        while (!queue.isEmpty() && toBreak.size() < MAX_LOGS) {
            BlockPos current = queue.poll();
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    for (int dz = -1; dz <= 1; dz++) {
                        if (dx == 0 && dy == 0 && dz == 0) {
                            continue;
                        }
                        BlockPos neighbor = current.offset(dx, dy, dz);
                        if (!visited.add(neighbor)) {
                            continue;
                        }
                        if (level.getBlockState(neighbor).is(BlockTags.LOGS)) {
                            toBreak.add(neighbor);
                            queue.add(neighbor);
                        }
                    }
                }
            }
        }

        if (toBreak.isEmpty()) {
            return;
        }

        CHOPPING_EXTRA.set(true);
        try {
            for (BlockPos logPos : toBreak) {
                serverPlayer.gameMode.destroyBlock(logPos);
            }
        } finally {
            CHOPPING_EXTRA.set(false);
        }
    }
}
