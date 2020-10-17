package Action_item_3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class weightwatchers1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); //set the chrome driver location
        ChromeOptions options = new ChromeOptions();//setting the chrome options before defining the driver
        options.addArguments("start-maximized");//set the driver to be maximized
        options.addArguments("incognito");//set the driver to incognito mode(private)
        //options.addArguments("headless");//run the driver in headless mode
        //defining the web driver that I will be using
        WebDriver driver = new ChromeDriver(options);//options variable should be passed here


        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11563");
        zipCode.add("11010");
        zipCode.add("10040");



        for (int i = 0; i < zipCode.size(); i++) {
            //lets navigate to weight watchers home page
            driver.navigate().to("https://www.weightwatchers.com");
                Thread.sleep(1000);//put 3 second delay
                    System.out.println(" navigated to weight watchers home page");




            String actualTitle = driver.getTitle();
                String expectedTitle = "Weight Watchers: Weight Loss & Wellness Help";
                    System.out.println("Trying to verify Title of the Website with Expected Title");
            if (expectedTitle.equalsIgnoreCase(actualTitle)) {
                System.out.println("Title Matched");
            } else {
                System.out.println("Title didn't match. Actual title is  " + actualTitle);
            }//end of if_else statement





            //click on find a workshop
            try {
                driver.findElement(By.xpath("//*[@data-e2e-name='find_a workshop']")).click();
                    Thread.sleep(2500);//put 2 second delay
                        System.out.println("Clicking on 'find a workshop' ");
            } catch (Exception err) {
                        System.out.println("unable to click on find a workshop " + err);//print out error
            }//end of find a workshop exception





            //entering my zipcode
            try {
                driver.findElement(By.xpath("//*[@class='input input-3TfT5']")).sendKeys(zipCode.get(i));
                    Thread.sleep(2500);//put 2 second delay
                        System.out.println("Entering zipcode");
            } catch (Exception err) {
                System.out.println("unable to enter a zipcode " + err);//print out error
            }//end of zipcode exception





            //click on search arrow
            try {
                driver.findElement(By.xpath("//*[@class='rightArrow-daPRP']")).click();
                    Thread.sleep(2500);
                        System.out.println("clicking on search button");
                } catch (Exception err) {
                System.out.println("unable to click on search arrow " + err);
                                }//end of search exception




            //click on different studio link in different iteration
            try {
                if (i == 0) {
                    driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(1).click();
                            Thread.sleep(1000);//put 2 second delay
                                System.out.println("clicking on 2nd Studio link");
                }if (i == 1) {
                    driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(2).click();
                            Thread.sleep(1000);//put 2 second delay
                                System.out.println("clicking on 3rd Studio link");
                }if (i == 2) {
                    driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(0).click();
                        Thread.sleep(1000);//put 2 second delay
                            System.out.println("clicking on 1st Studio link");
                }//end of if else condition
            } catch (Exception err) {
                System.out.println("unable to click on studio link " + err);
            }//end of if else exception





            //capturing the entire address
            try {
                String adr = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();//putting d into a string variable
                    String[] adressfnl = adr.split("Studio");//need to split by studio to separate the address
                        System.out.println("Capturing full Address of this studio ");
                            System.out.println(" The address for the Studio is \n" + adressfnl[0]); //print out the address
                                Thread.sleep(1000);//put 1 second delay
            } catch (Exception err) {
                System.out.println("unable to capture address " + err);
            }//end of address exception





            //Scroll to the bottom of the page
            JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("scroll(0,1200)");//scroll down by using executeScript command
                    System.out.println("Scrolling Down");
                        Thread.sleep(1500);//put 2 second delay






            //capture tables with days and hours
            try {
                System.out.println("Capturing Days and Hours ");
                    String table = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
                        System.out.println("Days and Hours for this Studio address is \n \n " + table + "\n \n \n");
            } catch (Exception err) {
                    System.out.println("unable to capture tables with days and hour " + err);
            }//end of table exception




        }//end of for loop

    }//end of main method
}//end of class


