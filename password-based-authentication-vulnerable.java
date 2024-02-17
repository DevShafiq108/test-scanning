import java.util.Scanner;

public class PasswordAuthenticationExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String storedPassword = "password123";
        
        System.out.print("Enter your password: ");
        String userInput = scanner.nextLine();
        
        // Issue: Insecure storage of the password and simple password used.
        if (userInput.equals(storedPassword)) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed!");
        }
        
        scanner.close();
    }
    // Issue: Insecure storage of the password and simple password used.
}

//Explanation of Issues :
//
//The password is stored in plain text, making it vulnerable to theft if the system is compromised.
//The use of a simple, easily guessable password(password123) makes it susceptible to brute force attacks.
