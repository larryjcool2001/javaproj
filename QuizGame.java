// // Declare a variable to store a score and print it
// public class unit1 {    
//     public static void main(String[] args) {
//         int score = 85;
//         System.out.println("Your score is: " + score);
//     }
// }




// // Declare a variable to store am integer a and print it
// public class unit1 {    
//     public static void main(String[] args) {
//         int a = 5 + 3 * 2;
//         System.out.println("The value of a is: " + a);
//     }
// }



// // Evaluate a boolean expression and store the result   
// public class unit1 {    
//     public static void main(String[] args) {
//     boolean result = true || false && false;
//     System.out.println("The value of result is: " + result);
    
//     }
// }



// // Evaluate a boolean expression and store the result   
// public class unit1 {    
//     public static void main(String[] args) {
//     boolean result = (true || false) && false;
//     System.out.println("The value of result is: " + result);
    
//     }
// }



// // // Use an if-else statement to check if a score is passing or failing
// public class unit1 {      
//     public static void main(String[] args) {
//         int score = 85;
//         if (score >= 50) {
//             System.out.println("Pass");
//         } else {
//             System.out.println("Fail");
//         }           
//     }
// }


import java.util.Scanner;  // Import Scanner for user input

public class QuizGame {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int score = 0;  // Keeps track of correct answers
        char answer;

        System.out.println("===== WELCOME TO THE JAVA QUIZ GAME =====\n");

        // ---------- QUESTION 1 ----------
        System.out.println("1. Which keyword is used to create a class in Java?");
        System.out.println("A. function");
        System.out.println("B. class");
        System.out.println("C. define");
        System.out.println("D. object");
        answer = getValidInput(input);

        if (answer == 'B') {
            score++;
        }

        // ---------- QUESTION 2 ----------
        System.out.println("\n2. Which data type is used to store decimal numbers?");
        System.out.println("A. int");
        System.out.println("B. char");
        System.out.println("C. double");
        System.out.println("D. boolean");
        answer = getValidInput(input);

        switch (answer) {
            case 'C':
                score++;
                break;
        }

        // ---------- QUESTION 3 ----------
        System.out.println("\n3. Which symbol is used to end a statement in Java?");
        System.out.println("A. :");
        System.out.println("B. ;");
        System.out.println("C. .");
        System.out.println("D. ,");
        answer = getValidInput(input);

        if (answer == 'B') {
            score++;
        }

        // ---------- QUESTION 4 ----------
        System.out.println("\n4. Which loop is guaranteed to run at least once?");
        System.out.println("A. for loop");
        System.out.println("B. while loop");
        System.out.println("C. do-while loop");
        System.out.println("D. foreach loop");
        answer = getValidInput(input);

        switch (answer) {
            case 'C':
                score++;
                break;
        }

        // ---------- QUESTION 5 ----------
        System.out.println("\n5. Which method is the entry point of a Java program?");
        System.out.println("A. start()");
        System.out.println("B. run()");
        System.out.println("C. main()");
        System.out.println("D. init()");
        answer = getValidInput(input);

        if (answer == 'C') {
            score++;
        }

        // ---------- FINAL SCORE ----------
        double percentage = (score / 5.0) * 100;

        System.out.println("\n===== QUIZ COMPLETED =====");
        System.out.println("Correct Answers: " + score + "/5");
        System.out.println("Final Score: " + percentage + "%");

        input.close();
    }

    // ---------- INPUT VALIDATION METHOD ----------
    public static char getValidInput(Scanner input) {
        char ans;
        while (true) {
            System.out.print("Enter your answer (A, B, C, or D): ");
            ans = input.next().toUpperCase().charAt(0);

            if (ans == 'A' || ans == 'B' || ans == 'C' || ans == 'D') {
                break;
            } else {
                System.out.println("Invalid input. Please enter A, B, C, or D.");
            }
        }
        return ans;
    }
}
