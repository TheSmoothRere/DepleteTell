package io.github.thesmoothrere.depletetell.config;

import io.github.thesmoothrere.depletetell.util.DurabilityStyle;
import io.github.thesmoothrere.depletetell.Constants;
import io.github.thesmoothrere.relib.api.Config;
import io.github.thesmoothrere.relib.api.ConfigApi;
import io.github.thesmoothrere.relib.config.option.EnumOption;

@Config(name = Constants.MOD_ID)
public class DepleteConfig implements ConfigApi {
    private final EnumOption<DurabilityStyle> durabilityStyle = new EnumOption<>("durabilityStyle", DurabilityStyle.NUMBER_WITH_MAX_DAMAGE);

    public EnumOption<DurabilityStyle> durabilityStyle() {
        return durabilityStyle;
    }
}
