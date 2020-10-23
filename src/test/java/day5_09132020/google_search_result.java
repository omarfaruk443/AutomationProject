package day5_09132020;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class google_search_result {

    public static void main(String[] args) throws InterruptedException {
        //set the chrome driver location
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver();

        //lets get to to google home page
        //driver.get("https://www.google.com");

        //let's navigate to google home page
        driver.navigate().to("https://google.com");
        //maximize my windows
        driver.manage().window().maximize();
        //put 3 second delays
        Thread.sleep(3000);
        //locate search field by name and enter a keyword on the search field
        driver.findElement(By.name("q")).sendKeys("cars");
        //click on google search
        driver.findElement(By.name("btnK")).submit();//hitting enter is same as submit
        //delay to load search result page
        Thread.sleep(2000);
        //capture the search result text
        String result = driver.findElement(By.id("result-stats")).getText();
        String[] arrayResult = result.split(" ");
        //print out the search number
        System.out.println("My search number is " + arrayResult[1]);


        //close driver
        //driver.close();
        //quite the entire sesion
        driver.quit();


    }//end of main method

}//end of class

