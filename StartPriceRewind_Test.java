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
public class StartPriceRewind_Test {

    public WebDriver driver;
    CitipricerewindMainPage CPRMainPage;
    CitiPriceRewindMyPriceRewinds CPRMyPriceRewinds;
    StartPriceRewind StartPriceRewind;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        this.driver = new FirefoxDriver();
        CPRMainPage = PageFactory.initElements(driver, CitipricerewindMainPage.class);
        CPRMyPriceRewinds = PageFactory.initElements(driver, CitiPriceRewindMyPriceRewinds.class);
        StartPriceRewind = PageFactory.initElements(driver, StartPriceRewind.class);
    }

    @AfterClass(alwaysRun = true)
    public void teardown(){
        driver.close();
    }

    @Test(groups ={"p1"})
    public void testStartPriceRewind()

    {
        WebDriverWait driverWait = new WebDriverWait(driver, 60);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.manage().deleteAllCookies();

        driver.get(CPRMainPage.PAGE_URL);

        WebElement payload = driver.findElement(By.cssSelector("input[value='Single Card Payload']"));
        payload.click();
        assertEquals(driver.getTitle(), CPRMainPage.PAGE_TITLE);

        //WebElement link_myPR = driver.findElement(By.linkText("My Price Rewinds"));
        //driverWait.until(ExpectedConditions.visibilityOf(link_myPR));
        //link_myPR.click();
        //assertEquals(driver.getTitle(), CPRMyPriceRewinds.PAGE_TITLE);

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
        String uploadSuccessful = driver.findElement(By.cssSelector(".cpr_successfulUpload")).getText();
        assertTrue(uploadSuccessful.contains("Your file CARTERA TEST RECEIPT PNG.png has been uploaded successfully."));

        //Click the 'Start a Price Rewind' button
        StartPriceRewind.click_Start_Price_Rewind();
        String trackCreated = driver.findElement(By.cssSelector(".cpr_modalTitle.cpr_focusable")).getText();
        assertTrue(trackCreated.contains("All Set"));


    }
}
