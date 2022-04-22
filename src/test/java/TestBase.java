
import helpers.DriverFactory;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.CategoryPage;
import pages.SearchPage;
import properties.App;
import properties.reader.YamlReader;


public class TestBase {
    private static final Logger log = LoggerFactory.getLogger("TestBase.class");
    protected WebDriver driver;
    private static App app;
    public static SearchPage searchPage;
    public static CategoryPage categoryPage;
    private static DriverFactory driverFactory = new DriverFactory();
    private static YamlReader yamlReader = new YamlReader();


    @BeforeAll
    static void beforeAll() {
        app = new App();
    }

    @BeforeEach
    void beforeEach() {
        driver = driverFactory.getDriver(yamlReader.getConfig().getBrowserConfig().getDriverEnum());
        searchPage = new SearchPage(driver);
        categoryPage = new CategoryPage(driver);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}


