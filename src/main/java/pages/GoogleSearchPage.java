package pages;

import io.qameta.allure.Step;
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

    @Step("Enter the search keyword")
    public void searchByKeyword(String keyword){
        findElement(searchText).clear();
        findElement(searchText).sendKeys(keyword, Keys.ENTER);
    }

    public List<WebElement> getSearchResults(){
        return findElements(searchResults);
    }

    @Step("Click on the link contains")
    public void clickOnTheLinkContain(String textLink) {
        for(WebElement element : getSearchResults()){
            if (element.getText().toLowerCase().contains(textLink)) {
                element.click();
                break;
            }
        }
    }
}
