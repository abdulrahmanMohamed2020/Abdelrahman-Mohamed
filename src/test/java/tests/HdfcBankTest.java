package tests;

import org.testng.annotations.Test;
import pages.HdfcBankPage;

public class HdfcBankTest extends BaseTest{

    HdfcBankPage hdfcBankPage;

    @Test(description = "BootstrapDropdown with dynamic selection")
    public void bootstrapDropdownWithDynamicSelection(){
        getDriver().get("https://www.hdfcbank.com/");
        hdfcBankPage =  new HdfcBankPage(getDriver());

        String productType = "Accounts";
        String product = "Savings Accounts";

        hdfcBankPage.selectProductType(productType);
        hdfcBankPage.selectProduct(product);
        takeScreenShot();
    }
}
