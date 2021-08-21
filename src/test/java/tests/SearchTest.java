package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.SearchPage;

import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest{
    private SearchPage searchPageObject;

    @Test
    public void verifyPageTitleTest(){
        searchPageObject =  new SearchPage(getDriver());
        searchPageObject.searchByKeyword("selenium");
        assertTrue(searchPageObject.getPageTitle().contains("selenium"));
    }

    @Test
    public void verifySearchResultsTest(){
        searchPageObject =  new SearchPage(getDriver());
        searchPageObject.searchByKeyword("google");
        for(WebElement link : searchPageObject.getSearchResults()){
            assertTrue(link.getText().toLowerCase().contains("google"));
        }
    }

    @Test
    public void verifyTextAfterInsertTest(){
        searchPageObject =  new SearchPage(getDriver());
        searchPageObject.enterTextInSearchBox("selenium");
        assertTrue(searchPageObject.getSearchText().equals("selenium"));
    }

    @Test
    public void verifyLogoPresenceTest(){
        searchPageObject =  new SearchPage(getDriver());
        assertTrue(searchPageObject.isTheLogoVisible());
    }

    @Test
    public void verifyPageTitleWithoutInsertingTextTest(){
        searchPageObject =  new SearchPage(getDriver());
        searchPageObject.searchByKeyword("");
        assertTrue(searchPageObject.getPageTitle().equals("Google"));
    }

    @Test
    public void verifyInvalidSearchTest(){
        searchPageObject =  new SearchPage(getDriver());
        searchPageObject.searchByKeyword("fasebook");
        assertTrue(searchPageObject.getShowingResultForText().contains("Showing results for"));
        assertTrue(searchPageObject.getSearchInsteadForText().contains("Search instead for"));
    }

    @Test
    public void verifyNotExistingDataTest(){
        searchPageObject =  new SearchPage(getDriver());
        String invalidData = "+++++++++++++++";
        searchPageObject.searchByKeyword(invalidData);
        assertTrue(searchPageObject.getNotExistingDataText()
                .contains("Your search - "+invalidData+" - did not match any documents."));
    }
}
