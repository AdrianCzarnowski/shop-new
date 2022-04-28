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
    @FindBy(xpath = "//button[contains(@class, 'touchspin-up')]")
    private List<WebElement> productUpBtn;
    @FindBy(xpath = "//button[contains(@class, 'touchspin-down')]")
    private List<WebElement> productDownBtn;


    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public String checkTotalCost() {
        return getTextFromElement(itemsValue).replace("$", "");
    }

    public BasketPage checkCostAfterChange() {
        List<String> priceList = new ArrayList<>();

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
            orderCostAfterChange += Double.parseDouble((priceList.get(i)));
        }
        log.info("Order cost after change : " + String.format("%.2f", orderCostAfterChange).replace(",", "."));
        assert (String.format("%.2f", orderCostAfterChange).replace(",", ".").contains(checkTotalCost()));
        log.info("Order cost is the same");
        return this;
    }

    public BasketPage clickUpQuantityRandomProduct() {
        clickOnElement(productUpBtn.get(productUpBtn.size() - 1));
        log.info("Product up button clicked");
        return this;
    }

    public BasketPage clickDownQuantityRandomProduct() {
        clickOnElement(productDownBtn.get(random.nextInt(productDownBtn.size() - 1)));
        log.info("Product down button clicked");
        return this;
    }
}
