package pages.product;

import model.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

import static model.Product.productList;

public class CartOrderDetailsPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("CartOrderDetailsPage.class");
    @FindBy(css = ".product-container [itemprop=name]")
    private WebElement productName;
    @FindBy(css = "div.col-md-5.divide-right > div > div:nth-child(2) > p")
    private WebElement productPrice;
    @FindBy(css = "span.product-quantity > strong")
    private WebElement productQuantity;

    @FindBy(css = "div.col-md-7 > div > div > button")
    private WebElement continueShoppingBtn;

    public CartOrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    public Product newProductBuilder() {
        String productNameText = getTextFromElement(productName);
        String productPriceText = getTextFromElement(productPrice).replace("$", "");
        String productQuantityText = getTextFromElement(productQuantity);


        Product product = new Product(productNameText, Double.parseDouble(productPriceText),
                Integer.parseInt(productQuantityText));
        log.info("Created item:" + product);
        return product;
    }

    public CartOrderDetailsPage clickCountinueShopping() {
        clickOnElement(continueShoppingBtn);
        return this;
    }

    public void productChart() {
        Product newProduct = newProductBuilder();
        log.info("Products in list:");
        productList.forEach(p -> log.info("\t- " + p.toString() + "\n"));
        if (productList.contains(newProduct)) {
            log.info("List contains item");
            Product productFromList = productList.get(productList.indexOf(newProduct));
            productFromList.setQuantityOfProducts(productFromList.getQuantity() + newProduct.getQuantity());
            log.info("<<<<<<<<<<<<<<<<<Quantity updated: " + newProduct.getQuantity());
        } else {
            log.warn("List doesnt contian item");
            productList.add(newProduct);
            log.info("<<<<<<<<<<New product added: " + newProduct.getProductName());
        }

//        if (productList.size() > 0) {
//            for (int i = 0; i < productList.size(); i++) {
//                if (productList.contains(newProduct)) {
//                    productList.get(i)
//                            .setQuantityOfProducts((productList
//                                    .get(i).getQuantity()) + newProduct.getQuantity());
//                    log.info("<<<<<<<<<<<<<<<<<Quantity updated: " + newProduct.getQuantity());
//                    continue;
//                } else {
//                    productList.add(newProduct);
//                    log.info("<<<<<<<<<<New product added: " + newProduct.getProductName());
//                }
//            }
//        }
    }
}
