package com.citipricerewind.tests;

import com.citipricerewind.data.CPRData;
import com.citipricerewind.pages.*;
import com.sun.org.apache.xerces.internal.impl.xs.identity.Field;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
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
public class Homepage_Test {

    public WebDriver driver;
    CitipricerewindMainPage CPRMainPage;
    //CitiPriceRewindMainPageSearch CPRMainPageSearch;
    //CitiPriceRewindSearchResults CPRSearchResults;
    CitiPriceRewindMyPriceRewinds CPRMyPriceRewinds;
    FAQPage FAQPage;
    HelpPage HelpPage;
    PrivacyPage PrivacyPage;


    @BeforeClass(alwaysRun = true)
    public void setup() {
        this.driver = new FirefoxDriver();
        CPRMainPage = PageFactory.initElements(driver, CitipricerewindMainPage.class);
        //CPRMainPage = new CitipricerewindMainPage(driver);
        //CPRMainPageSearch = PageFactory.initElements(driver, CitiPriceRewindMainPageSearch.class);
        //CPRSearchResults = PageFactory.initElements(driver, CitiPriceRewindSearchResults.class);
        CPRMyPriceRewinds = PageFactory.initElements(driver, CitiPriceRewindMyPriceRewinds.class);
        FAQPage = PageFactory.initElements(driver, FAQPage.class);
        HelpPage = PageFactory.initElements(driver, HelpPage.class);
        PrivacyPage = PageFactory.initElements(driver, PrivacyPage.class);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        driver.close();
    }


