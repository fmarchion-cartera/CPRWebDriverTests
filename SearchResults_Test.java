package com.citipricerewind.tests;

import com.citipricerewind.pages.CitiPriceRewindMyPriceRewinds;
import com.citipricerewind.pages.CitiPriceRewindSearchResults;
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
 * Created by frank.marchion on 6/26/2017.
 */
public class SearchResults_Test {

    public WebDriver driver;
    CitipricerewindMainPage CPRMainPage;
    CitiPriceRewindMyPriceRewinds CPRMyPriceRewinds;
    StartPriceRewind StartPriceRewind;
    CitiPriceRewindSearchResults CPRSearchResults;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        this.driver = new FirefoxDriver();
        CPRMainPage = PageFactory.initElements(driver, CitipricerewindMainPage.class);
        CPRMyPriceRewinds = PageFactory.initElements(driver, CitiPriceRewindMyPriceRewinds.class);
        StartPriceRewind = PageFactory.initElements(driver, StartPriceRewind.class);
        CPRSearchResults = PageFactory.initElements(driver, CitiPriceRewindSearchResults.class);
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

        //Click the help toggle button
        CPRSearchResults.click_Help_Toggle();
        String toggleText = driver.findElement(By.cssSelector(".cpr_searchHelpText.cpr_open>p")).getText();
        assertTrue(toggleText.contains("If you don't see your exact item, you can start a new search or narrow it by category, merchant or price. Still don't see it? Get search tips or learn more about what's covered."));

        //Click the 'search tips' link
        CPRSearchResults.click_Search_Tips();
        assertEquals(driver.getCurrentUrl(), CPRSearchResults.SEARCH_TIPS_URL);

        driver.navigate().back();

        //Click the help toggle button
        CPRSearchResults.click_Help_Toggle();
        String toggleText2 = driver.findElement(By.cssSelector(".cpr_searchHelpText.cpr_open>p")).getText();
        assertTrue(toggleText.contains("If you don't see your exact item, you can start a new search or narrow it by category, merchant or price. Still don't see it? Get search tips or learn more about what's covered."));

        //Click the 'what's covered' link
        CPRSearchResults.click_Whats_Covered();
        assertEquals(driver.getCurrentUrl(), CPRSearchResults.WHATS_COVERED_URL);

        driver.navigate().back();
        //}

        //@Test(groups ={"p2"})
        // public void pagination(){

        //Click 'Page 2' in the pagination list
        CPRSearchResults.click_Page_2();
        assertEquals(driver.getCurrentUrl(), CPRSearchResults.PAGE_2);

        //}


    }

}
