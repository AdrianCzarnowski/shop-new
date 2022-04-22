package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class CategoryPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("CategoriesPage.class");
    @FindBy(css = "#search_filters")
    private WebElement sideMenu;

    @FindBy(xpath = "//div[@itemprop='itemListElement']")
    private List<WebElement> productList;
    @FindBy(xpath = "//a[@class='dropdown-item']")
    private List<WebElement> categories;
    @FindBy(css = "#js-product-list-header > div > h1")
    private WebElement title;
    @FindBy(css = "div.col-md-6.hidden-sm-down.total-products")
    private WebElement productQuantity;
    @FindBy(xpath = "//ul[@class='category-sub-menu']//a")
    private List<WebElement> subCategories;


    private List<String> categoryNameDisplayed = new ArrayList<>();
    private List<String> subCategoryNameDisplayed = new ArrayList<>();



    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayedMenu() {
        if (sideMenu.isDisplayed()) {
            log.info("<<<<<<<<<<<<<<<<Side menu is displayed");
            return true;
        } else {
            log.info("<<<<<<<<<<Side menu is not displayed");
            return false;
        }
    }

    public boolean countProductList() {
        if (getTextFromElement(productQuantity).contains(String.valueOf(productList.size()))) {
            log.info("<<<<<<<<<<<<Products on this page is: " + productList.size());
            return true;
        } else {
            return false;
        }
    }

    public CategoryPage categoriesCheck() {
        for (int i = 0; i < categories.size(); i++) {
            categoryNameDisplayed.add(categories.get(i).getText());
            log.info("<<<<<<<<<<<<<<Choosen category: " + categories.get(i).getText());
            categories.get(i).click();
            String categoryName = getTextFromElement(title);
            log.info("<<<<<<<<<<<<<<<<Category after click: " + categoryName);
            countProductList();
            isDisplayedMenu();
        }
        return this;
    }
//    public CategoryPage subCategoriesCheck() {
//
//        for (int i = 0; i < categories.size(); i++) {
//            categories.
//            for (int j = 0; j < subCategories.size() ; j++) {
//                subCategoryNameDisplayed.add(subCategories.get(j).getText());
//                subCategories
//
//            }
//            String categoryName = getTextFromElement(title);
//            isDisplayedMenu();
//            log.info("<<<<<<<<<<<<<<<<Category after click: " + categoryName);
//            countProductList();
//        }
//        return this;
//    }
}


    
 













