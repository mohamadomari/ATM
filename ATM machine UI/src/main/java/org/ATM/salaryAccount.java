package org.ATM;



public class salaryAccount extends allAccounts
{
    private String accountType;
    private double salaryBalance;

    public salaryAccount(double salaryBalance) {
        this.accountType = Type.Salary.name();
        this.salaryBalance = salaryBalance;
    }

    public salaryAccount(int userId, String userName, String PIN,double salaryBalance) {
        super(userId, userName, PIN);
        this.accountType = Type.Salary.name();
        this.salaryBalance = salaryBalance;
    }
    public salaryAccount(allAccounts  account,double salaryBalance) {

        this.accountType = Type.Saving.name();
        this.salaryBalance = salaryBalance;


    }

    public String getAccountType() {
        return accountType;
    }



    public double getSalaryBalance() {
        return salaryBalance;
    }


    void Deposit(double amount)
    {
        if(amount>0)
        {
            salaryBalance = salaryBalance + amount;
            System.out.println("Successful deposit with  amount: " + amount + "JOD has been done");
        }
        else
        {
            System.out.println("Please insert a positive number");
        }
    }
    boolean Withdraw(double amount)
    {
        if(amount>0)
        {
            if(amount%5==0)
            {
                if (salaryBalance >= amount)
                {
                    salaryBalance =salaryBalance- amount;
                    System.out.println("Successful withdraw with  amount: " + amount + "JOD has been done");
                    return true;
                }
                else
                {
                    System.out.println("The withdraw with the amount: " + amount + "JOD has been rejected due to insufficient Funds");
                    return false;
                }
            }
            else
            {
                System.out.println("Please insert a number that is a multiple of 5");
                return false;
            }
        }
        else
        {
            System.out.println("Please insert a positive number");
            return false;
        }
    }

    boolean transferFrom(double amount)
    {
        if(amount>0)
        {

            if (salaryBalance >= amount)
            {
                salaryBalance-=amount;
                return true;
            }
            else
            {
                System.out.println("The transfer with the amount: " + amount + "JOD has been rejected due to insufficient Funds");
                return false;
            }


        }
        else
        {
            System.out.println("Please insert a positive number");
            return false;
        }
    }
    void transferTo(double amount)
    {
        salaryBalance += amount;
        System.out.println("The transfer with the amount: " + amount + "JOD has been done successfully");

    }
}

