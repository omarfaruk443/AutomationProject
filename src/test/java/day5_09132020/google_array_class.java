package day5_09132020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class google_array_class {
    public static void main(String[] args) throws InterruptedException {
        //set the chrome driver location
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();
        //set the driver to be maximized
        options.addArguments("start-maximized");
        //set the driver to incognito mode(private)
        options.addArguments("incognito");
        //run the driver in headless mode
        //options.addArguments("headless");

        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options);//options variable should be passed here

        //lets create dynamic array to handle multiple borough on google search
        String[] boroughs = new String[5];
        boroughs[0] = "brooklyn";
        boroughs[1] = "Queens";
        boroughs[2] = "Manhattan";
        boroughs[3] = "Bronx";
        boroughs[4] = "Staten Island";

        for (int i = 0; i < boroughs.length; i++) {

            //let's navigate to google home page
            driver.navigate().to("https://google.com");
            //maximize my windows
            driver.manage().window().maximize();
            //put 3 second delays
            Thread.sleep(1000);
            //locate search field by name and enter a keyword on the search field
            driver.findElement(By.name("q")).sendKeys(boroughs[i]);
            //click on google search
            driver.findElement(By.name("btnK")).submit();//hitting enter is same as submit
            //delay to load search result page
            Thread.sleep(1000);
            //capture the search result text
            String result = driver.findElement(By.id("result-stats")).getText();
            String[] arrayResult = result.split(" ");
            //print out the search number
            System.out.println("My search number for " + boroughs[i] + " is " + arrayResult[1]);


        }//end of for loop
        driver.quit();//quiet driver process






    }//end of main method
}//end of class
