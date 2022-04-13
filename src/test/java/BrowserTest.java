import factory.DriverType;
import factory.DriverFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class BrowserTest {


    @Test
    public void driverFactoryTest(String browser){
        WebDriver driver = DriverFactory.getDriver(DriverType.CHROME);
        driver.get("https://google.com");
    }

}
