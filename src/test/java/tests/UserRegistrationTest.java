package tests;

import base.Pages;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserRegistrationTest extends Pages {
    private static Logger log = LoggerFactory.getLogger("UserRegistrationTest.class");

    @Test
    public void registrationTest() {
        menuPage.clickSingInButton();
        loginPage.clickNewAccount();
        registrationPage.fillForm();
    }
}
