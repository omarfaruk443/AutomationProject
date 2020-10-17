package day4_09122020;

public class split_command {
    public static void main(String[] args) {
        //declare and define a string variable
        String message = "my name is john";
        //print out only the word john from the dtring message
        //by using split command
        String[] result =message.split(" ");
        //now print out the index for john
        System.out.println("my result is " + result[0] + " and " + result[3]);
    }//end of main method
}//end of java class
