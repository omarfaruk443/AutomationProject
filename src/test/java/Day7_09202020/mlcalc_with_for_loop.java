package Day7_09202020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class mlcalc_with_for_loop {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); //set the chrome driver location
        ChromeOptions options = new ChromeOptions();//setting the chrome options before defining the driver
        options.addArguments("start-maximized");//set the driver to be maximized
        options.addArguments("incognito");//set the driver to incognito mode(private)
        //options.addArguments("headless");//run the driver in headless mode
        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options);//options variable should be passed here

        //set the value for purchase price array list
        ArrayList<String> pPriceList = new ArrayList<>();
        pPriceList.add("350000");
        pPriceList.add("400000");
        //set the value for purchase price array list
        ArrayList<String> dPaymentList = new ArrayList<>();
        dPaymentList.add("30");
        dPaymentList.add("50");




        //call the for loop to iterate through the array list
        for (int i = 0; i < pPriceList.size(); i++){
            driver.navigate().to("https://mlcalc.com");//navigate to mlcalc website
            Thread.sleep(2000);//2 second delay

            //clear and enter purchase price
            try {
                System.out.println("entering new value on purchase price");
                WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
                pPrice.clear();
                pPrice.sendKeys(pPriceList.get(i));
            } catch (Exception err) {
                System.out.println("unable to enter value on purchase price " +err);
            }//end of purchase price exception

            //clear and enter down payment
            try {
                System.out.println("entering new value on down payment");
                WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
                dPayment.clear();
                dPayment.sendKeys(dPaymentList.get(i));
            } catch (Exception err) {
                System.out.println("unable to enter value on down payment " +err);
            }//end of down payment exception

            //click on calculate button
            try {
                System.out.println("clicking on calculate");
                driver.findElement(By.xpath("//*[@alt='Calculate']")).click();
            } catch (Exception err) {
                System.out.println("unable to click on calculate button " +err);
            }//end of calculator exception

            //grab the total monthly payment
            try {
                System.out.println("capturing total monthly payment");
               String mntPayment = driver.findElements(By.xpath("//*[@class='big']")).get(0).getText();
               System.out.println("My monthly payment is " +mntPayment);

            } catch (Exception err) {
                System.out.println("unable to click on calculate button " +err);
            }//end of monthly payment exception

        }//end of for loop


    }//end of main
}//end of class
