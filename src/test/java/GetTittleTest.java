import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;


public class GetTittleTest extends TestBase {


    public GetTittleTest(WebDriver driver) {
        super(driver);
    }

    @Test
    public void getTittle() {
        System.out.println(driver.getTitle());
    }

}

