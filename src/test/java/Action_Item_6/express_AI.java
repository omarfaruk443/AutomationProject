package Action_Item_6;

import Reusable_Liabrary.Abstract_Class;
import Reusable_Liabrary.Reusable_Methods_Loggers;
import org.testng.annotations.Test;

public class express_AI extends Abstract_Class {
    @Test
    public void navigate() throws InterruptedException {
        //delete all cookies before navigating to this page
        driver.manage().deleteAllCookies();
        //navigate to EXPRESS.COM
        Reusable_Methods_Loggers.navigate(driver,"https://www.express.com",logger,"EXPRESS.COM");
            Thread.sleep(2000);
        //verify the Page Title contains "Men's and Women's Clothing"
        Reusable_Methods_Loggers.getTitleContains(driver,"Men's and Women's Clothing",logger,"EXPRESS.COM");
            Thread.sleep(3000);
        //hover over mens tab
        Reusable_Methods_Loggers.mouseHover(driver,"//*[(@href='/mens-clothing')]",logger,"Mens Tab");
            Thread.sleep(3000);
        //

        //

        //


    }//end of test
}
