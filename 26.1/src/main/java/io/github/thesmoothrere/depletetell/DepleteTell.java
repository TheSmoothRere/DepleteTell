package io.github.thesmoothrere.depletetell;

import net.fabricmc.api.ModInitializer;

public class DepleteTell implements ModInitializer {
    @Override
    public void onInitialize() {
        Constants.LOGGER.info(Constants.MOD_NAME + " initialized!");
    }
}
