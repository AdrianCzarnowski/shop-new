import configuration.models.Browser;
import configuration.models.Config;
import factory.BrowserFactory;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {

    private static Logger log = LoggerFactory.getLogger("TestBase.class");
    protected static WebDriver driver;
    private static Browser browser;
    public static String driverType;
    public static BrowserFactory driverFactory;
    private static Config config;


    @BeforeAll
    static  void beforeAll(){


    }


}

