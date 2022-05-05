package factory;

import helpers.DriverEnum;
import model.DriverSetup;
import org.openqa.selenium.WebDriver;


public class DriverFactory extends DriverSetup {
    public WebDriver getDriver(DriverEnum driverEnum) {
        switch (driverEnum) {
            case CHROME:
                setupChrome();
                break;
            case FIREFOX:
                setupFirefox();
                break;
            case IE:
                setupIE();
                break;
            case EDGE:
                setupEDGE();
                break;
        }
        return driver;
    }


}




