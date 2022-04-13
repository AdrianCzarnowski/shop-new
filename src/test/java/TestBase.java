import configuration.Browsers;
import factory.DriverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {

    private static Logger log = LoggerFactory.getLogger("TestBase.class");

    DriverFactory driverFactory = new DriverFactory(Browsers.loadConfig());
}
