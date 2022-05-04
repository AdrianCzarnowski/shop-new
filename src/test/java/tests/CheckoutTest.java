package tests;

import base.Pages;
import factory.UserFactory;
import helpers.OrderDataCollect;
import model.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CheckoutTest extends Pages {
    private static Logger log = LoggerFactory.getLogger("UserRegistrationTest.class");

    @Test
    public void registrationTest() {

        OrderDataCollect orderDataCollect = new OrderDataCollect();

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
        orderDataCollect
                .setShippingMethodName(shippingMethodPage.shippingMethodName().getShippingMethodName().trim());

        shippingMethodPage
                .clickContinueBtn();
        orderDataCollect
                .setPaymentMethod(paymentPage.paymentMethodName());
        paymentPage
                .selectPayment()
                .checkTermsOfService()
                .selectTermsOfService()
                .clickPlaceOrderBtn();
        summaryPage
                .checkOrderDetails()
                .totalAmount();
        orderDataCollect
                .setOrderReference(summaryPage.orderReference());
        orderDataCollect
                .setTotalAmount(summaryPage.totalAmount());


        assertEquals(orderDataCollect.getShippingMethodName(), summaryPage.getShippingMethod());
        log.info("Shipping methods are the same");
        assertEquals(orderDataCollect.getPaymentMethod(), System.getProperty("payment_method_payment_page"));
        log.info("Payment methods are the same");

        summaryPage
                .goToOrderHistory();

        assertEquals(orderDataCollect.getOrderReference(), orderHistoryPage.orderReference());
        log.info("Order reference is the same");
        assertEquals(BasePage.getTodayDate(), orderHistoryPage.orderDate());
        log.info("Date is correct");
        assertEquals(orderDataCollect.getTotalAmount(), orderHistoryPage.orderTotalPrice());
        log.info("Prices are equals");
        assertEquals(System.getProperty("payment_order_history"), orderHistoryPage.orderPayment());
        log.info("Form of payment is the same");
        assertTrue(orderHistoryPage.orderStatus().contains(orderDataCollect.getPaymentMethod()));
        log.info("Order status is correct: " + orderHistoryPage.orderStatus());

        orderHistoryPage
                .goToDetailsPage();
        orderDetailsPage
                .details();


    }
}
