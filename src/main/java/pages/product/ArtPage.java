package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;
import pages.navigation.MenuPage;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


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

    public ArtPage(WebDriver driver) {
        super(driver);
    }

    public ArtPage clickArtCategory() {
        clickOnElement(menuPage.categories.get(i));
        log.info("Category after click: " + menuPage.categories.get(i).getText());
        return this;
    }

    public ArtPage firstPriceFilter(String properties, int offset) {

        while (!price.getText().endsWith(properties)) {
            waitToBeVisible(rightSlider);
            waitToBeClickable(rightSlider);
            clickAndHold(rightSlider);
            actions.moveByOffset(offset, 0).perform();
            log.info(getTextFromElement(price));
        }
        releaseMouse(rightSlider);
        return this;
    }

    public ArtPage secondPriceFilter(String properties, int offset) {

        while (!price.getText().startsWith(properties)) {
            waitToBeVisible(leftSlider);
            waitToBeClickable(leftSlider);
            clickAndHold(leftSlider);
            actions.moveByOffset(offset, 0).perform();
            log.info(getTextFromElement(price));
        }
        releaseMouse(leftSlider);
        return this;
    }

    public ArtPage countMatchedProducts(String properties) {
        List<String> products = new ArrayList<>();
        for (int j = 0; j < displayedProductsPrice.size(); j++) {
            waitToBeVisible(displayedProductsPrice.get(j));
            products.add(displayedProductsPrice.get(j).getText());
            log.info("Products: " + getTextFromElement(displayedProductsPrice.get(j)));
            String value = displayedProductsPrice.get(j).getText();
            assertThat(value.contains(properties));
        }
        log.info("Number of matched products: " + displayedProductsPrice.size());
        return this;
    }


    public ArtPage clearFilters() {
        clickOnElement(clearButton);
        return this;
    }
}



