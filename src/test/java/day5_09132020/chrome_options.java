package day5_09132020;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class chrome_options {
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
        options.addArguments("headless");

        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options);//options variable should be passed here
        //navigate to google page
        System.out.println("navigating to google home page");
        driver.navigate().to("https://www.google.com");
        //delay 2 second
        Thread.sleep(3000);

        //capture thge home page title and verify it matches the expected title
        //which is google
        String actualTitle = driver.getTitle();
        //verify it mattches the expected title
        if(actualTitle == "Google"){
            System.out.println("Title matches");
        }
        else {
            System.out.println("Title doesn't match. Actual title is " + actualTitle);
        }// end of if else conditional statement



        //quite the entire sesion
        //driver.quit();

    }//end of method
}//end of class
