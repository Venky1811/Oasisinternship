import java.util.Scanner;

class BankAccount {

    String name;
    String userName;
    String password;
    String accountNo;
    float balance = 100000f;
    int transactions = 0;
    StringBuilder transactionHistory = new StringBuilder();

    private Scanner scanner = new Scanner(System.in);

    public void register() {
        System.out.print("\nEnter Your Name - ");
        this.name = scanner.nextLine();
        System.out.print("\nEnter Your Username - ");
        this.userName = scanner.nextLine();
        System.out.print("\nEnter Your Password - ");
        this.password = scanner.nextLine();
        System.out.print("\nEnter Your Account Number - ");
        this.accountNo = scanner.nextLine();
        System.out.println("\nRegistration completed..kindly login");
    }

    public boolean login() {
        boolean isLogin = false;
        while (!isLogin) {
            System.out.print("\nEnter Your Username - ");
            String username = scanner.nextLine();
            if (username.equals(userName)) {
                while (!isLogin) {
                    System.out.print("\nEnter Your Password - ");
                    String passwordInput = scanner.nextLine();
                    if (passwordInput.equals(password)) {
                        System.out.print("\nLogin successful!!");
                        isLogin = true;
                    } else {
                        System.out.println("\nIncorrect Password");
                    }
                }
            } else {
                System.out.println("\nUsername not found");
            }
        }
        return isLogin;
    }

    public void withdraw() {
        System.out.print("\nEnter amount to withdraw - ");
        float amount = scanner.nextFloat();
        try {
            if (balance >= amount) {
                transactions++;
                balance -= amount;
                System.out.println("\nWithdraw Successfully");
                String str = amount + " Rs Withdrawn\n";
                transactionHistory.append(str);
            } else {
                System.out.println("\nInsufficient Balance");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deposit() {
        System.out.print("\nEnter amount to deposit - ");
        float amount = scanner.nextFloat();
        try {
            if (amount <= 100000f) {
                transactions++;
                balance += amount;
                System.out.println("\nSuccessfully Deposited");
                String str = amount + " Rs deposited\n";
                transactionHistory.append(str);
            } else {
                System.out.println("\nSorry...Limit is 100000.00");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void transfer() {
        scanner.nextLine(); // to consume the remaining newline character
        System.out.print("\nEnter Recipient's Name - ");
        String recipient = scanner.nextLine();
        System.out.print("\nEnter amount to transfer - ");
        float amount = scanner.nextFloat();
        try {
            if (balance >= amount) {
                if (amount <= 50000f) {
                    transactions++;
                    balance -= amount;
                    System.out.println("\nSuccessfully Transferred to " + recipient);
                    String str = amount + " Rs transferred to " + recipient + "\n";
                    transactionHistory.append(str);
                } else {
                    System.out.println("\nSorry...Limit is 50000.00");
                }
            } else {
                System.out.println("\nInsufficient Balance");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkBalance() {
        System.out.println("\n" + balance + " Rs");
    }

    public void transHistory() {
        if (transactions == 0) {
            System.out.println("\nEmpty");
        } else {
            System.out.println("\n" + transactionHistory);
        }
    }
}

public class AtmInterface {

    private static Scanner scanner = new Scanner(System.in);

    private static int takeIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;

        while (!flag) {
            try {
                input = scanner.nextInt();
                flag = true;

                if (input > limit || input < 1) {
                    System.out.println("Choose the number between 1 to " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter only an integer value");
                scanner.next(); // consume the invalid input
            }
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println("\n*********WELCOME TO SBI ATM SYSTEM*********\n");
        System.out.println("1.Register \n2.Exit");
        System.out.print("Enter Your Choice - ");
        int choice = takeIntegerInput(2);

        if (choice == 1) {
            BankAccount bankAccount = new BankAccount();
            bankAccount.register();
            while (true) {
                System.out.println("\n1.Login \n2.Exit");
                System.out.print("Enter Your Choice - ");
                int ch = takeIntegerInput(2);
                if (ch == 1) {
                    if (bankAccount.login()) {
                        System.out.println("\n\n**********WELCOME BACK " + bankAccount.name + " **********\n");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
                            System.out.print("\nEnter Your Choice - ");
                            int c = takeIntegerInput(6);
                            switch (c) {
                                case 1:
                                    bankAccount.withdraw();
                                    break;
                                case 2:
                                    bankAccount.deposit();
                                    break;
                                case 3:
                                    bankAccount.transfer();
                                    break;
                                case 4:
                                    bankAccount.checkBalance();
                                    break;
                                case 5:
                                    bankAccount.transHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}
