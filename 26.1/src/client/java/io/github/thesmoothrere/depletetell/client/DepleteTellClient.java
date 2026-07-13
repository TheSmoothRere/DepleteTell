package io.github.thesmoothrere.depletetell.client;

import io.github.thesmoothrere.depletetell.Constants;
import io.github.thesmoothrere.depletetell.config.DepleteConfig;
import io.github.thesmoothrere.relib.config.ConfigManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jspecify.annotations.NonNull;

import java.util.List;

@Environment(EnvType.CLIENT)
public class DepleteTellClient implements ClientModInitializer {
    private static final DepleteConfig CONFIG = ConfigManager.get(DepleteConfig.class);

    @Override
    public void onInitializeClient() {
        Constants.LOGGER.info(Constants.MOD_NAME + " client initialized!");
        ItemTooltipCallback.EVENT.register(DepleteTellClient::onTooltip);
    }

    private static void onTooltip(ItemStack itemStack, Item.TooltipContext tooltipContext,
                                  TooltipFlag tooltipFlag, List<Component> components) {
        if (!itemStack.isDamaged() && !CONFIG.alwaysShow().getValue()) return;

        Identifier itemKey = BuiltInRegistries.ITEM.getKey(itemStack.getItem());
        if (CONFIG.blacklistedItem().getValue().values().contains(itemKey.toString()))
            return;

        int maxDurability = itemStack.getMaxDamage();
        int currentDurability = maxDurability - itemStack.getDamageValue();

        float percent = (float) currentDurability / maxDurability;
        int durabilityColor = durabilityColor(percent);

        MutableComponent durabilityDisplay = switch (CONFIG.durabilityStyle().getValue()) {
            case PERCENTAGE -> durabilityPercentage(percent, durabilityColor);
            case NUMBER -> durabilityNumber(currentDurability, durabilityColor, maxDurability);
            case BAR -> durabilityBar(percent);
        };

        components.add(
                Component.translatable("item." + Constants.MOD_ID + ".durability")
                        .append(" ")
                        .append(durabilityDisplay)
        );
    }

    private static @NonNull MutableComponent durabilityPercentage(float percent, int durabilityColor) {
        return Component.literal(String.format("%.0f%%", percent * 100)).withColor(durabilityColor);
    }

    private static @NonNull MutableComponent durabilityNumber(int currentDurability, int durabilityColor, int maxDurability) {
        return Component.empty()
                .append(Component.literal(String.valueOf(currentDurability))
                        .withColor(durabilityColor))
                .append("/")
                .append(Component.literal(String.valueOf(maxDurability))
                        .withColor(0x00FF00));
    }

    private static @NonNull MutableComponent durabilityBar(float percent) {
        final int totalBars = 10;
        int filledBars = Math.round(percent * totalBars);

        MutableComponent component = Component.empty();

        for (int i = 0; i < totalBars; i++) {
            if (i < filledBars) {
                float barPercent = (float) (i + 1) / totalBars;
                component.append(Component.literal("❙")
                        .withColor(durabilityColor(barPercent)));
            } else {
                component.append(Component.literal("❙")
                        .withColor(0x555555));
            }
        }

        return component;
    }

    private static int durabilityColor(float percent) {
        percent = Mth.clamp(percent, 0.0F, 1.0F);
        percent = percent * percent * (3.0F - 2.0F * percent);

        return Mth.hsvToRgb(percent / 3.0F, 1.0F, 1.0F);
    }
}
