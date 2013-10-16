package helpers;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class GetHomePage {


    public GetHomePage() {

    }

    void homePage(WebDriver driver) {

        driver.get("http://www.vouchercodes.co.uk");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        assertTitle(driver);
    }

    public static void assertTitle(WebDriver driver) {

        assertTrue(driver.getTitle().startsWith("Voucher Codes - Exclusive Discount Codes and Discount Vouchers"));
    }
}