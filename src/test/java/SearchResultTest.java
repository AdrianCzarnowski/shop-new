import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.SearchResultPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


public class SearchResultTest extends TestBase {

    private static Logger log = LoggerFactory.getLogger("SearchResultTest.class");

    @Test
    public void resultOfSearchMatchToSearchBoxProductName(){
        String product = homePage.randomProductNameHomePage();
        log.info("<<<<<<Random product name: " + product);
        searchResultPage.fillSearchBox(product);
        searchResultPage.clickSearchButton();
        log.info("<<<<<<<<<<results: " + searchResultPage.getProductNameFromSearchField());
        assertThat("Products dont match", searchResultPage.getProductNameFromSearchField(), containsString(product));
    }

}

