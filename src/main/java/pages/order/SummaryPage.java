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
    @FindBy(xpath = "//div[@class='order-line row']")
    private List<WebElement> products;

    public SummaryPage(WebDriver driver) {
        super(driver);
    }

    public SummaryPage checkOrderDetails() {
        List<String> productList = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            productList.add(getTextFromElement(products.get(i)));
        }
        log.info(String.valueOf(productList));
        return this;
    }
}
