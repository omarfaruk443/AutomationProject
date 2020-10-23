package Action_Item_7;


import Reusable_Liabrary.Abstract_Class;
import Reusable_Liabrary.Abstract_Class_Cross_Browser;
import Reusable_Liabrary.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.awt.*;

public class FedEx_Ai extends Abstract_Class_Cross_Browser{

    @Test
    public void fedEx() throws InterruptedException, AWTException {
        //delete all cookies before navigating to this page
        driver.manage().deleteAllCookies();

        //Step-1:navigate to fedex
        Reusable_Methods_Loggers.navigate(driver,"https://www.fedex.com/en-us/home",logger,"FEDEX ");
        Thread.sleep(1000);

        //Step-2:click on design and print tab
        Reusable_Methods_Loggers.click(driver,"//*[contains(text(),'Design & Print')]",logger,"Design and Print TAB ");
        Thread.sleep(1000);

        //sometime there might be a popup, lets close it
        Reusable_Methods_Loggers.mouseClickPopUpByIndex(driver,"//*[@shape='rect']",0,logger,"PopUp");

        //Step-3:CLICK ON UPLOAD A PRINT READY FILE
        Reusable_Methods_Loggers.click(driver,"//*[@alt='Upload a Print-Ready File']",logger,"UPLOAD A PRINT READY FILE ");
        Thread.sleep(1000);

        //Step-4:verify title contains Fedex Office Print
        Reusable_Methods_Loggers.getTitleContains(driver,"FedEx Office Print",logger,"FEDEX PRINT ");

        //Step-5:sometime there might be a popup, lets close it
        Reusable_Methods_Loggers.mouseClickPopUpByIndex(driver,"//*[@shape='rect']",0,logger,"PopUp ");

        //Step-6:click on Document Printing image
        Reusable_Methods_Loggers.click(driver,"//*[@alt='Document Printing']",logger,"Document Printing ");
        Thread.sleep(1000);

        //sometime there might be a popup, lets close it
        Reusable_Methods_Loggers.mouseClickPopUpByIndex(driver,"//*[@shape='rect']",0,logger,"PopUp ");

        //Step-7:click on Copies & Custom Projects
        Reusable_Methods_Loggers.click(driver,"//*[@title='Copies & Custom Projects']",logger,"Copies & Custom Projects ");
        Thread.sleep(5000);

        //sometime there might be a popup, lets close it
        Reusable_Methods_Loggers.mouseClickPopUpByIndex(driver,"//*[@shape='rect']",0,logger,"PopUp");

        //Step-8:click on Use Your file button
        Reusable_Methods_Loggers.click(driver,"//*[@name='upload-files-button']",logger,"Use Your file button ");
        Thread.sleep(1000);

        //Step-9:upload my file
        Reusable_Methods_Loggers.uploadFile("C:\\Users\\oshuv\\Pictures\\Screenshot.png",logger);
        Thread.sleep(5000);

        //sometime there might be a popup, lets close it
        Reusable_Methods_Loggers.mouseClickPopUpByIndex(driver,"//*[@shape='rect']",0,logger,"PopUp");

        //Step-10:click on continue with existing
        Reusable_Methods_Loggers.popup(driver,"//*[contains(text(),'CONTINUE WITH EXISTING')]",logger,"Continue with existing  ");
        Thread.sleep(1000);

        //sometime there might be a popup, lets close it
        Reusable_Methods_Loggers.mouseClickPopUpByIndex(driver,"//*[@shape='rect']",0,logger,"PopUp");

        //Step-11:Change the Quantity to 5
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@class='quantity-field']","5",logger,"Quantity Box ");

        //sometime there might be a popup, lets close it
        Reusable_Methods_Loggers.mouseClickPopUpByIndex(driver,"//*[@shape='rect']",0,logger,"PopUp");

        //Step-12:click on add to cart
        Reusable_Methods_Loggers.click(driver,"//*[contains(text(),'Add to cart')]",logger,"Add to cart ");
        Thread.sleep(1000);

        //sometime there might be a popup, lets close it
        Reusable_Methods_Loggers.mouseClickPopUpByIndex(driver,"//*[@shape='rect']",0,logger,"PopUp");

        //Step-13:click on checkout
        Reusable_Methods_Loggers.click(driver,"//*[contains(text(),'Checkout')]",logger,"Checkout ");
        Thread.sleep(1000);

        //sometime there might be a popup, lets close it
        Reusable_Methods_Loggers.mouseClickPopUpByIndex(driver,"//*[@shape='rect']",0,logger,"PopUp");

        //Step-14:click on PROCEED AS GUEST
        Reusable_Methods_Loggers.click(driver,"//*[@id='continueAsGuest']",logger,"PROCEED AS GUEST ");
        Thread.sleep(1000);

        //sometime there might be a popup, lets close it
        Reusable_Methods_Loggers.mouseClickPopUpByIndex(driver,"//*[@shape='rect']",0,logger,"PopUp");

        //Step-15:select on within 5 miles from dropdown menu
        Reusable_Methods_Loggers.dropDownMenu(driver,"//*[@id='radiusSelect']","5 Miles",logger,"PickUp Within ");

        //sometime there might be a popup, lets close it
        Reusable_Methods_Loggers.mouseClickPopUpByIndex(driver,"//*[@shape='rect']",0,logger,"PopUp");

        //Step-16:enter zipcode
        Reusable_Methods_Loggers.typeAndSubmit(driver,"//*[@name='locSearchTxt']","11417",logger,"Zipcode ");

        //sometime there might be a popup, lets close it
        Reusable_Methods_Loggers.mouseClickPopUpByIndex(driver,"//*[@shape='rect']",0,logger,"PopUp");
        Reusable_Methods_Loggers.mouseClickPopUp(driver,"//*[@id='okErrorModalClose']",logger,"PopUp");

        //Step-17:get the first location, capture and print it
        String location = Reusable_Methods_Loggers.captureTextByIndex(driver,"//*[@class='location-list']",0,logger,"Location List ");
        //print the location
        System.out.println("The First Available address is " +location);
        logger.log(LogStatus.INFO,"The First Available address is " +location);















    }//end of test


}//end of class
