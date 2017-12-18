package com.citipricerewind.tests;

import com.citipricerewind.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by frank.marchion on 11/9/2017.
 */
public class Receipts_Test {

    public WebDriver driver;
    CitipricerewindMainPage CPRMainPage;
    CitiPriceRewindMyPriceRewinds CPRMyPriceRewinds;
    com.citipricerewind.pages.StartPriceRewind StartPriceRewind;
    HowItWorksPage HIWPage;
    StartBenefitRequestPage OMCPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        this.driver = new FirefoxDriver();
        CPRMainPage = PageFactory.initElements(driver, CitipricerewindMainPage.class);
        CPRMyPriceRewinds = PageFactory.initElements(driver, CitiPriceRewindMyPriceRewinds.class);
        StartPriceRewind = PageFactory.initElements(driver, StartPriceRewind.class);
        HIWPage = PageFactory.initElements(driver, HowItWorksPage.class);
        OMCPage = PageFactory.initElements(driver, StartBenefitRequestPage.class);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        driver.close();
    }

    @Test(groups = {"p1"})
    public void uploadPngTifJpgReceipts()

    {
        WebDriverWait driverWait = new WebDriverWait(driver, 60);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.manage().deleteAllCookies();

        driver.get(CPRMainPage.PAGE_URL);

        WebElement payload = driver.findElement(By.cssSelector("input[value='Single Card Payload']"));
        payload.click();
        assertEquals(driver.getTitle(), CPRMainPage.PAGE_TITLE);

        //Enter text into the search field
        CPRMainPage.setText_ProductSearch("gopro hero 5 black");
        assertEquals(driver.getTitle(), StartPriceRewind.HOMEPAGE_TITLE);

        //Click the search icon
        StartPriceRewind.click_Search_Icon();
        assertEquals(driver.getCurrentUrl(), StartPriceRewind.SEARCH_RESULTS_URL);


        //Click the Track This Item button
        StartPriceRewind.click_Track_This_Item_button();
        WebElement startButton = driver.findElement(By.cssSelector("#cpr_SPR_submit"));
        driverWait.until(ExpectedConditions.visibilityOf(startButton));
        assertEquals(driver.getTitle(), StartPriceRewind.START_PRICE_REWIND_TITLE);

        //Enter a 'Purchase Price'
        StartPriceRewind.setText_PurchasePrice("499.99");
        //assertTrue(driver.findElement(By.cssSelector("#cpr_SPR_price")).getText().contains("0.00"));

        //Click datepicker icon
        StartPriceRewind.click_Datepicker_Icon();

        //Click first date in the datepicker
        StartPriceRewind.select_First_Date();

        //Enter a store name
        StartPriceRewind.enter_Store_Name("Best Buy");

        //Select a payment method
        StartPriceRewind.select_Payment_Type();

        //Click Receipt Upload container
        StartPriceRewind.select_Receipt_Upload("C:\\Users\\frank.marchion\\Documents\\Documents\\Test Receipts\\CARTERA TEST RECEIPT PNG.png");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String uploadSuccessful = driver.findElement(By.cssSelector(".cpr_successfulUpload")).getText();
        assertTrue(uploadSuccessful.contains("Your file CARTERA TEST RECEIPT PNG.png has been uploaded successfully."));

        //Click Receipt Upload container
        StartPriceRewind.select_Receipt_Upload("C:\\Users\\frank.marchion\\Documents\\Documents\\Test Receipts\\url.jpg");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String uploadSuccessful2 = driver.findElement(By.cssSelector(".cpr_successfulUpload")).getText();
        //assertTrue(uploadSuccessful.contains("Your file url.jpg has been uploaded successfully."));

        //Click Receipt Upload container
        StartPriceRewind.select_Receipt_Upload("C:\\Users\\frank.marchion\\Documents\\Documents\\Test Receipts\\yellowstone_tm5_2008259_lrg.tif");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String uploadSuccessful3 = driver.findElement(By.cssSelector(".cpr_successfulUpload")).getText();
        //assertTrue(uploadSuccessful.contains("Your file yellowstone_tm5_2008259_lrg.tif has been uploaded successfully."));

        //Click the 'Start a Price Rewind' button
        StartPriceRewind.click_Start_Price_Rewind();
        String trackCreated = driver.findElement(By.cssSelector(".cpr_modalTitle.cpr_focusable")).getText();
        assertTrue(trackCreated.contains("All Set"));
    }

    @Test(groups = {"p1"})
    public void uploadPdfBmpGifReceipts()

    {
        WebDriverWait driverWait = new WebDriverWait(driver, 60);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.manage().deleteAllCookies();

        driver.get(CPRMainPage.PAGE_URL);

        WebElement payload = driver.findElement(By.cssSelector("input[value='Single Card Payload']"));
        payload.click();
        assertEquals(driver.getTitle(), CPRMainPage.PAGE_TITLE);

        //Enter text into the search field
        CPRMainPage.setText_ProductSearch("gopro hero 5 black");
        assertEquals(driver.getTitle(), StartPriceRewind.HOMEPAGE_TITLE);

        //Click the search icon
        StartPriceRewind.click_Search_Icon();
        assertEquals(driver.getCurrentUrl(), StartPriceRewind.SEARCH_RESULTS_URL);


        //Click the Track This Item button
        StartPriceRewind.click_Track_This_Item_button();
        WebElement startButton = driver.findElement(By.cssSelector("#cpr_SPR_submit"));
        driverWait.until(ExpectedConditions.visibilityOf(startButton));
        assertEquals(driver.getTitle(), StartPriceRewind.START_PRICE_REWIND_TITLE);

        //Enter a 'Purchase Price'
        StartPriceRewind.setText_PurchasePrice("499.99");
        //assertTrue(driver.findElement(By.cssSelector("#cpr_SPR_price")).getText().contains("0.00"));

        //Click datepicker icon
        StartPriceRewind.click_Datepicker_Icon();

        //Click first date in the datepicker
        StartPriceRewind.select_First_Date();

        //Enter a store name
        StartPriceRewind.enter_Store_Name("Best Buy");

        //Select a payment method
        StartPriceRewind.select_Payment_Type();

        //Click Receipt Upload container
        StartPriceRewind.select_Receipt_Upload("C:\\Users\\frank.marchion\\Documents\\Documents\\Test Receipts\\PDF Receipt.pdf");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String uploadSuccessful = driver.findElement(By.cssSelector(".cpr_successfulUpload")).getText();
        assertTrue(uploadSuccessful.contains("Your file PDF Receipt.pdf has been uploaded successfully."));

        //Click Receipt Upload container
        StartPriceRewind.select_Receipt_Upload("C:\\Users\\frank.marchion\\Documents\\Documents\\Test Receipts\\BMP Test 3mb.BMP");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String uploadSuccessful2 = driver.findElement(By.cssSelector(".cpr_successfulUpload")).getText();
        //assertTrue(uploadSuccessful.contains("Your file url.jpg has been uploaded successfully."));

        //Click Receipt Upload container
        StartPriceRewind.select_Receipt_Upload("C:\\Users\\frank.marchion\\Documents\\Documents\\Test Receipts\\GIF_Test_3mb.gif");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String uploadSuccessful3 = driver.findElement(By.cssSelector(".cpr_successfulUpload")).getText();
        //assertTrue(uploadSuccessful.contains("Your file yellowstone_tm5_2008259_lrg.tif has been uploaded successfully."));

        //Click the 'Start a Price Rewind' button
        StartPriceRewind.click_Start_Price_Rewind();
        String trackCreated = driver.findElement(By.cssSelector(".cpr_modalTitle.cpr_focusable")).getText();
        assertTrue(trackCreated.contains("All Set"));
    }

    @Test(groups = {"p1"})
    public void uploadPhotoProofs()

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
        OMCPage.setText_LowPriceFound("399.99");

        //Select datepicker icon
        OMCPage.click_datepicker();

        //Select 'Date of Low Price'
        StartPriceRewind.select_First_Date();

        //Add store name where lower price was found
        OMCPage.setText_LowPriceFoundStore("Some store");

        //Upload photo proof
        OMCPage.select_PhotoProof("C:\\Users\\frank.marchion\\Documents\\Documents\\Test Receipts\\clearearth-lights.jpg");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String uploadSuccessful1 = driver.findElement(By.cssSelector(".cpr_successfulUpload")).getText();
        assertTrue(uploadSuccessful1.contains("Your file clearearth-lights.jpg has been uploaded successfully."));

        //Upload photo proof
        OMCPage.select_PhotoProof("C:\\Users\\frank.marchion\\Documents\\Documents\\Test Receipts\\BMP Test 3mb.BMP");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String uploadSuccessful2 = driver.findElement(By.cssSelector(".cpr_successfulUpload")).getText();
        //assertTrue(uploadSuccessful1.contains("Your file clearearth-lights.jpg has been uploaded successfully."));

        //Upload photo proof
        OMCPage.select_PhotoProof("C:\\Users\\frank.marchion\\Documents\\Documents\\Test Receipts\\PNG Test 4mb.png");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String uploadSuccessful3 = driver.findElement(By.cssSelector(".cpr_successfulUpload")).getText();
        //assertTrue(uploadSuccessful1.contains("Your file clearearth-lights.jpg has been uploaded successfully."));

        //Click the 'Submit Request' button
        OMCPage.click_SubmitRequest();

    }

    @Test(groups = {"p1"})
    public void deleteReceipts()

    {
        WebDriverWait driverWait = new WebDriverWait(driver, 60);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.manage().deleteAllCookies();

        driver.get(CPRMainPage.PAGE_URL);

        WebElement payload = driver.findElement(By.cssSelector("input[value='Single Card Payload']"));
        payload.click();
        assertEquals(driver.getTitle(), CPRMainPage.PAGE_TITLE);

        //Enter text into the search field
        CPRMainPage.setText_ProductSearch("gopro hero 5 black");
        assertEquals(driver.getTitle(), StartPriceRewind.HOMEPAGE_TITLE);

        //Click the search icon
        StartPriceRewind.click_Search_Icon();
        assertEquals(driver.getCurrentUrl(), StartPriceRewind.SEARCH_RESULTS_URL);


        //Click the Track This Item button
        StartPriceRewind.click_Track_This_Item_button();
        WebElement startButton = driver.findElement(By.cssSelector("#cpr_SPR_submit"));
        driverWait.until(ExpectedConditions.visibilityOf(startButton));
        assertEquals(driver.getTitle(), StartPriceRewind.START_PRICE_REWIND_TITLE);

        //Enter a 'Purchase Price'
        StartPriceRewind.setText_PurchasePrice("499.99");
        //assertTrue(driver.findElement(By.cssSelector("#cpr_SPR_price")).getText().contains("0.00"));

        //Click datepicker icon
        StartPriceRewind.click_Datepicker_Icon();

        //Click first date in the datepicker
        StartPriceRewind.select_First_Date();

        //Enter a store name
        StartPriceRewind.enter_Store_Name("Best Buy");

        //Select a payment method
        StartPriceRewind.select_Payment_Type();

        //Click Receipt Upload container
        StartPriceRewind.select_Receipt_Upload("C:\\Users\\frank.marchion\\Documents\\Documents\\Test Receipts\\CARTERA TEST RECEIPT PNG.png");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String uploadSuccessful = driver.findElement(By.cssSelector(".cpr_successfulUpload")).getText();
        assertTrue(uploadSuccessful.contains("Your file CARTERA TEST RECEIPT PNG.png has been uploaded successfully."));

        //Click Receipt Upload container
        StartPriceRewind.select_Receipt_Upload("C:\\Users\\frank.marchion\\Documents\\Documents\\Test Receipts\\url.jpg");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String uploadSuccessful2 = driver.findElement(By.cssSelector(".cpr_successfulUpload")).getText();
        //assertTrue(uploadSuccessful.contains("Your file url.jpg has been uploaded successfully."));

        //Click Receipt Upload container
        StartPriceRewind.select_Receipt_Upload("C:\\Users\\frank.marchion\\Documents\\Documents\\Test Receipts\\yellowstone_tm5_2008259_lrg.tif");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String uploadSuccessful3 = driver.findElement(By.cssSelector(".cpr_successfulUpload")).getText();
        //assertTrue(uploadSuccessful.contains("Your file yellowstone_tm5_2008259_lrg.tif has been uploaded successfully."));

        //Delete receipt
        StartPriceRewind.click_Delete_Link();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Delete receipt
        StartPriceRewind.click_Delete_Link();

        //Click the 'Start a Price Rewind' button
        StartPriceRewind.click_Start_Price_Rewind();
        String trackCreated = driver.findElement(By.cssSelector(".cpr_modalTitle.cpr_focusable")).getText();
        assertTrue(trackCreated.contains("All Set"));


    }
}