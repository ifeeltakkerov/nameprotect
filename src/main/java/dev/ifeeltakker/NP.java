package dev.ifeeltakker;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NP implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("NP");

    @Override
    public void onInitialize() {
        Init.INSTANCE.init();
        LOGGER.info("Initializing NP");
    }
}
