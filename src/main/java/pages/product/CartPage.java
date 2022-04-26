package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.MenuPage;
import pages.base.BasePage;

import java.util.Random;

public class CartPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("CategoriesPage.class");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    MenuPage menuPage = new MenuPage(driver);
    CategoryPage categoryPage = new CategoryPage(driver);

    @FindBy(css="#quantity_wanted")
    private WebElement quantity;
    @FindBy(css ="div.add")
    private WebElement addToCartButton;


    public CartPage clickRandomCategory(){
        clickOnElement(randomValueFromList(menuPage.categories));
        return this;
    }

    public CartPage clickRandomProduct(){
        clickOnElement(randomValueFromList(categoryPage.productList));
        return this;
    }
    public CartPage setRandomQuantityValue(){
        Random random = new Random();
        sendKeys(quantity, String.valueOf(random.nextInt(4)+1), true);
        return this;
    }
    public CartPage clickAddToCartButton(){
        clickOnElement(addToCartButton);
        return this;
    }
}
