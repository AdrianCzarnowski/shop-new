package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import model.DriverEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverFactory {
    private WebDriver driver;
    private  static Logger log = LoggerFactory.getLogger("DriverFactory");
    String appUrl = System.getProperty("appUrl");

    public WebDriver getDriver(DriverEnum driverEnum) {
        switch (driverEnum) {
            case CHROME:
                ChromeOptions optionsChrome = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                optionsChrome.addArguments("start-maximized");
                driver = new ChromeDriver(optionsChrome);
                driver.get("www.wp.pl");
                break;
            case FIREFOX:
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
                optionsFirefox.addArguments("start-maximized");
                driver = new FirefoxDriver(optionsFirefox);
                driver.get(System.getProperty("appUrl"));
                break;
            case IE:
                InternetExplorerOptions optionsdefault = new InternetExplorerOptions();
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver(optionsdefault);
                driver.get(System.getProperty("appUrl"));
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                WebDriverManager.edgedriver().setup();
                edgeOptions.addArguments("start-maximized");
                driver = new EdgeDriver(edgeOptions);
                driver.get(System.getProperty("appUrl"));

        }

        return null;
    }
}
