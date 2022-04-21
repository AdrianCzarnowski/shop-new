import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


public class SearchResultTest extends TestBase {

    private static Logger log = LoggerFactory.getLogger("SearchResultTest.class");
    private String product = homePage.randomProductNameHomePage();

    private void fillSearchBox_RandomProductFromTheList(){
        log.info("<<<<<<Random product name: " + product);
        searchResultPage
                .fillSearchBox(product);
    }

    @Test
    public void searchResult_MatchTo_InputProductName() {
        fillSearchBox_RandomProductFromTheList();
        searchResultPage.clickSearchButton();
        log.info("<<<<<<<<<<<<<Product name after after search: " + searchResultPage.getProductNameFromSearchField());
        assertThat(searchResultPage.getProductNameFromSearchField(), containsString(product));
    }
    @Test
    public void dropDownResult_MatchTo_InputProductName(){
        fillSearchBox_RandomProductFromTheList();
        log.info("<<<<<<<<<<<<<Product name after after search: " + searchResultPage.getProductNameFromSearchField());
        assertThat(searchResultPage.getProductsNameFromDropDownList(), containsString(product));
    }
}

