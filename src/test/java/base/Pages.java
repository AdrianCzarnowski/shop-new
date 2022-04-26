package base;

import model.Product;
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
    public static CartPage cartPage;
    public static CartOrderDetailsPage cartOrderDetailsPage;
    public static Product product;

    @BeforeEach
    public void testSetup(){
        searchPage = new SearchPage(driver);
        categoryPage = new CategoryPage(driver);
        artPage = new ArtPage(driver);
        footerPage = new FooterPage(driver);
        priceDropPage = new PriceDropPage(driver);
        productPage = new ProductOnSalePage(driver);
        cartPage = new CartPage(driver);
        cartOrderDetailsPage = new CartOrderDetailsPage(driver);

    }

}
