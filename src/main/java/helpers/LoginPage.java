package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;


public class LoginPage {

    private static final String ID_SIGNIN = ".//*[@id='account-menu']/li[3]/a";
    private static final String ID_LOGIN_EMAIL = ".//*[@id='login-email']";
    private static final String ID_LOGIN_PASSWORD = ".//*[@id='login-password']";
    private static final String ID_SIGNOUT = ".//*[@id='account-menu']/li[4]/a";


    private final GetHomePage homePage;
    public LoginPage() {
        this.homePage = new GetHomePage();
    }

    public void testSignIn(String userName, String userPassword, WebDriver driver) throws Exception {

        try {

            homePage.homePage(driver);

            findElement(driver, ID_SIGNIN).click();

            WebElement loginElem = findElement(driver, ID_LOGIN_EMAIL);
            loginElem.clear();
            loginElem.sendKeys(userName);

            WebElement passwordElem = findElement(driver, ID_LOGIN_PASSWORD);
            passwordElem.clear();
            passwordElem.sendKeys(userPassword);
            passwordElem.submit();

            assertTrue(driver.getTitle().contains("Your Account"));
            findElement(driver, ID_SIGNOUT).click();

            assertTrue(driver.getTitle().startsWith("Voucher Codes - Exclusive Discount Codes and Discount Vouchers"));

        }

        finally {
            if (driver != null)
            {
                driver.quit();
            }
        }


    }
    private WebElement findElement(WebDriver driver, String xpath){

        return driver.findElement(By.xpath(xpath));

    }
}