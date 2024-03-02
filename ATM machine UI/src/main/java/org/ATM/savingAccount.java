package org.ATM;





public class savingAccount extends allAccounts
{
    private String accountType;
    private double savingBalance;

    public savingAccount(double savingBalance) {
        this.accountType = Type.Saving.name();
        this.savingBalance = savingBalance;
    }

    public savingAccount(int userId, String userName, String PIN,double savingBalance) {
        super(userId, userName, PIN);
        this.accountType = Type.Saving.name();
        this.savingBalance = savingBalance;


    }
    public savingAccount(allAccounts  account,double savingBalance) {

        this.accountType = Type.Saving.name();
        this.savingBalance = savingBalance;


    }


    public String getAccountType() {
        return accountType;
    }



    public double getSavingBalance() {
        return savingBalance;
    }






    void Deposit(double amount)
    {
        if(amount>0)
        {
            savingBalance = savingBalance + amount;
            System.out.println("Successful deposit with  amount: " + amount + "JOD has been done");
        }
        else
        {
            System.out.println("Please insert a positive number");
        }
    }
    @Override
    boolean Withdraw(double amount)
    {
        if(amount>0)
        {
            if(amount%5==0)
            {
                if (savingBalance >= amount)
                {
                   savingBalance= savingBalance - amount;

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

            if (savingBalance >= amount)
            {
                savingBalance-=amount;
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
        savingBalance += amount;
        System.out.println("The transfer with the amount: " + amount + "JOD has been done successfully");

    }

}
