package com.citipricerewind.tests;

import com.citipricerewind.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
public class OnlineManualClaims_Test {

    public WebDriver driver;
    CitipricerewindMainPage CPRMainPage;
    CitiPriceRewindMyPriceRewinds CPRMyPriceRewinds;
    StartPriceRewind StartPriceRewind;
    HowItWorksPage HIWPage;
    StartBenefitRequestPage OMCPage;
    FAQPage FAQPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        this.driver = new FirefoxDriver();
        CPRMainPage = PageFactory.initElements(driver, CitipricerewindMainPage.class);
        CPRMyPriceRewinds = PageFactory.initElements(driver, CitiPriceRewindMyPriceRewinds.class);
        StartPriceRewind = PageFactory.initElements(driver, StartPriceRewind.class);
        HIWPage = PageFactory.initElements(driver, HowItWorksPage.class);
        OMCPage = PageFactory.initElements(driver, StartBenefitRequestPage.class);
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
    public void testOnlineManualClaims()

    {

        WebDriverWait driverWait = new WebDriverWait(driver, 60);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.manage().deleteAllCookies();

        driver.get(CPRMainPage.PAGE_URL);

        WebElement payload = driver.findElement(By.cssSelector("input[value='Single Card Payload']"));
        payload.click();
        assertEquals(driver.getTitle(), CPRMainPage.PAGE_TITLE);

        //Click the 'How It Works' link
        CPRMainPage.clickHowItWorks();
        assertEquals(driver.getCurrentUrl(), CPRMainPage.HIW_URL);

        //Click the 'submit your Citi Price Rewind benefit request online' link
        HIWPage.clickBenReqForm();
        assertEquals(driver.getCurrentUrl(), HIWPage.START_BENEFIT_REQUEST);

        //Add a 'Product Name'
        OMCPage.setText_ProductName("gopro hero 5 black");
        assertEquals(driver.getTitle(), OMCPage.START_BENEFIT_REQUEST_TITLE);

        //Add a 'Purchase Price'
        OMCPage.setText_PurchasePrice("499.99");

        //Add a 'Date Purchased'
        OMCPage.setText_DatePurchased("10/07/17");

        //Add a 'Store Name'
        OMCPage.setText_StoreName("My Store");

        //Select payment type
        OMCPage.select_Payment_Type_Check();

        //Click Receipt Upload container
        StartPriceRewind.select_Receipt_Upload("C:\\Users\\frank.marchion\\Documents\\Documents\\Test Receipts\\CARTERA TEST RECEIPT PNG.png");
        String uploadSuccessful = driver.findElement(By.cssSelector(".cpr_successfulUpload")).getText();
        assertTrue(uploadSuccessful.contains("Your file CARTERA TEST RECEIPT PNG.png has been uploaded successfully."));

        //Click 'Add Low Price Information' button
        OMCPage.click_AddLowPrice();
        assertEquals(driver.getTitle(), OMCPage.ADD_LOW_PRICE_DETAILS_TITLE);

        //Add 'Low Price Found'
        driver.findElement(By.cssSelector("#cpr_SPR_price")).sendKeys(Keys.chord(Keys.CONTROL, "a"),"1.99");
        //OMCPage.setText_LowPriceFound("399.99");

        //Select datepicker icon
        OMCPage.click_datepicker();

        //Select 'Date of Low Price'
        StartPriceRewind.select_First_Date();

        //Add store name where lower price was found
        OMCPage.setText_LowPriceFoundStore("Some store");

        //Upload photo proof
        OMCPage.select_PhotoProof("C:\\Users\\frank.marchion\\Documents\\Documents\\Test Receipts\\clearearth-lights.jpg");
        String uploadSuccessful1 = driver.findElement(By.cssSelector(".cpr_successfulUpload")).getText();
        assertTrue(uploadSuccessful1.contains("Your file clearearth-lights.jpg has been uploaded successfully."));

        //Click the 'Submit Request' button
        OMCPage.click_SubmitRequest();

        //Assert track has a status of 'Processing Request' status
        if(driver.findElement(By.cssSelector("html#view-price-rewind > body > div#cpr_content > div#cpr_trackDetails > div.cpr_grid > div.cpr_md-9 > div.cpr_indicator > div.cpr_clearfix > div#track_label > div.cpr_trackBtn.cpr_md-only")).isDisplayed())
        {
            System.out.println("Status is Processing Request");
        }
        else{
            System.out.println("Status is Wrong");
        }



    }

