package org.ATM;



public class creditCardAccount extends allAccounts
{
    private String accountType;
    protected double creditCardBalance;



    public creditCardAccount(double creditCardBalance) {
        this.accountType = Type.creditCard.name();
        this.creditCardBalance = creditCardBalance;
    }

    public creditCardAccount(int userId, String userName, String PIN,double creditCardBalance) {
        super(userId, userName, PIN);
        this.accountType = Type.creditCard.name();
        this.creditCardBalance = creditCardBalance;

    }
    public creditCardAccount(allAccounts  account,double creditCardBalance) {

        this.accountType = Type.Saving.name();
        this.creditCardBalance  = creditCardBalance;


    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getCreditCardBalance() {
        return creditCardBalance;
    }

    public void setCreditCardBalance(double creditCardBalance) {
        this.creditCardBalance = creditCardBalance;
    }


    void Deposit(double amount)
    {
        if(amount>0)
        {
            creditCardBalance = creditCardBalance + amount;
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
                if (creditCardBalance >= amount)
                {
                    creditCardBalance = creditCardBalance- amount;
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

            if (creditCardBalance >= amount)
            {
                creditCardBalance-=amount;
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
        creditCardBalance += amount;
        System.out.println("The transfer with the amount: " + amount + "JOD has been done successfully");

    }
}
