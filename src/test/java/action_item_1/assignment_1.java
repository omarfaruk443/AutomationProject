package action_item_1;

public class assignment_1 {
    public static void main(String[] args) {
        int grade = 85;//inputting my grade in my exam
        if (grade >= 90 && grade <= 100){//if grade is between 90-100 print this ↓
            System.out.println("Grade is A");
        }//end of grade A if_statement
        else if (grade >= 80 && grade <= 89){//if grade is between 80-89 print this ↓
            System.out.println("Grade is B");
        }//end of grade B else_if_statement
        else if (grade >= 70 && grade <= 79){//if grade is between 70-79 print this ↓
            System.out.println("Grade is C");
        }//end of grade C else_if_statement
        else if (grade >= 60 && grade <= 69){//if grade is between 60-69 print this ↓
            System.out.println("Grade is D");
        }//end of grade D else_if_statement
        else{////if grade is less than 60 print this ↓
            System.out.println("Grade is F \nSorry, U failed this Test \nNext time, try to study harder");
        }//end of else_statement

    }//end of main method
}//end of class
