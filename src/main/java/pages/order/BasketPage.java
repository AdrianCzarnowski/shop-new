package pages.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

public class BasketPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("BasketPage.class");
    @FindBy(css = "#cart-subtotal-products > span.value")
    private static WebElement itemsValue;

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public String checkTotalCost() {
        return getTextFromElement(itemsValue).replace("$", "");
    }
}

