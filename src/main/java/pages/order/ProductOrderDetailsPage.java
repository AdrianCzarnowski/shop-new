package pages.order;

import model.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

import static model.Product.productList;

public class ProductOrderDetailsPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("ProductOrderDetailsPage.class");
    @FindBy(css = ".product-container [itemprop=name]")
    private static WebElement productName;
    @FindBy(css = "[itemprop=price]")
    private static WebElement productPrice;
    @FindBy(css = "span.product-quantity > strong")
    private static WebElement productQuantity;

    @FindBy(css = "div.col-md-7 > div > div > button")
    private WebElement continueShoppingBtn;

    public ProductOrderDetailsPage(WebDriver driver) {
        super(driver);
    }


    public static Product newProductBuilder() {
        String productNameText = getTextFromElement(productName);
        highLightenerMethod(productPrice);
        String productPriceText = getTextFromElement(productPrice).replace("$", "");
        String productQuantityText = getTextFromElement(productQuantity).replace("$", "");


        Product product = new Product(productNameText, Double.parseDouble(productPriceText),
                Integer.parseInt(productQuantityText));
        log.info("Created item:" + product);
        return product;
    }

    public ProductOrderDetailsPage clickContinueShopping() {
        clickOnElement(continueShoppingBtn);
        return this;
    }

    public void checkCartOfProducts() {
        Product newProduct = newProductBuilder();


        if (productList.contains(newProduct)) {
            Product productFromList = productList.get(productList.indexOf(newProduct));
            log.info("List contains item");
            productFromList.addQuantity(newProduct.getQuantity());
            log.info("Quantity updated " + newProduct.getProductName() + " quantity after updated: " + newProduct.getQuantity());

        } else {
            log.warn("List doesn't contains item");
            productList.add(newProduct);
            log.info("New product added: " + newProduct.getProductName());
        }
        log.info("Products in list: ");
        productList.forEach(product -> log.info("\t- " + product.toString() + "\n"));
    }
}

