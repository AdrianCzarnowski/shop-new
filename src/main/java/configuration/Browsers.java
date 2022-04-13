package configuration;

import configuration.models.Browser;
import configuration.models.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Browsers {

    private static Logger log = LoggerFactory.getLogger("Browsers.class");

    public static Browser getInstance() {
        return Browsers.BrowserPropertySingleton.INSTANCE;
    }

    private static class BrowserPropertySingleton {
        private static final Browser INSTANCE = loadConfig();
    }

    public static Browser loadConfig() {

        YamlReader yamlReader = new YamlReader();
        Config config = yamlReader.getConfig();

        try {
            String activeBrowser = config.getActiveBrowser();
            log.info("<<<<<<<<<<<<<<<<<<<Active environment founded name: " + activeBrowser.toUpperCase());
            return config.getBrowsers().get(activeBrowser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
