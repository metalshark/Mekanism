package mekanism.common.inventory.slot;

import java.util.function.Predicate;
import javax.annotation.Nonnull;
import mekanism.api.Action;
import mekanism.api.annotations.NonNull;
import mekanism.api.gas.Gas;
import mekanism.api.gas.GasStack;
import mekanism.api.gas.GasTank;
import mekanism.api.gas.IGasItem;
import mekanism.common.recipe.GasConversionHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GasInventorySlot extends BasicInventorySlot {

    /**
     * Fills the tank from this item OR converts the given item to a gas
     */
    public static GasInventorySlot fillOrConvert(GasTank gasTank, Predicate<Gas> isValidGas, int x, int y) {
        return new GasInventorySlot(gasTank, stack -> {
            //NOTE: Even though we KNOW from isValid when we added the item that this should be an IGasItem, have it double check until we end up switching to a capability
            Item item = stack.getItem();
            //TODO: Use a capability instead of instanceof
            if (item instanceof IGasItem) {
                //Only allow extraction if our item is out of gas
                return ((IGasItem) item).getGas(stack).isEmpty();
            }
            //Always allow it if something went horribly wrong and we are not an IGasItem AND we can't provide a valid type of gas
            //TODO: Should we be checking the tank for if the gas is valid?
            //TODO: Re-evaluate this after switching GasConversion to being a recipe
            return GasConversionHandler.getItemGasConversion(stack, isValidGas).isEmpty();
        }, stack -> {
            //NOTE: Even though we KNOW from isValid that this should be an IGasItem, have it double check until we end up switching to a capability
            Item item = stack.getItem();
            //TODO: Use a capability instead of instanceof
            if (item instanceof IGasItem) {
                GasStack containedGas = ((IGasItem) item).getGas(stack);
                //True if we can fill the tank with any of our contents, ignored if the item has no gas, as it won't pass isValid
                return gasTank.fill(containedGas, Action.SIMULATE) > 0;
            }
            //TODO: Re-evaluate this after switching GasConversion to being a recipe
            GasStack gasConversion = GasConversionHandler.getItemGasConversion(stack, isValidGas);
            //Note: We recheck about this being empty as the conversion list might have changed
            return !gasConversion.isEmpty() && gasTank.fill(gasConversion, Action.SIMULATE) > 0;
        }, stack -> {
            Item item = stack.getItem();
            //TODO: Use a capability instead of instanceof
            if (item instanceof IGasItem) {
                //TODO: Add a way to the capability to see if the item can ever output gas, as things like jetpacks cannot have the gas be drained from them
                // Strictly speaking this currently could be done as gasItem.canProvideGas(stack, MekanismAPI.EMPTY_GAS), but is being ignored instead for clarity
                GasStack containedGas = ((IGasItem) item).getGas(stack);
                return !containedGas.isEmpty() && isValidGas.test(containedGas.getType());
            }
            //TODO: Re-evaluate this after switching GasConversion to being a recipe
            //Allow gas conversion of items that have a gas that is valid
            return !GasConversionHandler.getItemGasConversion(stack, isValidGas).isEmpty();
        }, x, y);
    }

    /**
     * Fills the tank from this item
     */
    public static GasInventorySlot fill(GasTank gasTank, Predicate<Gas> isValidGas, int x, int y) {
        return new GasInventorySlot(gasTank, stack -> {
            //NOTE: Even though we KNOW from isValid when we added the item that this should be an IGasItem, have it double check until we end up switching to a capability
            Item item = stack.getItem();
            //TODO: Use a capability instead of instanceof
            if (item instanceof IGasItem) {
                //Only allow extraction if our item is out of gas
                return ((IGasItem) item).getGas(stack).isEmpty();
            }
            //Always allow it if something went horribly wrong and we are not an IGasItem
            return true;
        }, stack -> {
            //NOTE: Even though we KNOW from isValid that this should be an IGasItem, have it double check until we end up switching to a capability
            Item item = stack.getItem();
            //TODO: Use a capability instead of instanceof
            if (item instanceof IGasItem) {
                GasStack containedGas = ((IGasItem) item).getGas(stack);
                //True if we can fill the tank with any of our contents, ignored if the item has no gas, as it won't pass isValid
                return gasTank.fill(containedGas, Action.SIMULATE) > 0;
            }
            return false;
        }, stack -> {
            Item item = stack.getItem();
            //TODO: Use a capability instead of instanceof
            if (item instanceof IGasItem) {
                //TODO: Add a way to the capability to see if the item can ever output gas, as things like jetpacks cannot have the gas be drained from them
                // Strictly speaking this currently could be done as gasItem.canProvideGas(stack, MekanismAPI.EMPTY_GAS), but is being ignored instead for clarity
                GasStack containedGas = ((IGasItem) item).getGas(stack);
                return !containedGas.isEmpty() && isValidGas.test(containedGas.getType());
            }
            return false;
        }, x, y);
    }

    /**
     * Accepts any items that can be filled with the current contents of the gas tank, or if it is a gas tank container and the tank is currently empty
     *
     * Drains the tank into this item.
     */
    public static GasInventorySlot drain(GasTank gasTank, int x, int y) {
        return new GasInventorySlot(gasTank, stack -> {
            //NOTE: Even though we KNOW from isValid that this should be an IGasItem, have it double check until we end up switching to a capability
            Item item = stack.getItem();
            //TODO: Use a capability instead of instanceof
            if (item instanceof IGasItem) {
                //Only allow extraction if our item is full
                return ((IGasItem) item).getNeeded(stack) == 0;
            }
            //Always allow it if something went horribly wrong and we are not an IGasItem
            return true;
        }, stack -> {
            Item item = stack.getItem();
            //TODO: Use a capability instead of instanceof
            if (item instanceof IGasItem) {
                IGasItem gasItem = (IGasItem) item;
                GasStack containedGas = gasItem.getGas(stack);
                //TODO: After switching to caps use simulations to see if the item can accept a given gas so that this would become
                // gasTank.isEmpty() OR it simulating the item accepting the gas.
                if (containedGas.isEmpty()) {
                    return true;
                }
                //NOTE: The canReceiveGas is not consistent on if it checks if we need any gas or we even double check the contained type
                return gasTank.isEmpty() || gasItem.canReceiveGas(stack, gasTank.getType());
            }
            return false;
        }, stack -> {
            Item item = stack.getItem();
            //TODO: Use a capability instead of instanceof
            if (item instanceof IGasItem) {
                //Only accept items that are gas items and can accept some form of gas
                return ((IGasItem) item).getNeeded(stack) > 0;
            }
            return false;
        }, x, y);
    }

    //TODO: Replace GasTank with an IGasHandler??
    private final GasTank gasTank;

    private GasInventorySlot(GasTank gasTank, Predicate<@NonNull ItemStack> canExtract, Predicate<@NonNull ItemStack> canInsert,
          @Nonnull Predicate<@NonNull ItemStack> validator, int x, int y) {
        super(canExtract, canInsert, validator, x, y);
        this.gasTank = gasTank;
    }

    //TODO: Make it so that the gas tank drains/fills
}