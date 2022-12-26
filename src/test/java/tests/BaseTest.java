package tests;

import core.CapabilityFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import uitils.TestListener;

import java.net.MalformedURLException;
import java.net.URL;

@Listeners({TestListener.class})
public class BaseTest {

    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public CapabilityFactory capabilityFactory = new CapabilityFactory();

    @Parameters(value={"browser"})
    @BeforeMethod(description = "initialize the web drive", alwaysRun = true)
    public void setUp (@Optional("firefox") String browser) throws MalformedURLException {
        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
    }

    public WebDriver getDriver(){
        return driver.get();
    }

    @AfterMethod(description = "close the web drive", alwaysRun = true)
    public void tearDown() {
        getDriver().quit();
    }
}
