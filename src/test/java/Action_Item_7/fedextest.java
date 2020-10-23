package Action_Item_7;

import Reusable_Liabrary.Abstract_Class;
import Reusable_Liabrary.Reusable_Methods;
import Reusable_Liabrary.Reusable_Methods_Loggers;
import org.testng.annotations.Test;

import java.awt.*;

public class fedextest extends Abstract_Class {

    @Test
    public void fed() throws InterruptedException, AWTException {
        Reusable_Methods_Loggers.navigate(driver,"https://www.fedex.com/apps/printonline/#!upload/multiple/pid%3D1456773326927/false",logger,"fedex checkout");
        Thread.sleep(2000);

        //sometime there might be a popup, lets close it
        Reusable_Methods_Loggers.mouseClickPopUp(driver,"//area[contains(@alt,'close' or @alt,'no')]",logger,"PopUp");
        Thread.sleep(1000);

        //Step-8:click on Use Your file button
        Reusable_Methods_Loggers.click(driver,"//*[@name='upload-files-button']",logger,"Use Your file button");
        Thread.sleep(3000);

        //Step-9:upload my file
        Reusable_Methods_Loggers.uploadFile("C:\\Users\\oshuv\\Videos\\Captures\\file008.png",logger);
        Thread.sleep(25000);

        //sometime there might be a popup, lets close it
        Reusable_Methods_Loggers.mouseClickPopUp(driver,"//area[contains(@alt,'close' or @alt,'no')]",logger,"PopUp");
        Thread.sleep(1000);
        //Step-10:click on continue with existing
        Reusable_Methods_Loggers.popup(driver,"//*[contains(text(),'CONTINUE WITH EXISTING')]",logger,"Resulotion");
        Thread.sleep(2000);

        //sometime there might be a popup, lets close it
        Reusable_Methods_Loggers.mouseClickPopUp(driver,"//area[contains(@alt,'close' or @alt,'no')]",logger,"PopUp");
        Thread.sleep(1000);

        //Step-11:Change the Quantity to 5
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@class='quantity-field']","5",logger,"Quantity Box ");
        Thread.sleep(500);

        //Step-12:click on add to cart
        Reusable_Methods_Loggers.click(driver,"//*[contains(text(),'Add to cart')]",logger,"Add to cart ");
        Thread.sleep(2000);

        //Step-13:click on checkout
        Reusable_Methods_Loggers.click(driver,"//*[@onclick='javascript:setLinkView('Checkout');']",logger,"Checkout ");
        Thread.sleep(2000);

        //Step-14:click on PROCEED AS GUEST
        Reusable_Methods_Loggers.click(driver,"//*[@id='continueAsGuest']",logger,"PROCEED AS GUEST");
        Thread.sleep(2000);

        //Step-15:select on within 5 miles from dropdown menu
        Reusable_Methods_Loggers.dropDownMenu(driver,"//*[@id='radiusSelect']","5 Miles",logger,"PickUp Within");
        Thread.sleep(1000);
    }


}
