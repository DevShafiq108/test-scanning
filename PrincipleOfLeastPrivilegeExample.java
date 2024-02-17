public class PrincipleOfLeastPrivilegeExample {
    private int balance;

    // Method to deposit funds
    public void deposit(int amount) {
        // Check if user is authorized to perform the operation
        if (isAuthorized()) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Unauthorized operation!");
        }
    }

    // Method to check authorization
    private boolean isAuthorized() {
        // Issue: The isAuthorized() method always returns true, implying that everyone is authorized 
        // to perform the deposit operation. This violates the principle of least privilege, as it grants 
        // more access than necessary, potentially leading to unauthorized transactions.
        return true; // Vulnerability: Always returns true, giving everyone full access
    }
}
