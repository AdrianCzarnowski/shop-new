package pages.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class BasketPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("BasketPage.class");
    @FindBy(css = "#cart-subtotal-products > span.value")
    private static WebElement itemsValue;

    @FindBy(css = "span > strong")
    private List<WebElement> price;
    private List<String> priceList = new ArrayList<>();

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public String checkTotalCost() {
        return getTextFromElement(itemsValue).replace("$", "");
    }

    public double checkCostAfterChange() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        double cost = 0;
        double orderCostAfterChange = 0;

        for (int i = 0; i < price.size(); i++) {
            String value = getTextFromElement(price.get(i)).replace("$", "");
            cost = Double.parseDouble(value);
            log.info(String.valueOf(cost));
            priceList.add(value);
        }
        log.info(String.valueOf(priceList));
        for (int i = 0; i < priceList.size(); i++) {
            orderCostAfterChange += Double.parseDouble(priceList.get(i));

        }
        log.info("Order cost after change : " + orderCostAfterChange);
        return orderCostAfterChange;

    }
}
