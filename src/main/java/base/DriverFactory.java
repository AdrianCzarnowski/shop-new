package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.NoArgsConstructor;
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
import properties.reader.YamlReader;

@NoArgsConstructor
public class DriverFactory {
    private static Logger log = LoggerFactory.getLogger("DriverFactory");
    YamlReader yamlReader = new YamlReader();
    private WebDriver driver;

    public WebDriver getDriver(DriverEnum driverEnum) {
        switch (driverEnum) {
            case CHROME:
                ChromeOptions optionsChrome = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                optionsChrome.addArguments("start-maximized");
                driver = new ChromeDriver(optionsChrome);
                String URL = System.getProperty("appUrl");
                driver.get(URL);
                break;
            case FIREFOX:
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
                optionsFirefox.addArguments("start-maximized");
                driver = new FirefoxDriver(optionsFirefox);
                driver.get(System.getProperty("appUrl"));
                break;
            case IE:
                InternetExplorerOptions optionsIe = new InternetExplorerOptions();
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver(optionsIe);
                driver.get(System.getProperty("appUrl"));
            case EDGE:
                EdgeOptions optionsEdge = new EdgeOptions();
                WebDriverManager.edgedriver().setup();
                optionsEdge.addArguments("start-maximized");
                driver = new EdgeDriver(optionsEdge);
                driver.get(System.getProperty("appUrl"));
        }
        return driver;
    }
}



