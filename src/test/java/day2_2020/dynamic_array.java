package day2_2020;

public class dynamic_array {
    public static void main(String[] args) {
        //dynamic array example with string data
        String[] zipcode = new String[5];//defying and setting boundary for array values
        zipcode[0] = "11417";
        zipcode[1] = "11418";
        zipcode[2] = "11419";
        zipcode[3] = "11420";
        zipcode[4] = "brooklyn";
        System.out.println("my last zipcode place  is \n " + zipcode[4]);

        //dynamic array example with integer data
        int[] checkamount = new int [5];
        checkamount[0] = 1000;
        checkamount[1] = 2000;
        checkamount[2] = 3000;
        checkamount[3] = 4000;
        checkamount[4] = 5000;
        System.out.println("my last 2 month check amount is " + (checkamount[4] + checkamount[3]));



    }//end of main method
}
