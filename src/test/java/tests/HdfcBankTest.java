package tests;

import org.testng.annotations.Test;
import pages.HdfcBankPage;

import static org.testng.Assert.assertTrue;

public class HdfcBankTest extends BaseTest{

    HdfcBankPage hdfcBankPage;

    @Test(description = "Verify the user can select product from drop-down menu")
    public void verifyUserCanSelectProduct(){
        getDriver().get("https://www.hdfcbank.com/");
        hdfcBankPage =  new HdfcBankPage(getDriver());

        String productType = "Accounts";
        String product = "Savings Accounts";

        hdfcBankPage.selectProductType(productType);
        hdfcBankPage.selectProduct(product);

        assertTrue(hdfcBankPage.isProductVisible(),"The Product drop-down is not visible");
    }
}
