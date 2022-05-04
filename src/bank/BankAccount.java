package bank;

public abstract class BankAccount {
    protected double balance;
    protected String owner;

    public double getBalance() {
        return balance;
    }
    public void deposit(double amount){
        if(amount<0){
            error("cannot deposit this amount !");
            return;
        } 
        balance += amount;
    }
    public boolean withdraw(double amount){
        if(balance<amount){
            return error("cannot withdraw this amount !");
        } 
        balance -= amount;
        return true;
    }

    protected boolean error(String text){
        System.out.println("Problem : " + text);
        return false;
    }
    


    @Override
    public String toString() {
        return owner + " have " + balance + "CHF on his account.";
    }
}
