package Cucumber_Framework.Step_Definition_2;

import Reusable_Liabrary.Abstract_Class_Cucumber;
import Reusable_Liabrary.Reusable_Methods;
import Reusable_Liabrary.Reusable_Methods_Loggers;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class Google_Search_Result_Loop {
    WebDriver driver;
    @Given("^I am navigating to Google homepage$")
    public void Step1_navigateToGoogleHome() throws InterruptedException, IOException {
        driver = Reusable_Methods.getDriver();
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);
    }//end of navigate

    @When("^I am entering a keyword (.*) on search field$")
    public void Step2_googleSearchField(String City){
        Reusable_Methods.sendkeys(driver,"//*[@name='q']",City,"Search Field");
    }//end of search field

    @When("^I click on Search button$")
    public void Step3_googleSubmitButton(){
        Reusable_Methods.submit(driver,"//*[@name='btnK']","Search Field");
    }//end of submit button



}//end of Test
