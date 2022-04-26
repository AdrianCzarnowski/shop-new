package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

public class ProductPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("CategoriesPage.class");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "span.discount.discount-percentage")
    private WebElement savePercent;
    @FindBy(css = "span.regular-price")
    private WebElement regularPrice;
    @FindBy(css = "div.product-price.h5.has-discount > div > span:nth-child(1)")
    private WebElement discountPrice;
    @FindBy(css="div:nth-child(2) > h1")
    private WebElement productName;

    public ProductPage checkVisibilityOfSaveLabel() {
        waitToBeVisible(savePercent);
        waitToBeVisible(regularPrice);
        waitToBeVisible(discountPrice);
        log.info("Selected product: " + getTextFromElement(productName));
        log.info("Save label is visibile. Text inside: " + getTextFromElement(savePercent));
        log.info("Regular price is visibile. Value: " + getTextFromElement(regularPrice));
        log.info("Discount price is visibile. Value: " + getTextFromElement(discountPrice));
        return this;
    }

    public ProductPage checkCalculateDiscount() {
        double regularPriceValue = Double.parseDouble(regularPrice.getText().substring(1));
        double discountPriceValue = Double.parseDouble(discountPrice.getText().substring(1));
        double priceAfterDiscount = regularPriceValue * (0.8);
        assert (discountPriceValue == priceAfterDiscount);
        log.info("Discount price is well calculated" + "" +
                " Regular price: " + regularPriceValue + "$" + " after 20% off: " + priceAfterDiscount + "$");
        assert (discountPriceValue < regularPriceValue);
        log.info("Regular price is higher than the discounted price");
        return this;
    }
}

