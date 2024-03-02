package org.ATM;




public class allAccounts
{
    private int userId;
    private String userName;

    private String PIN;


    protected enum Type{
        Saving,
        Salary,
        creditCard
    }

    public allAccounts() {
    }

    protected allAccounts(int userId, String userName, String PIN) {
        this.userId = userId;
        this.userName = userName;
        this.PIN = PIN;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }





     void Deposit(double amount){

     }
    boolean Withdraw(double amount){
        return false;
     }
     boolean transferFrom(double amount){
        return false;

     }
     void transferTo(double amount){

     }



}

