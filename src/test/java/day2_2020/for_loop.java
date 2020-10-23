package day2_2020;

public class for_loop {
    public static void main(String[] args) {
        //dynamic array example with string data
        String[] zipcode = new String[5]; //defining and setting boundary for array values
        zipcode[0] = "11417";
        zipcode[1] = "11418";
        zipcode[2] = "11419";
        zipcode[3] = "11420";
        zipcode[4] = "11421";
        //iterate through all of zipcode data and print each one
        for (int a = 0;a < 5; a++) { //++ is same as +1
            //code goes here
            System.out.println("my zipcode is " + zipcode[a]);

            //i = i+1; // this is to skip specific index(s) from array
        }//end of for loop

    }//end of main method
}//end of class