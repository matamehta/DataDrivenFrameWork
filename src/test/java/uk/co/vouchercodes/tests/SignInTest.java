package uk.co.vouchercodes.tests;

import org.testng.annotations.AfterMethod;
import uk.co.vouchercodes.framework.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import uk.co.vouchercodes.utils.ReadJsonFile;


public class SignInTest {

    private SignInSetUp signInSetUp;
    private WebDriver driver;
    private WebDriverWait wait;

    @DataProvider(name = "signInData")
    public Object[][] createData() {
        return new ReadJsonFile().getData();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver,30);
        signInSetUp = new SignInSetUp(driver, wait);
    }

    @Test(dataProvider = "signInData")
    public void testSignIn(ReadLogInData loginParameter) throws Exception {
        signInSetUp.signInSetup(loginParameter.getLoginEmail(), loginParameter.getPassword());
    }

    @AfterMethod
     public void quitdriver(){
        driver.quit();
     }
}