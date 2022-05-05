package tests;

import base.Pages;
import factory.UserFactory;
import handler.DataHandler;
import model.Product;
import model.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CheckoutTest extends Pages {
    private static Logger log = LoggerFactory.getLogger("UserRegistrationTest.class");

    @Test
    public void registrationTest() {

        DataHandler dataHandler = new DataHandler();

        User user = new UserFactory().getRandomUser();
        menuPage
                .clickSingInButton();
        loginPage
                .clickNewAccount();
        registrationPage
                .fillForm(user);

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
        final List<Product> basketList = productOrderDetailsPage
                .setBasket().getBasketList();
        basketPage
                .clickProceedBtn();
        addressPage
                .fillAddressesForm();
        dataHandler
                .setShippingMethodName(shippingMethodPage.shippingMethodName().getShippingMethodName());

        shippingMethodPage
                .clickContinueBtn();
        dataHandler
                .setPaymentMethod(paymentPage.getPaymentMethodName());
        paymentPage
                .selectPayment()
                .checkTermsOfService()
                .selectTermsOfService()
                .clickPlaceOrderBtn();
        summaryPage
                .checkOrderDetails()
                .getTotalAmount();
        dataHandler
                .setOrderReference(summaryPage.getOrderReference());
        dataHandler
                .setTotalAmount(summaryPage.getTotalAmount());


        assertEquals(dataHandler.getShippingMethodName(), summaryPage.getShippingMethod());
        log.info("Shipping methods are the same");
        assertEquals(dataHandler.getPaymentMethod(), System.getProperty("payment_method_payment_page"));
        log.info("Payment methods are the same");

        summaryPage
                .goToOrderHistory();

        assertEquals(dataHandler.getOrderReference(), orderHistoryPage.orderReference());
        log.info("Order reference is the same");
        assertEquals(BasePage.getTodayDate(), orderHistoryPage.orderDate());
        log.info("Date is correct");
        assertEquals(dataHandler.getTotalAmount(), orderHistoryPage.orderTotalPrice());
        log.info("Prices are equals");
        assertEquals(System.getProperty("payment_order_history"), orderHistoryPage.orderPayment());
        log.info("Form of payment is the same");
        assertTrue(orderHistoryPage.orderStatus().contains(dataHandler.getPaymentMethod()));
        log.info("Order status is correct: " + orderHistoryPage.orderStatus());

        orderHistoryPage
                .goToDetailsPage();
        orderDetailsPage
                .comparisionOfProducts_FromCartToBasket(basketList);

        dataHandler
                .setAddress(orderDetailsPage.getDeliveryAddress());

        assertEquals(orderDetailsPage.getDeliveryAddress(), orderDetailsPage.getInvoiceAddress());
        
        orderDetailsPage
                .goToAddressPage();

        assertEquals(dataHandler.getAddress(), userAddressPage.userAddress());
        log.info("Address on invoice, delivery and account address are the same");
    }
}
