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
public class FAQPage_Test {

    public WebDriver driver;
    CitipricerewindMainPage CPRMainPage;
    //CitiPriceRewindMainPageSearch CPRMainPageSearch;
    //CitiPriceRewindSearchResults CPRSearchResults;
    CitiPriceRewindMyPriceRewinds CPRMyPriceRewinds;
    com.citipricerewind.pages.FAQPage FAQPage;



    @BeforeClass(alwaysRun = true)
    public void setup() {
        this.driver = new FirefoxDriver();
        CPRMainPage = PageFactory.initElements(driver, CitipricerewindMainPage.class);
        //CPRMainPage = new CitipricerewindMainPage(driver);
        //CPRMainPageSearch = PageFactory.initElements(driver, CitiPriceRewindMainPageSearch.class);
        //CPRSearchResults = PageFactory.initElements(driver, CitiPriceRewindSearchResults.class);
        CPRMyPriceRewinds = PageFactory.initElements(driver, CitiPriceRewindMyPriceRewinds.class);
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
    public void testFaqGeneralPage(/*String status, String perPage String status_UploadReceipt*/) {

        //Click the 'FAQs' link
        CPRMainPage.click_FAQS();
        assertEquals(driver.getCurrentUrl(), FAQPage.FAQ_PAGE_URL);


        //Verify 'Welcome back to Citi Price Rewind' text is visible
        if(driver.findElement(By.cssSelector("html#faq > body > div#cpr_content > div.cpr_grid.cpr_staticPage.cpr_faq > div.cpr_underlinedBlock > h1")).isDisplayed()){
            System.out.println("Citi® Price Rewind FAQ is visible");
        }else{
            System.out.println("Citi® Price Rewind FAQ is NOT visible");
        }

        //Click the 'What is Citi Price Rewind?' link
        FAQPage.click_WhatIsCitiPriceRewind();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.GENERAL1_URL);

        //Go back to top of page
        FAQPage.click_faq1_BackToTop();

        //Click the 'Do I have to use my Citi card to be eligible to use Citi Price Rewind?' link
        FAQPage.click_general2();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.GENERAL2_URL);

        //Go back to top of page
        FAQPage.click_faq2_BackToTop();

