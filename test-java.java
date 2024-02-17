import java.util.Scanner;

public class VulnerableApp {

    // Vulnerability 1: SQL Injection
    public void searchUser(String username) {
        String query = "SELECT * FROM users WHERE username='" + username + "'";
        // Execute the SQL query
    }

    // Vulnerability 2: Cross-Site Scripting (XSS)
    public void displayMessage(String message) {
        System.out.println("<div>" + message + "</div>");
    }

    // Vulnerability 3: Deserialization vulnerability
    public Object deserialize(byte[] serializedObject) {
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(serializedObject);
            ObjectInputStream ois = new ObjectInputStream(bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static void main(String[] args) {
        VulnerableApp app = new VulnerableApp();
        Scanner scanner = new Scanner(System.in);

        // Test SQL injection vulnerability
        System.out.print("Enter username to search: ");
        String userSearch = scanner.nextLine();
        app.searchUser(userSearch);

        // Test XSS vulnerability
        System.out.print("Enter message to display: ");
        String userMessage = scanner.nextLine();
        app.displayMessage(userMessage);

        // Test Deserialization vulnerability
        System.out.print("Enter serialized object: ");
        String serializedObject = scanner.nextLine();
        byte[] serializedBytes = serializedObject.getBytes();
        app.deserialize(serializedBytes);

        scanner.close();
    }
}
