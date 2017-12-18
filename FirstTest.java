package com.citipricerewind.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by frank.marchion on 6/2/2017.
 */
public class FirstTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        WebDriverWait driverWait = new WebDriverWait(driver, 60);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.get("http://silver.www.citipricerewind.com/demo/citi_prw_sso.php");

        WebElement singleCardPayload = driver.findElement(By.xpath("html/body/form[1]/input[2]"));

        singleCardPayload.click();

        String url1 = driver.getCurrentUrl();
        System.out.println(url1);

        String title1 = driver.getTitle();
        System.out.println(title1);

        WebElement signOff = driver.findElement(By.cssSelector(".cpr_logInOutLink.cpr_icon_lock"));
        driverWait.until(ExpectedConditions.visibilityOf(signOff));
        signOff.click();

        Thread.sleep(2000L);

        driver.get("http://www.amazon.com");

        String url = driver.getCurrentUrl();
        System.out.println(url);

        String title = driver.getTitle();
        System.out.println(title);


        WebElement signIn = driver.findElement(By.xpath("html/body/div[1]/header/div/div[2]/div[2]/div/a[2]/span[1]"));

        signIn.click();

        driver.close();

    }
}
