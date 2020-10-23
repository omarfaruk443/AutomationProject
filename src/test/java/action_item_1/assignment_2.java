package action_item_1;

public class assignment_2 {
    public static void main(String[] args) {
        String[] city = new String[4];//SETTING BOUNDARY FOR ARRAY VALUE
        city[0] = "Brooklyn";
        city[1] = "Queens";
        city[2] = "manhattan";
        city[3] = "staten";


        for (int i = 0; i < city.length; i++){

            if(city[i] == "Brooklyn"){
                System.out.println("my city is " + city[i]);
            }//end of if for brooklyn
            if(city[i] == "Manhattan"){
                System.out.println("my city is " + city[i]);
            }//end of if for Manhattan
        }//end of loop

    }//end of main method
}//end of class
