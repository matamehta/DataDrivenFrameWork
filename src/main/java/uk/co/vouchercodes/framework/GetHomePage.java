package uk.co.vouchercodes.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



import static org.testng.Assert.assertTrue;

public class GetHomePage {

    public GetHomePage() {
    }

    void homePage(WebDriver driver, WebDriverWait wait) {

        driver.get("http://www.vouchercodes.co.uk");
        assertHomePage(driver);
    }

    public static void assertHomePage(WebDriver driver) {

        assertTrue(driver.getTitle().startsWith("Voucher Codes - Exclusive Discount Codes and Discount Vouchers"));
    }
}