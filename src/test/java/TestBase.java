import configuration.models.Browser;
import configuration.models.Config;
import factory.DriverFactory;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

public class TestBase {

    private static Logger log = LoggerFactory.getLogger("TestBase.class");
    protected static WebDriver driver;
    private static Browser browser;
    public static Supplier<WebDriver> driverType;
    public static DriverFactory driverFactory;
    private static Config config;


    @BeforeAll
    static  void beforeAll(){
        browser = config.getActiveBrowser();
        driverType = driverFactory.getDriver(browser);


    }


}

