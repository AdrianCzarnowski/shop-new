
import helpers.DriverFactory;

import model.DriverEnum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.FooterPage;
import pages.MenuPage;
import pages.base.BasePage;
import pages.product.*;
import properties.App;
import properties.reader.YamlReader;


public class TestBase {
    private static final Logger log = LoggerFactory.getLogger("TestBase.class");
    protected WebDriver driver;
    private static App app;
    private static DriverFactory driverFactory = new DriverFactory();
    private static YamlReader yamlReader = new YamlReader();

    public static SearchPage searchPage;
    public static CategoryPage categoryPage;
    public static ArtPage artPage;
    public static FooterPage footerPage;
    public static PriceDropPage priceDropPage;
    public static ProductPage productPage;
    public static CartPage cartPage;

    @BeforeAll
    static void beforeAll() {
        app = new App();
    }

    @BeforeEach
    void beforeEach() {
        driver = driverFactory.getDriver(yamlReader.getBrowserName());
        searchPage = new SearchPage(driver);
        categoryPage = new CategoryPage(driver);
        artPage = new ArtPage(driver);
        footerPage = new FooterPage(driver);
        priceDropPage = new PriceDropPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}