    @Test(groups = {"p1"})
    public void testOMCStillTracking()

    {

        WebDriverWait driverWait = new WebDriverWait(driver, 60);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.manage().deleteAllCookies();

        driver.get(CPRMainPage.PAGE_URL);

        WebElement payload = driver.findElement(By.cssSelector("input[value='Single Card Payload']"));
        payload.click();
        assertEquals(driver.getTitle(), CPRMainPage.PAGE_TITLE);

        //Click the 'My Price Rewinds' link
        CPRMainPage.clickMyPriceRewinds();
        //assertEquals(driver.getCurrentUrl(), CPRMainPage.HIW_URL);

        //Click the drop-down 'Filter by' status box
        CPRMyPriceRewinds.setFilter_Status();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getTitle(), CPRMyPriceRewinds.PAGE_TITLE);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Select the 'Still Tracking' status box
        CPRMyPriceRewinds.setStatus_StillTracking();
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), CitiPriceRewindMyPriceRewinds.STILL_TRACKING_URL);

        //Select the first track in the list
        CPRMyPriceRewinds.setSelect_Track();

        //Click the 'submit your Citi Price Rewind benefit request online' link
        OMCPage.click_BenefitRequestOnline();
        //assertEquals(driver.getCurrentUrl(), HIWPage.START_BENEFIT_REQUEST);

        //Add 'Low Price Found'
        driver.findElement(By.cssSelector("#cpr_SPR_price")).sendKeys(Keys.chord(Keys.CONTROL, "a"),"1.99");
        //OMCPage.setText_LowPriceFound("199.99");

        //Select datepicker icon
        OMCPage.click_datepicker();

        //Select 'Date of Low Price'
        StartPriceRewind.select_First_Date();

        //Add store name where lower price was found
        OMCPage.setText_LowPriceFoundStore("Some store");

        //Upload photo proof
        OMCPage.select_PhotoProof("C:\\Users\\frank.marchion\\Documents\\Documents\\Test Receipts\\clearearth-lights.jpg");
        String uploadSuccessful1 = driver.findElement(By.cssSelector(".cpr_successfulUpload")).getText();
        assertTrue(uploadSuccessful1.contains("Your file clearearth-lights.jpg has been uploaded successfully."));

        //Click the 'Submit Request' button
        OMCPage.click_SubmitRequest();

        //Assert track has a status of 'Processing Request' status
        if(driver.findElement(By.cssSelector("html#view-price-rewind > body > div#cpr_content > div#cpr_trackDetails > div.cpr_grid > div.cpr_md-9 > div.cpr_indicator > div.cpr_clearfix > div#track_label > div.cpr_trackBtn.cpr_md-only")).isDisplayed())
        {
            System.out.println("Status is Processing Request");
        }
        else{
            System.out.println("Status is Wrong");
        }



    }

    @Test(groups = {"p1"})
    public void testOMCRequestPriceDifference()

    {
        WebDriverWait driverWait = new WebDriverWait(driver, 60);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.manage().deleteAllCookies();

        driver.get(CPRMainPage.PAGE_URL);

        WebElement payload = driver.findElement(By.cssSelector("input[value='Single Card Payload']"));
        payload.click();
        assertEquals(driver.getTitle(), CPRMainPage.PAGE_TITLE);

        //Click the 'My Price Rewinds' link
        CPRMainPage.clickMyPriceRewinds();
        //assertEquals(driver.getCurrentUrl(), CPRMainPage.HIW_URL);

        //Click the drop-down 'Filter by' status box
        CPRMyPriceRewinds.setFilter_Status();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getTitle(), CPRMyPriceRewinds.PAGE_TITLE);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Select the 'Still Tracking' status box
        CPRMyPriceRewinds.setStatus_RequestPriceDifference();
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), CitiPriceRewindMyPriceRewinds.REQUEST_PRICE_DIFFERENCE_URL);

        //Select the first track in the list
        CPRMyPriceRewinds.setSelect_Track();

        //Click the 'submit your Citi Price Rewind benefit request online' link
        OMCPage.click_BenefitRequestOnline();
        //assertEquals(driver.getCurrentUrl(), HIWPage.START_BENEFIT_REQUEST);

        //Add 'Low Price Found'
        driver.findElement(By.cssSelector("#cpr_SPR_price")).sendKeys(Keys.chord(Keys.CONTROL, "a"),"1.99");
        //OMCPage.setText_LowPriceFound("199.99");

        //Select datepicker icon
        OMCPage.click_datepicker();

        //Select 'Date of Low Price'
        StartPriceRewind.select_First_Date();

        //Add store name where lower price was found
        OMCPage.setText_LowPriceFoundStore("Some store");

        //Upload photo proof
        OMCPage.select_PhotoProof("C:\\Users\\frank.marchion\\Documents\\Documents\\Test Receipts\\clearearth-lights.jpg");
        String uploadSuccessful1 = driver.findElement(By.cssSelector(".cpr_successfulUpload")).getText();
        assertTrue(uploadSuccessful1.contains("Your file clearearth-lights.jpg has been uploaded successfully."));

        //Click the 'Submit Request' button
        OMCPage.click_SubmitRequest();

        //Assert track has a status of 'Processing Request' status
        if(driver.findElement(By.cssSelector("html#view-price-rewind > body > div#cpr_content > div#cpr_trackDetails > div.cpr_grid > div.cpr_md-9 > div.cpr_indicator > div.cpr_clearfix > div#track_label > div.cpr_trackBtn.cpr_md-only")).isDisplayed())
        {
            System.out.println("Status is Processing Request");
        }
        else{
            System.out.println("Status is Wrong");
        }



    }

    @Test(groups = {"p1"})
    public void testOMCNoLowerPrice()

    {
        WebDriverWait driverWait = new WebDriverWait(driver, 60);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.manage().deleteAllCookies();

        driver.get(CPRMainPage.PAGE_URL);

        WebElement payload = driver.findElement(By.cssSelector("input[value='Single Card Payload']"));
        payload.click();
        assertEquals(driver.getTitle(), CPRMainPage.PAGE_TITLE);

        //Click the 'My Price Rewinds' link
        CPRMainPage.clickMyPriceRewinds();
        //assertEquals(driver.getCurrentUrl(), CPRMainPage.HIW_URL);

        //Click the drop-down 'Filter by' status box
        CPRMyPriceRewinds.setFilter_Status();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getTitle(), CPRMyPriceRewinds.PAGE_TITLE);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Select the 'Now Lower Price' status box
        CPRMyPriceRewinds.setStatus_NoLowerPrice();
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), CitiPriceRewindMyPriceRewinds.NO_LOWER_PRICE_URL);

        //Select the first track in the list
        CPRMyPriceRewinds.setSelect_Track();

        //Click the 'submit your Citi Price Rewind benefit request online' link
        OMCPage.click_BenefitRequestOnline();
        //assertEquals(driver.getCurrentUrl(), HIWPage.START_BENEFIT_REQUEST);

        //Add 'Low Price Found'
        driver.findElement(By.cssSelector("#cpr_SPR_price")).sendKeys(Keys.chord(Keys.CONTROL, "a"),"1.99");

        //OMCPage.setText_LowPriceFound("1.99");

        //Select datepicker icon
        OMCPage.click_datepicker();

        //Select 'Date of Low Price'
        StartPriceRewind.select_First_Date();

        //Add store name where lower price was found
        OMCPage.setText_LowPriceFoundStore("Some store");

        //Upload photo proof
        OMCPage.select_PhotoProof("C:\\Users\\frank.marchion\\Documents\\Documents\\Test Receipts\\clearearth-lights.jpg");
        String uploadSuccessful1 = driver.findElement(By.cssSelector(".cpr_successfulUpload")).getText();
        assertTrue(uploadSuccessful1.contains("Your file clearearth-lights.jpg has been uploaded successfully."));

        //Click the 'Submit Request' button
        OMCPage.click_SubmitRequest();

        //Assert track has a status of 'Processing Request' status
        //if(driver.findElement(By.cssSelector("html#view-price-rewind > body > div#cpr_content > div#cpr_trackDetails > div.cpr_grid > div.cpr_md-9 > div.cpr_indicator > div.cpr_clearfix > div#track_label > div.cpr_trackBtn.cpr_md-only")).isDisplayed())
          if(driver.findElement(By.cssSelector("html#view-price-rewind > body > div#cpr_content > div#cpr_trackDetails > div.cpr_grid > div.cpr_md-9 > div.cpr_indicator > div.cpr_clearfix > div#track_label > div.cpr_trackBtn.cpr_md-only")).isDisplayed())
        {
            System.out.println("Status is Processing Request");
        }
        else{
            System.out.println("Status is Wrong");
        }



    }

    @Test(groups = {"p1"})
    public void testOMCFAQLink()

    {
        WebDriverWait driverWait = new WebDriverWait(driver, 60);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.manage().deleteAllCookies();

        driver.get(CPRMainPage.PAGE_URL);

        WebElement payload = driver.findElement(By.cssSelector("input[value='Single Card Payload']"));
        payload.click();
        assertEquals(driver.getTitle(), CPRMainPage.PAGE_TITLE);

        //Click the 'FAQS' link
        CPRMainPage.click_FAQS();

        //Click the 'Citi Price Rewind benefit request' link
        FAQPage.click_OMC_FAQ_Link();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Add a 'Product Name'
        OMCPage.setText_ProductName("gopro hero 5 black");
        assertEquals(driver.getTitle(), OMCPage.START_BENEFIT_REQUEST_TITLE);

        //Add a 'Purchase Price'
        OMCPage.setText_PurchasePrice("499.99");

        //Add a 'Date Purchased'
        OMCPage.setText_DatePurchased("10/07/17");

        //Add a 'Store Name'
        OMCPage.setText_StoreName("My Store");

        //Select payment type
        OMCPage.select_Payment_Type_Check();

        //Click Receipt Upload container
        StartPriceRewind.select_Receipt_Upload("C:\\Users\\frank.marchion\\Documents\\Documents\\Test Receipts\\CARTERA TEST RECEIPT PNG.png");
        String uploadSuccessful = driver.findElement(By.cssSelector(".cpr_successfulUpload")).getText();
        assertTrue(uploadSuccessful.contains("Your file CARTERA TEST RECEIPT PNG.png has been uploaded successfully."));

        //Click 'Add Low Price Information' button
        OMCPage.click_AddLowPrice();
        assertEquals(driver.getTitle(), OMCPage.ADD_LOW_PRICE_DETAILS_TITLE);

        //Add 'Low Price Found'
        driver.findElement(By.cssSelector("#cpr_SPR_price")).sendKeys(Keys.chord(Keys.CONTROL, "a"),"1.99");
        //OMCPage.setText_LowPriceFound("399.99");

        //Select datepicker icon
        OMCPage.click_datepicker();

        //Select 'Date of Low Price'
        StartPriceRewind.select_First_Date();

        //Add store name where lower price was found
        OMCPage.setText_LowPriceFoundStore("Some store");

        //Upload photo proof
        OMCPage.select_PhotoProof("C:\\Users\\frank.marchion\\Documents\\Documents\\Test Receipts\\clearearth-lights.jpg");
        String uploadSuccessful1 = driver.findElement(By.cssSelector(".cpr_successfulUpload")).getText();
        assertTrue(uploadSuccessful1.contains("Your file clearearth-lights.jpg has been uploaded successfully."));

        //Click the 'Submit Request' button
        OMCPage.click_SubmitRequest();

        //Assert track has a status of 'Processing Request' status
        if(driver.findElement(By.cssSelector("html#view-price-rewind > body > div#cpr_content > div#cpr_trackDetails > div.cpr_grid > div.cpr_md-9 > div.cpr_indicator > div.cpr_clearfix > div#track_label > div.cpr_trackBtn.cpr_md-only")).isDisplayed())
        {
            System.out.println("Status is Processing Request");
        }
        else{
            System.out.println("Status is Wrong");
        }


    }
}
