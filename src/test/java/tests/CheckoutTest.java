package tests;

import base.Pages;
import factory.UserFactory;
import model.DataCollect;
import model.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutTest extends Pages {
    private static Logger log = LoggerFactory.getLogger("UserRegistrationTest.class");

    @Test
    public void registrationTest() {

        DataCollect dataCollect = new DataCollect();

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
        dataCollect
                .setShippingMethodName(shippingMethodPage.shippingMethodName().getShippingMethodName().trim());

        shippingMethodPage
                .clickContinueBtn();
        dataCollect
                .setPaymentMethod(paymentPage.paymentMethodName());
        paymentPage
                .selectPayment()
                .checkTermsOfService()
                .selectTermsOfService()
                .clickPlaceOrderBtn();
        summaryPage
                .checkOrderDetails()
                .getOrderReference()
                .getShippingMethod();
        summaryPage
                .getPaymentMethod();

        assertEquals(dataCollect.getShippingMethodName(), summaryPage.getShippingMethod());
        log.info("Shipping method is the same");
        assertEquals(dataCollect.getPaymentMethod(), System.getProperty("payment_method"));
        log.info("Payment method is the same");
    }
}
