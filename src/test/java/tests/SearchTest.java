package tests;

import org.testng.annotations.Test;
import pages.SearchPage;

import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest{
    private SearchPage searchPageObject;

    @Test
    public void verifyPageTitleTest(){
        searchPageObject =  new SearchPage(getDriver());
        searchPageObject.insertTextAndPressEnter("selenium");
        assertTrue(searchPageObject.getPageTitle().contains("selenium"));
    }

    @Test
    public void verifyTextAfterInsertTest(){
        searchPageObject =  new SearchPage(getDriver());
        searchPageObject.setSearchText("selenium");
        assertTrue(searchPageObject.getSearchText().equals("selenium"));
    }

    @Test
    public void verifyLogoPresenceTest(){
        searchPageObject =  new SearchPage(getDriver());
        assertTrue(searchPageObject.isThelogoVisible());
    }

    @Test
    public void verifyPageTitleWithoutInsertingTextTest(){
        searchPageObject =  new SearchPage(getDriver());
        searchPageObject.pressEnter();
        assertTrue(searchPageObject.getPageTitle().equals("Google"));
    }

    @Test
    public void verifyResultsForTest(){
        searchPageObject =  new SearchPage(getDriver());
        searchPageObject.insertTextAndPressEnter("fasebook");
        assertTrue(searchPageObject.getShowingResultForText().contains("Showing results for"));
        assertTrue(searchPageObject.getSearchInstedForText().contains("Search instead for"));
    }

    @Test
    public void verifyNotExistingDataTest(){
        searchPageObject =  new SearchPage(getDriver());
        String invalidData = "+++++++++++++++";
        searchPageObject.insertTextAndPressEnter(invalidData);
        assertTrue(searchPageObject.getNotExistingDataText()
                .contains("Your search - "+invalidData+" - did not match any documents."));
    }

}
