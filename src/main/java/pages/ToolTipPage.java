package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolTipPage extends BasePage{

    private final By ageTextBox = By.id("age");
    private final By demoFrame = By.xpath("//iframe");
    private final By tooltip = By.xpath("//*[@role=\"tooltip\"]");

    public ToolTipPage(WebDriver driver) {
        super(driver);
    }

    public void hoverOverTheAgeTextBox() {
        driver.switchTo().frame(findElement(demoFrame));

        actionClick(ageTextBox);
    }

    public String getTooltipMessage() {
        return findElement(tooltip).getText();
    }
}
