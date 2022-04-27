package tests;

import base.Pages;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddProductTest extends Pages {

    private static Logger log = LoggerFactory.getLogger("SearchResultTest.class");


    @Test
    public void addRandomProduct() {
        for (int i = 0; i < 5; i++) {
            cartPage
                    .clickRandomCategory()
                    .clickRandomProduct()
                    .setRandomQuantityValue()
                    .clickAddToCartButton();
            cartOrderDetailsPage
                    .clickCountinueShopping();
            cartOrderDetailsPage
                    .productChart();
        }


    }
}
