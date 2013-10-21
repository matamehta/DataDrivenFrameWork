package uk.co.vouchercodes.utils;

public class SingInPageDuplicate {
    /*
public class SignInSetUp {

    private static final Logger LOGGER = LogManager.getLogger(SignInSetUp.class);

    private static final String ID_SIGNIN_LINK = ".//*[@id='account-menu']/li[3]/a";
    private static final String ID_LOGIN_EMAIL_FIELD = ".//*[@id='login-email']";
    private static final String ID_LOGIN_PASSWORD_FIELD = ".//*[@id='login-password']";
    private static final String ID_SIGN_BUTTON = ".//*[@id='login-modal']/fieldset/button";
    private static final String ID_MESSAGE = "html / body / div[4] / div / div / hgroup / h1";
    private static final String ID_SIGNOUT_LINK = ".//*[@id='account-menu']/li[4]/a";

    private final GetHomePage homePage;
    private final WebDriver driver;
    private final WebDriverWait wait;

    public SignInSetUp(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.homePage = new GetHomePage();
    }

    public void signInSetup(String userName, String userPassword) throws Exception {

        try {

            homePage.homePage(driver, wait);
            final WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ID_SIGNIN_LINK)));
//           final WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
//            By.cssSelector("ul#account-menu li.login a")));
            element.click();
//            findElement(driver, ID_SIGNIN_LINK).click();

            final WebElement loginElem = wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath(ID_LOGIN_EMAIL_FIELD)));

            //WebElement loginElem = findElement(driver, ID_LOGIN_EMAIL_FIELD);
            loginElem.clear();
            LOGGER.debug(String.format("Email ID Entered: %s", userName));
            loginElem.sendKeys(userName);

            WebElement passwordElem = wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath(ID_LOGIN_PASSWORD_FIELD)));

            //passwordElem = findElement(driver, ID_LOGIN_PASSWORD_FIELD);
            passwordElem.clear();
            LOGGER.debug(String.format("Password Entered: %s", userPassword));
            passwordElem.sendKeys(userPassword);

            WebElement signInButton = findElement(driver, ID_SIGN_BUTTON);
            assertTrue(signInButton.isEnabled());
            passwordElem.submit();

            WebElement welcomeMessage = findElement(driver, ID_MESSAGE);
            assertTrue(welcomeMessage.isDisplayed());
            assertTrue(driver.getTitle().contains("Your Account"));

            findElement(driver, ID_SIGNOUT_LINK).click();

            GetHomePage.assertHomePage(driver);

        }
        finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
    private WebElement findElement(WebDriver driver, String xpath) {
        return driver.findElement(By.xpath(xpath));
    }
}        */
}
