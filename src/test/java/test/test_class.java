package test;

public class test_class {
    public static void main(String[] args) {
        String[] city = new String[4];//setting boundary for array value
        city[0] = "Brooklyn";
        city[1] = "queens";
        city[2] = "Manhattan";
        city[3] = "Staten island";

        for (int i = 0; i < city.length; i++) {
            if (city[i] == "Manhattan") {
                System.out.println("city is " + city[i]);
            }//end of if for Manhattan

            if (city[i] == "Brooklyn") {
                System.out.println("city is " + city[i]);
            }//end of if for Brooklyn
        }//end of for loop
    }//end of main

}//end of class
