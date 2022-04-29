package pages.user;

import base.FakeDataFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

public class RegistrationPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("RegistrationPage.class");
  
    @FindBy(xpath = "//*/section/div[1]/div[1]/label[1]/span")
    private WebElement gender;
    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;
    @FindBy(xpath = "//input[@name='birthday']")
    private WebElement birthday;


    @FindBy(xpath = "//input[@name='optin']")
    private WebElement offers;
    @FindBy(xpath = "//input[@name='customer_privacy']")
    private WebElement customerPrivacy;
    @FindBy(xpath = "//input[@name='newsletter']")
    private WebElement newsletter;

    @FindBy(xpath = "//*/div[10]/div[1]/span/label/input")
    private WebElement acceptRegulamin;
    @FindBy(css = "footer > button")
    private WebElement saveBtn;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage fillForm() {
        clickOnElement(gender);
        sendKeys(firstName, FakeDataFactory.getFakeFirstName(), true);
        sendKeys(lastName, FakeDataFactory.getFakeLastName(), true);
        sendKeys(email, FakeDataFactory.getFakeEmail(), true);
        sendKeys(password, FakeDataFactory.getPassword(), false);
        sendKeys(birthday, FakeDataFactory.getFakeBirthDate(), true);
        offers.click();
        customerPrivacy.click();
        newsletter.click();
        acceptRegulamin.click();
        clickOnElement(saveBtn);
        log.info("New user created");
        return this;
    }
}
