package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeroKuAppPage extends BasePage{

    private final By alertMessage = By.xpath("//div[@class=\"example\"]/p");

    public HeroKuAppPage(WebDriver driver) {
        super(driver);
    }

    public String getAlertMessage() {
        return findElement(alertMessage).getText();
    }
}
