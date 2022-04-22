package pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

import java.util.List;

public class CategoryPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("CategoriesPage.class");

    @FindBy(css = "#_desktop_logo")
    private WebElement shopLogo;

    @FindBy(css = "#category-3")
    private WebElement clothes;

    @FindBy(css = "#category-4")
    private WebElement clothesMen;

    @FindBy(css = "#category-5")
    private WebElement clothesWomen;

    @FindBy(css = "#category-6")
    private WebElement accessories;

    @FindBy(css = "#category-7")
    private WebElement accessoriesStationery;

    @FindBy(css = "#category-8")
    private WebElement accessoriesHomeAccessories;

    @FindBy(css = "#category-9")
    private WebElement art;

    @FindBy(css = "#search_filters")
    private WebElement sideMenu;

    @FindBy(css = " li:nth-child(2) > span")
    private WebElement categoryName;

    @FindBy(css = " li:nth-child(3) > span")
    private WebElement subCategoryName;

    @FindBy(css = "products")
    private List<WebElement> productList;



    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public void clickShopLogoButton(){
        clickOnElement(shopLogo);
    }
    public CategoryPage clickClothes(){
        getTextFromElement(clothes);
        clickOnElement(clothes);
        return this;
    }
    public String  clothesName(){
         return getTextFromElement(clothes);
    }
    public String  categoryName(){
        return getTextFromElement(categoryName);
    }







}
