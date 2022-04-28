package pages.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class BasketPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("BasketPage.class");
    @FindBy(css = "#cart-subtotal-products > span.value")
    private static WebElement itemsValue;

    @FindBy(css = "span > strong")
    private List<WebElement> price;
    @FindBy(xpath = "//button[contains(@class, 'touchspin-up')]")
    private List<WebElement> productUpBtn;
    private List<String> priceList = new ArrayList<>();

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public String checkTotalCost() {
        return getTextFromElement(itemsValue).replace("$", "");
    }

    public void checkCostAfterChange() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        double orderCostAfterChange = 0;

        for (int i = 0; i < price.size(); i++) {
            String value = getTextFromElement(price.get(i)).replace("$", "");
            priceList.add(value);
        }
        for (int i = 0; i < priceList.size(); i++) {
            orderCostAfterChange += Double.parseDouble(priceList.get(i));
        }
        log.info("Order cost after change : " + round(orderCostAfterChange));
        assert (valueOf(orderCostAfterChange).contains(checkTotalCost()));
    }

    public BasketPage clickUpQuantityRandomProduct() {
        clickOnElement(productUpBtn.get(0));
        return this;
    }
}
