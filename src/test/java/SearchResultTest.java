import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


public class SearchResultTest extends TestBase {

    private static Logger log = LoggerFactory.getLogger("SearchResultTest.class");
    @Test
    public void searchResult_MatchTo_InputProductName() {
        searchPage
                .fillSearchBox()
                .clickSearchButton();
        log.info("<<<<<<<<<<<<<Product name after after search: " + searchPage.getProductNameFromSearchField());
        assertThat(searchPage.getProductNameFromSearchField(), containsString(searchPage.getProduct()));
    }
    @Test
    public void dropDownResult_MatchTo_InputProductName(){
        searchPage
                .fillSearchBox();
        log.info("<<<<<<<<<<<<<Product name after after search: " + searchPage.getProductNameFromSearchField());
        assertThat(searchPage.getProductsNameFromDropDownList(), containsString(searchPage.getProduct()));
    }
}

