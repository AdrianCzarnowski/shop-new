
import base.BasePage;
import helpers.DriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import properties.App;
import properties.reader.YamlReader;

public class TestBase extends BasePage {

    private static Logger log = LoggerFactory.getLogger("TestBase.class");
    protected static WebDriver driver;
    private static App app;
    private static DriverFactory driverFactory = new DriverFactory();
    private static YamlReader yamlReader = new YamlReader();

    public TestBase(WebDriver driver) {
        super(driver);
    }


    @BeforeAll
    static  void beforeAll(){
        app = new App();
        driver= driverFactory.getDriver
                (yamlReader.getConfig().getBrowserConfig().getDriverEnum());
    }
    @AfterAll
    static void afterAll(){
        driver.close();
    }

}

