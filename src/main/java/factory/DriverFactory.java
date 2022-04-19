package factory;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverFactory {

    private static Logger log = LoggerFactory.getLogger("DriverFactory.class");

    public DriverFactory(){}

    private static final Supplier<WebDriver> CHROME = ()->{
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    };
    private static final Supplier<WebDriver> FIREFOX = ()->{
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    };
    private static final Supplier<WebDriver> IE = ()->{
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    };
    private static final Supplier<WebDriver> EDGE = ()->{
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    };

    private static  final Map<DriverType,Supplier<WebDriver>> MAP = new EnumMap<>(DriverType.class);

    static {
        MAP.put(DriverType.CHROME, CHROME);
        MAP.put(DriverType.FIREFOX, FIREFOX);
        MAP.put(DriverType.IE, IE);
        MAP.put(DriverType.EDGE, EDGE);
    }

    public static WebDriver getDriver(DriverType browser){
        return MAP.get(browser).get();
    }

}
