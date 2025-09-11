import java.util.Scanner;

// Account Class

class Account 
{
    int accountNumber;
    String accountHolderName;
    double balance;
    String email;
    String phoneNumber;

    public Account(int accNo, String name, double initialBalance, String mail, String phone) 
	{
        accountNumber = accNo;
        accountHolderName = name;
        balance = initialBalance;
        email = mail;
        phoneNumber = phone;
    }

    public void deposit(double amount)
	{
        if (amount > 0) 
		{
            balance += amount;
            System.out.println("Amount deposited successfully. New Balance: " + balance);
        } 
		
		else 
		{
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) 
	{
        if (amount > 0 && amount <= balance) 
		{
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining Balance: " + balance);
        } 
		
		else 
		{
            System.out.println("Invalid withdrawal. Either amount is negative or insufficient balance.");
        }
    }

    public void displayAccountDetails()
	{
        System.out.println("----- Account Details -----");
        System.out.println("Account No: " + accountNumber);
        System.out.println("Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("---------------------------");
    }

    public void updateContactDetails(String newEmail, String newPhone) 
	{
        email = newEmail;
        phoneNumber = newPhone;
        System.out.println("Contact details updated successfully!");
    }
}

// User Interface Class

class UserInterface 
{
    Account[] accounts;
    int count;
    Scanner sc;

    public UserInterface(int size) 
	{
        accounts = new Account[size];
        count = 0;
        sc = new Scanner(System.in);
    }

    public void createAccount() 
	{
        if (count >= accounts.length) 
		{
            System.out.println("Account storage full. Cannot add more accounts.");
            return;
        }
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter initial deposit: ");
        double initBal = sc.nextDouble();
        sc.nextLine(); // clear buffer
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        int accNo = 1000 + count + 1; 
        accounts[count] = new Account(accNo, name, initBal, email, phone);
        System.out.println("Account created successfully! Your Account Number is: " + accNo);
        count++;
    }

    public void performDeposit() 
	{
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter amount to deposit: ");
        double amt = sc.nextDouble();
        sc.nextLine();

        Account acc = findAccount(accNo);
        if (acc != null) 
		{
            acc.deposit(amt);
        } 
		
		else 
		{
            System.out.println("Account not found!");
        }
    }

    public void performWithdrawal() 
	{
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter amount to withdraw: ");
        double amt = sc.nextDouble();
        sc.nextLine();

        Account acc = findAccount(accNo);
        if (acc != null) 
		{
            acc.withdraw(amt);
        } 
		
		else 
		{
            System.out.println("Account not found!");
        }
    }

    public void showAccountDetails() 
	{
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        Account acc = findAccount(accNo);
        if (acc != null) 
		{
            acc.displayAccountDetails();
        } 
		
        else 
		{
            System.out.println("Account not found!");
        }
    }

    public void updateContact() 
	{
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new Email: ");
        String newEmail = sc.nextLine();
        System.out.print("Enter new Phone Number: ");
        String newPhone = sc.nextLine();

        Account acc = findAccount(accNo);
        if (acc != null) 
		{
            acc.updateContactDetails(newEmail, newPhone);
        } 
		
		else 
		{
            System.out.println("Account not found!");
        }
    }

    private Account findAccount(int accNo) 
	{
        for (int i = 0; i < count; i++) 
		{
            if (accounts[i].accountNumber == accNo) 
			{
                return accounts[i];
            }
        }
        return null;
    }

    public void mainMenu() 
	{
        int choice;
        do 
		{
            System.out.println("\n=== Banking Application ===");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View account details");
            System.out.println("5. Update contact details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) 
			{
                case 1: createAccount(); break;
                case 2: performDeposit(); break;
                case 3: performWithdrawal(); break;
                case 4: showAccountDetails(); break;
                case 5: updateContact(); break;
                case 6: System.out.println("Thank you for using the Banking Application!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
		while (choice != 6);
    }
}

// main class

public class main 
{
    public static void main(String[] args) 
	{
        UserInterface ui = new UserInterface(50); 
        ui.mainMenu();
    }
}
