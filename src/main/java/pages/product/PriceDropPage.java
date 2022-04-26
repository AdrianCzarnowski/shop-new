package pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;


public class PriceDropPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("CategoriesPage.class");
    CategoryPage categoryPage = new CategoryPage(driver);

    @FindBy(css = "#js-product-list-header")
    private WebElement onSaleTitle;
    @FindBy(css = "li:nth-child(2) > span")
    private WebElement subCategoriesTitle;

    By discountLabel = By.cssSelector("article > div > ul > li");
    By regularPrice = By.cssSelector("span.regular-price");
    By discountPrice = By.cssSelector("span.price");
    By productName = By.cssSelector("div.product-description > h2");


    public PriceDropPage(WebDriver driver) {
        super(driver);
    }

    public PriceDropPage checkOnSalePageAreLoaded() {
        log.info("Page header: " +getTextFromElement(onSaleTitle));
        log.info("Subcategory name: " +getTextFromElement(subCategoriesTitle));
        String subCategoriesToUpperCase = getTextFromElement(subCategoriesTitle).toUpperCase();
        assert (getTextFromElement(onSaleTitle).equals(subCategoriesToUpperCase));
        log.info("<<<<<<<<<<<<<" + subCategoriesToUpperCase+ " page loaded");
        return this;
    }

    public PriceDropPage checkVisibilityOfPricesAndDiscount() {
        log.info("Number of discounted products on the website: " + categoryPage.productList.size());
        for (int i = 0; i < categoryPage.productList.size(); i++) {

            WebElement discountValue = categoryPage.productList.get(i).findElement(discountLabel);
            WebElement regularPriceValue = categoryPage.productList.get(i).findElement(regularPrice);
            WebElement discountPriceValue = categoryPage.productList.get(i).findElement(discountPrice);
            WebElement productNameValue = categoryPage.productList.get(i).findElement(productName);

            if (discountValue != null && regularPriceValue != null
                    && discountPriceValue != null && productNameValue != null) {
                log.info("<<<<<<<<<<<<<Product: " + productNameValue.getText());
                log.info("<<<<<<<<<<<<<Discount: " + discountValue.getText());
                log.info("<<<<<<<<<<<<<Regular price: " + regularPriceValue.getText());
                log.info("<<<<<<<<<<<<<Discount price: " + discountPriceValue.getText());
            } else {
                throw new NullPointerException("ON SALE page is empty");
            }
        }
        return this;
    }
    public PriceDropPage calculateAndCheckDiscountPrice() {
        for (int i = 0; i < categoryPage.productList.size(); i++) {
            WebElement productNameValue = categoryPage.productList.get(i).findElement(productName);
            log.info("<<<<<<<<<<<<<Product: " + productNameValue.getText());

            double regularPriceValue = Double.parseDouble(categoryPage.productList.get(i)
                    .findElement(regularPrice).getText().substring(1));
            double discountPriceValue = Double.parseDouble(categoryPage.productList.get(i)
                    .findElement(discountPrice).getText().substring(1));
            double priceAfterDiscount = regularPriceValue*(0.8);

            assert (discountPriceValue == priceAfterDiscount);
            log.info("Discount price is well calculated" + "" +
                    " Regular price: "+ regularPriceValue + "$"+" after 20% off: " + priceAfterDiscount+"$");
            assert (discountPriceValue<regularPriceValue);
            log.info("Regular price is higher than the discounted price");

        }
        return  this;
    }
    public PriceDropPage openOneProduct() {
        clickOnElement(randomValueFromList(categoryPage.productList));
        log.info("<<<<<<<<<<<<<<<Go to random product page>>>>>>>>>>>>>>>>>>");
        return this;
    }
}



