package pages.product;

import model.ProductModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

import static model.ProductModel.productList;

public class CartProductOrderDetailsPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("CartOrderDetailsPage.class");
    @FindBy(css = ".product-container [itemprop=name]")
    private WebElement productName;
    @FindBy(css = "div.col-md-5.divide-right > div > div:nth-child(2) > p")
    private WebElement productPrice;
    @FindBy(css = "span.product-quantity > strong")
    private WebElement productQuantity;

    @FindBy(css = "div.col-md-7 > div > div > button")
    private WebElement continueShoppingBtn;

    public CartProductOrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    public ProductModel newProductBuilder() {
        String productNameText = getTextFromElement(productName);
        String productPriceText = getTextFromElement(productPrice).replace("$", "");
        String productQuantityText = getTextFromElement(productQuantity).replace("$", "");


        ProductModel product = new ProductModel(productNameText, Double.parseDouble(productPriceText),
                Integer.parseInt(productQuantityText));
        log.info("Created item:" + product);
        return product;
    }

    public CartProductOrderDetailsPage clickContinueShopping() {
        clickOnElement(continueShoppingBtn);
        return this;
    }

    public void checkCartOfProducts() {
        ProductModel newProduct = newProductBuilder();

        if (productList.contains(newProduct)) {
            log.info("List contains item");
            ProductModel productFromList = productList.get(productList.indexOf(newProduct));
            productFromList.setQuantityOfProducts(productFromList.getQuantity() + newProduct.getQuantity());
            log.info("Quantity updated " + newProduct.getProductName() + " quantity after updated: " + newProduct.getQuantity());

        } else {
            log.warn("List doesn't contains item");
            productList.add(newProduct);
            log.info("New product added: " + newProduct.getProductName());
        }
        log.info("Products in list:");
        productList.forEach(p -> log.info("\t- " + p.toString() + "\n"));
    }
}
