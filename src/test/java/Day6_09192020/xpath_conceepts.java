package Day6_09192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class xpath_conceepts {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); //set the chrome driver location
        ChromeOptions options = new ChromeOptions();//setting the chrome options before defining the driver
        options.addArguments("start-maximized");//set the driver to be maximized
        options.addArguments("incognito");//set the driver to incognito mode(private)
        options.addArguments("headless");//run the driver in headless mode
        WebDriver driver = new ChromeDriver(options);//defining the web driver that you will be using//options variable should be passed here on ()

        driver.navigate().to("https://www.yahoo.com");//navigate to yahoo
        Thread.sleep(2000);//2 second delay
        System.out.println("navigating to yahoo");//print that its navigating to yahoo

        driver.findElement(By.xpath("//*[@]"));


    }//end of main
}//end of class
