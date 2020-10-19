package Reusable_Liabrary;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reusable_Methods_Loggers {

    static int timeOut = 10;

    public static WebDriver getDriver() throws IOException, InterruptedException {
        Thread.sleep(1000);
        //kill all the chrome driver instance before opening a new one
        //Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        Thread.sleep(1000);
        //set the chrome driver location
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();
        //set the driver to be maximized
        options.addArguments("start-maximized");
        //set the driver to be incognito mode(private)
        options.addArguments("incognito");
        //run the driver in headless mode
        //options.addArguments("headless");
        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options); //options variable should be passed here
        return driver;
    }//end of get driver









    //navigate to any Website or URL
    public static void navigate(WebDriver driver,String url,ExtentTest logger,String website ){
        //navigate to the Website
        driver.navigate().to(url);
        System.out.println("Navigating to " +website+ " Home Page");
        logger.log(LogStatus.INFO,"Navigating to " +website+ " Home Page");
    }//end of Navigate method










    //reusable method to click on any element on any websites
    public static void click(WebDriver driver, String locator,ExtentTest logger,String elementName){
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try{
            System.out.println("Clicking on element " + elementName);
            logger.log(LogStatus.INFO,"Clicking on element " + elementName);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
        }catch (Exception err){
            System.out.println("Unable to click on element " + err);
            logger.log(LogStatus.FAIL,"Unable to click on element " + err);
            getScreenShot(driver,logger,elementName);
        }//end of exception
    }//end of click method










    //reusable method to click on any element on any websites
    public static void clickByIndex(WebDriver driver, String locator,int indexNumber,ExtentTest logger,String elementName){
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try{
            System.out.println("Clicking on element " + elementName);
            logger.log(LogStatus.INFO,"Clicking on element " + elementName);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(indexNumber).click();
        }catch (Exception err){
            System.out.println("Unable to click on element " + err);
            logger.log(LogStatus.FAIL,"Unable to click on element " + err);
            getScreenShot(driver,logger,elementName);
        }//end of exception
    }//end of click method









    //reusable method to type on any element on any websites
    public static void sendKeys(WebDriver driver, String locator, String userValue, ExtentTest logger,String elementName){
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try{
            System.out.println("Typing on element " + elementName);
            logger.log(LogStatus.INFO,"Typing on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userValue);
        }catch (Exception err){
            System.out.println("Unable to type on element " + err);
            logger.log(LogStatus.FAIL,"Unable to type on element " + err);
            getScreenShot(driver,logger,elementName);
        }//end of exception
    }//end of sendkeys method










    //reusable method to submit on any element on any websites
    public static void submit(WebDriver driver, String locator,ExtentTest logger, String elementName){
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try{
            System.out.println("Submitting on element " + elementName);
            logger.log(LogStatus.INFO,"Submitting on element " + elementName);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).submit();
        }catch (Exception err){
            System.out.println("Unable to submit on element " + err);
            logger.log(LogStatus.FAIL,"Unable to submit on element " + err);
            getScreenShot(driver,logger,elementName);
        }//end of exception
    }//end of submit method











    //reusable method to capture a value/text from a page
    public static String captureText(WebDriver driver, String locator,ExtentTest logger,String elementName){
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        String result = "";
        try{
            System.out.println("Capturing text on element " + elementName);
            logger.log(LogStatus.INFO,"Capturing text on element " + elementName);
            result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).getText();
        }catch (Exception err){
            System.out.println("Unable to capture text on element " + err);
            logger.log(LogStatus.FAIL,"Unable to capture text on element " + err);
            getScreenShot(driver,logger,elementName);
        }//end of exception

        return result;
    }//end of get result method













    //method to select from drop down menu
    public static void dropDownMenu(WebDriver driver, String locator, String userInput,ExtentTest logger, String elementName)
    {
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try
        {
            System.out.println("\nSelecting " + userInput + elementName);
            logger.log(LogStatus.INFO,"\nSelecting "+userInput + elementName);
            WebElement dropDown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select selectDropDown= new Select(dropDown);
            selectDropDown.selectByVisibleText(userInput);
        }
        catch (Exception err)
        {
            System.out.println("\nUnable to select from drop down " + err);
            logger.log(LogStatus.FAIL,"\nUnable to select from drop down " + err);
            getScreenShot(driver,logger,elementName);
        }
    }//end of drop down by text method










    //method to type something and then hit enter key on keyboard
    public static void typeAndSubmit(WebDriver driver,String locator, String userInput,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try{
            System.out.println("Entering a value on element " + elementName);
            logger.log(LogStatus.INFO,"Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userInput);
            Thread.sleep(1000);
            element.sendKeys(Keys.ENTER); //this is another way to submit to an element using key event
        } catch (Exception e) {
            System.out.println("Unable to enter on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to enter on element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }//end of exception
    }//end of type and submit method













    //method to click on an element by using your mouse
    public static void mouseClick(WebDriver driver,String locator,ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        Actions actions = new Actions(driver);
        try{
            System.out.println("Mouse clicking a value on element " + elementName);
            logger.log(LogStatus.INFO,"Mouse clicking a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            actions.moveToElement(element).click().perform();
        } catch (Exception e) {
            System.out.println("Unable to mouse click element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to mouse click element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }//end of exception
    }//end of click method














    //method to move to an element by using your mouse
    public static void mouseHover(WebDriver driver,String locator,ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        Actions actions = new Actions(driver);
        try{
            System.out.println("Mouse moving to an element " + elementName);
            logger.log(LogStatus.INFO,"Mouse moving to an element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to move mouse to an element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to move mouse to an element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }//end of exception
    }//end of Mouse Hover method













    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver wDriver,ExtentTest logger,String imageName) {
        try {
            String fileName = imageName + ".png";
            String directory = "src/main/java/HTML_Report/Screenshots/";
            File sourceFile = ((TakesScreenshot) wDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture("Screenshots/" + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }//end of exception
    }//end of screenshot method











    //reusable method to get Title from any websites and verify it contains certain  words
    public static void getTitleContains(WebDriver driver,String contain,ExtentTest logger,String website){
        try {
            System.out.println("getting Title from The Website " +website+ "And ");
            logger.log(LogStatus.INFO,"getting Title from The Website " +website+ "And ");
            System.out.println("Trying to verify Title of the Website with Title that contains " +contain);
            logger.log(LogStatus.INFO,"Trying to verify Title of the Website with Title that contains " +contain);
            String actual = driver.getTitle();
            if(driver.getTitle().contains(contain)){
                System.out.println("Title Matched with containing  word " +contain);
                logger.log(LogStatus.PASS,"Title Matched with containing  word " +contain);
            }else{
                System.out.println("Title didn't match. Actual title is  " + actual);
                logger.log(LogStatus.FAIL,"Title didn't match. Actual title is  " + actual);
            }//end of if_else statement
        }catch(Exception err){
            System.out.println("Unable to get Title from The Website " +website +err);
            logger.log(LogStatus.FAIL,"Unable to get Title from The Website " +website +err);
            getScreenShot(driver,logger,website);
        }//end of exception
    }//end of get title contains method












    //reusable method to get Title from any websites
    public static void getTitleVerifyWithExpected(WebDriver driver,String expectedTitle,ExtentTest logger,String website){
        System.out.println("getting Title from The Website " + website);
        logger.log(LogStatus.INFO,"getting Title from The Website " + website);
        String actual = driver.getTitle();
        String expected = expectedTitle;
        System.out.println("Trying to verify Title of the Website with Expected Title");
        logger.log(LogStatus.INFO,"Trying to verify Title of the Website with Expected Title");

        if(expected.equalsIgnoreCase(actual)){
            System.out.println("Title Matched");
            logger.log(LogStatus.PASS,"Title Matched");
        }else{
            System.out.println("Title didn't match. Actual title is  " + actual);
            logger.log(LogStatus.FAIL,"Title didn't match. Actual title is  " + actual);
            getScreenShot(driver,logger,website);
        }//end of if_else statement
    }//end of get text return String method












    //reusable method to select a DropDown on any elements on any websites
    public static void selectByVisibleText(WebDriver driver,String xpathLocator,String visibleText,ExtentTest logger,String elementName){
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try{
            System.out.println("Selecting by Visible Text element " +elementName);
            logger.log(LogStatus.INFO,"Selecting by Visible Text element " +elementName);
            WebElement slct = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)));
            Select dropDown = new Select(slct);
            dropDown.selectByVisibleText(visibleText);
        }catch (Exception err){
            System.out.println("Unable to Select by Visible Text element  " +elementName +err);
            logger.log(LogStatus.FAIL,"Unable to Select by Visible Text element  " +elementName +err);
            getScreenShot(driver,logger,elementName);
        }//end of exception
    }//end of Select by visible text method












    //method to switch to different tabs
    public static void switchtabs(WebDriver driver, int TabNmbr,ExtentTest logger){
        //need to store get window handles command in as ArrayList to switch to different tab(s)
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(TabNmbr));//switch to second tab
        System.out.println("switching to tab no " +TabNmbr);
        logger.log(LogStatus.INFO,"switching to tab no " +TabNmbr);
    }//end of switch tab method












    //to check/verify if checkbox in any kind of element not selected (which should be default)
    public static void checkBoxStateSelected(WebDriver driver,String locator,ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try{
            System.out.println("checking if checkBox is selected or not from " + elementName);
            logger.log(LogStatus.INFO,"checking if checkBox is selected or not from " + elementName);
            boolean checkBoxState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).isSelected();
            //expecting checkbox is selected
            if (checkBoxState == true){
                System.out.println("CheckBox is selected as Expected ");
                logger.log(LogStatus.PASS,"CheckBox is selected as Expected ");
                getScreenShot(driver,logger,elementName);
            }else {
                System.out.println("CheckBox is Not selected by default ");
                logger.log(LogStatus.FAIL,"CheckBox is Not selected by default ");
                getScreenShot(driver,logger,elementName);
            }//end of if else
        } catch (Exception e) {
            System.out.println("Unable to check if CheckBox is selected or not from " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to check if CheckBox is selected or not from " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }//end of exception
    }//end of check box state selected method












    //to check/verify if checkbox in any kind of element is not selected (which should be default)
    public static void checkBoxStateNotSelected(WebDriver driver,String locator,ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try{
            System.out.println("checking if checkBox is selected or not from " + elementName);
            logger.log(LogStatus.INFO,"checking if checkBox is selected or not from " + elementName);
            boolean checkBoxState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).isSelected();
            //expecting checkbox is not selected
            if (checkBoxState == false){
                System.out.println("CheckBox is Not selected as Expected ");
                logger.log(LogStatus.PASS,"CheckBox is not selected as Expected ");
                getScreenShot(driver,logger,elementName);
            }else {
                System.out.println("CheckBox is selected by default ");
                logger.log(LogStatus.FAIL,"CheckBox is selected by default ");
                getScreenShot(driver,logger,elementName);
            }//end of if else
        } catch (Exception e) {
            System.out.println("Unable to check if CheckBox is selected or not from " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to check if CheckBox is selected or not from " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }//end of exception
    }//end of check box state Not selected method













    //get tabs or link count from a group of element which shares same identity
    public static void linkCount(WebDriver driver,String locator,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try{
            System.out.println("Getting linkCount From  " + elementName);
            logger.log(LogStatus.INFO,"Getting linkCount From  " + elementName);
            //get the count of all links from an element
            List<WebElement> linkCount = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
            //print Tabs count
            System.out.println("link Count Is " + linkCount.size());
            logger.log(LogStatus.INFO,"Getting linkCount From  " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to get link Count From " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to get link Count From " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }//end of exception
    }//end of linkCount method












    //verify if one of the msg/report/text matches my expected one
    public static void verifyStringToExpectedString(WebDriver driver,String actual,String expected,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try{
            System.out.println("Verifying if " + elementName + " is matching my expected One '");
            logger.log(LogStatus.INFO,"Verifying if " + elementName + " is matching my expected One '");

            if (actual.equalsIgnoreCase(expected)){
                System.out.println(elementName+" Matched as Expected");
                logger.log(LogStatus.PASS,elementName+" Matched as Expected");
                getScreenShot(driver,logger,elementName);
            }else{
                System.out.println(elementName+ " didn't match as expected. \n actual is "+actual);
                logger.log(LogStatus.FAIL,elementName+ " didn't match as expected. \n actual is "+actual);
                getScreenShot(driver,logger,elementName);
            }//end of if else
        } catch (Exception e) {
            System.out.println("Unable to verify " + elementName + "with my expected one " + e);
            logger.log(LogStatus.FAIL,"Unable to verify " + elementName + "with my expected one " + e);
            getScreenShot(driver,logger,elementName);
        }//end of exception
    }//end of verify string to string method










































}//end of java class
