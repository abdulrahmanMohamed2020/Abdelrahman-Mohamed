package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BasePage {

    protected WebDriver driver;
    private WebDriverWait wait;
    private final Duration TIMEOUT = Duration.ofSeconds(30);
    private final Duration POLLING_TIMEOUT = Duration.ofMillis(200);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    protected WebElement findElement(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(TIMEOUT)
                .pollingEvery(POLLING_TIMEOUT)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected List<WebElement> findElements(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(TIMEOUT)
                .pollingEvery(POLLING_TIMEOUT)
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    protected boolean elementVisible(By locator, int timeOut) {
        boolean flag;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            flag = true;
        } catch (Exception ex) {
            flag = false;
        }
        return flag;
    }

    public void actionClickByKeys(By locator) {
        WebElement element = findElement(locator);
        scrollToElement(element);

        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.visibilityOf(element));
        try {
            element.sendKeys(Keys.ENTER);
        } catch (StaleElementReferenceException ex) {
            findElement(locator).click();
        }
    }

    private void waitTillTheElementIsVisible(WebElement element) {
        String isVisibleScript = "function isScrolledIntoView(el) { " +
                "var rect = el.getBoundingClientRect();" +
                "var elemTop = rect.top;" +
                "var elemBottom = rect.bottom;" +
                "var isVisible = (elemTop >= 0) && (elemBottom <= window.innerHeight);" +
                "return isVisible;" +
                "}" +
                "return isScrolledIntoView(arguments[0]);";
        wait.until(d -> (Boolean) ((JavascriptExecutor) driver).executeScript(isVisibleScript, element));
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        waitTillTheElementIsVisible(element);

        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

}
