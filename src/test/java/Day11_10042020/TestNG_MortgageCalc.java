package Day11_10042020;

import Reusable_Liabrary.Reusable_Methods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TestNG_MortgageCalc {

    //declare all the global variable outside
    WebDriver driver;
    Workbook readableFile;
    Sheet readableSheet;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;
    int rowCount;




    @BeforeSuite
    public void setDriver() throws IOException, BiffException, InterruptedException {
        //setting the chrome driver
        driver = Reusable_Methods.getDriver();

        //Step 1: locate the Readable excel workbook
        readableFile = Workbook.getWorkbook(new File("src/main/resources/mortgage_info.xls"));
        //Step 2: locate the excel sheet for this workbook
        readableSheet = readableFile.getSheet(0);
        //Step 3: make a copy to ReadableFile to write back to the excel so it doesn't corrupt the original file
        writableFile = Workbook.createWorkbook(new File("src/main/resources/mortgage_info_Results.xls"),readableFile);
        //Step 4: define the writable sheet for writable file
        writableSheet = writableFile.getSheet(0);
        //Step 5: get the count of the rows that are not empty on your excel workbook
        rowCount = writableSheet.getRows();
    }//end of Before Suite



    @Test
    public  void getMonthlyPayment() throws InterruptedException, WriteException {
        //all the test step have to go inside for loop
        for (int i = 1; i < rowCount; i++){
            //i need to get the content of the cell
            //column is hard coded and row is dynamic(i)
            String homeValue = writableSheet.getCell(0,i).getContents();
            String downPayment = writableSheet.getCell(1,i).getContents();
            String loanAmount = writableSheet.getCell(2,i).getContents();
            String startMonth = writableSheet.getCell(3,i).getContents();
            String startYear = writableSheet.getCell(4,i).getContents();

            //lets navigate to mortgage calculator website
            Reusable_Methods.navigate(driver,"https://www.mortgagecalculator.org","Mortgage Calculator ");
            Thread.sleep(2000);
            //enter home value
            Reusable_Methods.sendkeys(driver,"//*[@id='homeval']",homeValue,"Home Value ");
            //enter down payment
            Reusable_Methods.sendkeys(driver,"//*[@id='downpayment']",downPayment,"down payment ");
            //enter loan amount
            Reusable_Methods.sendkeys(driver,"//*[@id='loanamt']",loanAmount,"loan amount ");
            //select the month
            Reusable_Methods.selectByVisibleText(driver,"//*[@name='param[start_month]']",startMonth,"start month ");
            //enter the year
            Reusable_Methods.sendkeys(driver,"//*[@id='start_year']",startYear,"start year ");
            //click on calculate
            Reusable_Methods.click(driver,"//*[@value='Calculate']","Calculate");
            Thread.sleep(2000);

            //capture the month payment
            String result = Reusable_Methods.getText(driver,"//*[@class='left-cell']/following::h3[contains(text(),'$')]","Monthly Payment");
            System.out.println("My total monthly payment is " + result);

            //store and send it to empty column is excel
            Label label = new Label(5,i,result);
            //adding this label to writable sheet
            writableSheet.addCell(label);

        }//end of for loop

    }//end of test



    @AfterSuite
    public void closingInfo() throws IOException, WriteException {
        //you writing back to workbook(excel file) only once
        writableFile.write();
        writableFile.close();

        driver.quit();//quiet

    }//end of after suite





}//end of class
