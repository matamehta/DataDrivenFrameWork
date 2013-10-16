package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import static org.testng.Assert.assertTrue;


public class LoginPage {

    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);

    private static final String ID_SIGNIN_LINK = ".//*[@id='account-menu']/li[3]/a";
    private static final String ID_LOGIN_EMAIL_FIELD = ".//*[@id='login-email']";
    private static final String ID_LOGIN_PASSWORD_FIELD = ".//*[@id='login-password']";
    private static final String ID_SIGN_BUTTON = ".//*[@id='login-modal']/fieldset/button";
    private static final String ID_MESSAGE = "html / body / div[4] / div / div / hgroup / h1";
    private static final String ID_SIGNOUT_LINK = ".//*[@id='account-menu']/li[4]/a";

    private final GetHomePage homePage;
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.homePage = new GetHomePage();
    }

    public void testSignIn(String userName, String userPassword) throws Exception {

        try {

            homePage.homePage(driver);

            findElement(driver, ID_SIGNIN_LINK).click();

            WebElement loginElem = findElement(driver, ID_LOGIN_EMAIL_FIELD);
            loginElem.clear();
            LOGGER.debug(String.format("Email ID Entered: %s", userName));
            loginElem.sendKeys(userName);


            WebElement passwordElem = findElement(driver, ID_LOGIN_PASSWORD_FIELD);
            passwordElem.clear();
            LOGGER.debug(String.format("Email ID Entered: %s", userPassword));
            passwordElem.sendKeys(userPassword);

            WebElement signInButton = findElement(driver,ID_SIGN_BUTTON);
            assertTrue(signInButton.isEnabled());

            passwordElem.submit();

            WebElement welcomeMessage = findElement(driver, ID_MESSAGE);
            assertTrue(welcomeMessage.isDisplayed());
            assertTrue(driver.getTitle().contains("Your Account"));

            findElement(driver, ID_SIGNOUT_LINK).click();

            GetHomePage.assertTitle(driver);
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