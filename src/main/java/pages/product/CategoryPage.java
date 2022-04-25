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

public class CategoryPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("CategoriesPage.class");
    MenuPage menuPage = new MenuPage(driver);

    @FindBy(xpath = "//div[@itemprop='itemListElement']")
    private List<WebElement> productList;

    @FindBy(css = "#js-product-list-header > div > h1")
    private WebElement title;
    @FindBy(css = "div.col-md-6.hidden-sm-down.total-products")
    private WebElement productQuantity;
    @FindBy(xpath = "//ul[@class='category-sub-menu']//a")
    private List<WebElement> subCategories;


    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    private List<String> categoryNameDisplayed = new ArrayList<>();


    private void getCategoryName() {
        String categoryName = getTextFromElement(title);
        log.info("<<<<<<<<<<<<<<<<Category after click: " + categoryName);
    }

    public CategoryPage checkCategories_AndSubcategories() {
        for (int i = 0; i < menuPage.categories.size(); i++) {
            categoryNameDisplayed.add(getTextFromElement(menuPage.categories.get(i)));
            log.info("<<<<<<<<<<<<<<Chosen category: " + getTextFromElement(menuPage.categories.get(i)));
            clickOnElement(menuPage.categories.get(i));
            amountOfProducts_AndSideMenuIsDisplayed();

            actions.moveToElement(menuPage.categories.get(i)).build().perform();
            for (int j = 0; j < subCategories.size(); j++) {
                clickOnElement(subCategories.get(j));
                amountOfProducts_AndSideMenuIsDisplayed();
                clickOnElement(menuPage.categories.get(i));
            }
        }
        return this;
    }

    private boolean isDisplayedMenu() {
        if (menuPage.sideMenu.isDisplayed()) {
            log.info("<<<<<<<<<<<<<<<<Side menu is displayed");
            return true;
        } else {
            log.info("<<<<<<<<<<Side menu is not displayed");
            return false;
        }
    }

    private boolean countProductList() {
        if (getTextFromElement(productQuantity).contains(String.valueOf(productList.size()))) {
            log.info("<<<<<<<<<<<<Products on this page is: " + productList.size());
            return true;
        } else {
            return false;
        }
    }

    private void amountOfProducts_AndSideMenuIsDisplayed() {
        getCategoryName();
        countProductList();
        isDisplayedMenu();
    }
}


    
 













