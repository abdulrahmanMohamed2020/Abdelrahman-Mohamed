package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BasePage{

    private By searchText = By.name("q");
    private By logo = By.className("lnXdpd");
    private By SearchInsteadForText = By.className("spell_orig");
    private By ShowingResultsForText = By.className("gL9Hy");
    private By notExistingData = By.className("card-section");
    private By searchResults = By.cssSelector("h3.LC20lb.DKV0Md");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

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

    public boolean isTheLogoVisible(){
        return elementVisible(logo,3);
    }

    public String getShowingResultForText(){
        return findElement(ShowingResultsForText).getText();
    }

    public String getSearchInsteadForText(){
        return findElement(SearchInsteadForText).getText();
    }

    public String getNotExistingDataText(){
        return findElement(notExistingData).getText();
    }

    public List<WebElement> getSearchResults(){
        return findElements(searchResults);
    }
}
