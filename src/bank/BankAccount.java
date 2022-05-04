package bank;

public abstract class BankAccount {
    protected double balance;
    protected String owner;

    public double getBalance() {
        return balance;
    }
    public void deposit(double amount){
        balance += amount;
    }
    public boolean withdraw(double amount){
        if(balance<amount){
            System.out.println("Problem : cannot withdraw that amount");
            return false;
        } 
        
        balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return owner + " have " + balance + "CHF on his account.";
    }
}
