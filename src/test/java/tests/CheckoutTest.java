package tests;

import base.Pages;
import base.UserFactory;
import model.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckoutTest extends Pages {
    private static Logger log = LoggerFactory.getLogger("UserRegistrationTest.class");

    @Test
    public void registrationTest() {
        User user = new UserFactory().getRandomUser();
        menuPage.clickSingInButton();
        loginPage.clickNewAccount();
        registrationPage.fillForm(user);

        for (int i = 0; i < randomProductPage.numberOfRandomProduct - 1; i++) {
            randomProductPage
                    .clickRandomCategory()
                    .clickRandomProduct()
                    .setRandomQuantityValue()
                    .clickAddToCartButton();
            productOrderDetailsPage.clickContinueShopping();
        }

        randomProductPage
                .clickRandomCategory()
                .clickRandomProduct()
                .setRandomQuantityValue()
                .clickAddToCartButton();
        productOrderDetailsPage
                .clickProceedToCheckout();
        basketPage
                .clickProceedBtn();
        addressPage
                .fillAddressesForm();
        shippingMethodPage
                .clickContinueBtn();
        paymentPage
                .selectPayment()
                .checkTermsOfService()
                .selectTermsOfService()
                .clickPlaceOrderBtn();
    }
}
