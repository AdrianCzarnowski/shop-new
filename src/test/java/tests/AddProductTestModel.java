package tests;

import base.Pages;
import model.Product;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddProductTestModel extends Pages {

    private static Logger log = LoggerFactory.getLogger("SearchResultTest.class");


    @Test
    public void addRandomProduct() {
        for (int i = 0; i < randomProductPage.numberOfAdditionToCart; i++) {
            randomProductPage.clickRandomCategory().clickRandomProduct().setRandomQuantityValue().clickAddToCartButton();
            cartOrderDetailsPage.clickContinueShopping().checkCartOfProducts();

        }
    }

    @Test
    public void basketTest() {

        for (int i = 0; i < randomProductPage.numberOfRandomProduct; i++) {
            randomProductPage
                    .clickRandomCategory()
                    .clickRandomProduct()
                    .clickAddToCartButton();
            cartOrderDetailsPage
                    .clickContinueShopping()
                    .checkCartOfProducts();
        }
        randomProductPage
                .clickBasketBtn();
        basketPage
                .checkTotalCost();
        assert ((String.valueOf(Product.getAllOrderCost())).contains(basketPage.checkTotalCost()));
        log.info("Order value are the same");

        randomProductPage
                .setFirstProductQuantity();
        basketPage
                .checkCostAfterChange()
                .clickUpQuantityRandomProduct()
                .checkCostAfterChange()
                .clickDownQuantityRandomProduct()
                .checkCostAfterChange()
                .clickTrashBtn();

    }
}
