package com.citipricerewind.tests;

import com.citipricerewind.pages.CitiPriceRewindMyPriceRewinds;
import com.citipricerewind.pages.CitipricerewindMainPage;
import com.citipricerewind.pages.StartPriceRewind;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
public class DatePicker_Test {

    public WebDriver driver;
    CitipricerewindMainPage CPRMainPage;
    CitiPriceRewindMyPriceRewinds CPRMyPriceRewinds;
    StartPriceRewind StartPriceRewind;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        this.driver = new FirefoxDriver();
        CPRMainPage = PageFactory.initElements(driver, CitipricerewindMainPage.class);
        CPRMyPriceRewinds = PageFactory.initElements(driver, CitiPriceRewindMyPriceRewinds.class);
        StartPriceRewind = PageFactory.initElements(driver, StartPriceRewind.class);
    }

    @AfterClass(alwaysRun = true)
    public void teardown(){
        driver.close();
    }

    @Test(groups = {"p1"})
    //Test to start a track by selecting date from date picker
    public void testDatePicker1()

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
        String uploadSuccessful = driver.findElement(By.cssSelector(".cpr_successfulUpload")).getText();
        assertTrue(uploadSuccessful.contains("Your file CARTERA TEST RECEIPT PNG.png has been uploaded successfully."));

        //Click the 'Start a Price Rewind' button
        StartPriceRewind.click_Start_Price_Rewind();
        String trackCreated = driver.findElement(By.cssSelector(".cpr_modalTitle.cpr_focusable")).getText();
        assertTrue(trackCreated.contains("All Set"));

        //Click the X on the 'All Set' model
        WebElement closeModal = driver.findElement(By.xpath("html/body/div[5]/div[2]/button"));
        closeModal.click();

        //Click 'Start a Price Rewind' button
        //StartPriceRewind.click_Start_Price_Rewind();
        //String trackCreated = driver.findElement(By.cssSelector(".cpr_modalTitle.cpr_focusable")).getText();

        //Verify tooltip for date picker displays or not. This is not working because it thinks it is always visible.
        //WebElement dateTooltip = driver.findElement(By.xpath("/html[@id='start-price-rewind']/body/div[@id='cpr_content']/div[@class='cpr_SPR_container']/div[@class='cpr_grid']/div[@class='cpr_SPR_singleProduct cpr_clearfix']/form[@class='cpr_SPR_purchaseData']/div[@class='cpr_md-3 cpr_sm-6 cpr_SPR_formFieldContainer'][2]"));
        //WebElement dateTooltip = driver.findElement(By.xpath("//span[text()='Price should be between $0.01 and $1,000,001']"));
        //WebElement dateTooltip = driver.findElement(By.xpath("html/body/div[3]/div/div/div[2]/form/div[3]/div[2]/input"));
        //WebElement dateTooltip = driver.findElement(By.xpath("/html[@id='start-price-rewind']/body/div[@id='cpr_content']/div[@class='cpr_SPR_container']/div[@class='cpr_grid']/div[@class='cpr_SPR_singleProduct cpr_clearfix']/form[@class='cpr_SPR_purchaseData']/div[@class='cpr_md-3 cpr_sm-6 cpr_SPR_formFieldContainer'][1]/div[@id='cpr_SPR_money']/span[@id='SPR_price-tip']"));

        // if(dateTooltip.isDisplayed()){
        //System.out.println("Element is Visible");
        //}
        //else {
        //System.out.println("Element is Invisible");
        //}


        /*//Enter a store name
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
        */

    }

    @Test(groups = {"p1"})
    //Test manual date entry in format M/D/YYYY
    public void testDatePicker2()

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

        //Enter date manually
        StartPriceRewind.setText_Date_Field("10/9/17");

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

        //Click the X on the 'All Set' model
        WebElement closeModal = driver.findElement(By.xpath("html/body/div[5]/div[2]/button"));
        closeModal.click();

    }

    @Test(groups = {"p1"})
    //Test manual date entry in format M/DD/YYYY
    public void testDatePicker3()

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

        //Enter date manually
        StartPriceRewind.setText_Date_Field("10/09/2017");

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

        //Click the X on the 'All Set' model
        WebElement closeModal = driver.findElement(By.xpath("html/body/div[5]/div[2]/button"));
        closeModal.click();

    }

    @Test(groups = {"p1"})
    //Test manual date entry in format MM/D/YY
    public void testDatePicker4()

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

        //Enter date manually
        StartPriceRewind.setText_Date_Field("10/9/17");

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

        //Click the X on the 'All Set' model
        WebElement closeModal = driver.findElement(By.xpath("html/body/div[5]/div[2]/button"));
        closeModal.click();

    }

    @Test(groups = {"p1"})
    //Test manual date entry in format MM/D/YYYY
    public void testDatePicker5()

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

        //Enter date manually
        StartPriceRewind.setText_Date_Field("10/9/2017");

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

        //Click the X on the 'All Set' model
        WebElement closeModal = driver.findElement(By.xpath("html/body/div[5]/div[2]/button"));
        closeModal.click();

    }

    @Test(groups = {"p1"})
    //Test previous and next month buttons
    public void testDatePicker6()

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

        //Click the previous month button
        StartPriceRewind.click_Previous_Month();

        //Click the datepicker close button
        StartPriceRewind.click_Close_Datepicker();

        //Click datepicker icon
        StartPriceRewind.click_Datepicker_Icon();

        //Click the previous month button
        StartPriceRewind.click_Previous_Month();

        //Click the next month button
        StartPriceRewind.click_Next_Month();

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

        //Click the X on the 'All Set' model
        WebElement closeModal = driver.findElement(By.xpath("html/body/div[5]/div[2]/button"));
        closeModal.click();

    }

    @Test(groups = {"p1"})
    //Select date from previous month
    public void testDatePicker7()

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

        //Click the previous month button
        StartPriceRewind.click_Previous_Month();

        //Select a date
        StartPriceRewind.select_Prev_Month_Date();

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

        //Click the X on the 'All Set' model
        WebElement closeModal = driver.findElement(By.xpath("html/body/div[5]/div[2]/button"));
        closeModal.click();

    }


    @Test(groups = {"p1"})
    //Negative test for incorrect date
    public void testDatePicker8()

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


       /* //Verify tooltip appears for incorrect date
        if(driver.getPageSource().contains("Date Purchased must be within the last 60 days. Date must be in the format month/day/year"))
        {
            System.out.println("Text Present");
        }
        else {
            System.out.println("Text Not Present");
        }*/

        //Click the Track This Item button
        StartPriceRewind.click_Track_This_Item_button();
        WebElement startButton = driver.findElement(By.cssSelector("#cpr_SPR_submit"));
        driverWait.until(ExpectedConditions.visibilityOf(startButton));
        assertEquals(driver.getTitle(), StartPriceRewind.START_PRICE_REWIND_TITLE);

        //Enter a 'Purchase Price'
        StartPriceRewind.setText_PurchasePrice("499.99");
        //assertTrue(driver.findElement(By.cssSelector("#cpr_SPR_price")).getText().contains("0.00"));

        //Enter date manually
        StartPriceRewind.setText_Date_Field("01/01/2017");

        //Enter a store name
        StartPriceRewind.enter_Store_Name("Best Buy");

        //Select a payment method
        StartPriceRewind.select_Payment_Type();

        //Click Receipt Upload container
        StartPriceRewind.select_Receipt_Upload("C:\\Users\\frank.marchion\\Documents\\Documents\\Test Receipts\\CARTERA TEST RECEIPT PNG.png");
        //WebElement deleteButton = driver.findElement(By.cssSelector(".cpr_deleteLink"));
        //driverWait.until(ExpectedConditions.visibilityOf(deleteButton));
        String uploadSuccessful = driver.findElement(By.cssSelector(".cpr_successfulUpload")).getText();
        assertTrue(uploadSuccessful.contains("Your file CARTERA TEST RECEIPT PNG.png has been uploaded successfully."));

        //Click the 'Start a Price Rewind' button
        StartPriceRewind.click_Start_Price_Rewind();

        //Verify tooltip appears for incorrect date
        if(driver.getPageSource().contains("Date Purchased must be within the last 60 days. Date must be in the format month/day/year"))
        {
            System.out.println("Text Present");
        }
        else {
            System.out.println("Text Not Present");
        }



        //Verify tooltip for date picker displays or not. This is not working because it thinks it is always visible.
        //WebElement dateTooltip = driver.findElement(By.xpath("/html[@id='start-price-rewind']/body/div[@id='cpr_content']/div[@class='cpr_SPR_container']/div[@class='cpr_grid']/div[@class='cpr_SPR_singleProduct cpr_clearfix']/form[@class='cpr_SPR_purchaseData']/div[@class='cpr_md-3 cpr_sm-6 cpr_SPR_formFieldContainer'][2]"));
        //WebElement dateTooltip = driver.findElement(By.xpath("//span[text()='Price should be between $0.01 and $1,000,001']"));
        //WebElement dateTooltip = driver.findElement(By.xpath("html/body/div[3]/div/div/div[2]/form/div[3]/div[2]/input"));
        //WebElement dateTooltip = driver.findElement(By.xpath("/html[@id='start-price-rewind']/body/div[@id='cpr_content']/div[@class='cpr_SPR_container']/div[@class='cpr_grid']/div[@class='cpr_SPR_singleProduct cpr_clearfix']/form[@class='cpr_SPR_purchaseData']/div[@class='cpr_md-3 cpr_sm-6 cpr_SPR_formFieldContainer'][1]/div[@id='cpr_SPR_money']/span[@id='SPR_price-tip']"));

        /*WebElement dateTooltip = driver.findElement(By.xpath("/html[@id='start-price-rewind']/body/div[@id='cpr_content']/div[@class='cpr_SPR_container']/div[@class='cpr_grid']/div[@class='cpr_SPR_singleProduct cpr_clearfix']/form[@class='cpr_SPR_purchaseData']/div[@class='cpr_md-3 cpr_sm-6 cpr_SPR_formFieldContainer']/div[@class='cpr_hidden']"));
        driverWait.until(ExpectedConditions.visibilityOf(dateTooltip));
        Assert.assertEquals(true, dateTooltip.isDisplayed());*/




    }
}



