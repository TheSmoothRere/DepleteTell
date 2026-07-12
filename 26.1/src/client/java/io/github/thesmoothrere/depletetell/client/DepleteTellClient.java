package io.github.thesmoothrere.depletetell.client;

import io.github.thesmoothrere.depletetell.Constants;
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

        int durabilityColor = durabilityColor((float) currentDurability / maxDurability);

        MutableComponent currentDurabilityComponent =
                Component.literal(String.valueOf(currentDurability))
                        .withColor(durabilityColor);

        MutableComponent maxDurabilityComponent =
                Component.literal(String.valueOf(maxDurability))
                        .withColor(0x00FF00);

        components.add(
                Component.translatable("item." + Constants.MOD_ID + ".durability")
                        .append(" ")
                        .append(currentDurabilityComponent)
                        .append("/")
                        .append(maxDurabilityComponent)
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
