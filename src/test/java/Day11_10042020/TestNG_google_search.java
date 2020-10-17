package Day11_10042020;

import Reusable_Liabrary.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestNG_google_search {
    //call beforesuit to set your chromedriver
    //precondition
    //driver needs to be initialized outside so it can be reusable
    WebDriver driver;

    @BeforeSuite
    public void setChromeDriver() throws IOException, InterruptedException {
        driver = Reusable_Methods.getDriver();
    }//end of before suit

    @Test(priority = 1)
    public void searchKeyword() throws InterruptedException {
        Reusable_Methods.navigate(driver,"https://www.google.com","Google");
        Thread.sleep(2000);
        Reusable_Methods.sendkeys(driver,"//*[@name='q']","Cars","Search Field");
        Reusable_Methods.submit(driver,"//*[@name='btnK']","Search button");
        Thread.sleep(2000);
    }//end of test 1

    @Test(priority = 2)
    public void getSearchResult(){
        String result = Reusable_Methods.getText(driver,"//*[@id='result-stats']","Result");
        System.out.println("My search reslt is " + result);
    }//end of test 2


    @AfterSuite
    public  void closeDriver(){
        driver.quit();
    }//end of after suit


}//end of java class
