package mekanism.client.gui.element.tab;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import mekanism.client.gui.IGuiWrapper;
import mekanism.client.gui.element.GuiTexturedElement;
import mekanism.common.MekanismLang;
import mekanism.common.config.MekanismConfig;
import mekanism.common.util.MekanismUtils;
import mekanism.common.util.MekanismUtils.ResourceType;
import mekanism.common.util.UnitDisplayUtils.TempType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class GuiHeatTab extends GuiTexturedElement {

    private final IInfoHandler infoHandler;
    private final Map<TempType, ResourceLocation> icons = new Object2ObjectOpenHashMap<>();

    public GuiHeatTab(IInfoHandler handler, IGuiWrapper gui) {
        super(MekanismUtils.getResource(ResourceType.GUI, "heat_info.png"), gui, -26, 109, 26, 26);
        infoHandler = handler;
    }

    @Override
    public void renderButton(int mouseX, int mouseY, float partialTicks) {
        minecraft.textureManager.bindTexture(getResource());
        blit(x, y, 0, 0, width, height, width, height);
    }

    @Override
    public void renderToolTip(int mouseX, int mouseY) {
        List<ITextComponent> info = new ArrayList<>(infoHandler.getInfo());
        info.add(MekanismLang.UNIT.translate(MekanismConfig.general.tempUnit.get()));
        displayTooltips(info, mouseX, mouseY);
    }

    @Override
    protected ResourceLocation getResource() {
        return icons.computeIfAbsent(MekanismConfig.general.tempUnit.get(), (type) ->
              MekanismUtils.getResource(ResourceType.GUI, "tabs/heat_info_" + type.name().toLowerCase() + ".png"));
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        MekanismConfig.general.tempUnit.set(MekanismConfig.general.tempUnit.get().getNext());
    }
}