package io.github.thesmoothrere.depletetell.client;

import io.github.thesmoothrere.depletetell.Constants;
import io.github.thesmoothrere.depletetell.config.DepleteConfig;
import io.github.thesmoothrere.relib.config.ConfigManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

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
        if (!itemStack.isDamaged()) return;

        int maxDurability = itemStack.getMaxDamage();
        int currentDurability = maxDurability - itemStack.getDamageValue();

        float percent = (float) currentDurability / maxDurability;
        int durabilityColor = durabilityColor(percent);

        MutableComponent durabilityDisplay = switch (CONFIG.durabilityStyle().getValue()) {
            case PERCENTAGE -> Component.literal(String.format("%.0f%%", percent * 100)).withColor(durabilityColor);
            case NUMBER_WITH_MAX_DAMAGE -> Component.empty()
                    .append(Component.literal(String.valueOf(currentDurability))
                            .withColor(durabilityColor))
                    .append("/")
                    .append(Component.literal(String.valueOf(maxDurability))
                            .withColor(0x00FF00));
            case NUMBER_WITH_DAMAGE_ONLY -> Component.literal(String.valueOf(currentDurability)).withColor(durabilityColor);
        };

        components.add(
                Component.translatable("item." + Constants.MOD_ID + ".durability")
                        .append(" ")
                        .append(durabilityDisplay)
        );
    }

    private static int durabilityColor(float percent) {
        percent = Mth.clamp(percent, 0.0F, 1.0F);

        if (percent < 0.5F) {
            return lerpColor(0xFF0000, 0xFFFF00, percent * 2.0F);
        } else {
            return lerpColor(0xFFFF00, 0x00FF00, (percent - 0.5F) * 2.0F);
        }
    }

    private static int lerpColor(int startColor, int endColor, float t) {
        t = Mth.clamp(t, 0.0F, 1.0F);

        int sr = (startColor >> 16) & 0xFF;
        int sg = (startColor >> 8) & 0xFF;
        int sb = startColor & 0xFF;

        int er = (endColor >> 16) & 0xFF;
        int eg = (endColor >> 8) & 0xFF;
        int eb = endColor & 0xFF;

        int r = Mth.lerpInt(t, sr, er);
        int g = Mth.lerpInt(t, sg, eg);
        int b = Mth.lerpInt(t, sb, eb);

        return (r << 16) | (g << 8) | b;
    }
}
