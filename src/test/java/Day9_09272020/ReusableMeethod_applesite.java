package Day9_09272020;

import Reusable_Liabrary.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ReusableMeethod_applesite {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); //set the chrome driver location
        ChromeOptions options = new ChromeOptions();//setting the chrome options before defining the driver
        options.addArguments("start-maximized");//set the driver to be maximized
        options.addArguments("incognito");//set the driver to incognito mode(private)
        //options.addArguments("headless");//run the driver in headless mode
        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options);//options variable should be passed here


        driver.navigate().to("https://www.apple.com");//navigate to apple home page
        //click on mac
        Reusable_Methods.click(driver,"//*[@data-analytics-title='mac']","Mac Link");
        //click on macbook air
        Reusable_Methods.click(driver,"//*[text()='MacBook Air']","Mac Book Air");
        //click on search icon
        Reusable_Methods.click(driver,"//*[@id='ac-gn-link-search']","Search Icon");
            Thread.sleep(2000);
        //entering a Keyword on Search field
        Reusable_Methods.sendkeys(driver,"//*[@placeholder='Search apple.com']","iphone","Search Field");
            Thread.sleep(2000);
        //hit submit
        Reusable_Methods.submit(driver,"//*[@placeholder='Search apple.com']","Search Field");
            Thread.sleep(2000);
    }//end of main
}//end of class
