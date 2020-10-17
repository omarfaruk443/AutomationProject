package Reusable_Liabrary;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reusable_Methods {
    static int timeOut = 10;




    public static WebDriver getDriver() throws IOException, InterruptedException {
        Thread.sleep(1000);
        //kill all the chrome driver instance before opening a new one
        //Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        Thread.sleep(1000);
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");//set the chrome driver location
        ChromeOptions options = new ChromeOptions();//setting the chrome options before defining the driver
        options.addArguments("start-maximized");//set the driver to be maximized
        options.addArguments("incognito");//set the driver to incognito mode(private)
        //options.addArguments("headless");//run the driver in headless mode
        //defining the web driver that I will be using
        WebDriver driver = new ChromeDriver(options);//options variable should be passed here

        return driver;
    }//end dof getDriver method





    //reusable method to click on any elements on any websites
    public static void click(WebDriver driver,String xpathLocator,String elementName){
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try{
                System.out.println("Clicking on element " +elementName);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator))).click();
            }catch (Exception err){
            System.out.println("Unable to click on element " +elementName +err);
                    }//end of exception
    }//end of Click Method







    //reusable method to type on any elements on any websites
    public static void sendkeys(WebDriver driver,String xpathLocator,String UserValue,String elementName){
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try{
            System.out.println("Typing an element " +elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)));
            element.click();
            element.clear();
            element.sendKeys(UserValue);
        }catch (Exception err){
            System.out.println("Unable to Type on element " +elementName +err);
                    }//end of exception
    }//end of SendKeys Method







    //reusable method to submit on any elements on any websites
    public static void submit(WebDriver driver,String xpathLocator,String elementName){
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try{
            System.out.println("submitting an element " +elementName);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator))).submit();
        }catch (Exception err){
            System.out.println("Unable to submit on element " +elementName +err);
                    }//end of exception
    }//end of submit method








   //reusable return string method to get a text from an element on any websites
    public static String getText(WebDriver driver, String xpathLocator, String elementName){
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        String rtn = "";
        try {
            System.out.println("getting Text from an element " + elementName);
            rtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator))).getText();
        }catch(Exception err){
            System.out.println("Unable to get Text from an element " +elementName +err);
        }//end of exception

        return rtn;
    }//end of get text return String method







    //reusable method to get Title from any websites and verify it contains certain  words
    public static void getTitleContains(WebDriver driver,String contain,String website){
        try {
                System.out.println("getting Title from The Website " +website+ "And ");
                System.out.println("Trying to verify Title of the Website with Title that contains " +contain);
                String actual = driver.getTitle();
                    if(driver.getTitle().contains(contain)){
                            System.out.println("Title Matched with containing  word " +contain);
                        }else{
                            System.out.println("Title didn't match. Actual title is  " + actual);
                        }//end of if_else statement
            }catch(Exception err){
                System.out.println("Unable to get Title from The Website " +website +err);
                    }//end of exception
    }//end of get text return String method






    //reusable method to get Title from any websites
    public static void getTitleVerifyExpected(WebDriver driver,String expectedTitle,String website){
                System.out.println("getting Title from The Website " + website);
                    String actual = driver.getTitle();
                    String expected = expectedTitle;
                        System.out.println("Trying to verify Title of the Website with Expected Title");
                if(expected.equalsIgnoreCase(actual)){
                    System.out.println("Title Matched");
                }else{
                    System.out.println("Title didn't match. Actual title is  " + actual);
                    }//end of if_else statement

    }//end of get text return String method







    //reusable method to select a DropDown on any elements on any websites
    public static void selectByVisibleText(WebDriver driver,String xpathLocator,String visibleText,String elementName){
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try{
            System.out.println("Selecting by Visible Text element " +elementName);
            WebElement slct = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)));
            Select dropDown = new Select(slct);
            dropDown.selectByVisibleText(visibleText);
        }catch (Exception err){
            System.out.println("Unable to Select by Visible Text element  " +elementName +err);
        }//end of exception
    }//end of Select by visible text method







    //navigate to any Website or URL
    public static void navigate(WebDriver driver,String url,String website ){
        //navigate to the Website
        driver.navigate().to(url);
        System.out.println("Navigating to " +website+ " Home Page");
    }//end of Navigate method






    public static void switchtabs(WebDriver driver, int TabNmbr){
        //need to store get window handles command in as ArrayList to switch to different tab(s)
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(TabNmbr));//switch to second tab
        System.out.println("switching to tab no " +TabNmbr);
    }//end of switch tab method






    public static void clickByIndex(WebDriver driver,String locator,int indexNumber, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try{
            System.out.println("Clicking by index " + indexNumber + " on element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(indexNumber);
                element.click();
        } catch (Exception err) {
            System.out.println("Unable to click by index " + indexNumber +  " on element " + elementName + " " + err);
                    }//end of exception
    }//end of click by index method






    public static void typeAndSubmit(WebDriver driver,String locator, String userInput, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try{
            System.out.println("Entering a value on element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                element.clear();
                element.sendKeys(userInput);
                Thread.sleep(1000);
                element.sendKeys(Keys.ENTER); //this is another way to submit to an element using key event
        } catch (Exception e) {
            System.out.println("Unable to enter on element " + elementName + " " + e);
                     }//end of exception
    }//end of type and submit method







    public static void checkBoxStateSelected(WebDriver driver,String locator,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try{
            System.out.println("checking if checkBox is selected or not from " + elementName);
            boolean checkBoxState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).isSelected();
            //expecting checkbox is selected
            if (checkBoxState == true){
                System.out.println("CheckBox is selected as Expected ");
            }else {
                System.out.println("CheckBox is Not selected by default ");
            }//end of if else
        } catch (Exception e) {
            System.out.println("Unable to check if CheckBox is selected or not from " + elementName + " " + e);
        }//end of exception
    }//end of check box state selected method







    public static void checkBoxStateNotSelected(WebDriver driver,String locator,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try{
            System.out.println("checking if checkBox is selected or not from " + elementName);
                boolean checkBoxState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).isSelected();
                //expecting checkbox is not selected
                    if (checkBoxState == false){
                        System.out.println("CheckBox is Not selected as Expected ");
                    }else {
                        System.out.println("CheckBox is selected by default ");
                        }//end of if else
            } catch (Exception e) {
            System.out.println("Unable to check if CheckBox is selected or not from " + elementName + " " + e);
                }//end of exception
        }//end of check box state Not selected method







    public static void TabsCount(WebDriver driver,String locator, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try{
            System.out.println("Getting TabsCount From  " + elementName);
            //get the count of all Tabs from an element
            List<WebElement> linkCount = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
            //print Tabs count
            System.out.println("Tabs Count Is " + linkCount.size());
        } catch (Exception e) {
            System.out.println("Unable to get Tabs Count From " + elementName + " " + e);
        }//end of exception
    }//end of TabsCount method































}//end of java class
