package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class FooterPage extends BasePage {
    public FooterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#link-product-page-prices-drop-1")
    private WebElement priceDropButton;

    public FooterPage clickPriceDropButton(){
        clickOnElement(priceDropButton);
        return this;
    }
}
