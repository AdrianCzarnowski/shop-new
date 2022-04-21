package pages.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;
import java.util.List;
import java.util.Random;


public class BasePage {
    protected WebDriver driver;
    private WebDriverWait driverWait;
    protected Actions actions;
    private static Logger logger = LoggerFactory.getLogger("BasePage.class");

    public BasePage(WebDriver driver){
        this.driver = driver;
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnElement(WebElement element){
        driverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        logger.info("<<<<<<<<<<<<<Click on element: " + element.getText());
    }
    public void cleanAndSendKeys (WebElement element, String value){
        driverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(value);
        logger.info("<<<<<<<<<<<<<Text in element: " + element.getText() + " is " + value);
    }

    public void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        logger.info("<<<<<<<<<<<<<<<<<Scroll to element: " + element.getText());
    }
    public WebElement randomValueFromList(List<WebElement> elementList){
        int size = new Random().nextInt(elementList.size());
        return elementList.get(size);
    }
}
