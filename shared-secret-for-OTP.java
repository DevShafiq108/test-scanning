import java.util.Scanner;

public class SharedSecretOTPExample {
    private static final String sharedSecret = "MySecret123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your one-time password: ");
        String userPassword = scanner.nextLine();

        // Issue: The shared secret is hardcoded, making it vulnerable if exposed in the source code
        if (validateOneTimePassword(userPassword)) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed!");
        }

        scanner.close();
    }

    // Issue: The shared secret is hardcoded, making it vulnerable if exposed in the source code
    private static boolean validateOneTimePassword(String userPassword) {
        // Issue: The shared secret is hardcoded, making it vulnerable if exposed in the source code
        String encryptedNonce = encryptWithSharedSecret(userPassword);
        return encryptedNonce.equals(encryptWithSharedSecret(sharedSecret));
    }

    // Issue: The shared secret is hardcoded, making it vulnerable if exposed in the source code
    private static String encryptWithSharedSecret(String data) {
        // Issue: A secure encryption algorithm is not implemented in this example
        // (Encryption should use a strong cryptographic algorithm and follow best practices)
        return data; // Placeholder for demonstration purposes
    }
}

//Explanation of Issues :
//
//The shared secret is hardcoded, making it vulnerable if exposed in the source code.
//The example uses a simple placeholder for encryption, and a secure encryption algorithm is not implemented.

// See this improvement:
 private static String encryptWithSharedSecret(String data) {
        try {
            // Convert shared secret to bytes
            byte[] keyBytes = sharedSecret.getBytes("UTF-8");
            SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");

            // Initialize AES cipher in encryption mode
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Encrypt the data
            byte[] encryptedBytes = cipher.doFinal(data.getBytes("UTF-8"));

            // Convert encrypted bytes to base64 string for easier storage and transmission
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
