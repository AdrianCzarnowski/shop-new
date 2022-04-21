package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;


public class SearchResultPage extends BasePage {



    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input.ui-autocomplete-input")
    private WebElement searchBox;
    @FindBy(css = "form > button ")
    private WebElement searchButton;

    @FindBy(css = "div.product-description > h2")
    private WebElement searchResultProductName;

    public SearchResultPage fillSearchBox(String value){
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
}
