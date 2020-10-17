package test;

import Reusable_Liabrary.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class testuhc {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); //set the chrome driver location
        ChromeOptions options = new ChromeOptions();//setting the chrome options before defining the driver
        options.addArguments("start-maximized");//set the driver to be maximized
        options.addArguments("incognito");//set the driver to incognito mode(private)
        options.addArguments("headless");//run the driver in headless mode
        //defining the web driver that I will be using
        WebDriver driver = new ChromeDriver(options);//options variable should be passed here


        //lets navigate to UHC.com
        Reusable_Methods.navigate(driver, "https://www.uhc.com", "UHC.COM");
        Thread.sleep(2000);//put some delay

        String rrrr = Reusable_Methods.getText(driver,"//*[@class='lg-display-inlineBlock mr-6']","display name");
        //String[] rtn = rrrr.split("");
        System.out.println(" " +rrrr);





    }
}

