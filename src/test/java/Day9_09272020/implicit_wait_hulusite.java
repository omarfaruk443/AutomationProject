package Day9_09272020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class implicit_wait_hulusite {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); //set the chrome driver location
        ChromeOptions options = new ChromeOptions();//setting the chrome options before defining the driver
        options.addArguments("start-maximized");//set the driver to be maximized
        options.addArguments("incognito");//set the driver to incognito mode(private)
        //options.addArguments("headless");//run the driver in headless mode
        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options);//options variable should be passed here



        //set the implicit wait before your test steps
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.navigate().to("https://www.hulu.com");//navigate to hulu home page

        //click on start free trial
        //driver.findElement(By.xpath("//*[text()='START YOUR FREE TRIAL']")).click();
        //above text property didn't work because element not interactable
        //if this is the case then use another unique property
        driver.findElement(By.xpath("//*[@class='button--cta button--white Masthead__input-cta']")).click();

    }//end of main
}//end of class
