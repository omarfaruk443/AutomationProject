package Action_Item_7;

import Reusable_Liabrary.Abstract_Class_Cross_Browser;
import Reusable_Liabrary.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.awt.*;

public class FedEx_Ai extends Reusable_Library.Abstract_Class {

    @Test
    public void fedEx() throws InterruptedException, AWTException {
        //delete all cookies before navigating to this page
        driver.manage().deleteAllCookies();
        //Step-1:navigate to fedex
        Reusable_Methods_Loggers.navigate(driver,"https://www.fedex.com/en-us/home",logger,"FEDEX");
            Thread.sleep(2000);

        //Step-2:click on design and print tab
        Reusable_Methods_Loggers.click(driver,"//*[contains(text(),'Design & Print')]",logger,"Design and Print TAB");
            Thread.sleep(2000);

        //Step-3:CLICK ON UPLOAD A PRINT READY FILE
        Reusable_Methods_Loggers.click(driver,"//*[@alt='Upload a Print-Ready File']",logger,"UPLOAD A PRINT READY FILE");
            Thread.sleep(5000);

        //Step-4:verify title contains Fedex Office Print
        Reusable_Methods_Loggers.getTitleContains(driver,"Fedex Office Print",logger,"FEDEX PRINT");
            Thread.sleep(2000);

        //Step-5:sometime there might be a popup, lets close it
        Reusable_Methods_Loggers.click(driver,"//*[@alt='close']",logger,"PopUp");
            Thread.sleep(1000);

        //Step-6:click on Document Printing image
        Reusable_Methods_Loggers.click(driver,"//*[@alt='Document Printing']",logger,"Document Printing");
            Thread.sleep(2000);
                //sometime there might be a popup, lets close it
                Reusable_Methods_Loggers.click(driver,"//*[@alt='close']",logger,"PopUp");
                    Thread.sleep(1000);

        //Step-7:click on Copies & Custom Projects
        Reusable_Methods_Loggers.click(driver,"//*[@title='Copies & Custom Projects']",logger,"Copies & Custom Projects");
            Thread.sleep(2000);
                //sometime there might be a popup, lets close it
                Reusable_Methods_Loggers.click(driver,"//*[@alt='close']",logger,"PopUp");
                    Thread.sleep(1000);

        //Step-8:click on Use Your file button
        Reusable_Methods_Loggers.click(driver,"//*[@name='upload-files-button']",logger,"Use Your file button");
            Thread.sleep(2000);

        //Step-9:upload my file
        Reusable_Methods_Loggers.uploadFile("C:/Users/oshuv/Videos/Captures/Zoom Meeting 10_18_2020 11_34_38 AM.png");
            Thread.sleep(2000);

        //Step-10:click on continue with existing
        Reusable_Methods_Loggers.popup(driver,"//*[text(),'CONTINUE WITH EXISTING']",logger,"Resulotion");
            Thread.sleep(2000);

        //Step-11:Change the Quantity to 5
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@class='quantity-field']","5",logger,"Quantity Box");
            Thread.sleep(500);

        //Step-12:click on add to cart
        Reusable_Methods_Loggers.click(driver,"//*[text(),'Add to cart']",logger,"Add to cart");
            Thread.sleep(4000);

        //Step-13:click on checkout
        Reusable_Methods_Loggers.click(driver,"//*[text(),'Checkout']",logger,"Checkout");
            Thread.sleep(2000);

        //Step-14:click on PROCEED AS GUEST
        Reusable_Methods_Loggers.click(driver,"//*[@id='continueAsGuest']",logger,"PROCEED AS GUEST");
            Thread.sleep(2000);

        //Step-15:select on within 5 miles from dropdown menu
        Reusable_Methods_Loggers.dropDownMenu(driver,"//*[@id='radiusSelect']","5 Miles",logger,"PickUp Within");
            Thread.sleep(1000);

        //Step-16:enter zipcode
        Reusable_Methods_Loggers.typeAndSubmit(driver,"//*[@name='locSearchTxt']","11417",logger,"Zipcode");
            Thread.sleep(4000);

        //Step-17:get the first location, capture and print it
        String location = Reusable_Methods_Loggers.captureTextByIndex(driver,"//*[@class='location-list']",0,logger,"Location List");
            //print the location
            System.out.println("The First Available address is " +location);
            logger.log(LogStatus.INFO,"The First Available address is " +location);















    }//end of test


}//end of class
