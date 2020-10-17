package day3_09062020;

public class multiple_conditon {
    public static void main(String[] args) {
        int a = 1000;
        int b = 3000;
        int c = 1500;
        if((a+b) == c){
            System.out.println("sum of a & b is equal to c  ");
        }
        else if ((a+b) < c){
            System.out.println("sum of a & b is less than c ");
        }
        else if ((b-a) > c){
            System.out.println("subtraction of b & a is greater than c");
        }
        else if ((a+c) > b){
            System.out.println("sum of a and c is greater than b ");
        }
        else{
            System.out.println("u are very bad in math :P");
        }

    }
}
