package pages.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

public class OrderHistoryPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("OrderHistoryPage.class");
    @FindBy(css = "tbody > tr > th")
    private WebElement orderReference;
    @FindBy(css = "tbody > tr > td:nth-child(2)")
    private WebElement date;

    @FindBy(css = "tbody > tr > td:nth-child(3)")
    private WebElement totalPrice;

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    public String orderReference() {
        String order = getTextFromElement(orderReference);
        return order;
    }

    public String orderDate() {
        String orderDate = getTextFromElement(date);
        return orderDate;
    }

    public double orderTotalPrice() {
        double total = Double.parseDouble(getTextFromElement(totalPrice).replace("$", ""));
        return total;
    }
}

