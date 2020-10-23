package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.regex.Pattern;

public class AI2_OmarFaruk_extra {
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

        //lets create dynamic array to handle multiple hobbies on bing search
        String[] hobby = new String[5];
        hobby[0] = "cooking";
        hobby[1] = "driving";
        hobby[2] = "travelling";
        hobby[3] = "computing";
        hobby[4] = "eating";

        for (int i = 0; i < hobby.length; i++) {

            //let's navigate to yahoo home page
            driver.navigate().to("https://yahoo.com");
            //maximize my windows
            driver.manage().window().maximize();
            //put 3 second delays
            //Thread.sleep(3000);
            //print when the system navigating to yahoo
            System.out.println("navigating to yahoo");
            //locate search field by name and enter a keyword on the search field
            driver.findElement(By.name("p")).sendKeys(hobby[i]);
            //print that I'm inputting my hobby in yahoo search bar
            System.out.println("Inputtting my hobby in yahoo search bar which is (" + hobby[i] + ")");
            //click on yahoo search button or submit
            driver.findElement(By.className("ybar-mod-searchbox-fr")).submit();//submit is same as hitting enter (couldn't click)
            //delay to load search result page
            //Thread.sleep(2000);
            //print when it's submitted
            System.out.println("submitted");
            //scroll down all the way to bottom
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            //5 seconds delay
            Thread.sleep(5000);
            //print when it's scrolled down all the way to the bottom
            System.out.println("scrolled down");
            //capture the search result text
            String result = driver.findElement(By.className("compPagination")).getText();
            String[] arrayresult = result.split("Next");
            //print out the search number
                System.out.println("Total search number for my hobbby (" + hobby[i] + ") is " + arrayresult[1]);
        }//end of for loop
        driver.quit();//quiet driver process






    }//end of main method
}//end of class
