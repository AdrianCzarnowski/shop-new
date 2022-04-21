import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


public class SearchResultTest extends TestBase {

    private static Logger log = LoggerFactory.getLogger("SearchResultTest.class");

    @Test
    public void resultOfSearchMatchToInputProductName() {
        String product = homePage.randomProductNameHomePage();
        log.info("<<<<<<Random product name: " + product);

        searchResultPage
                .fillSearchBox(product)
                .clickSearchButton();
        log.info("<<<<<<<<<<<<<Product name after after search: " + searchResultPage.getProductNameFromSearchField());

        assertThat("Products don't match", searchResultPage.getProductNameFromSearchField(), containsString(product));
    }
    @Test
    public void resulOfDropDownMatchToInputProductName(){
        String product = homePage.randomProductNameHomePage();
        log.info("<<<<<<Random product name: " + product);

        searchResultPage
                .fillSearchBox(product);
        log.info("<<<<<<<<<<<<<Product name after after search: " + searchResultPage.getProductNameFromSearchField());
        assertThat("Products don't match", searchResultPage.getProductsNameFromDropDownList(), containsString(product));
    }
}

