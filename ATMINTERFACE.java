import java.util.Scanner;

public class ATMINTERFACE {
    private double accountBalance;

    ATMINTERFACE(double initialBalance) {
        this.accountBalance = initialBalance;
    }

    public void withdraw(double amount) {
        if (amount > 0.0 && amount <= this.accountBalance) {
            this.accountBalance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + this.accountBalance);
        } else {
            System.out.println("Insufficient funds. Cannot withdraw.");
        }

    }

    public void deposit(double amount) {
        if (amount > 0.0) {
            this.accountBalance += amount;
            System.out.println("Deposit successful. New balance: $" + this.accountBalance);
        }

    }

    public double checkBalance() {
        return this.accountBalance;
    }

    public static void main(String[] args) {
        ATMINTERFACE atm = new ATMINTERFACE(5000);
        Scanner scanner = new Scanner(System.in);

        while(true) {
            while(true) {
                System.out.println("Choose an option:");
                System.out.println("1. Withdraw");
                System.out.println("2. Deposit");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.println("Current balance: $" + atm.checkBalance());
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }
}
