package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.MenuPage;
import pages.base.BasePage;

import java.util.Random;
import java.util.stream.Collectors;

public class CartPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("CategoriesPage.class");
    MenuPage menuPage = new MenuPage(driver);
    CategoryPage categoryPage = new CategoryPage(driver);
    @FindBy(css = "#quantity_wanted")
    private WebElement quantity;
    @FindBy(css = "div.add")
    private WebElement addToCartButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage clickRandomCategory() {
        log.info("Available categories: " + menuPage.categories.stream().map(WebElement::getText).collect(Collectors.toList()));
        WebElement category = randomValueFromList(menuPage.categories);
        log.info("Selected category: " + category.getText());
        clickOnElement(category);
        return this;
    }

    public CartPage clickRandomProduct() {
        WebElement product = randomValueFromList(categoryPage.productList);
        log.info("Selected product: " + product.getText());
        clickOnElement(product);
        return this;
    }

    public CartPage setRandomQuantityValue() {
        Random random = new Random();
        int value = random.nextInt(4) + 1;
        log.info("quantity: " + value);
        sendKeys(quantity, String.valueOf(value), true);
        return this;
    }

    public CartPage clickAddToCartButton() {
        clickOnElement(addToCartButton);
        return this;
    }
}
