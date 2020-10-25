package Cucumber_Framework.Test_Runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//this refers to your step definitions class
@CucumberOptions(
        features = {"src/test/java/Cucumber_Framework/Feature_File/Google_Test_Cucumber.feature"},
        glue = {"Cucumber_Framework.Step_Definitions_2"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"}
)//array of arguments you are passing
public class GoogleRunner {
    //this is empty
}
