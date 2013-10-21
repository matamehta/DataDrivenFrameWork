package uk.co.vouchercodes.framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SignInSetUp {

    private static final Logger LOGGER = LogManager.getLogger(SignInSetUp.class);

    private static final String ID_SIGNIN_LINK = ".//*[@id='account-menu']/li[3]/a";
    private static final String ID_LOGIN_EMAIL_FIELD = ".//*[@id='login-email']";
    private static final String ID_LOGIN_PASSWORD_FIELD = ".//*[@id='login-password']";
    private static final String ID_SIGN_BUTTON = ".//*[@id='login-modal']/fieldset/button";


    private final GetHomePage homePage;
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final MyAccountPage myAccountPage;


    public SignInSetUp(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.homePage = new GetHomePage();
        this.myAccountPage = new MyAccountPage(driver, wait);
    }

    public void signInSetup(String userName, String userPassword) throws Exception {

        homePage.homePage(driver, wait);
        final WebElement signInLink = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(SignInSetUp.ID_SIGNIN_LINK)));
        signInLink.click();

        new SignInFrame(userName, userPassword).invoke();

        myAccountPage.assertOnMyAccountPage();
        myAccountPage.doLogout();
    }

    private class SignInFrame {
        private String userName;
        private String userPassword;

        public SignInFrame(String userName, String userPassword) {
            this.userName = userName;
            this.userPassword = userPassword;
        }

        public void invoke() {
            WebElement loginElem = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath(ID_LOGIN_EMAIL_FIELD)));
            loginElem.clear();
            LOGGER.debug(String.format("Email ID Entered: %s", userName));
            loginElem.sendKeys(userName);

            WebElement passwordElem = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath(ID_LOGIN_PASSWORD_FIELD)));
            passwordElem.clear();
            LOGGER.debug(String.format("Password Entered: %s", userPassword));
            passwordElem.sendKeys(userPassword);

            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable
                    (By.xpath(ID_SIGN_BUTTON)));
            signInButton.click();
        }
    }
}