package day3_09062020;

public class reusable_method_test1 {
    public static void add(int a, int b){//this is to add a method indivitually for adding codes

        System.out.println("My result of (a+b) is " + (a+b));

        //this wil be executed in method execution class
    }//end of add method





    public static void substraction(int a, int b, int c){
        System.out.println(" result of (a-b-c) is " + (a-b-c));
    }//end of substraction method







    public static int returnAdd(int a, int b){
        int adl = a+b;
        System.out.println("my result is " + adl);
        return adl;
    }//end of returnadd method
}
