package Action_Item_4;

import Reusable_Liabrary.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class UHC_ReUsableMethod {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); //set the chrome driver location
        ChromeOptions options = new ChromeOptions();//setting the chrome options before defining the driver
        options.addArguments("start-maximized");//set the driver to be maximized
        options.addArguments("incognito");//set the driver to incognito mode(private)
        //options.addArguments("headless");//run the driver in headless mode
        //defining the web driver that I will be using
        WebDriver driver = new ChromeDriver(options);//options variable should be passed here


        //Creating an ArrayList to input FirstName value
        ArrayList<String> firstNameList = new ArrayList<>();
        firstNameList.add("Donald");
        firstNameList.add("Barak");
        firstNameList.add("George");

        //Creating an ArrayList to input lastName value
        ArrayList<String> lastNameList = new ArrayList<>();
        lastNameList.add("Trump");
        lastNameList.add("Obama");
        lastNameList.add("Washington");

        //Creating an ArrayList to input dateOFBirth value
        ArrayList<String> dateOFBirthList = new ArrayList<>();
        dateOFBirthList.add("01031990");//mm/dd/yyyy
        dateOFBirthList.add("01021980");//mm/dd/yyyy
        dateOFBirthList.add("01051970");//mm/dd/yyyy

        //Creating an ArrayList to input SSN value
        ArrayList<String> ssnList = new ArrayList<>();
        ssnList.add("159515");//00-0000
        ssnList.add("369874");//00-0000
        ssnList.add("214789");//00-0000

        //Creating an ArrayList to input SSN value
        ArrayList<String> zipCodeList = new ArrayList<>();
        zipCodeList.add("11414");
        zipCodeList.add("11416");
        zipCodeList.add("11010");


        for (int i = 0; i < firstNameList.size(); i++) {
            //lets navigate to UHC.com
            Reusable_Methods.navigate(driver, "https://www.uhc.com", "UHC.COM ");
            Thread.sleep(2000);//put some delay

            //verify that the Home Page Title Contains Health insurance plans
            Reusable_Methods.getTitleContains(driver, "Health insurance plans", "UHC.com ");

            //click on find a doctor link
            Reusable_Methods.click(driver, "//*[text()='Find a Doctor']", "Find a Doctor ");
            Thread.sleep(1000);//put some delay

            //click on sign in to find a doctor
            Reusable_Methods.click(driver, "//*[@id='btn-sign-in']", "Sign in to Find a Provider ");
            Thread.sleep(4000);//put some delay

            //switch to new tab
            Reusable_Methods.switchtabs(driver, 1);
            //Thread.sleep(2000);//put some delay

            Reusable_Methods.click(driver, "//*[@id='registerbutton']", " Register Button ");
            Thread.sleep(4000);//put some delay

            //input first Name
            Reusable_Methods.sendkeys(driver, "//*[@id='piFirstName']", firstNameList.get(i), "First Name ");
            Thread.sleep(500);//put some delay

            //input Last Name
            Reusable_Methods.sendkeys(driver, "//*[@id='piLastName']", lastNameList.get(i), "Last Name ");
            Thread.sleep(500);//put some delay

            //Input Date Of Birth
            Reusable_Methods.sendkeys(driver, "//*[@id='piDoB']", dateOFBirthList.get(i), "Date Of Birth ");
            Thread.sleep(500);//put some delay

            //clicking on No Member ID card
            Reusable_Methods.click(driver, "//*[@ng-value='regOptions.no']", " No Member ID Card ");
            Thread.sleep(500);//put some delay

            //enter last 6 digit of SSN
            Reusable_Methods.sendkeys(driver, "//*[@id='piSSN']", ssnList.get(i), "SSN ");
            Thread.sleep(500);//put some delay

            //enter zipcode
            Reusable_Methods.sendkeys(driver, "//*[@id='piZipCode']", zipCodeList.get(i), "ZipCode ");
            Thread.sleep(500);//put some delay

            //click on continue button
            Reusable_Methods.click(driver, "//*[@id='step1Btn']", "Continue Button ");
            Thread.sleep(5000);//put some delay

            //get the error message
            String error = Reusable_Methods.captureText(driver, "//*[@ng-if='isPageErrorExistent']", "Error Message ");
            System.out.println("Error Message = \n" + error);


            driver.close();//close the current tab
            //switch to the previous Tab
            Reusable_Methods.switchtabs(driver, 0);
            Thread.sleep(1000);
        }//end of for loop


        driver.quit();//quit the driver


    }//end of main
}//end of class
