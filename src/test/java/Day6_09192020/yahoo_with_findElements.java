package Day6_09192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class yahoo_with_findElements {
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


        //using find elements to click on 3rd link (news)
        driver.findElements(By.xpath("//*[@class='_yb_e4mte ']")).get(2).click();
        Thread.sleep(2000);
        System.out.println("clicking on news");


        WebElement searchField = driver.findElement(By.xpath("//*[@name='p']"));//setting search field as a webelement
            searchField.clear();//cler any pre-defined value on the filed
            searchField.sendKeys("cars");//enter your new keyword
            //Thread.sleep(1000);
            searchField.submit();//submit on the same field after the value
            System.out.println("searching cars");
            searchField.clear();//cler any pre-defined value on the filed
            searchField.sendKeys("bmw");//enter your new keyword
            ///Thread.sleep(1000);
            searchField.submit();//submit on the same field after the value
            System.out.println("searching bmw");

            driver.quit();//quiet the process

    }//end of main
}//end of class
