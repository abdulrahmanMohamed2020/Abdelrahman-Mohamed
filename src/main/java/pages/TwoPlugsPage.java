package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TwoPlugsPage extends BasePage{

    private final By livePostingButton = By.linkText("LIVE POSTING");
    private final By mapTextBox = By.id("autocomplete");
    private final By item = By.xpath("//span[text()=\"ON, Canada\"]");

    public TwoPlugsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on the Live Posting button")
    public void clickOnLivePostingButton(){
        actionClick(livePostingButton);
    }

    @Step("Enter the search keyword")
    public void searchByKeyword(String keyword){
        findElement(mapTextBox).clear();
        findElement(mapTextBox).sendKeys(keyword);
    }

    @Step("Select the search keyword and hit Enter key")
    public void selectTheSearchKeyword(){
        findElement(item).click();
        findElement(mapTextBox).sendKeys(Keys.ENTER);
    }

    public String getTheMapTextBoxValue(){
        return findElement(mapTextBox).getAttribute("value");
    }
}
