package Day6_09192020;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class yahoo_with_xpath {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); //set the chrome driver location
        ChromeOptions options = new ChromeOptions();//setting the chrome options before defining the driver
        options.addArguments("start-maximized");//set the driver to be maximized
        options.addArguments("incognito");//set the driver to incognito mode(private)
        //options.addArguments("headless");//run the driver in headless mode
        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options);//options variable should be passed here

        driver.navigate().to("https://www.yahoo.com");//navigate to yahoo
            Thread.sleep(2000);//2 second delay
                System.out.println("navigating to yahoo");//print that its navigating to yahoo

        driver.findElement(By.xpath("//*[@name='p']")).sendKeys("cars");//Type a keyword on yahoo search field
            System.out.println("inputting my keyword on search bar ");//print if its happening
        driver.findElement(By.xpath("//*[@value='Search']")).click();//click on submit button
        Thread.sleep(3500);//2to3second delay
            System.out.println("submitted");//print that its happening

        JavascriptExecutor jse = (JavascriptExecutor)driver;//need to scroll to the bottom of the page to capture the search result
        jse.executeScript("scroll(0,6000)");//scroll down using executescript command
        String result = driver.findElement(By.xpath("//*[@class='compPagination']")).getText();//capture the entire footer including result from yahoo result page
        String[] arrayResult = result.split("Next");//need to split by Next to separate the search result
        String[] searchResult = arrayResult[1].split(" ");//need to split again only capture the number
        System.out.println("My Search Number is " + searchResult[0]);//print out the number you are looking for
        Thread.sleep(100);
        jse.executeScript("scroll(0,-6000)");


        //driver.quit();//quit the browser process


    }//end of main

}//end of class