        //Click the 'Is there any fee for using Citi Price Rewind?' link
        FAQPage.click_general3();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.GENERAL3_URL);

        //Go back to top of page
        FAQPage.click_faq3_BackToTop();

        //Click the 'What types of purchases are eligible for a Price Rewind?' link
        FAQPage.click_general4();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.GENERAL4_URL);

        //Go back to top of page
        FAQPage.click_faq4_BackToTop();

        //Click the 'Are purchases made using a gift card or store credit eligible for a Price Rewind?' link
        FAQPage.click_general5();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.GENERAL5_URL);

        //Go back to top of page
        FAQPage.click_faq5_BackToTop();

        //Click the 'Are purchases made from online merchants and in-store merchants eligible for a Price Rewind?' link
        FAQPage.click_general6();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.GENERAL6_URL);

        //Go back to top of page
        FAQPage.click_faq6_BackToTop();

        //Click the 'Why do I have to search for my item, shouldn't Citi have my purchase information already?' link
        FAQPage.click_general6b();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.GENERAL6b_URL);

        //Go back to top of page
        FAQPage.click_faq6b_BackToTop();
    }

    @Test(groups = {"p1"})
    public void testFaqRegistrationPage(/*String status, String perPage String status_UploadReceipt*/) {

        //Click the 'FAQs' link
        CPRMainPage.click_FAQS();
        assertEquals(driver.getCurrentUrl(), FAQPage.FAQ_PAGE_URL);

        //Click the 'How do I sign up for Citi Price Rewind?' link
        FAQPage.click_registration();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.REGISTRATION_URL);

        //Go back to top of page
        FAQPage.click_faq7_BackToTop();

    }

    @Test(groups = {"p1"})
    public void testFaqTechnicalPage(/*String status, String perPage String status_UploadReceipt*/) {

        //Click the 'FAQs' link
        CPRMainPage.click_FAQS();
        assertEquals(driver.getCurrentUrl(), FAQPage.FAQ_PAGE_URL);

        //Click the 'Why do I have to have JavaScript enabled in my browser to use this site? Is it safe?' link
        FAQPage.click_technical1();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.TECHNICAL1_URL);

        //Go back to top of page
        FAQPage.click_faq9_BackToTop();

        //Click the 'Why do I have to have browser cookies enabled in my browser to use Citi Price Rewind? Are they safe?' link
        FAQPage.click_technical2();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.TECHNICAL2_URL);

        //Go back to top of page
        FAQPage.click_faq10_BackToTop();

        //Click the 'The website does not appear properly formatted and is difficult to read. Does this website need a specific browser to function properly?' link
        FAQPage.click_technical3();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.TECHNICAL3_URL);

        //Go back to top of page
        FAQPage.click_faq11_BackToTop();

        //Click the 'I'm using a shared computer, how can I protect my personal information?' link
        FAQPage.click_technical4();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.TECHNICAL4_URL);

        //Go back to top of page
        FAQPage.click_faq12_BackToTop();


    }

    @Test(groups = {"p1"})
    public void testFaqSearchPage(/*String status, String perPage String status_UploadReceipt*/) {

        //Click the 'FAQs' link
        CPRMainPage.click_FAQS();
        assertEquals(driver.getCurrentUrl(), FAQPage.FAQ_PAGE_URL);

        //Click the 'When should I start a Price Rewind?' link
        FAQPage.click_search1();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.SEARCH1_URL);

        //Go back to top of page
        FAQPage.click_faq13_BackToTop();

        //Click the 'How do I start a Price Rewind?' link
        FAQPage.click_search2();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.SEARCH2_URL);

        //Go back to top of page
        FAQPage.click_faq14_BackToTop();

        //Click the 'How long after I make a purchase can I start a Price Rewind?' link
        FAQPage.click_search3();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.SEARCH3_URL);

        //Go back to top of page
        FAQPage.click_faq15_BackToTop();

        //Click the 'I searched for an item but Citi Price Rewind did not find a match. What should I do?' link
        FAQPage.click_search4();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.SEARCH4_URL);

        //Go back to top of page
        FAQPage.click_faq16_BackToTop();

        //Click the 'I found my item, but the store where I purchased it isn't listed. Is that ok?' link
        FAQPage.click_search5();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.SEARCH5_URL);

        //Go back to top of page
        FAQPage.click_faq17_BackToTop();

    }

    @Test(groups = {"p1"})
    public void testFaqMPRPage(/*String status, String perPage String status_UploadReceipt*/) {

        //Click the 'FAQs' link
        CPRMainPage.click_FAQS();
        assertEquals(driver.getCurrentUrl(), FAQPage.FAQ_PAGE_URL);

        //Click the 'When will I know if I can initiate a benefit request?' link
        FAQPage.click_mpr1();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.MPR1_URL);

        //Go back to top of page
        FAQPage.click_faq18_BackToTop();

        //Click the 'How will I be notified if I can initiate a benefit request?' link
        FAQPage.click_mpr2();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.MPR2_URL);

        //Go back to top of page
        FAQPage.click_faq19_BackToTop();

        //Click the 'Can I cancel a Price Rewind?' link
        FAQPage.click_mpr3();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.MPR3_URL);

        //Go back to top of page
        FAQPage.click_faq20_BackToTop();

        //Click the 'What is the minimum price difference to initiate a benefit request?' link
        FAQPage.click_mpr4();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.MPR4_URL);

        //Go back to top of page
        FAQPage.click_faq21_BackToTop();

        //Click the 'I submitted my Citi Price Rewind benefit request but I never got my difference in price?' link
        FAQPage.click_mpr5();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.MPR5_URL);

        //Go back to top of page
        FAQPage.click_faq22_BackToTop();

        //Click the 'Can I choose how to receive the difference in price?' link
        FAQPage.click_mpr6();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.MPR6_URL);

        //Go back to top of page
        FAQPage.click_faq23_BackToTop();

        //Click the 'I received an alert that a lower price for an item was found. What do I do?' link
        FAQPage.click_mpr7();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.MPR7_URL);

        //Go back to top of page
        FAQPage.click_faq24_BackToTop();

        //Click the 'I found a lower price on my own. Can I still initiate a benefit request?' link
        FAQPage.click_mpr8();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.MPR8_URL);

        //Go back to top of page
        FAQPage.click_faq25_BackToTop();

        //Click the 'How do I complete a Citi Price Rewind benefit request if I find a better price than Citi Price Rewind does?' link
        FAQPage.click_mpr9();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.MPR9_URL);

        //Go back to top of page
        FAQPage.click_faq26_BackToTop();

        //Click the 'Why is Citi Price Rewind showing my difference in price as less than the difference between my purchase price and the lowest price found?' link
        FAQPage.click_mpr10();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.MPR10_URL);

        //Go back to top of page
        FAQPage.click_faq27_BackToTop();

        //Click the 'How long can I wait before I initiate a benefit request?' link
        FAQPage.click_mpr11();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.MPR11_URL);

        //Go back to top of page
        FAQPage.click_faq28_BackToTop();

        //Click the 'When will I get the difference in price?' link
        FAQPage.click_mpr12();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.MPR12_URL);

        //Go back to top of page
        FAQPage.click_faq29_BackToTop();

        //Click the 'Is there a limit on the amount I can receive for a Price Rewind?' link
        FAQPage.click_mpr13();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.MPR13_URL);

        //Go back to top of page
        FAQPage.click_faq30_BackToTop();

        //Click the 'Is there any limit to the number of Price Rewinds I can have?' link
        FAQPage.click_mpr14();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.MPR14_URL);

        //Go back to top of page
        FAQPage.click_faq31_BackToTop();

        //Click the 'I purchased more than one item of the same product at the same time (for example, two cameras). How many Price Rewinds do I need to register?' link
        FAQPage.click_mpr15();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.MPR15_URL);

        //Go back to top of page
        FAQPage.click_faq32_BackToTop();

        //Click the 'Why is my item not covered, I found it on the Citi Price Rewind website?' link
        FAQPage.click_mpr16();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.MPR16_URL);

        //Go back to top of page
        FAQPage.click_faq33_BackToTop();

    }

    @Test(groups = {"p1"})
    public void testFaqMiscPage(/*String status, String perPage String status_UploadReceipt*/) {

        //Click the 'FAQs' link
        CPRMainPage.click_FAQS();
        assertEquals(driver.getCurrentUrl(), FAQPage.FAQ_PAGE_URL);

        //Click the 'I'm an international user' link
        FAQPage.click_misc1();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.MISC1_URL);

        //Go back to top of page
        FAQPage.click_faq34_BackToTop();

        //Click the 'I have questions about the Citi Price Rewind program' link
        FAQPage.click_misc2();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.MISC2_URL);

        //Go back to top of page
        FAQPage.click_faq35_BackToTop();

        //Click the 'I have questions regarding my benefit request status' link
        FAQPage.click_misc3();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.MISC3_URL);

        //Go back to top of page
        FAQPage.click_faq36_BackToTop();

        //Click the 'I have questions about my Citi Card' link
        FAQPage.click_misc4();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.MISC4_URL);

        //Go back to top of page
        FAQPage.click_faq37_BackToTop();

        //Click the 'What should I do if I return an item I am tracking?' link
        FAQPage.click_misc5();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.getCurrentUrl(), FAQPage.MISC5_URL);

        //Go back to top of page
        FAQPage.click_faq38_BackToTop();

    }
}