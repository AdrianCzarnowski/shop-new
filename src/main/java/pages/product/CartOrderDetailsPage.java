package pages.product;

import model.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

public class CartOrderDetailsPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("CartOrderDetailsPage.class");

    public CartOrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="div:nth-child(2) > h6")
    private WebElement productName;
    @FindBy(css ="div.col-md-5.divide-right > div > div:nth-child(2) > p")
    private WebElement productPrice;
    @FindBy(css="span.product-quantity > strong")
    private WebElement productQuantity;
    @FindBy(css ="span.subtotal.value")
    private WebElement productsValue;

    public Product newProductBuilder() {
        Product product = new Product(getTextFromElement(productName), Double.parseDouble(getTextFromElement(productPrice).substring(1)),
                Integer.parseInt(getTextFromElement(productQuantity)),Double.parseDouble(getTextFromElement(productsValue).substring(1)));
        return product;
    }
    public void productChart(Product product){
        Product newProduct = newProductBuilder();
        if (product.getProductList().size()>0){
            for (int i = 0; i <product.getProductList().size(); i++) {
                if (product.getProductList().get(i).equals(newProduct)){
                    product.getProductList().get(i)
                            .setQuantityOfProducts((product.getProductList()
                                    .get(i).getQuantity()) + newProduct.getQuantity());
                }else product.getProductList().add(newProduct);
            }
        }
    }
}
