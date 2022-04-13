package configuration.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Browser {

    private static Logger log = LoggerFactory.getLogger("Browser.class");

    private String browserName;
    private String appUrl;

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

}
