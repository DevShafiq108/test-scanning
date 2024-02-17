import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OneTimePasswordListExample {
    private static List<String> passwordList = new ArrayList<>();

    public static void main(String[] args) {
        initializePasswordList();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your one-time password: ");
        String userPassword = scanner.nextLine();

        // Issue: Passwords are stored in memory and can be reused if not properly managed
        if (validateOneTimePassword(userPassword)) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed!");
        }

        scanner.close();
    }

    // Issue: Passwords are stored in memory and can be reused if not properly managed
    private static void initializePasswordList() {
        for (int i = 0; i < 10; i++) {
            passwordList.add("OTP" + i);
        }
    }

    // Issue: Passwords are stored in memory and can be reused if not properly managed
    private static boolean validateOneTimePassword(String userPassword) {
        return passwordList.contains(userPassword);
    }
}

//Explanation of Issues :
//
//The password list is stored in memory, allowing potential reuse of passwords if not properly managed.
//There is no mechanism to ensure that passwords are used in order, as the user may enter any password from the list.
