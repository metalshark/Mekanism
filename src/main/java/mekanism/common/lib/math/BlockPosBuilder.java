package mekanism.common.lib.math;

import mekanism.common.lib.multiblock.Structure.Axis;
import net.minecraft.util.math.BlockPos;

public class BlockPosBuilder {

    private int[] pos = new int[3];
    private boolean[] set = new boolean[3];

    public BlockPos build() {
        return new BlockPos(pos[0], pos[1], pos[2]);
    }

    public boolean isSet(Axis axis) {
        return set[axis.ordinal()];
    }

    public void set(Axis axis, int value) {
        pos[axis.ordinal()] = value;
        set[axis.ordinal()] = true;
    }

    public int get(Axis axis) {
        return pos[axis.ordinal()];
    }
}
