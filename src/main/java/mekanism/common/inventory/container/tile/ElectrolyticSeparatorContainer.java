package mekanism.common.inventory.container.tile;

import javax.annotation.Nonnull;
import mekanism.api.gas.GasStack;
import mekanism.api.gas.IGasItem;
import mekanism.common.inventory.container.MekanismContainerTypes;
import mekanism.common.tags.MekanismTags;
import mekanism.common.tile.TileEntityElectrolyticSeparator;
import mekanism.common.util.ChargeUtils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;

public class ElectrolyticSeparatorContainer extends MekanismTileContainer<TileEntityElectrolyticSeparator> {

    public ElectrolyticSeparatorContainer(int id, PlayerInventory inv, TileEntityElectrolyticSeparator tile) {
        super(MekanismContainerTypes.ELECTROLYTIC_SEPARATOR, id, inv, tile);
    }

    public ElectrolyticSeparatorContainer(int id, PlayerInventory inv, PacketBuffer buf) {
        this(id, inv, getTileFromBuf(buf, TileEntityElectrolyticSeparator.class));
    }

    @Nonnull
    @Override
    public ItemStack transferStackInSlot(PlayerEntity player, int slotID) {
        ItemStack stack = ItemStack.EMPTY;
        Slot currentSlot = inventorySlots.get(slotID);
        if (currentSlot != null && currentSlot.getHasStack()) {
            ItemStack slotStack = currentSlot.getStack();
            stack = slotStack.copy();
            if (slotID != 0 && slotID != 1 && slotID != 2 && slotID != 3) {
                if (tile.isFluidInputItem(slotStack)) {
                    if (!mergeItemStack(slotStack, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (slotStack.getItem() instanceof IGasItem) {
                    GasStack gasStack = ((IGasItem) slotStack.getItem()).getGas(slotStack);
                    if (!gasStack.isEmpty()) {
                        if (gasStack.getType().isIn(MekanismTags.HYDROGEN)) {
                            if (!mergeItemStack(slotStack, 1, 2, false)) {
                                return ItemStack.EMPTY;
                            }
                        } else if (gasStack.getType().isIn(MekanismTags.OXYGEN)) {
                            if (!mergeItemStack(slotStack, 2, 3, false)) {
                                return ItemStack.EMPTY;
                            }
                        }
                    } else if (!mergeItemStack(slotStack, 1, 2, false)) {
                        if (!mergeItemStack(slotStack, 2, 3, false)) {
                            return ItemStack.EMPTY;
                        }
                    }
                } else if (ChargeUtils.canBeDischarged(slotStack)) {
                    if (!mergeItemStack(slotStack, 3, 4, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (slotID <= 30) {
                    if (!mergeItemStack(slotStack, 31, inventorySlots.size(), false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (!mergeItemStack(slotStack, 4, 30, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!mergeItemStack(slotStack, 4, inventorySlots.size(), true)) {
                return ItemStack.EMPTY;
            }
            if (slotStack.getCount() == 0) {
                currentSlot.putStack(ItemStack.EMPTY);
            } else {
                currentSlot.onSlotChanged();
            }
            if (slotStack.getCount() == stack.getCount()) {
                return ItemStack.EMPTY;
            }
            currentSlot.onTake(player, slotStack);
        }
        return stack;
    }
}