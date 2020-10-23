package Day9_09272020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class USPS_MouseMovement {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); //set the chrome driver location
        ChromeOptions options = new ChromeOptions();//setting the chrome options before defining the driver
        options.addArguments("start-maximized");//set the driver to be maximized
        options.addArguments("incognito");//set the driver to incognito mode(private)
        //options.addArguments("headless");//run the driver in headless mode
        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options);//options variable should be passed here


        driver.navigate().to("https://www.usps.com");//navigate to usps.com
            Thread.sleep(2000);//put some delay
                System.out.println("navigating to usps.com");


        //declare your mouse actions command
        Actions actions = new Actions(driver);

        //move your mouse to quick tools to open the dropdown
        WebElement quickTools = driver.findElement(By.xpath("//*[text()='Quick Tools']"));
            actions.moveToElement(quickTools).perform();
                Thread.sleep(1000);//put some delay
                    System.out.println("Moving Mouse to Quick Tools to open the dropdown");


        //click on track a package using actions
        WebElement trackPackage = driver.findElement(By.xpath("//*[text()='Track a Package']"));
            actions.moveToElement(trackPackage).click().perform();
                Thread.sleep(3000);//put some delay
                    System.out.println("clicking on track a package using actions");



            try {
                //Entering Tracking Number
                WebElement trackNumber = driver.findElement(By.xpath("//*[contains(@class,'form-control')]"));
                    trackNumber.sendKeys("15123165120");
                        Thread.sleep(2000);//put some delay
                            System.out.println("Entering Tracking Number");
                }catch (Exception err){
                System.out.println("unable to enter tracking number " +err);
            }//end of try catch


    }//end of main

}//end of class
