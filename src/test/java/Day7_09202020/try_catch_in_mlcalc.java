package Day7_09202020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class try_catch_in_mlcalc {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); //set the chrome driver location
        ChromeOptions options = new ChromeOptions();//setting the chrome options before defining the driver
        options.addArguments("start-maximized");//set the driver to be maximized
        options.addArguments("incognito");//set the driver to incognito mode(private)
        //options.addArguments("headless");//run the driver in headless mode
        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options);//options variable should be passed here

        driver.navigate().to("https://mlcalc.com");//navigate to mlcalc website
        Thread.sleep(2000);//2 second delay

        //clear and enter purchase price
        try {
            WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
            pPrice.clear();
            pPrice.sendKeys("400000");
        } catch (Exception err) {
            System.out.println("unable to enter value on purchase price " +err);
        }//end of purchase price exception

        //clear and enter down payment
        try {
            WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
            dPayment.clear();
            dPayment.sendKeys("40");
        } catch (Exception err) {
            System.out.println("unable to enter value on down payment " +err);
        }//end of down payment exception

        //select a start month
        try {
            WebElement startMonth = driver.findElement(By.xpath("//*[@name='sm']"));
            Select smList = new Select(startMonth);
            smList.selectByVisibleText("Feb");
        } catch (Exception err) {
            System.out.println("unable to select a month" +err);
        }//end of start month exception

        //click on calculate button
        try {
            driver.findElement(By.xpath("//*[@alt='Calculate']")).click();
        } catch (Exception err) {
            System.out.println("unable to click on calculate button " +err);
        }//end of calculator exception


    }
}
