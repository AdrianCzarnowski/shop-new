package base;

import org.junit.jupiter.api.BeforeEach;
import pages.FooterPage;
import pages.product.*;

public class Pages extends TestBase {
    public static SearchPage searchPage;
    public static CategoryPage categoryPage;
    public static ArtPage artPage;
    public static FooterPage footerPage;
    public static PriceDropPage priceDropPage;
    public static ProductOnSalePage productPage;
    public static RandomProductPage randomProductPage;
    public static CartProductOrderDetailsPage cartOrderDetailsPage;

    @BeforeEach
    public void testSetup() {
        searchPage = new SearchPage(driver);
        categoryPage = new CategoryPage(driver);
        artPage = new ArtPage(driver);
        footerPage = new FooterPage(driver);
        priceDropPage = new PriceDropPage(driver);
        productPage = new ProductOnSalePage(driver);
        randomProductPage = new RandomProductPage(driver);
        cartOrderDetailsPage = new CartProductOrderDetailsPage(driver);
    }
}
