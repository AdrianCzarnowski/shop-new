package pages.product;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.MenuPage;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.Keys.ENTER;


public class ArtPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("CategoriesPage.class");

    @FindBy(css = "a.ui-slider-handle:nth-of-type(1)")
    private WebElement leftSlider;
    @FindBy(css = "a.ui-slider-handle:nth-of-type(2)")
    private WebElement rightSlider;
    @FindBy(css = ".ui-slider")
    private WebElement slider;
    @FindBy(css = ".faceted-slider p")
    private WebElement price;
    @FindBy(css = "span.price")
    private List<WebElement> displatedProductsPrice;
    @FindBy(xpath = "//div[@id='_desktop_search_filters_clear_all']/button")
    private WebElement clearButton;
    @FindBy(css="#search_filters > p")
    private WebElement fliters;

    public ArtPage(WebDriver driver) {
        super(driver);
    }

    MenuPage menuPage = new MenuPage(driver);
    private int i = 2;

    public ArtPage clickArtCategory() {
        clickOnElement(menuPage.categories.get(i));
        log.info("<<<<<<<<<<<<<<<<Category after click: " + menuPage.categories.get(i).getText());
        return this;
    }

    public ArtPage priceStart9$Ends10$() {

        while (!price.getText().endsWith("$10.00")) {
            waitToBeVisible(rightSlider);
            waitToBeClickable(rightSlider);
            clickAndHold(rightSlider);
            actions.moveByOffset(-10, 0).perform();
            log.info(getTextFromElement(price));
        }
        clickOnElement(rightSlider);
        return this;
    }
}



