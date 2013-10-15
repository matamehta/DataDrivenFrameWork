package helpers;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.awt.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BaseUrl {

    static WebDriver driver;
    /*final private String protocol = "http";
    final private String domain ="www.vouchercodes.co.uk";
    final private String Root_Url = protocol + "://" + domain;    */

    @Test

    public void createDriver(){

        driver = new FirefoxDriver();
        //driver = new ChromeDriver();

        driver.get("http://www.vouchercodes.co.uk");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        assertTrue(driver.getTitle().startsWith("Voucher Codes - Exclusive Discount Codes and Discount Vouchers"));

        WebElement signUp = driver.findElement(By.xpath(".//*[@id='account-menu']/li[3]/a"));

        signUp.click();



        WebElement loginEmail = driver.findElement(By.xpath(".//*[@id='login-email']"));

        loginEmail.clear();

        loginEmail.sendKeys("kodali_prasad2000@yahoo.co.in");

       // loginEmail.submit();

        WebElement loginPassword = driver.findElement(By.xpath(".//*[@id='login-password']"));

        loginPassword.sendKeys("sreedevi");

        //loginPassword.clear();

        loginPassword.submit();

        assertTrue(driver.getTitle().contains("Your Account"));

        WebElement signOut = driver.findElement(By.xpath(".//*[@id='account-menu']/li[4]/a"));

        signOut.click();

        assertTrue(driver.getTitle().startsWith("Voucher Codes - Exclusive Discount Codes and Discount Vouchers"));

        driver.quit();

    }
}

