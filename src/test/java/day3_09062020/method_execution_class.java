package day3_09062020;

public class method_execution_class {
    public static void main(String[] args) {
        reusable_method_test1.add(100,250);

        reusable_method_test1.substraction(2000,1000,500);

        int number = reusable_method_test1.returnAdd(100,200);
        System.out.println("return value result plus 200 = " + (number+200));
    }
}
