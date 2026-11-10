package dev.ultimateclient;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.util.LinkedHashMap;
import java.util.Map;

public class UltimateMenuScreen extends Screen {
    private static final Map<String, Boolean> FEATURES = new LinkedHashMap<>();

    static {
        FEATURES.put("Fly", false);
        FEATURES.put("Speed", false);
        FEATURES.put("X-Ray", false);
        FEATURES.put("Fullbright", false);
        FEATURES.put("Night Vision", false);
        FEATURES.put("No Fall Damage", false);
        FEATURES.put("Player ESP", false);
        FEATURES.put("Auto Sprint", false);
    }

    public UltimateMenuScreen() {
        super(Component.literal("Ultimate Client"));
    }

    @Override
    protected void init() {
        int panelWidth = 310;
        int left = (this.width - panelWidth) / 2;
        int top = Math.max(28, (this.height - 300) / 2);

        int index = 0;
        for (String feature : FEATURES.keySet()) {
            final String name = feature;
            int col = index % 2;
            int row = index / 2;
            int x = left + 12 + col * 145;
            int y = top + 66 + row * 42;

            this.addRenderableWidget(Button.builder(
                    buttonText(name),
                    button -> {
                        FEATURES.put(name, !FEATURES.get(name));
                        button.setMessage(buttonText(name));
                    }
            ).bounds(x, y, 136, 28).build());

            index++;
        }

        this.addRenderableWidget(Button.builder(
                Component.literal("Close"),
                button -> this.onClose()
        ).bounds(left + 12, top + 252, panelWidth - 24, 24).build());
    }

    private Component buttonText(String name) {
        return Component.literal(name + "  [" + (FEATURES.get(name) ? "ON" : "OFF") + "]");
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float delta) {
        int panelWidth = 310;
        int panelHeight = 292;
        int left = (this.width - panelWidth) / 2;
        int top = Math.max(28, (this.height - 300) / 2);

        graphics.fill(0, 0, this.width, this.height, 0x99060912);
        graphics.fill(left, top, left + panelWidth, top + panelHeight, 0xFF111827);
        graphics.fill(left, top, left + panelWidth, top + 3, 0xFF38BDF8);
        graphics.fill(left + 1, top + 42, left + panelWidth - 1, top + 43, 0xFF334155);

        super.extractRenderState(graphics, mouseX, mouseY, delta);

        graphics.text(this.font, "ULTIMATE CLIENT", left + 14, top + 14, 0xFFFFFFFF, true);
        graphics.text(this.font, "FABRIC 26.2  •  RIGHT SHIFT", left + 14, top + 29, 0xFF94A3B8, false);
        graphics.text(this.font, "CLIENT FEATURES", left + 14, top + 51, 0xFF7DD3FC, false);
        graphics.text(this.font, "Toggle a feature to change its menu state.", left + 14, top + 228, 0xFF94A3B8, false);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
