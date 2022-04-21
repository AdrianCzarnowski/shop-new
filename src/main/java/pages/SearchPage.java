package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

import java.util.List;


public class SearchPage extends BasePage {



    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input.ui-autocomplete-input")
    private WebElement searchBox;
    @FindBy(css = "form > button ")
    private WebElement searchButton;

    @FindBy(css = "div.product-description")
    private WebElement searchResultProductName;
    @FindBy(css="#ui-id-1")
    private WebElement dropDownResult;

    public SearchPage fillSearchBox(String value){
        cleanAndSendKeys(searchBox, value);
        return this;
    }
    public void clickSearchButton(){
        clickOnElement(searchButton);
    }

    public String getProductNameFromSearchField(){
        wait.until(ExpectedConditions.visibilityOf(searchResultProductName));
        return searchResultProductName.getText();
    }
    public String getProductsNameFromDropDownList(){
        wait.until(ExpectedConditions.visibilityOf(dropDownResult));
        return dropDownResult.getText();
    }


}
