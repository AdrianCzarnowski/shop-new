package configuration.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

@Data
@NoArgsConstructor
public class Browser implements Supplier<WebDriver> {
    private static Logger log = LoggerFactory.getLogger("Browser.class");
    private String browserName;
    private String appUrl;

    @Override
    public WebDriver get() {
        return null;
    }
}
