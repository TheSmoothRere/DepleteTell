package io.github.thesmoothrere.depletetell.config;

import io.github.thesmoothrere.depletetell.util.DurabilityStyle;
import io.github.thesmoothrere.depletetell.Constants;
import io.github.thesmoothrere.relib.api.Config;
import io.github.thesmoothrere.relib.api.ConfigApi;
import io.github.thesmoothrere.relib.config.option.BooleanOption;
import io.github.thesmoothrere.relib.config.option.EnumOption;
import io.github.thesmoothrere.relib.config.option.ListStringOption;

@Config(name = Constants.MOD_ID)
public class DepleteConfig implements ConfigApi {
    private final BooleanOption alwaysShow = new BooleanOption("alwaysShow", false);
    private final EnumOption<DurabilityStyle> durabilityStyle = new EnumOption<>("durabilityStyle", DurabilityStyle.NUMBER);
    private final ListStringOption blacklistedItem = new ListStringOption("blacklistedItem");

    public BooleanOption alwaysShow() {
        return alwaysShow;
    }

    public EnumOption<DurabilityStyle> durabilityStyle() {
        return durabilityStyle;
    }

    public ListStringOption blacklistedItem() {
        return blacklistedItem;
    }
}
