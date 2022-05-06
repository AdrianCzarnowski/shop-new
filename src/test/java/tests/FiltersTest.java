package tests;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FiltersTest extends Pages {

    private static Logger log = LoggerFactory.getLogger("SearchResultTest.class");

    @Test
    @DisplayName("Checking categories, subcategories and products list")
    public void checkCategories() {
        categoryPage
                .checkCategories_AndSubcategories();
    }

    @Test
    public void artCategories(){
        artPage
                .clickArtCategory()
                .firstFilterOfPrices()
                .firstFilteredMatchedProducts()
                .clearFilters()
                .secondFilterOfPrices()
                .secondFilteredMatchedProducts()
                .clearFilters();
    }
}




