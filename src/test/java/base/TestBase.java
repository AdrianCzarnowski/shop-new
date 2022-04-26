package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import properties.App;


public class TestBase {
    private static final Logger log = LoggerFactory.getLogger("TestBase.class");
    protected WebDriver driver;
    private static App app;
    private static DriverFactory driverFactory = new DriverFactory();

    @BeforeAll
    static void beforeAll() {
        app = new App();
    }

    @BeforeEach
    void beforeEach() {
        driver = driverFactory.getDriver(driverFactory.getBrowserName());

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}


