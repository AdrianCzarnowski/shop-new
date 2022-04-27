package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

import java.util.List;

public class HomePage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("HomePage.class");
    @FindBy(css = "div.product-description > h3")
    private List<WebElement> productsNameList;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String randomProductNameFromHomePage() {
        return randomValueFromList(productsNameList).getText();
    }


}
