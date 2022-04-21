
import helpers.DriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;
import pages.SearchPage;
import properties.App;
import properties.reader.YamlReader;

public class TestBase  {

    private static Logger log = LoggerFactory.getLogger("TestBase.class");
    protected static WebDriver driver;
    private static App app;
    private static DriverFactory driverFactory = new DriverFactory();
    private static YamlReader yamlReader = new YamlReader();

    SearchPage searchResultPage = new SearchPage(driver);



    @BeforeAll
    static  void beforeAll(){
        app = new App();
        driver= driverFactory.getDriver
                (yamlReader.getConfig().getBrowserConfig().getDriverEnum());
    }
    @AfterAll
    static void tearDown(){
        driver.quit();
    }
}

