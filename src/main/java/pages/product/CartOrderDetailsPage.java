package pages.product;

import model.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class CartOrderDetailsPage extends BasePage {

    public CartOrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="div:nth-child(2) > h6")
    private WebElement productName;
    @FindBy(css ="div.col-md-5.divide-right > div > div:nth-child(2) > p")
    private WebElement productPrice;
    @FindBy(css="span.product-quantity > strong")
    private WebElement productQuantity;
    @FindBy(css ="span.subtotal.valu")
    private WebElement productsValue;

    public Product build() {
        Product product = new Product(getTextFromElement(productName), Double.parseDouble(getTextFromElement(productPrice)),
                Integer.parseInt(getTextFromElement(productQuantity)),Double.parseDouble(getTextFromElement(productsValue)));
        return product;
    }
}
