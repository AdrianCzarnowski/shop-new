import factory.BrowserType;
import factory.DriverFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class BrowserTest {


    @Test
    public void driverFactoryTest(String browser){
        WebDriver driver = DriverFactory.getDriver(BrowserType.CHROME);
        driver.get("https://google.com");
    }

}
