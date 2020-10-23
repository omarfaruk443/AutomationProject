package Day8_09262020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Metlife_switchtabs {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); //set the chrome driver location
        ChromeOptions options = new ChromeOptions();//setting the chrome options before defining the driver
        options.addArguments("start-maximized");//set the driver to be maximized
        options.addArguments("incognito");//set the driver to incognito mode(private)
        //options.addArguments("headless");//run the driver in headless mode
        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options);//options variable should be passed here



        driver.navigate().to("https://www.metlife.com");//navigate to metlife home page
            Thread.sleep(3000);//3 second delay
                System.out.println("navigate to metlife home page");

        driver.findElement(By.xpath("//*[@aria-label='SOLUTIONS']")).click();//click on solution
            Thread.sleep(500);//half second delay
                System.out.println("clicking on solution");

        driver.findElement(By.xpath("//*[text()='MetLife TakeAlong Dental']")).click();//click on metlife TakeAlong dental
            Thread.sleep(1500);//1.5 second delay
                System.out.println("clicking on metlife TakeAlong dental");

        driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]")).click();//click on enroll now button
            Thread.sleep(500);//half second delay
                System.out.println("click on enroll now button");



        //need to store get window handles command in as ArrayList to switch to different tab(s)
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));//switch to second tab
                System.out.println("switching to second tab");


        driver.findElement(By.xpath("//*[@name='txtZipCode']")).sendKeys("11417");//enter the zipcode
            Thread.sleep(1000);//put 1 second delay
                driver.close();//to close the new tab if u don't need it again


        driver.switchTo().window(tabs.get(0));//switch back to previous tab
                System.out.println("switching back to previous tabb");


        driver.navigate().to("https://www.metlife.com"); //ReNavigate to met life
            Thread.sleep(2000);//put 2 second delay
                System.out.println("ReNavigating to met life");







    }//end of main
}//eend of class
