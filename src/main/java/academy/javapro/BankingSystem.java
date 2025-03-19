package academy.javapro;

/**
 * Main class demonstrating the banking system functionality.
 * Creates and operates on different types of accounts using polymorphism.
 */
public class BankingSystem {

    public static void main(String[] args) {
        System.out.println("======= Banking System Demonstration =======\n");

        // Creates different types: accounts
        SavingsAccount savings = new SavingsAccount("SA001", "John Doe", 1000.0, 2.5);
        
        CheckingAccount checking = new CheckingAccount("CA001", "Jane Smith", 2000.0, 500.0);

        // Store accounts in an array to demonstrate polymorphism
        Account[] accounts = {savings, checking};

        // Display initial information for all accounts
        System.out.println("--- Initial Account Information ---");
        for (Account account : accounts) {
            account.displayInfo();
            System.out.println();
        }

        // Demonstrate account operations
        System.out.println("--- Performing Account Operations ---");

        // Test deposit operations
        System.out.println("\n1. Testing deposits:");
        savings.deposit(500.0);   // Deposit 500.0 into savings account
        checking.deposit(300.0);  // Deposit 300.0 into checking account

        // Test withdrawal operations
        System.out.println("\n2. Testing withdrawals:");
        savings.withdraw(1300.0); // Withdraw 1300.0 from savings account 
        savings.withdraw(200.0);  // Withdraw 200.0 from savings account (should fail due to minimum balance requirement)
        checking.withdraw(2500.0); // Withdraw 2500.0 from checking account (should go into overdraft)

        // Test account-specific operations
        System.out.println("\n3. Testing account-specific operations:");

        // Savings account - apply interest
        System.out.println("\nSavings Account - Applying interest:");
        savings.applyInterest();

        // Checking account - modify overdraft limit
        System.out.println("\nChecking Account - Modifying overdraft limit:");
        checking.setOverdraftLimit(1000.0);

        // Display updated information for all accounts
        System.out.println("\n--- Updated Account Information ---");
        for (Account account : accounts) {
            account.displayInfo();
            System.out.println();
        }

        // Display transaction history
        System.out.println("--- Transaction History ---");

        System.out.println("\nSavings Account Transactions:");
        for (String record : savings.getTransactionHistory()) {
            System.out.println(record);
        }

        System.out.println("\nChecking Account Transactions:");
        for (String record : checking.getTransactionHistory()) {
            System.out.println(record);
        }

        System.out.println("\n======= End of Banking System Demonstration =======");
    }
}
