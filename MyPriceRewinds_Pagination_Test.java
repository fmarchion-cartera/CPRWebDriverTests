package com.citipricerewind.tests;

import com.citipricerewind.pages.CitiPriceRewindMyPriceRewinds;
import com.citipricerewind.pages.CitipricerewindMainPage;
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

/**
 * Created by frank.marchion on 6/22/2017.
 */
public class MyPriceRewinds_Pagination_Test {

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
    public void testMyPRPagination() {

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

        //Click 'Page 2' in the pagination list
        CPRMyPriceRewinds.setPagination_Page_2();
        assertEquals(driver.getCurrentUrl(), CitiPriceRewindMyPriceRewinds.PAGE_2_PAGINATION);

        //Click the next page button to move to page 3
        CPRMyPriceRewinds.setPagination_Next_Page();
        assertEquals(driver.getCurrentUrl(), CitiPriceRewindMyPriceRewinds.NEXT_PAGE);

        //Click the last page in the pagination list
        CPRMyPriceRewinds.setPagination_Last_Page();
        //not sure how to do an assert here since URL will be different for each test.
        //assertEquals(driver.getCurrentUrl(), CitiPriceRewindMyPriceRewinds.LAST_PAGE);

        //Click the second to last page in the pagination list
        CPRMyPriceRewinds.setPagination_Second_To_Last_Page();
        //assertEquals(driver.getCurrentUrl(), CitiPriceRewindMyPriceRewinds.SECOND_TO_LAST_PAGE);

        //Click the previous page button
        CPRMyPriceRewinds.setPagination_Previous_Page();
        //assertEquals(driver.getCurrentUrl(), CitiPriceRewindMyPriceRewinds.PREVIOUS_PAGE);

        //Click page 1 in the pagination list
        CPRMyPriceRewinds.setFirst_Page();
        assertEquals(driver.getCurrentUrl(), CitiPriceRewindMyPriceRewinds.FIRST_PAGE);

    }

}
