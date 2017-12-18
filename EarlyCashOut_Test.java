package com.citipricerewind.tests;

import com.citipricerewind.pages.CitiPriceRewindMyPriceRewinds;
import com.citipricerewind.pages.CitipricerewindMainPage;
import com.citipricerewind.pages.StartPriceRewind;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by frank.marchion on 6/22/2017.
 */
public class EarlyCashOut_Test {

    public WebDriver driver;
    CitipricerewindMainPage CPRMainPage;
    CitiPriceRewindMyPriceRewinds CPRMyPriceRewinds;
    StartPriceRewind StartPriceRewind;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        this.driver = new FirefoxDriver();
        CPRMainPage = PageFactory.initElements(driver, CitipricerewindMainPage.class);
        CPRMyPriceRewinds = PageFactory.initElements(driver, CitiPriceRewindMyPriceRewinds.class);
        StartPriceRewind = PageFactory.initElements(driver, StartPriceRewind.class);

        WebDriverWait driverWait = new WebDriverWait(driver, 60);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.manage().deleteAllCookies();

        driver.get(CPRMainPage.PAGE_URL);

        WebElement payload = driver.findElement(By.cssSelector("input[value='Single Card Payload']"));
        payload.click();
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        driver.close();
     }

    @Test(groups = {"p1"})
    public void testEarlyCashOut()

    {

        //assertEquals(driver.getTitle(), CPRMainPage.PAGE_TITLE);

        WebElement link_myPR = driver.findElement(By.linkText("My Price Rewinds"));
        //driverWait.until(ExpectedConditions.visibilityOf(link_myPR));
        link_myPR.click();
        assertEquals(driver.getTitle(), CPRMyPriceRewinds.PAGE_TITLE);

        //status_UploadReceipt;

        //Click the drop-down 'Filter by' status box
        CPRMyPriceRewinds.setFilter_Status();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //assertEquals(driver.getTitle(), CPRMyPriceRewinds.PAGE_TITLE);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Select the 'Still Tracking' status
        CPRMyPriceRewinds.setStatus_StillTracking();
        {

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            assertEquals(driver.getCurrentUrl(), CitiPriceRewindMyPriceRewinds.STILL_TRACKING_URL);

        //Expand the 'View' per page drop-down to 24 per page
            //Click the drop-down 'Per Page' view box
            CPRMyPriceRewinds.set_PerPage();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //assertEquals(driver.getTitle(), CPRMyPriceRewinds.PAGE_TITLE);

            //Select view per page 12
            CPRMyPriceRewinds.setView_24PerPage();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            assertEquals(driver.getCurrentUrl(), CitiPriceRewindMyPriceRewinds.STILL_TRACKING_24_PER_PAGE);

            //Find a tile with Early Cash Out and click 'Request Now' link
            CPRMyPriceRewinds.clickRequestNow();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Assert pop-up box and text appear
            String ecoPopup = driver.findElement(By.cssSelector("html#my-price-rewinds > body > div.cpr_dialog > div.cpr_dialogPopUp > div.cpr_popUpContent.cpr_focusable > div.cpr_dialogHeader")).getText();
            assertTrue(ecoPopup.contains("REQUEST SAVINGS"));

            //Click the 'Continue Search' button
            CPRMyPriceRewinds.clickContinueSearch();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //Find a tile with Early Cash Out and click 'Request Now' link
            CPRMyPriceRewinds.clickRequestNow();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Assert pop-up box and text appear
            String ecoPopup1 = driver.findElement(By.cssSelector("html#my-price-rewinds > body > div.cpr_dialog > div.cpr_dialogPopUp > div.cpr_popUpContent.cpr_focusable > div.cpr_dialogHeader")).getText();
            assertTrue(ecoPopup1.contains("REQUEST SAVINGS"));

            //Click the 'Request Now' button in pop-up window
            CPRMyPriceRewinds.clickECORequestNowButton();

            //Assert track has a status of 'Processing Request' status
            if(driver.findElement(By.cssSelector("html#view-price-rewind > body > div#cpr_content > div#cpr_trackDetails > div.cpr_grid > div.cpr_md-9 > div.cpr_indicator > div.cpr_clearfix > div#track_label > div.cpr_trackBtn.cpr_md-only")).isDisplayed())
            {
                System.out.println("Status is Processing Request");
            }
            else{
                System.out.println("Status is Wrong");
            }



        }



            //Select a tile
            /*CPRMyPriceRewinds.clickRequestPriceDifference();

            //Click Request Price Difference button
            CPRMyPriceRewinds.clickRequestButton();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();

            }
            assertTrue(driver.findElement(By.cssSelector(".cpr_trackBtn.cpr_md-only")).getText().contains("Processing Request"));*/


        }
    }
