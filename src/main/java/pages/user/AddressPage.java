package pages.user;

import base.FakeDataFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

public class AddressPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("LoginPage.class");
    @FindBy(xpath = "//input[@name='company']")
    private WebElement company;
    @FindBy(xpath = "//input[@name='address1']")
    private WebElement address;
    @FindBy(xpath = "//input[@name='city']")
    private WebElement city;
    @FindBy(xpath = "//input[@name='postcode']")
    private WebElement postcode;
    @FindBy(xpath = "//select[@name='id_state']")
    private WebElement state;

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    private void chooseState() {
        clickOnElement(state);
    }

    public AddressPage fillAddressesForm() {
        sendKeys(company, FakeDataFactory.getCompany(), true);
        sendKeys(address, FakeDataFactory.getStreet(), true);
        sendKeys(city, FakeDataFactory.getCity(), true);
        sendKeys(postcode, FakeDataFactory.getZipCode(), true);
        chooseState();
        log.info("Address form is complete");
        return this;
    }
}
