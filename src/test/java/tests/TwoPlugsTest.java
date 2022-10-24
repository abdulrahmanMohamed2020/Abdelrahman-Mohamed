package tests;

import org.testng.annotations.Test;
import pages.TwoPlugsPage;

import static org.testng.Assert.assertEquals;

public class TwoPlugsTest extends BaseTest{

    private TwoPlugsPage twoPlugsPage;
    private static String KEYWORD = "Toronto";

    @Test(description = "Handle Auto Complete Google Places")
    public void handleAutoCompleteGooglePlaces(){
        getDriver().get("https://www.twoplugs.com/");
        twoPlugsPage =  new TwoPlugsPage(getDriver());
        twoPlugsPage.clickOnLivePostingButton();
        twoPlugsPage.searchByKeyword(KEYWORD);
        twoPlugsPage.selectTheSearchKeyword();

        String expectedTextResult = "Toronto, ON, Canada";

        assertEquals(twoPlugsPage.getTheMapTextBoxValue(), expectedTextResult);
    }
}
