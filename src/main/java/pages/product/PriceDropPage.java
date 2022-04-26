package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

public class PriceDropPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("CategoriesPage.class");

    @FindBy(css = "#js-product-list-header")
    private WebElement onSaleTitle;
    @FindBy(css="li:nth-child(2) > span")
    private WebElement subCategoriesTitle;


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

}
