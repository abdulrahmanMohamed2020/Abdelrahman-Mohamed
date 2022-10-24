package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HdfcBankPage extends BasePage{

    private final By productTypeDropDown = By.xpath("//*[@class=\"drp1\"]//div[@class=\"dropdown\"]/ul");
    private final By productDropDown = By.xpath("//*[@class=\"drp2\"]//div[@class=\"dropdown\"]/ul");

    public HdfcBankPage(WebDriver driver) {
        super(driver);
    }

    public void selectProductType(String productType) {
        Select select = _captureAllItems(productTypeDropDown);

        select.selectByVisibleText(productType);
    }

    public void selectProduct(String productType) {
        Select select = _captureAllItems(productDropDown);

        select.selectByVisibleText(productType);
    }

    private Select _captureAllItems(By dropDown) {
        Select select = new Select(findElement(dropDown));

        List<WebElement> dropdownValues = select.getOptions();

        System.out.println(dropdownValues);
        return select;
    }
}
