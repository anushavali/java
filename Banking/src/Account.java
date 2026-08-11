import java.util.*;

class Account {
    private int accountNumber;
    private String name;
    private double balance;
    private ArrayList<String> transactions;

    Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        transactions = new ArrayList<>();
        transactions.add("Account created with balance: " + balance);
    }

    int getAccountNumber() {
        return accountNumber;
    }

    String getName() {
        return name;
    }

    double getBalance() {
        return balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited: " + amount);
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            transactions.add("Withdrawn: " + amount);
            System.out.println("Amount withdrawn successfully.");
        }
    }

    void showDetails() {
        System.out.println("\nAccount Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }

    void showTransactions() {
        System.out.println("\nTransaction History:");

        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }
}

public class BankingSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Account> accounts = new ArrayList<>();

    static Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    static void createAccount() {
        System.out.print("Enter account number: ");
        int number = sc.nextInt();
        sc.nextLine();

        if (findAccount(number) != null) {
            System.out.println("Account already exists.");
            return;
        }

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial deposit: ");
        double balance = sc.nextDouble();

        if (balance < 0) {
            System.out.println("Invalid balance.");
            return;
        }

        accounts.add(new Account(number, name, balance));
        System.out.println("Account created successfully.");
    }

    static void deposit() {
        System.out.print("Enter account number: ");
        int number = sc.nextInt();

        Account account = findAccount(number);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        account.deposit(amount);
    }

    static void withdraw() {
        System.out.print("Enter account number: ");
        int number = sc.nextInt();

        Account account = findAccount(number);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        account.withdraw(amount);
    }

    static void viewAccount() {
        System.out.print("Enter account number: ");
        int number = sc.nextInt();

        Account account = findAccount(number);

        if (account == null) {
            System.out.println("Account not found.");
        } else {
            account.showDetails();
        }
    }

    static void checkBalance() {
        System.out.print("Enter account number: ");
        int number = sc.nextInt();

        Account account = findAccount(number);

        if (account == null) {
            System.out.println("Account not found.");
        } else {
            System.out.println("Current Balance: " + account.getBalance());
        }
    }

    static void transactionHistory() {
        System.out.print("Enter account number: ");
        int number = sc.nextInt();

        Account account = findAccount(number);

        if (account == null) {
            System.out.println("Account not found.");
        } else {
            account.showTransactions();
        }
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== BANKING SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. View Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. Transaction History");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    createAccount();
                    break;

                case 2:
                    viewAccount();
                    break;

                case 3:
                    deposit();
                    break;

                case 4:
                    withdraw();
                    break;

                case 5:
                    checkBalance();
                    break;

                case 6:
                    transactionHistory();
                    break;

                case 7:
                    System.out.println("Thank you for using the Banking System.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}