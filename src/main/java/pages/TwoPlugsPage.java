package pages;

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

    public void clickOnLivePostingButton(){
        actionClick(livePostingButton);
    }

    public void searchByKeyword(String keyword){
        findElement(mapTextBox).clear();
        findElement(mapTextBox).sendKeys(keyword);
    }

    public void selectTheSearchKeyword(){
        findElement(item).click();
        findElement(mapTextBox).sendKeys(Keys.ENTER);
    }

    public String getTheMapTextBoxValue(){
        return findElement(mapTextBox).getAttribute("value");
    }
}
