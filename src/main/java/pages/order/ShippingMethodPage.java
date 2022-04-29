package pages.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

public class ShippingMethodPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("ShippingMethodPage.class");
    @FindBy(xpath = "//button[@name='confirmDeliveryOption']")
    private WebElement confirmDeliveryOptionBtn;

    public ShippingMethodPage(WebDriver driver) {
        super(driver);
    }

    public ShippingMethodPage clickContinueBtn() {
        clickOnElement(confirmDeliveryOptionBtn);
        log.info("Shipping method selected");
        return this;
    }
}
