package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSearchPage extends BasePage {
    private final By searchText = By.name("q");
    private final By searchResults = By.cssSelector("h3.LC20lb.DKV0Md");

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(String keyword){
        findElement(searchText).clear();
        findElement(searchText).sendKeys(keyword, Keys.ENTER);
    }

    public List<WebElement> getSearchResults(){
        return findElements(searchResults);
    }

    public void clickOnTheLinkContain(String textLink) {
        for(WebElement element : getSearchResults()){
            if (element.getText().toLowerCase().contains(textLink)) {
                element.click();
                break;
            }
        }
    }
}
