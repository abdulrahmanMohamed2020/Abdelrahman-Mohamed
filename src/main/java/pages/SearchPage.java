package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage{
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private By searchText = By.name("q");
    private By logo = By.className("lnXdpd");
    private By wrongText = By.className("lnXdpd");
    private By correctText = By.className("spell_orig");
    private By notExistingData = By.className("card-section");

    public void setSearchText(String textToInsert){
        findElement(searchText).clear();
        findElement(searchText).sendKeys(textToInsert);
    }

    public void pressEnter(){
        actionClickByKeys(searchText);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getSearchText(){
        return findElement(searchText).getAttribute("value");
    }

    public boolean isThelogoVisible(){
        return elementVisible(logo,3);
    }

    public String getShowingResultForText(){
        return findElement(correctText).getText();
    }

    public String getSearchInstedForText(){
        return findElement(wrongText).getText();
    }

    public void insertTextAndPressEnter(String text){
        setSearchText(text);
        pressEnter();
    }

    public String getNotExistingDataText(){
        return findElement(notExistingData).getText();
    }
}
