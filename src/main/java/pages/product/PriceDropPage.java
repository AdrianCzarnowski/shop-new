package pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class PriceDropPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("CategoriesPage.class");
    CategoryPage categoryPage;

    @FindBy(css = "#js-product-list-header")
    private WebElement onSaleTitle;
    @FindBy(css="li:nth-child(2) > span")
    private WebElement subCategoriesTitle;

    @FindBy(xpath = "//div[@itemprop='itemListElement']")
    private List<WebElement> discountProducts;

    By discount = By.cssSelector("article > div > ul > li");


    public PriceDropPage(WebDriver driver) {
        super(driver);
    }

    public PriceDropPage checkOnSalePageAreLoaded(){
        log.info(getTextFromElement(onSaleTitle));
        log.info(getTextFromElement(subCategoriesTitle));
        String subCategoriesToUpperCase = getTextFromElement(subCategoriesTitle).toUpperCase();
        assert(getTextFromElement(onSaleTitle).equals(subCategoriesToUpperCase));
        log.info("<<<<<<<<<<<<<ON SALE page loaded");
        return this;
    }

    public PriceDropPage checkVisibilityOfDiscount(){
        log.info("Number of discounted products on the website: " + discountProducts.size());
        for (int i = 0; i <discountProducts.size() ; i++) {
            WebElement discountValue = discountProducts.get(i).findElement(discount);
            if(discountValue != null){
                log.info("<<<<<<<<<<Discount: " + discountValue.getText());
            }else {
                throw new NullPointerException("On sale page is empty");
            }
        }
        return this;
    }

}
