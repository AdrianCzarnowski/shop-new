package pages.product;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.MenuPage;
import pages.base.BasePage;

import java.util.Random;
import java.util.stream.Collectors;

public class RandomProductPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("CategoriesPage.class");

    public final int numberOfAdditionToCart = Integer.parseInt(System.getProperty("number_of_addition_to_cart"));
    public final int firstProductQuantity = Integer.parseInt(System.getProperty("first_product_quantity"));
    MenuPage menuPage = new MenuPage(driver);
    CategoryPage categoryPage = new CategoryPage(driver);
    @FindBy(css = "#quantity_wanted")
    private WebElement quantity;
    @FindBy(css = "div.add")
    private WebElement addToCartButton;
    @FindBy(css = "#_desktop_cart")
    private WebElement basket;

    @FindBy(xpath = "//li[1]/div/div[3]/div/div[2]/div/div[1]/div/input")
    private WebElement firstProduct;

    public RandomProductPage(WebDriver driver) {
        super(driver);
    }

    public RandomProductPage clickRandomCategory() {
        log.info("Available categories: " + menuPage.categories.stream().map(WebElement::getText).collect(Collectors.toList()));
        WebElement category = randomValueFromList(menuPage.categories);
        log.info("Selected category: " + category.getText());
        clickOnElement(category);
        return this;
    }

    public RandomProductPage clickRandomProduct() {
        WebElement product = randomValueFromList(categoryPage.productList);
        log.info("Selected product: " + product.getText());
        clickOnElement(product);
        return this;
    }

    public RandomProductPage setRandomQuantityValue() {
        Random random = new Random();
        int value = random.nextInt(4) + 1;
        log.info("quantity: " + value);
        sendKeys(quantity, String.valueOf(value), true);
        return this;
    }

    public RandomProductPage setFirstProductQuantity() {
        clickOnElement(firstProduct);
        firstProduct.sendKeys(Keys.BACK_SPACE);
        sendKeys(firstProduct, String.valueOf(firstProductQuantity), true);
        return this;
    }

    public RandomProductPage clickAddToCartButton() {
        clickOnElement(addToCartButton);
        return this;
    }

    public RandomProductPage clickBasketBtn() {
        clickOnElement(basket);
        return this;
    }
}
