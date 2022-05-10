package bank;

/**
 * Create a bank account with a balance and a owner
 * General abstract class for used in specific other bank account
 */
public abstract class BankAccount {
    protected double balance;
    protected String owner;

    /**
     * Get balance of the account
     * @return The balance of the account
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deposit an amount on your account
     * Check the amount for accept only positive amount.
     * @param amount The amount you want to deposit (have to be positive).
     */
    public void deposit(double amount){
        if(amount<0){
            error("cannot deposit this amount !");
            return;
        } 
        balance += amount;
    }

    /**
     * Withdraw an amount on your account
     * Check the amount for be sure you have this money
     * @param amount The amount you want to withdraw (have to be less or equal to the money you have)
     * @return true : if the withdraw has been done
     */
    public boolean withdraw(double amount){
        if(balance<amount){
            return error("cannot withdraw this amount !");
        } 
        balance -= amount;
        return true;
    }

    /**
     * Explain the problem, if something is wrong. And print it on terminal.
     * 
     * @param text The description of your specific error
     * @return return always false. Can be used for check if have a problem
     */
    protected boolean error(String text){
        System.out.println("Problem : " + text);
        return false;
    }

    /**
     * Rewrite the bank account to string
     */
    @Override
    public String toString() {
        return owner + " have " + balance + "CHF on his account.";
    }
}