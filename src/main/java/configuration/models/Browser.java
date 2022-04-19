package configuration.models;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public class Browser {

    private static Logger log = LoggerFactory.getLogger("Browser.class");

    private String browserName;
    private String appUrl;

}
