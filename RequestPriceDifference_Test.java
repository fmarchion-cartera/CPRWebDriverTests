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
public class RequestPriceDifference_Test {

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
    public void teardown(){
        driver.close();
    }

    @Test(groups ={"p1"})
    public void testRequestPriceDifference()

    {
        WebDriverWait driverWait = new WebDriverWait(driver, 60);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);


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

        //Select a tile
        CPRMyPriceRewinds.clickRequestPriceDifference();

        //Click Request Price Difference button
        CPRMyPriceRewinds.clickRequestButton();

        /*String expText = "Your benefit request is being processed!";

        String actText = driver.findElement(By.cssSelector(".cpr_trackDetails_bolder_text")).getText();
        if(actText.contains(expText)){
            System.out.println("1) Expected text '"+expText+"' present in the web page.");
        }else{
            System.out.println("1) Expected text '"+expText+"' is not present in the web page.");
        }*/

        //assertTrue(driver.findElement(By.cssSelector(".cpr_trackDetails_bolder_text")).getText().contains("Your benefit request is being processed"));

        //String Your benefit request is being processed = driver.findElement(By.tagName("Your benefit request is being processed")).getText();
        //Assert.assertTrue("Text not found!", bodyText.contains(text));

        //WebElement processing_button = driver.findElement(By.cssSelector(".cpr_trackBtn.cpr_md-only"));
        //driverWait.until(ExpectedConditions.visibilityOf(processing_button));
        //assertTrue(processing_button.getText().matches("Processing Request"));

        //assertTrue(driver.findElement(By.cssSelector(".cpr_trackBtn.cpr_md-only")).getText().matches("Processing Request"));

        //driver.findElement(By.cssSelector(".cpr_trackBtn.cpr_md-only"));
        //if(driver)
        //System.out.println("Request complete");

        /*WebElement processing_button = driver.findElement(By.cssSelector(".cpr_trackBtn.cpr_md-only"));
        driverWait.until(ExpectedConditions.visibilityOf(processing_button));
        String strng = processing_button.getText();
        System.out.println(strng);
        Assert.assertEquals("Processing Request", strng);*/

        //assertTrue(processing_button).getText().contains("Processing Request"));


        //assertTrue(driver.findElement(By.cssSelector(".cpr_trackBtn.cpr_md-only")).getText().contains("Processing Request"));


    }
}

