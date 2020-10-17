package action_item_2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AI2_OmarFaruk_Yahoo {
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

        //lets create dynamic array to handle multiple hobbies on bing search
        String[] hobby = new String[5];
        hobby[0] = "cooking";
        hobby[1] = "driving";
        hobby[2] = "travelling";
        hobby[3] = "computing";
        hobby[4] = "eating";

        for (int i = 0; i < hobby.length; i++) {

            //let's navigate to yahoo home page
            driver.navigate().to("https://www.yahoo.com");
            //maximize my windows
            driver.manage().window().maximize();
            //put 2 second delays
            Thread.sleep(2000);
            //locate search field by name and enter a keyword on the search field
            //driver.findElement(By.name("p")).sendKeys(hobby[i]);
            //click on bing search
            //driver.findElement(By.className("rapid-noclick-resp _yb_1em5b")).click();//submit is same as hitting enter (couldn't click)
            //delay to load search result page
            //Thread.sleep(2000);
            //scroll down all the way to bottom
            //JavascriptExecutor js = (JavascriptExecutor)driver;
            //js.executeScript("scrollBy(0, -9000)");
            //Thread.sleep(2000);
            driver.findElement(By.id("atomic")).sendKeys("PAGE_DOWN");
            //capture the search result text
            //String result = driver.findElement(By.className("sb_count")).getText();
            //String[] arrayResult = result.split(" ");
            //print out the search number
            //System.out.println("Total search number for my hobbby (" + hobby[i] + ") is " + arrayResult[0]);


        }//end of for loop
        driver.quit();//quiet driver process






    }//end of main method
}//end of class
