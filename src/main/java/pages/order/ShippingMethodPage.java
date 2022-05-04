package pages.order;

import helpers.OrderDataCollect;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

//import static model.DataCollect.dataList;

public class ShippingMethodPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("ShippingMethodPage.class");
    public OrderDataCollect orderDataCollect;
    @FindBy(xpath = "//button[@name='confirmDeliveryOption']")
    private WebElement confirmDeliveryOptionBtn;
    @FindBy(css = "[for='delivery_option_1'] .carrier-name")
    private WebElement nameOfShippingMethod;

    public ShippingMethodPage(WebDriver driver) {
        super(driver);
    }

    public ShippingMethodPage clickContinueBtn() {
        clickOnElement(confirmDeliveryOptionBtn);
        log.info("Shipping method selected");
        return this;
    }

    public OrderDataCollect shippingMethodName() {
        String shippingNameText = getTextFromElement(nameOfShippingMethod).trim();
        log.info(getTextFromElement(nameOfShippingMethod));
        OrderDataCollect orderDataCollect1 = new OrderDataCollect(shippingNameText);
        return orderDataCollect1;
    }


}
