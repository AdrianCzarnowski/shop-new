package pages.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class SummaryPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("BasePage.class");
    List<String> productList = new ArrayList<>();
    @FindBy(xpath = "//div[@class='order-line row']")
    private List<WebElement> products;
    @FindBy(css = "#order-details > ul > li:nth-child(1)")
    private WebElement orderReference;
    @FindBy(css = "#order-details > ul > li:nth-child(3)")
    private WebElement shippingMethod;

    @FindBy(css = "#order-details > ul > li:nth-child(2)")
    private WebElement paymentMethod;


    public SummaryPage(WebDriver driver) {
        super(driver);
    }

    public SummaryPage checkOrderDetails() {

        for (int i = 0; i < products.size(); i++) {
            waitToBeVisibleAllElements(products);
            productList.add(getTextFromElement(products.get(i)));
        }
        log.info(String.valueOf(productList));
        return this;
    }

    public SummaryPage getOrderReference() {
        log.info(getTextFromElement(orderReference).replace("Order reference: ", ""));
        return this;
    }

    public String getShippingMethod() {
        String shippingMethodName = getTextFromElement(shippingMethod).replace("Shipping method: ", "").replace("Pick up in-store", "");
        log.info("Shipping method name: " + getTextFromElement(shippingMethod).replace("Shipping method: ", "").replace("Pick up in-store", ""));
        return shippingMethodName;
    }

    public String getPaymentMethod() {
        String payment = getTextFromElement(paymentMethod);
        log.info(payment);
        return payment;
    }
}
