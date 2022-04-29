package base;

import org.junit.jupiter.api.BeforeEach;
import pages.navigation.FooterPage;
import pages.navigation.HomePage;
import pages.navigation.MenuPage;
import pages.order.BasketPage;
import pages.order.ProductOrderDetailsPage;
import pages.product.*;
import pages.user.LoginPage;
import pages.user.RegistrationPage;

public class Pages extends TestBase {
    public static SearchPage searchPage;
    public static CategoryPage categoryPage;
    public static ArtPage artPage;
    public static FooterPage footerPage;
    public static PriceDropPage priceDropPage;
    public static ProductOnSalePage productPage;
    public static RandomProductPage randomProductPage;
    public static ProductOrderDetailsPage productOrderDetailsPage;
    public static HomePage homePage;
    public static BasketPage basketPage;
    public static MenuPage menuPage;
    public static LoginPage loginPage;
    public static RegistrationPage registrationPage;

    @BeforeEach
    public void testSetup() {
        searchPage = new SearchPage(driver);
        categoryPage = new CategoryPage(driver);
        artPage = new ArtPage(driver);
        footerPage = new FooterPage(driver);
        priceDropPage = new PriceDropPage(driver);
        productPage = new ProductOnSalePage(driver);
        randomProductPage = new RandomProductPage(driver);
        productOrderDetailsPage = new ProductOrderDetailsPage(driver);
        homePage = new HomePage(driver);
        basketPage = new BasketPage(driver);
        menuPage = new MenuPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }
}
