import java.util.Scanner;

public class InputValidationExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        
        // Issue: While this code validates the age entered by the user, it does not handle the case 
        // where the user enters non-integer input. This can lead to InputMismatchException or other 
        // unexpected behavior. Additionally, the program does not handle negative values gracefully, 
        // and it may also consider extremely high values (e.g., 1000) as valid ages.
        
        // Check if age is within a valid range
        if (age >= 0 && age <= 120) {
            System.out.println("Valid age entered: " + age);
        } else {
            System.out.println("Invalid age entered!");
        }
        scanner.close();
    }
}
