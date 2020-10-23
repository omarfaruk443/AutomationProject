package Day12_10102020;

import Reusable_Liabrary.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class TestNG_Assertions {
    @Test
    public void assertions() throws InterruptedException, IOException {
        WebDriver driver = Reusable_Methods.getDriver();

        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);


        //verify the google title using hard assert
        //Assert.assertEquals(driver.getTitle(),"GOOGle");


        //verify the google title using soft assert
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(),"GooGLE");



        //enter keyword on search
        Reusable_Methods.sendkeys(driver,"//*[@name='q']","Cars","Search Field");


        softAssert.assertAll();








    }



}
