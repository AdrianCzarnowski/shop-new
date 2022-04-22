import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CategoryPageTest extends TestBase{

    private static Logger log = LoggerFactory.getLogger("SearchResultTest.class");



    @Test
    public void categoryNameAfterClick(){
        categoryPage.clickClothes();
        assertThat(categoryPage.clothesName(), equalTo(categoryPage.categoryName().toUpperCase()));
        log.info("Clicked category: " + categoryPage.categoryName()
                + " <<<<<Category displayed on product site: " + categoryPage.categoryName());



    }
}
