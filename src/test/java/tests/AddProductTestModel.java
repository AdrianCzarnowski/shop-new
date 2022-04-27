package tests;

import base.Pages;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddProductTestModel extends Pages {

    private static Logger log = LoggerFactory.getLogger("SearchResultTest.class");


    @Test
    public void addRandomProduct() {
        for (int i = 0; i < randomProductPage.numberOfAdditionToCart; i++) {
            randomProductPage
                    .clickRandomCategory()
                    .clickRandomProduct()
                    .setRandomQuantityValue()
                    .clickAddToCartButton();
            cartOrderDetailsPage
                    .clickContinueShopping();
            cartOrderDetailsPage
                    .checkCartOfProducts();
        }
    }
}
