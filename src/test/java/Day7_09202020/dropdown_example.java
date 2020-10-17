package Day7_09202020;

import Reusable_Liabrary.Reusable_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class dropdown_example {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); //set the chrome driver location
        ChromeOptions options = new ChromeOptions();//setting the chrome options before defining the driver
        options.addArguments("start-maximized");//set the driver to be maximized
        options.addArguments("incognito");//set the driver to incognito mode(private)
        //options.addArguments("headless");//run the driver in headless mode
        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options);//options variable should be passed here

        //navigate to mlcalc website
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(2000);//2 second delay

        //use WebElement variable to store your start Month dropdown
        WebElement startMonth = driver.findElement(By.xpath("//*[@name='sm']"));
        Select smDropDown = new Select(startMonth);
        smDropDown.selectByVisibleText("Feb");

        //use WebElement variable to store your start Year dropdown
        WebElement startYear = driver.findElement(By.xpath("//*[@name='sy']"));
        Select syDropDown = new Select(startYear);
        syDropDown.selectByVisibleText("2022");

        //selecting html tag when html tag is not under the select tag
        driver.findElement(By.xpath("//*[@name='sy']")).click();
        Thread.sleep(1000);//1 second delay
        driver.findElement(By.xpath("//*[Text()='2022']")).click();








    }
}
