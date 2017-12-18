package com.citipricerewind.tests;

import com.citipricerewind.data.CPRData;
import com.citipricerewind.pages.*;
import com.sun.org.apache.xerces.internal.impl.xs.identity.Field;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by frank.marchion on 6/8/2017.
 */
public class TermsAndConditions_Test {

    public WebDriver driver;
    CitipricerewindMainPage CPRMainPage;
    //CitiPriceRewindMainPageSearch CPRMainPageSearch;
    //CitiPriceRewindSearchResults CPRSearchResults;
    CitiPriceRewindMyPriceRewinds CPRMyPriceRewinds;
    com.citipricerewind.pages.FAQPage FAQPage;


    @BeforeClass(alwaysRun = true)
    public void setup() {
        this.driver = new FirefoxDriver();
        CPRMainPage = PageFactory.initElements(driver, CitipricerewindMainPage.class);
        //CPRMainPage = new CitipricerewindMainPage(driver);
        //CPRMainPageSearch = PageFactory.initElements(driver, CitiPriceRewindMainPageSearch.class);
        //CPRSearchResults = PageFactory.initElements(driver, CitiPriceRewindSearchResults.class);
        CPRMyPriceRewinds = PageFactory.initElements(driver, CitiPriceRewindMyPriceRewinds.class);
        FAQPage = PageFactory.initElements(driver, FAQPage.class);

        WebDriverWait driverWait = new WebDriverWait(driver, 60);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.manage().deleteAllCookies();

        driver.get(CPRMainPage.PAGE_URL);

        WebElement payload = driver.findElement(By.cssSelector("input[value='Single Card Payload']"));
        payload.click();
        assertEquals(driver.getTitle(), CPRMainPage.PAGE_TITLE);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        driver.close();
    }


    @Test(groups = {"p1"})
    public void testTermsAndConditions(/*String status, String perPage String status_UploadReceipt*/) {

        //Click the 'Site Terms and Conditions' link
        CPRMainPage.click_TermsConditions();
        assertEquals(driver.getCurrentUrl(), CPRMainPage.SITE_TERMS_CONDITIONS_URL);


        //Verify 'Citibank Disclaimer' text is visible
        if (driver.findElement(By.cssSelector("html#terms > body > div#cpr_content > div.cpr_grid.cpr_staticPage > div.cpr_HWblock:nth-of-type(1)")).isDisplayed()) {
            System.out.println("Citibank Disclaimer is visible");
        } else {
            System.out.println("Citibank Disclaimer is NOT visible");
        }

        //Verify 'Trademarks' text is visible
        if (driver.findElement(By.cssSelector("html#terms > body > div#cpr_content > div.cpr_grid.cpr_staticPage > div.cpr_HWblock:nth-of-type(2)")).isDisplayed()) {
            System.out.println("Trademarks is visible");
        } else {
            System.out.println("Trademarks is NOT visible");
        }

        //Verify 'Use of Information and Material' text is visible
        if (driver.findElement(By.cssSelector("html#terms > body > div#cpr_content > div.cpr_grid.cpr_staticPage > div.cpr_HWblock:nth-of-type(3)")).isDisplayed()) {
            System.out.println("Use of Information and Material is visible");
        } else {
            System.out.println("Use of Information and Material is NOT visible");
        }

        //Verify 'Links' text is visible
        if (driver.findElement(By.cssSelector("html#terms > body > div#cpr_content > div.cpr_grid.cpr_staticPage > div.cpr_HWblock:nth-of-type(4)")).isDisplayed()) {
            System.out.println("Links text is visible");
        }else {
            System.out.println("Links text is NOT visible");
        }

        //Verify 'No Warranty' text is visible
        if (driver.findElement(By.cssSelector("html#terms > body > div#cpr_content > div.cpr_grid.cpr_staticPage > div.cpr_HWblock:nth-of-type(5)")).isDisplayed()) {
            System.out.println("No Warranty text is visible");
        }else {
            System.out.println("No Warranty text is NOT visible");
        }

        //Verify 'Limitation of Liability' text is visible
        if (driver.findElement(By.cssSelector("html#terms > body > div#cpr_content > div.cpr_grid.cpr_staticPage > div.cpr_HWblock:nth-of-type(6)")).isDisplayed()) {
            System.out.println("Limitation of Liability text is visible");
        }else {
            System.out.println("Limitation of Liability text is NOT visible");
        }

        //Verify 'Submissions' text is visible
        if (driver.findElement(By.cssSelector("html#terms > body > div#cpr_content > div.cpr_grid.cpr_staticPage > div.cpr_HWblock:nth-of-type(7)")).isDisplayed()) {
            System.out.println("Submissions text is visible");
        }else {
            System.out.println("Submissions text is NOT visible");
        }

        //Verify 'Availability' text is visible
        if (driver.findElement(By.cssSelector("html#terms > body > div#cpr_content > div.cpr_grid.cpr_staticPage > div.cpr_HWblock:nth-of-type(8)")).isDisplayed()) {
            System.out.println("Availability text is visible");
        }else {
            System.out.println("Availability text is NOT visible");
        }

        //Verify 'Additional Terms' text is visible
        if (driver.findElement(By.cssSelector("html#terms > body > div#cpr_content > div.cpr_grid.cpr_staticPage > div.cpr_HWblock:nth-of-type(9)")).isDisplayed()) {
            System.out.println("Additional Terms text is visible");
        } else {
            System.out.println("Additional Terms text is NOT visible");
        }

        //Verify 'Governing Law' text is visible
        if (driver.findElement(By.cssSelector("html#terms > body > div#cpr_content > div.cpr_grid.cpr_staticPage > div.cpr_HWblock:nth-of-type(10)")).isDisplayed()) {
            System.out.println("Governing Law text is visible");
        }else {
            System.out.println("Governing Law text is NOT visible");
        }

    }

}