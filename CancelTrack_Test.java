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
public class CancelTrack_Test {

    public WebDriver driver;
    CitipricerewindMainPage CPRMainPage;
    //CitiPriceRewindMainPageSearch CPRMainPageSearch;
    //CitiPriceRewindSearchResults CPRSearchResults;
    CitiPriceRewindMyPriceRewinds CPRMyPriceRewinds;


    @BeforeClass(alwaysRun = true)
    public void setup(){
        this.driver = new FirefoxDriver();
        CPRMainPage = PageFactory.initElements(driver, CitipricerewindMainPage.class);
        //CPRMainPage = new CitipricerewindMainPage(driver);
        //CPRMainPageSearch = PageFactory.initElements(driver, CitiPriceRewindMainPageSearch.class);
        //CPRSearchResults = PageFactory.initElements(driver, CitiPriceRewindSearchResults.class);
        CPRMyPriceRewinds = PageFactory.initElements(driver, CitiPriceRewindMyPriceRewinds.class);
    }

    @AfterClass(alwaysRun = true)
    public void teardown(){
        driver.close();
    }


    @Test(groups ={"p1"})
    public void testCancelTrack(/*String status, String perPage String status_UploadReceipt*/){

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
        assertEquals(driver.getTitle(), CPRMyPriceRewinds.PAGE_TITLE);

        //Select the 'Still Tracking' status box
        CPRMyPriceRewinds.setStatus_StillTracking();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), CitiPriceRewindMyPriceRewinds.STILL_TRACKING_URL);

        //Select the first track in the list
        CPRMyPriceRewinds.setSelect_Track();

        //Select cancel rewind link
        CPRMyPriceRewinds.clickCancel_Rewind();

        //Select cancel rewind Yes button
        CPRMyPriceRewinds.clickCancel_Yes();

        driver.navigate().back();

        WebElement page_not_found = driver.findElement(By.xpath("/html[@id='page-not-found']/body/div[@id='cpr_content']/div[@class='cpr_serverError']/div[@class='cpr_grid']/h1"));
        driverWait.until(ExpectedConditions.visibilityOf(page_not_found));

        if(driver.getPageSource().contains("Page Not Found"))
        {
            System.out.println("Text present");
        }
        else{
            System.out.println("Text not present");
        }




    }
}

