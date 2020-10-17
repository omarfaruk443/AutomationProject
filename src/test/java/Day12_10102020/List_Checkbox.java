package Day12_10102020;

import Reusable_Liabrary.Reusable_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class List_Checkbox {
    @Test
    public void verifications() throws InterruptedException, IOException {
        WebDriver driver = Reusable_Methods.getDriver();

        //navigate to yahoo page
        Reusable_Methods.navigate(driver, "https://www.yahoo.com", "Yahoo Home Page");
        Thread.sleep(2000);
        //get the count of all links in  yahoo home page
        List<WebElement> linkCount = driver.findElements(By.xpath("//*[@class='_yb_5coqv']"));
        //print link count
        System.out.println("Link Count Is " + linkCount.size());

        //click on sign in button
        Reusable_Methods.click(driver, "//*[@class='_yb_687jt']", "Sign In Button");
        Thread.sleep(3000);
        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        //expecting checkbox is selected
        if (checkboxState == true) {
            System.out.println("CheckBox is selected ");
        } else {
            System.out.println("CheckBox is Not selected ");
        }//end of if else

    }//end of test method

}//end of class
