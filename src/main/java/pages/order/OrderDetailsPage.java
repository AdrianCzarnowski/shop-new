package pages.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static model.Product.productList;

public class OrderDetailsPage extends BasketPage {

    private static Logger log = LoggerFactory.getLogger("OrderHistoryPage.class");
    List<String> productLi = new ArrayList<>();
    @FindBy(xpath = "//table[@id='order-products']//tbody//tr")
    private List<WebElement> productRows;

    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> checkOrderDetails() {

        for (int i = 0; i < productRows.size(); i++) {
            waitToBeVisibleAllElements(productRows);
            productLi.add(getTextFromElement(productRows.get(i)));
        }
        log.info(String.valueOf(productLi));
        return productLi;
    }

    public OrderDetailsPage details() {

        List<String> product = checkOrderDetails();
        log.info("111 " + productList.get(0).getProductName());
        log.info("222 " + String.valueOf(productList.get(0).getProductPrice()));
        for (int i = 0; i < product.size(); i++) {
            for (int j = 0; j < productList.size(); j++) {
                if (product.get(i).contains(productList.get(j).getProductName())
                        && (product.get(i).contains((String.valueOf(productList.get(j).getProductPrice()))))
                        && (product.get(i).contains((String.valueOf(productList.get(j).getQuantity()))))) {

                }
            }

        }

        log.info("All products is visible and data are correct");
        return this;
    }
}
