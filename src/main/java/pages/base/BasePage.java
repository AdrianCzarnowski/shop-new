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
    protected WebDriverWait wait;
    protected Actions actions;
    protected JavascriptExecutor js;
    private static Logger logger = LoggerFactory.getLogger("BasePage.class");


    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        js = ((JavascriptExecutor)driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public void sendKeys(WebElement element, String text, boolean clear){
        if(clear){
            highLightenerMethod(element);
            element.clear();
        }
        wait.until(ExpectedConditions.visibilityOf(element));
        highLightenerMethod(element);
        element.sendKeys(text);
        logger.info("<<<<<<<<<<<<<Text in element: " + text);
    }

    public WebElement randomValueFromList(List<WebElement> elementList){
        int size = new Random().nextInt(elementList.size());
        return elementList.get(size);
    }

    public String getTextFromElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
       return element.getText();
    }

    public void clickAndHold(WebElement element){
        actions.clickAndHold(element);
    }


    public void scrollToElement(WebElement element){
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        waitToBeVisible(element);
        logger.info("<<<<<<<<<<<<<<<<<Scroll to element: " + element);
    }
    public void waitToBeVisible (WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitToBeInvisible (WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public void waitToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void highLightenerMethod(WebElement element){
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: lightred; border: 5px solid red;')", element);
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }



}
