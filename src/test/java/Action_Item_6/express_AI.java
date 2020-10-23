package Action_Item_6;

import Reusable_Liabrary.Abstract_Class;
import Reusable_Liabrary.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class express_AI extends Abstract_Class {
    @Test
    public void navigate() throws InterruptedException, IOException, BiffException, WriteException {
        //Step 1: locate the Readable excel workbook
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/express_ai.xls"));
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/express_ai_results.xls"),readableFile);
        //Step 4: define the writable sheet for writable file
        WritableSheet writableSheet = writableFile.getSheet(0);
        //Step 5: get the count of the rows that are not empty on your excel workbook
        int rowCount = writableSheet.getRows();

        //putting test steps into for loop
        for (int i = 1; i < rowCount; i++) {
            String size = writableSheet.getCell(0,i).getContents();
            String quantity = writableSheet.getCell(1,i).getContents();
            String firstName = writableSheet.getCell(2,i).getContents();
            String lastName = writableSheet.getCell(3,i).getContents();
            String email = writableSheet.getCell(4,i).getContents();
            String phoneNumber = writableSheet.getCell(5,i).getContents();
            String address = writableSheet.getCell(6,i).getContents();
            String zipCode = writableSheet.getCell(7,i).getContents();
            String city = writableSheet.getCell(8,i).getContents();
            String state = writableSheet.getCell(9,i).getContents();
            String cardNumber = writableSheet.getCell(10,i).getContents();
            String expireMonth = writableSheet.getCell(11,i).getContents();
            String expireYear = writableSheet.getCell(12,i).getContents();
            String cvv = writableSheet.getCell(13,i).getContents();







            //delete all cookies before navigating to this page
            driver.manage().deleteAllCookies();
            //Step-1:navigate to EXPRESS.COM
            Reusable_Methods_Loggers.navigate(driver, "https://www.express.com", logger, "EXPRESS.COM ");
            Thread.sleep(2000);
            //Step-2:verify the Page Title contains "Men's and Women's Clothing"
            Reusable_Methods_Loggers.getTitleContains(driver, "Men's and Women's Clothing", logger, "EXPRESS.COM ");
            Thread.sleep(3000);
            //Step-3:hover over mens tab
            Reusable_Methods_Loggers.mouseHover(driver, "//*[(@href='/mens-clothing')]", logger, "Mens Tab ");
            Thread.sleep(3000);
            //Step-4:Click on Shirts link
            Reusable_Methods_Loggers.click(driver, "//*[contains(@href,'mens-clothing/shirts/cat410008')]", logger, "Shirts ");
            Thread.sleep(5000);
            //Step-5:Scroll Down
            Reusable_Methods_Loggers.scrollDown(driver, 200, logger);
            //Step-6:click on 3rd image
            Reusable_Methods_Loggers.clickByIndex(driver, "//*[@class='_1ddDj _136PD']", 2, logger, "3rd Image ");
            //click on express view
            //Reusable_Methods_Loggers.mouseClick(driver,"//button[contains(@class,'_1KV5Y')]",logger,"express view ");
            //Step-7:wait few second
            Thread.sleep(6000);
            //scroll down
            Reusable_Methods_Loggers.scrollDown(driver, 300, logger);
            //Step-8:click on size
            Reusable_Methods_Loggers.click(driver,"//*[@value='"+size+"']",logger,"Size "+size+" ");
            //Step-9:click on add to bag button
            Reusable_Methods_Loggers.click(driver,"//*[contains(text(),'Add to Bag')]",logger,"Add to Bag ");
            Thread.sleep(1000);
            //scroll up
            Reusable_Methods_Loggers.scrollUp(driver,-200,logger);
            //move to shopping bag
            Reusable_Methods_Loggers.mouseHoverByIndex(driver,"//*[@aria-label='modal']",2,logger,"Shopping Bag ");
            Thread.sleep(2000);
            //click on view bag and check out
            Reusable_Methods_Loggers.mouseClick(driver,"//*[contains(text(),'View Bag & Check Out')]",logger,"Checkout ");
            Thread.sleep(4000);
            //Step-11:select quantity from dropdown menu
            Reusable_Methods_Loggers.dropDownMenu(driver,"//*[@id='qdd-0-quantity']",quantity,logger,"Quantity ");
            Thread.sleep(500);
            //scroll down
            Reusable_Methods_Loggers.scrollDown(driver,500,logger);
            //click on checkout
            Reusable_Methods_Loggers.click(driver,"//*[@id='continue-to-checkout' or @aria-label='Continue to Checkout' or @alt='CHECKOUT BUTTON' or @class='granify-cta-message']",logger,"CHECKOUT ");
            Thread.sleep(1000);
            Reusable_Methods_Loggers.click(driver,"//*[contains(text(),'Checkout as Guest')]",logger,"Checkout as Guest ");
            Thread.sleep(5000);
            //let's input first name, last name, email, confirm email and phone number
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='firstname']",firstName,logger,"First Name ");
            Thread.sleep(250);
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='lastname']",lastName,logger,"last Name ");
            Thread.sleep(250);
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='email']",email,logger,"email ");
            Thread.sleep(250);
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='confirmEmail']",email,logger,"Confirm Email ");
            Thread.sleep(250);
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='phone']",phoneNumber,logger,"phone Number ");
            Thread.sleep(250);
            //click on continue button
            Reusable_Methods_Loggers.click(driver,"//*[contains(text(),'Continue')]",logger,"Continue ");
            Thread.sleep(2000);
            //scroll little bit
            Reusable_Methods_Loggers.scrollDown(driver,200,logger);
            //input address, zip, city, state,
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='shipping.line1']",address,logger,"address ");
            Thread.sleep(250);
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='shipping.postalCode']",zipCode,logger,"zipCode ");
            Thread.sleep(250);
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='shipping.city']",city,logger,"city ");
            Thread.sleep(250);
            Reusable_Methods_Loggers.selectByVisibleText(driver,"//*[@name='shipping.state']",state,logger,"State ");
            Thread.sleep(250);
            //scroll little bit
            Reusable_Methods_Loggers.scrollDown(driver,600,logger);
            //click on continue button twice
            Reusable_Methods_Loggers.click(driver,"//*[contains(text(),'Continue')]",logger,"Continue ");
            Thread.sleep(3000);
            Reusable_Methods_Loggers.click(driver,"//*[contains(text(),'Continue')]",logger,"Continue ");
            Thread.sleep(3000);
            //scroll little bit
            //Reusable_Methods_Loggers.scrollDown(driver,600,logger);
            //input card number, expire month, expire year and cvv
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='creditCardNumber']",cardNumber,logger,"credit Card Number ");
            Thread.sleep(250);
            Reusable_Methods_Loggers.selectByVisibleText(driver,"//*[@name='expMonth']",expireMonth,logger,"expire month  ");
            Thread.sleep(250);
            Reusable_Methods_Loggers.selectByVisibleText(driver,"//*[@name='expYear']",expireYear,logger,"expire year ");
            Thread.sleep(250);
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='cvv']",cvv,logger,"cvv ");
            Thread.sleep(250);
            Reusable_Methods_Loggers.click(driver,"//*[contains(text(),'Place Order')]",logger,"Place Order");
            Thread.sleep(3000);
            //scroll little bit
            //Reusable_Methods_Loggers.scrollUp(driver,-100,logger);
            //get the error message and capture it
            String result = Reusable_Methods_Loggers.captureText(driver,"//*[@id='rvn-note-NaN']",logger,"Error Message ");
            System.out.println("The error message I'm getting is  " + result);
            logger.log(LogStatus.INFO,"The error message I'm getting is  " + result);

            //store and send it to empty column is excel
            Label label = new Label(14,i,result);
            //adding this label to writable sheet
            writableSheet.addCell(label);
        }//end of for loop




        //you writing back to workbook(excel file) only once
        writableFile.write();
        writableFile.close();

    }//end of test
}//end of class
