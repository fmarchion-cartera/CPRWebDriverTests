package com.citipricerewind.tests;

import com.citipricerewind.data.CPRData;
import com.citipricerewind.pages.CitiPriceRewindMainPageSearch;
import com.citipricerewind.pages.CitiPriceRewindMyPriceRewinds;
import com.citipricerewind.pages.CitiPriceRewindSearchResults;
import com.citipricerewind.pages.CitipricerewindMainPage;
import com.sun.org.apache.xerces.internal.impl.xs.identity.Field;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
public class MyPriceRewinds_Filters_Test {

    public WebDriver driver;
    CitipricerewindMainPage CPRMainPage;
    CitiPriceRewindMyPriceRewinds CPRMyPriceRewinds;


    @BeforeClass(alwaysRun = true)
    public void setup(){
        this.driver = new FirefoxDriver();
        CPRMainPage = PageFactory.initElements(driver, CitipricerewindMainPage.class);
        CPRMyPriceRewinds = PageFactory.initElements(driver, CitiPriceRewindMyPriceRewinds.class);
    }

    @AfterClass(alwaysRun = true)
    public void teardown(){
        driver.close();
    }


    @Test(groups ={"p1"})
    public void testMyPRFilters(/*String status, String perPage String status_UploadReceipt*/){

        WebDriverWait driverWait = new WebDriverWait(driver, 60);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.manage().deleteAllCookies();

        driver.get(CPRMainPage.PAGE_URL);

        WebElement payload = driver.findElement(By.cssSelector("input[value='Single Card Payload']"));
        payload.click();
        assertEquals(driver.getTitle(), CPRMainPage.PAGE_TITLE);

        WebElement link_myPR = driver.findElement(By.linkText("My Price Rewinds"));
        driverWait.until(ExpectedConditions.visibilityOf(link_myPR));
        link_myPR.click();
        assertEquals(driver.getTitle(), CPRMyPriceRewinds.PAGE_TITLE);

        //Click the drop-down 'Filter by' status box
        CPRMyPriceRewinds.setFilter_Status();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getTitle(), CPRMyPriceRewinds.PAGE_TITLE);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Select the 'Request Price Difference' status
        CPRMyPriceRewinds.setStatus_RequestPriceDifference();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals(driver.getCurrentUrl(), CitiPriceRewindMyPriceRewinds.REQUEST_PRICE_DIFFERENCE_URL);

        //Click the drop-down 'Filter by' status box
        CPRMyPriceRewinds.setFilter_Status();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getTitle(), CPRMyPriceRewinds.PAGE_TITLE);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Select the 'Upload Receipt' status
        CPRMyPriceRewinds.setStatus_UploadReceipt();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals(driver.getCurrentUrl(), CitiPriceRewindMyPriceRewinds.UPLOAD_RECEIPT_URL);

        //Click the drop-down 'Filter by' status box
        CPRMyPriceRewinds.setFilter_Status();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getTitle(), CPRMyPriceRewinds.PAGE_TITLE);

        //Select the 'Processing Request' status box
        CPRMyPriceRewinds.setStatus_ProcessingRequest();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), CitiPriceRewindMyPriceRewinds.PROCESSING_REQUEST_URL);

        //Click the drop-down 'Filter by' status box
        CPRMyPriceRewinds.setFilter_Status();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getTitle(), CPRMyPriceRewinds.PAGE_TITLE);

        //Select the 'Information Required' status box
        CPRMyPriceRewinds.setStatus_InformationRequired();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), CitiPriceRewindMyPriceRewinds.INFORMATION_REQUIRED_URL);

        //Click the drop-down 'Filter by' status box
        CPRMyPriceRewinds.setFilter_Status();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getTitle(), CPRMyPriceRewinds.PAGE_TITLE);

        //Select the 'Still Tracking' status box
        CPRMyPriceRewinds.setStatus_StillTracking();
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), CitiPriceRewindMyPriceRewinds.STILL_TRACKING_URL);

        //Click the drop-down 'Filter by' status box
        CPRMyPriceRewinds.setFilter_Status();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getTitle(), CPRMyPriceRewinds.PAGE_TITLE);

        //Select the 'Request Approved' status box
        CPRMyPriceRewinds.setStatus_RequestApproved();
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), CitiPriceRewindMyPriceRewinds.REQUEST_APPROVED_URL);

        //Click the drop-down 'Filter by' status box
        CPRMyPriceRewinds.setFilter_Status();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getTitle(), CPRMyPriceRewinds.PAGE_TITLE);

        //Select the 'No Lower Price' status box
        CPRMyPriceRewinds.setStatus_NoLowerPrice();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), CitiPriceRewindMyPriceRewinds.NO_LOWER_PRICE_URL);

        //Click the drop-down 'Filter by' status box
        CPRMyPriceRewinds.setFilter_Status();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getTitle(), CPRMyPriceRewinds.PAGE_TITLE);

        //Select the 'Request Not Approved' status box
        CPRMyPriceRewinds.setStatus_RequestNotApproved();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), CitiPriceRewindMyPriceRewinds.REQUEST_NOT_APPROVED_URL);

        //Click the drop-down 'Filter by' status box
        CPRMyPriceRewinds.setFilter_Status();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getTitle(), CPRMyPriceRewinds.PAGE_TITLE);

        //Select the 'Item Not Covered' status box
        CPRMyPriceRewinds.setStatus_ItemNotCovered();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), CitiPriceRewindMyPriceRewinds.ITEM_NOT_COVERED_URL);

        //Click the drop-down 'Filter by' status box
        CPRMyPriceRewinds.setFilter_Status();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getTitle(), CPRMyPriceRewinds.PAGE_TITLE);

        //Select the 'Expired' status box
        CPRMyPriceRewinds.setStatus_Expired();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), CitiPriceRewindMyPriceRewinds.EXPIRED_URL);

        //Click the drop-down 'Filter by' status box
        CPRMyPriceRewinds.setFilter_Status();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getTitle(), CPRMyPriceRewinds.PAGE_TITLE);

        //Select the 'Status of Price Rewind' status box
        CPRMyPriceRewinds.setStatus_StatOfPriceRewind();

        //Click the drop-down 'Per Page' view box
        CPRMyPriceRewinds.set_PerPage();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getTitle(), CPRMyPriceRewinds.PAGE_TITLE);

        //Select view per page 12
        CPRMyPriceRewinds.setView_12PerPage();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), CitiPriceRewindMyPriceRewinds.VIEW_12_PER_PAGE);

        //Click the drop-down 'Per Page' view box
        CPRMyPriceRewinds.set_PerPage();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getTitle(), CPRMyPriceRewinds.PAGE_TITLE);

        //Select view per page 12
        CPRMyPriceRewinds.setView_24PerPage();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), CitiPriceRewindMyPriceRewinds.VIEW_24_PER_PAGE);

        }
}

