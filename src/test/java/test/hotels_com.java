package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class hotels_com {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); //set the chrome driver location
        ChromeOptions options = new ChromeOptions();//setting the chrome options before defining the driver
        options.addArguments("start-maximized");//set the driver to be maximized
        options.addArguments("incognito");//set the driver to incognito mode(private)
        //options.addArguments("headless");//run the driver in headless mode
        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options);//options variable should be passed here


        //set array list to input destination name in SearchBox
        ArrayList<String> searchboxList = new ArrayList<>();
        searchboxList.add("Hawaii");
        searchboxList.add("Las Vegas");
        searchboxList.add("Florida");

        //set array list to input Checkin Dates
        ArrayList<String> checkinList = new ArrayList<>();
        checkinList.add("30-03-2021");
        checkinList.add("05-01-2021");
        checkinList.add("25-05-2021");

        //set array list to input Checkout Dates
        ArrayList<String> checkoutList = new ArrayList<>();
        checkoutList.add("20-04-2021");
        checkoutList.add("25-01-2021");
        checkoutList.add("15-06-2021");



        for (int i = 0; i < searchboxList.size(); i++) {

            driver.navigate().to("https://www.hotels.com/");//navigate to hotels.com homepage
                Thread.sleep(2000);//put 2 second delay
                    System.out.println("Navigated To Hotels.com Homepage");



            //entering destination name on searchbox
            try {
                WebElement searchbox = driver.findElement(By.xpath("//*[@name='q-destination']"));
                    searchbox.clear();
                    searchbox.sendKeys(searchboxList.get(i));
                        Thread.sleep(2000);//put some delay
                            System.out.println("Entering Destination Name on SearchBox");
                }catch(Exception err){
                            System.out.println("Unable to enter Distination Name" +err);
                                    }//end of SearchBox Exception



            //click on first link from AutoSuggestion DropDown
            try {
                driver.findElements(By.xpath("//*[contains(@class,'autosuggest-category-result')]")).get(1).click();
                    Thread.sleep(3000);//put 3 second delay
                        System.out.println("Clicking on First Link from AutoSuggestion DropDown");
                }catch(Exception err){
                        System.out.println("Unable to click on suggestion list" +err);
                                    }//end of autosuggestion exception



            //enter CheckIn Date
            try {
                    //setting webElement variable to store my element and use it again
                    WebElement checkin = driver.findElement(By.xpath("//*[@name='q-localised-check-in']"));
                    checkin.click();//click on date field
                        Thread.sleep(1000);//put some delay
                    checkin.clear();//clear everything if there's a preset date
                        Thread.sleep(1000);//put some delay
                    checkin.sendKeys(checkinList.get(i));//Input CheckIn dates
                        Thread.sleep(2000);//put some delay
                            System.out.println("Entering CheckIn Dates");
                }catch (Exception err){
                        System.out.println("Unable to enter checkin date" +err);
                                    }//end of checkIn exception


            //enter CheckOut Dates
            try {
                    //setting webElement variable to store my element and use it again
                    WebElement checkout = driver.findElement(By.xpath("//*[@name='q-localised-check-out']"));
                    checkout.click();//click on date field
                        Thread.sleep(1000);//put some delay
                    checkout.clear();//clear everything if there's a preset date
                        Thread.sleep(1000);//put some delay
                    checkout.sendKeys(checkoutList.get(i));//Input CheckOut dates
                        Thread.sleep(2000);//put some delay
                            System.out.println("Entering CheckOut Dates");
            }catch (Exception err){
                System.out.println("Unable to enter checkout date" +err);
            }//end of CheckOut exception





        }//end of for loop


    }//end of main
}//end of class
