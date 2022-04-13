package configuration.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class Config {

    private static Logger log = LoggerFactory.getLogger("Config.class");

    public Config() {
    }

    public HashMap<String, Browser> getBrowsers() {
        return browsers;
    }

    public String getActiveBrowser() {
        return activeBrowser;
    }

    String activeBrowser;
    @JsonAnyGetter
    private HashMap<String, Browser> browsers;

    public void setBrowsers(HashMap<String, Browser> browsers) {
        this.browsers = browsers;
        log.info("<<<<<<<<<<<<<<<<<<<Number of test browsers available: " + browsers.size());
    }
}
