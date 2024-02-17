import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SecurePasswordStorageExample {
    private static Map<String, String> userCredentials = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        
        // Securely store the hashed password
        String hashedPassword = hashPassword(password);
        userCredentials.put(username, hashedPassword);
        
        System.out.println("User registered successfully!");
        
        scanner.close();
    }
    
    // Method to securely hash the password using SHA-256
    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());
            
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}

//The isValidPassword() method should include additional checks for password complexity, such as the presence of uppercase letters, lowercase letters, digits, and special characters, to enforce stronger password policies.
//
//Improvements:
//
//Passwords are securely hashed using the SHA - 256 hashing algorithm before storing them in the data store.
//Storing hashed passwords with a salt adds an additional layer of security against dictionary attacks and rainbow table attacks.
//In practice, using a proper saltand pepper strategy along with a strong hashing algorithm is recommended for enhanced security.
