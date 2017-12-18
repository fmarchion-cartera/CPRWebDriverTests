package com.citipricerewind.tests;

import com.citipricerewind.data.CPRData;
import com.citipricerewind.pages.CitiPriceRewindMainPageSearch;
import com.citipricerewind.pages.CitiPriceRewindSearchResults;
import com.citipricerewind.pages.CitipricerewindMainPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by frank.marchion on 6/2/2017.
 */
public class Logout_Test {

    public WebDriver driver;
    CitipricerewindMainPage CPRMainPage;
    CitiPriceRewindMainPageSearch CPRMainPageSearch;
    CitiPriceRewindSearchResults CPRSearchResults;


    @BeforeClass(alwaysRun = true)
    public void setup() {
        this.driver = new FirefoxDriver();
        //WebDriverWait driverWait = new WebDriverWait(driver, 60);

        CPRMainPage = PageFactory.initElements(driver, CitipricerewindMainPage.class);
        //CPRMainPage = new CitipricerewindMainPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        CPRMainPageSearch = PageFactory.initElements(driver, CitiPriceRewindMainPageSearch.class);
        CPRSearchResults = PageFactory.initElements(driver, CitiPriceRewindSearchResults.class);


    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        driver.close();
    }

    @Test(groups = {"p1", "pageLoads", "moreGroups"}, dataProvider = "pages", dataProviderClass = CPRData.class)
    public void payload(String url, String title) {
        driver.get(CPRMainPage.PAGE_URL);
        WebElement payload = driver.findElement(By.cssSelector("input[value='Single Card Payload']"));
        payload.click();
        assertEquals(driver.getTitle(), CPRMainPage.PAGE_TITLE);

        //Click the Sign Off button
        CPRMainPage.clicklogout_button();

        //Verify Citi logo in header
        if (driver.findElement(By.cssSelector(".cpr_logInOutLink.cpr_icon_lock")).isDisplayed()){
            System.out.println("User is logged out");
        }else{
            System.out.println("User is not logged out");
        }


    }
}
