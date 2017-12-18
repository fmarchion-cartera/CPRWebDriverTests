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
public class BenefitRequestGuide_Test {

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
    public void testGuideToBenefit(/*String status, String perPage String status_UploadReceipt*/) {

        //Click the 'Guide To Citi Price Rewind Benefit' link
        CPRMainPage.click_BenefitGuide();
        assertEquals(driver.getCurrentUrl(), CPRMainPage.GUIDE_TO_CITi_PRICE_REWIND_URL);


        //Verify 'Guide to Citi Price Rewind Benefit' text is visible
        if (driver.findElement(By.cssSelector("html#guide > body > div#cpr_content > div.cpr_grid.cpr_staticPage.cpr_guide > div.cpr_HWblock:nth-of-type(1) > h1")).isDisplayed()) {
            System.out.println("Guide to Citi® Price Rewind Benefit is visible");
        } else {
            System.out.println("Guide to Citi® Price Rewind Benefit is NOT visible");
        }

        //Verify 'Did you get the lowest price on your Citi card purchase? Let Citi Price Rewind search for you.' text is visible
        if (driver.findElement(By.cssSelector("html#guide > body > div#cpr_content > div.cpr_grid.cpr_staticPage.cpr_guide > div.cpr_HWblock:nth-of-type(2)")).isDisplayed()) {
            System.out.println("Did you get the lowest price on your Citi card purchase? Let Citi Price Rewind search for you. is visible");
        } else {
            System.out.println("Did you get the lowest price on your Citi card purchase? Let Citi Price Rewind search for you. is NOT visible");
        }

        //Verify 'What purchases are eligible' text is visible
        if (driver.findElement(By.cssSelector("html#guide > body > div#cpr_content > div.cpr_grid.cpr_staticPage.cpr_guide > div.cpr_HWblock:nth-of-type(3)")).isDisplayed()) {
            System.out.println("What purchases are eligible: is visible");
        } else {
            System.out.println("What purchases are eligible: is NOT visible");
        }

        //Verify 'What purchases are not eligible' text is visible
        if (driver.findElement(By.cssSelector("html#guide > body > div#cpr_content > div.cpr_grid.cpr_staticPage.cpr_guide > div.cpr_HWblock:nth-of-type(4)")).isDisplayed()) {
            System.out.println("What purchases are not eligible: is visible");
        } else {
            System.out.println("What purchases are not eligible: is NOT visible");
        }

        //Verify 'How to initiate a Citi Price Rewind benefit request' is visible
        if (driver.findElement(By.cssSelector("html#guide > body > div#cpr_content > div.cpr_grid.cpr_staticPage.cpr_guide > div.cpr_HWblock:nth-of-type(5)")).isDisplayed()) {
            System.out.println("How to initiate a Citi Price Rewind benefit request is visible");
        } else {
            System.out.println("How to initiate a Citi Price Rewind benefit request is NOT visible");
        }
    }
}