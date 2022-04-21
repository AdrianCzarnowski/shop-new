import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;


public class GetTittleTest extends TestBase {
    @Test
    public void getTittle() {
        System.out.println(driver.getTitle());
    }

}