    @Test(groups = {"p1"})
    public void testHomepage(/*String status, String perPage String status_UploadReceipt*/) {

        WebDriverWait driverWait = new WebDriverWait(driver, 60);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.manage().deleteAllCookies();

        driver.get(CPRMainPage.PAGE_URL);

        WebElement payload = driver.findElement(By.cssSelector("input[value='Single Card Payload']"));
        payload.click();
        assertEquals(driver.getTitle(), CPRMainPage.PAGE_TITLE);



        //Verify Citi logo in header
         if (driver.findElement(By.cssSelector(".cpr_logoLink")).isDisplayed()){
            System.out.println("Citi Logo is Visible");
        }else{
            System.out.println("Citi Logo is Invisible");
        }

        //Verify Sign Off button is present in the header
        if (driver.findElement(By.cssSelector(".cpr_logInOutLink.cpr_icon_lock")).isDisplayed()){
            System.out.println("Sign Off button is Visible");
        }else{
            System.out.println("Sign Off button is Not Visible");
        }

        //Verify 'Welcome back to Citi Price Rewind' text is visible
        if(driver.findElement(By.cssSelector("html#home > body > div#cpr_content > div.cpr_hero_container > div.cpr_hero > div.cpr_grid > div.cpr_copy.cpr_md-7.cpr_sm-10 > h1#cpr_headerText")).isDisplayed()){
            System.out.println("Welcome back to Citi Price Rewind text is visible");
        }else{
            System.out.println("Welcome back to Citi Price Rewind text is NOT visible");
        }

        //Verify 'Enjoying your purchases' text is visible
        if(driver.findElement(By.cssSelector("html#home > body > div#cpr_content > div.cpr_hero_container > div.cpr_hero > div.cpr_grid > div.cpr_copy.cpr_md-7.cpr_sm-10 > p.cpr_xs-hide.cpr_heroDescription.cpr_sm-10")).isDisplayed()){
            System.out.println("Enjoying your purchases text is visible");
        }else{
            System.out.println("Enjoying your purchases text is NOT visible");
        }

        //Click 'Search Tips' link
        CPRMainPage.click_SearchTips();
        assertEquals(driver.getCurrentUrl(), CPRMainPage.SEARCH_FAQ);

        driver.navigate().back();

        //Click 'what's covered' link
        CPRMainPage.click_WhatsCovered();
        assertEquals(driver.getCurrentUrl(), CPRMainPage.WHATS_COVERED);

        driver.navigate().back();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Verify 'Your recent Price Rewinds' text is visible
        if(driver.getPageSource().contains("Your recent Price Rewinds")){
            System.out.println("Your recent Price Rewinds is present");
        }else{
            System.out.println("Your recent Price Rewinds is not present");
        }

        //Click on first tile present
        CPRMainPage.click_firstTile();
        driver.navigate().back();

        //Click on second tile present
        CPRMainPage.click_secondTile();
        driver.navigate().back();

        //Click on third tile present
        CPRMainPage.click_thirdTile();
        driver.navigate().back();

        //Click the 'View All Price Rewinds' button
        CPRMainPage.click_ViewAllPriceRewindsButton();
        assertEquals(driver.getCurrentUrl(), CPRMyPriceRewinds.MAIN_PAGE_URL);

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.navigate().back();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Verify 'Leave it to us' text is visible
        if(driver.findElement(By.cssSelector("html#home > body > div#cpr_content > div.cpr_messaging > div.cpr_grid > div.cpr_slick.cpr_focusable > div.cpr_messageTile_1 > h3")).isDisplayed()){
            System.out.println("Leave it to us text is visiblet");
        }else{
            System.out.println("Leave it to us text is NOT visible");
        }

        //Verify 'Save on purchases of all sizes' text is visible
        if(driver.findElement(By.cssSelector("html#home > body > div#cpr_content > div.cpr_messaging > div.cpr_grid > div.cpr_slick.cpr_focusable > div.cpr_messageTile_2 > h3")).isDisplayed()){
            System.out.println("Save on purchases of all sizes text is visible");
        }else{
            System.out.println("Save on purchases of all sizes text is NOT visible");
        }

        //Verify 'Save up to $2,500 per year' text is visible
        if(driver.findElement(By.cssSelector("html#home > body > div#cpr_content > div.cpr_messaging > div.cpr_grid > div.cpr_slick.cpr_focusable > div.cpr_messageTile_3 > h3")).isDisplayed()){
            System.out.println("Save up to $2,500 per year text is visible");
        }else{
            System.out.println("Save up to $2,500 per year text is NOT visible");
        }

        //Verify 'We do an extensive search' text is visible
        if(driver.findElement(By.cssSelector("html#home > body > div#cpr_content > div.cpr_messaging > div.cpr_grid > div.cpr_slick.cpr_focusable > div.cpr_messageTile_4 > h3")).isDisplayed()){
            System.out.println("We do an extensive search text is visible");
        }else{
            System.out.println("We do an extensive search text is NOT visible");
        }

        //Verify '$30.04' average payment issued text is visible
        if(driver.findElement(By.cssSelector("html#home > body > div#cpr_content > div.cpr_stats > div.cpr_grid > div.cpr_parentStatTiles > div.cpr_statTile_1.cpr_sm-4 > div.cpr_stat")).isDisplayed()){
            System.out.println("$30.04 average payment issued text is visible");
        }else{
            System.out.println("$30.04 average payment issued text is NOT visible");
        }

        //Verify '$12,886,756' total paid out amount text is visible
        if(driver.findElement(By.cssSelector("html#home > body > div#cpr_content > div.cpr_stats > div.cpr_grid > div.cpr_parentStatTiles > div.cpr_statTile_2.cpr_sm-4 > div.cpr_stat")).isDisplayed()){
            System.out.println("$12,886,756 total paid out amount text is visible");
        }else{
            System.out.println("$12,886,756 total paid out amount text is NOT visible");
        }

        //Verify '429,056' number of payments issued text is visible
        if(driver.findElement(By.cssSelector("html#home > body > div#cpr_content > div.cpr_stats > div.cpr_grid > div.cpr_parentStatTiles > div.cpr_statTile_3.cpr_sm-4 > div.cpr_stat.cpr_noDollar")).isDisplayed()){
            System.out.println("429,056 number of payments issued text is visible");
        }else{
            System.out.println("429,056 number of payments issued text is NOT visible");
        }

        //Verify 'Here's how Citi Price Rewind works' text is visible
        if(driver.findElement(By.cssSelector("html#home > body > div#cpr_content > div.cpr_overview > div.cpr_grid > h2")).isDisplayed()){
            System.out.println("Here's how Citi Price Rewind works text is visible");
        }else{
            System.out.println("Here's how Citi Price Rewind works text is NOT visible");
        }

        //Verify 'Step 1' text is visible
        if(driver.findElement(By.cssSelector("html#home > body > div#cpr_content > div.cpr_overview > div.cpr_grid > div.cpr_slick.cpr_focusable > div.cpr_step:nth-of-type(1)")).isDisplayed()){
            System.out.println("Step 1 text is visible");
        }else{
            System.out.println("Step 1 text is NOT visible");
        }

        //Verify 'Step 2' text is visible
        if(driver.findElement(By.cssSelector("html#home > body > div#cpr_content > div.cpr_overview > div.cpr_grid > div.cpr_slick.cpr_focusable > div.cpr_step:nth-of-type(2)")).isDisplayed()){
            System.out.println("Step 2 text is visible");
        }else{
            System.out.println("Step 2 text is NOT visible");
        }

        //Verify 'Step 3' text is visible
        if(driver.findElement(By.cssSelector("html#home > body > div#cpr_content > div.cpr_overview > div.cpr_grid > div.cpr_slick.cpr_focusable > div.cpr_step:nth-of-type(3)")).isDisplayed()){
            System.out.println("Step 3 text is visible");
        }else{
            System.out.println("Step 3 text is NOT visible");
        }

        //Click the 'Learn More' button
        CPRMainPage.click_LearnMoreButton();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.navigate().back();

        //Verify footer text is visible
        if(driver.findElement(By.cssSelector("html#home > body > div#cpr_footer > div.cpr_grid")).isDisplayed()){
            System.out.println("Footer text is visible");
        }else{
            System.out.println("Footer text is NOT visible");
        }

        //Click the 'GUIDE TO CITI PRICE REWINDS BENEFIT' link
        CPRMainPage.click_BenefitGuide();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), CPRMainPage.GUIDE_TO_CITi_PRICE_REWIND_URL);

        driver.navigate().back();

        //Click the 'SITE TERMS & CONDITIONS' link
        CPRMainPage.click_TermsConditions();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), CPRMainPage.SITE_TERMS_CONDITIONS_URL);

        driver.navigate().back();

        //Click the 'FAQS' link
        CPRMainPage.click_FAQS();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.FAQ_PAGE_URL);

        driver.navigate().back();

        //Click the 'Help' link
        CPRMainPage.click_HELP();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), HelpPage.HELP_PAGE_URL);

        driver.navigate().back();

        //Click the 'Privacy' link
        CPRMainPage.click_Privacy();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), PrivacyPage.PRIVACY_PAGE_URL);

        driver.navigate().back();

    }


}