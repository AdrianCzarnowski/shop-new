import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CategoryPageTest extends TestBase {

    private static Logger log = LoggerFactory.getLogger("SearchResultTest.class");

    @Test
    public void categoryNameAfterClick() {
        categoryPage
                .categoriesCheck();
//                .subCategoriesCheck();

    }
}




