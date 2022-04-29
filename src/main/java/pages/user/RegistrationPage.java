package pages.user;

import model.User;
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

    public RegistrationPage fillForm(User user) {
        clickOnElement(gender);
        sendKeys(firstName, user.getFirstName(), true);
        sendKeys(lastName, user.getLastName(), true);
        sendKeys(email, user.getEmail(), true);
        sendKeys(password, user.getPassword(), false);
        sendKeys(birthday, user.getBirthDate(), true);
        selectCheckBox(offers);
        selectCheckBox(customerPrivacy);
        selectCheckBox(newsletter);
        selectCheckBox(acceptRegulamin);
        clickOnElement(saveBtn);
        log.info("New user created");
        return this;
    }
}
