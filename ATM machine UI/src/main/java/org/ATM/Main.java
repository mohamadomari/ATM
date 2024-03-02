package org.ATM;


import org.apache.el.util.Validation;

import java.security.cert.CertificateRevokedException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        allAccounts Account = new allAccounts(1234, "Bashar", "1234");
        savingAccount Saving = new savingAccount(Account, 3000);
        salaryAccount Salary = new salaryAccount(Account, 2000);
        creditCardAccount Credit = new creditCardAccount(Account, 1000);
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("Please enter the PIN: ");
            String pin = scanner.nextLine();

            if (Validation(Account, pin)) {

                break;
            } else {
                System.out.println("The PIN is incorrect");
            }

        }
        String selectedType = accountTypeSelection();

        Menu(selectedType,Saving,Salary,Credit);



    }
private static boolean Menu(String selectedType,savingAccount Saving,salaryAccount Salary,creditCardAccount Credit)
{
    while(true) {

        int exit=mainMenu(selectedType, Saving, Salary, Credit);
        if(exit==6)
        {
            return false;
        }
    }
}
    private static boolean Validation(allAccounts Account,String pin)
    {
        if(pin.equals(Account.getPIN()))
        {

            return true;
        }
        else {

            return false;

        }
    }
    private static String accountTypeSelection()
    {
        Scanner scanner=new Scanner(System.in);
        boolean Selected=true;
        int choice=0;
        while (Selected) {

            System.out.println("Please Choose an option:");
            System.out.println("1-Saving Account");
            System.out.println("2-Salary Account");
            System.out.println("3-Credit Card Account");


             choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1:

                    Selected= false;

                    break;
                case 2:

                    Selected= false;
                    break;
                case 3:

                    Selected= false;

                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }

        }
        if(choice==1)
        {
            return "Saving";
        } else if (choice ==2)
        {
            return "Salary";

        }
        else
        {
            return "creditCard";
        }
    }
    private static int mainMenu(String selectedType,savingAccount savingAccount,salaryAccount salaryAccount,creditCardAccount creditCardAccount)
    {
        Scanner scanner=new Scanner(System.in);
        boolean Selected=true;
        int choice=0;
        while (Selected) {

            System.out.println("Please Choose an option:\n");
            System.out.println("1-Check Account Balance");
            System.out.println("2-Deposit");
            System.out.println("3-Withdraw");
            System.out.println("4-Transfer Balance");
            System.out.println("5-Go back to account selection");
            System.out.println("6-Exit ATM");



            choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1:
                   checkBalance (selectedType,savingAccount,salaryAccount,creditCardAccount);


                    break;
                case 2:
                    Deposit (selectedType,savingAccount,salaryAccount,creditCardAccount);


                    break;
                case 3:

                    Withdraw (selectedType,savingAccount,salaryAccount,creditCardAccount);


                    break;
                case 4:

                    Transfer(selectedType,Destination(selectedType,savingAccount,salaryAccount,creditCardAccount),savingAccount,salaryAccount,creditCardAccount);

                    break;
                case 5:

                    Menu(accountTypeSelection(),savingAccount,salaryAccount,creditCardAccount);
                    break;
                case 6:

                    Selected= false;

                    break;

                default:
                    System.out.println("Invalid option. Please choose again.");
            }

        }
        return choice;
    }
    private static void checkBalance(String selectedType,savingAccount savingAccount,salaryAccount salaryAccount,creditCardAccount creditCardAccount)
    {
        Scanner scanner = new Scanner(System.in);
        if(selectedType.equals("Saving"))
        {
            System.out.println("The saving account balance is:"+savingAccount.getSavingBalance()+ "JOD") ;

        }
        else if ( selectedType.equals("Salary"))
        {
            System.out.println("The salary account balance is:"+salaryAccount.getSalaryBalance()+ "JOD");

        }

        else
        {
            System.out.println("The Credit Card account balance is:"+creditCardAccount.getCreditCardBalance()+ "JOD");

        }
        while (true)
        {
            System.out.println("1-Go Back");
            String choice = scanner.nextLine();
            if(choice.equals("1"))
            {
                break;
            }
            else {System.out.println("Invalid option. Please choose again.");}
        }
    }
    private static void Deposit(String selectedType,savingAccount savingAccount,salaryAccount salaryAccount,creditCardAccount creditCardAccount)
    {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("to go back insert 0");
        System.out.println("Please insert the amount to deposit:");
        double amount = scanner.nextDouble();
        if(amount==0)
        {
            Menu(selectedType,savingAccount,salaryAccount,creditCardAccount);
        }
        if(selectedType.equals("Saving"))
        {
            savingAccount.Deposit(amount);
        }
        else if ( selectedType.equals("Salary"))
        {
            salaryAccount.Deposit(amount);
        }

        else
        {
            creditCardAccount.Deposit(amount);
        }
        while (true)
        {
            System.out.println("1-Go Back");
            String choice = scanner2.nextLine();
            if(choice.equals("1"))
            {
                break;
            }
            else {System.out.println("Invalid option. Please choose again.");}
        }
    }
    private static void Withdraw(String selectedType,savingAccount savingAccount,salaryAccount salaryAccount,creditCardAccount creditCardAccount)
    {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        while (true) {
            System.out.println("to go back insert 0");
            System.out.println("Please insert the amount to withdraw:");
            double amount = scanner.nextDouble();
            if(amount==0)
            {
                Menu(selectedType,savingAccount,salaryAccount,creditCardAccount);
            }
            if (selectedType.equals("Saving")) {
                if (savingAccount.Withdraw(amount)) {
                    break;
                }

            } else if (selectedType.equals("Salary")) {
                if (salaryAccount.Withdraw(amount)) {
                    break;
                }
            } else {
                if (creditCardAccount.Withdraw(amount)) {
                    break;
                }
            }
        }
            while (true) {
                System.out.println("1-Go Back");
                String choice = scanner2.nextLine();
                if (choice.equals("1")) {
                    break;
                } else {
                    System.out.println("Invalid option. Please choose again.");
                }
            }

    }
    private static String Destination(String selectedType,savingAccount savingAccount,salaryAccount salaryAccount,creditCardAccount creditCardAccount)
    {
        Scanner scanner=new Scanner(System.in);
        String destinationAccount="";
        String choice="";
        while (true) {
            System.out.println("Please select the account to transfer to:");
            if (selectedType.equals("Saving")) {

                while (true) {
                    System.out.println("1-Salary account");
                    System.out.println("2-Credit Card account");
                    System.out.println("3-Go back");
                    choice = scanner.nextLine();
                    if (choice.equals("1")) {
                        return "Salary";
                    }
                    else if (choice.equals("2")) {
                        return "CreditCard";

                    } else if (choice.equals("3")) {
                        Menu(selectedType,savingAccount,salaryAccount,creditCardAccount);

                    } else
                    {
                        System.out.println("Invalid option. Please choose again.");
                    }
                }

            } else if (selectedType.equals("Salary")) {


                while (true) {
                    System.out.println("1-Saving account");
                    System.out.println("2-Credit Card account");
                    System.out.println("3-Go back");
                    choice = scanner.nextLine();
                    if (choice.equals("1")) {
                        return "Saving";
                    }
                    else if (choice.equals("2")) {
                        return "CreditCard";

                    } else if (choice.equals("3")) {
                        Menu(selectedType,savingAccount,salaryAccount,creditCardAccount);

                    }else {
                        System.out.println("Invalid option. Please choose again.");
                    }
                }


            } else {

                while (true) {
                    System.out.println("1-Saving account");
                    System.out.println("2-Salary account");
                    System.out.println("3-Go back");
                    choice = scanner.nextLine();
                    if (choice.equals("1")) {
                        return "Saving";

                    } else if (choice.equals("2")) {
                        return "Salary";

                    } else if (choice.equals("3")) {
                        Menu(selectedType,savingAccount,salaryAccount,creditCardAccount);

                    } else {
                        System.out.println("Invalid option. Please choose again.");
                    }
                }


            }

        }
    }
    private static void Transfer(String selectedType,String Destination,savingAccount savingAccount,salaryAccount salaryAccount,creditCardAccount creditCardAccount)
    {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        while (true) {
            System.out.println("to go back insert 0");
            System.out.println("Please insert the amount to transfer:");
            double amount = scanner.nextDouble();
            if(amount==0)
            {
                Menu(selectedType,savingAccount,salaryAccount,creditCardAccount);
            }
            if (selectedType.equals("Saving")) {
                if (savingAccount.transferFrom(amount)) {
                    if(Destination.equals("Salary"))
                    {
                        salaryAccount.transferTo(amount);
                        break;
                    }
                    else {
                        creditCardAccount.transferTo(amount);
                        break;
                    }
                }
                else
                {
                    Menu(selectedType,savingAccount,salaryAccount,creditCardAccount);

            }

            } else if (selectedType.equals("Salary")) {
                if (salaryAccount.transferFrom(amount)) {
                    if(Destination.equals("Saving"))
                    {
                        savingAccount.transferTo(amount);
                        break;
                    }
                    else {
                        creditCardAccount.transferTo(amount);
                        break;
                    }
                }
                else
                {
                    Menu(selectedType,savingAccount,salaryAccount,creditCardAccount);
                }
            } else {
                if (creditCardAccount.transferFrom(amount)) {
                    if(Destination.equals("Salary"))
                    {
                        savingAccount.transferTo(amount);
                        break;
                    }
                    else {
                        salaryAccount.transferTo(amount);
                        break;
                    }
                }
                else
                {
                    Menu(selectedType,savingAccount,salaryAccount,creditCardAccount);
                }
            }
        }
        while (true) {
            System.out.println("1-Go Back");
            String choice = scanner2.nextLine();
            if (choice.equals("1")) {
                break;
            } else {
                System.out.println("Invalid option. Please choose again.");
            }
        }
    }



}