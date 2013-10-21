package uk.co.vouchercodes.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MyAccountPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private static final String ID_MESSAGE = "html / body / div[4] / div / div / hgroup / h1";
    private static final String ID_SIGNOUT_LINK = ".//*[@id='account-menu']/li[4]/a";

    public MyAccountPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void assertOnMyAccountPage() {
        WebElement welcomeMessage = driver.findElement(By.xpath(ID_MESSAGE));
        Assert.assertTrue(welcomeMessage.isDisplayed());
        Assert.assertTrue(driver.getTitle().contains("Your Account"));
    }

    public void doLogout() {
        WebElement signOut = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(ID_SIGNOUT_LINK)));
        signOut.click();
    }
}