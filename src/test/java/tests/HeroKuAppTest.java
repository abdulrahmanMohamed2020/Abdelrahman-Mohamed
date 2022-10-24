package tests;

import org.testng.annotations.Test;
import pages.HeroKuAppPage;

import static org.testng.AssertJUnit.assertEquals;

public class HeroKuAppTest extends BaseTest{

    private HeroKuAppPage heroKuAppPage;

    @Test(description = "Handle Authenticated pop-ups")
    public void handleAuthenticatedPopUps(){
        getDriver().get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        heroKuAppPage =  new HeroKuAppPage(getDriver());

        String expectedMessage = "Congratulations! You must have the proper credentials.";

        assertEquals(heroKuAppPage.getAlertMessage(), expectedMessage);
    }
}
