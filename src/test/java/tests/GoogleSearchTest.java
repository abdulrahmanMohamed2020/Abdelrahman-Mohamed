package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;

import java.util.List;

public class GoogleSearchTest extends BaseTest{

    private GoogleSearchPage googleSearchPage;
    private static String SEARCH_KEYWORD = "java tutorial";
    private static String TEXT_LINK = "w3schools";

    @Test(description = "Auto Suggest Dropdown From Google Search")
    public void AutoSuggestDropdown(){
        getDriver().get("https://www.google.com/webhp?hl=en");
        googleSearchPage =  new GoogleSearchPage(getDriver());
        googleSearchPage.searchByKeyword(SEARCH_KEYWORD);

        // Can be used later
        List<WebElement> searchResultsList = googleSearchPage.getSearchResults();

        googleSearchPage.clickOnTheLinkContain(TEXT_LINK);
        takeScreenShot();
    }

}
