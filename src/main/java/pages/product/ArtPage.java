package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.MenuPage;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;


public class ArtPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("CategoriesPage.class");
    private final int i = 2;
    MenuPage menuPage = new MenuPage(driver);
    @FindBy(css = "a.ui-slider-handle:nth-of-type(1)")
    private WebElement leftSlider;
    @FindBy(css = "a.ui-slider-handle:nth-of-type(2)")
    private WebElement rightSlider;
    @FindBy(css = ".faceted-slider p")
    private WebElement price;
    @FindBy(css = "span.price")
    private List<WebElement> displayedProductsPrice;
    @FindBy(xpath = "//div[@id='_desktop_search_filters_clear_all']/button")
    private WebElement clearButton;
    @FindBy(css = "#category > div")
    private WebElement reload;
    public ArtPage(WebDriver driver) {
        super(driver);
    }

    public ArtPage clickArtCategory() {
        clickOnElement(menuPage.categories.get(i));
        log.info("Category after click: " + menuPage.categories.get(i).getText());
        return this;
    }

    public ArtPage firstFilterOfPrices() {

        while (!price.getText().endsWith(System.getProperty("max_value_first_filter"))) {
            waitToBeVisible(rightSlider);
            waitToBeClickable(rightSlider);
            clickAndHold(rightSlider);
            actions.moveByOffset(-10, 0).perform();
            log.info(getTextFromElement(price));
        }
        clickOnElement(rightSlider);
        waitToBeInvisible(reload);
        return this;
    }

    public ArtPage secondFilterOfPrices() {

        while (!price.getText().startsWith(System.getProperty("max_value_first_filter"))) {
            waitToBeVisible(leftSlider);
            waitToBeClickable(leftSlider);
            clickAndHold(leftSlider);
            actions.moveByOffset(10, 0).perform();
            log.info(getTextFromElement(price));
        }
        clickOnElement(rightSlider);
        waitToBeInvisible(reload);
        return this;
    }

    public ArtPage firstFilteredMatchedProducts() {
        List<String> products = new ArrayList<>();
        for (int j = 0; j < displayedProductsPrice.size(); j++) {
            products.add(getTextFromElement(displayedProductsPrice.get(j)));
            log.info("Products: " + getTextFromElement(displayedProductsPrice.get(j)));
            String value = displayedProductsPrice.get(j).getText();
            assert (value.contains(System.getProperty("min_value_first_filter")));
        }
        log.info("Number of matched products: " + displayedProductsPrice.size());
        return this;
    }

    public ArtPage secondFilteredMatchedProducts() {
        List<String> products = new ArrayList<>();
        for (int j = 0; j < displayedProductsPrice.size(); j++) {
            products.add(getTextFromElement(displayedProductsPrice.get(j)));
            log.info("Products: " + getTextFromElement(displayedProductsPrice.get(j)));
            String value = displayedProductsPrice.get(j).getText();
            assert (value.contains(System.getProperty("max_value_second_filter")));
        }
        log.info("Number of matched products: " + displayedProductsPrice.size());
        return this;
    }

    public ArtPage clearFilters() {
        clickOnElement(clearButton);
        return this;
    }
}



