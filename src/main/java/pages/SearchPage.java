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
    private By searchButton = By.className("btnK");

    public void searchByKeyword(String keyword){
        findElement(searchText).clear();
        findElement(searchText).sendKeys(keyword);
        actionClickByKeys(searchText);
    }

    public void enterTextInSearchBox(String keyword){
        findElement(searchText).clear();
        findElement(searchText).sendKeys(keyword);
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

    public String getNotExistingDataText(){
        return findElement(notExistingData).getText();
    }

    public void clickSearchButton(){
        actionClick(searchButton);
    }
}
