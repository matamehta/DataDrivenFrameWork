package helpers;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class GetHomePage {


    public GetHomePage() {

    }

    void homePage(WebDriver driver) {

        driver.get("http://www.vouchercodes.co.uk");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        assertTrue(driver.getTitle().startsWith("Voucher Codes - Exclusive Discount Codes and Discount Vouchers"));
    }
}