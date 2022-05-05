package bank;

/**
 * Create a bank account with specification : compte courant
 *      - you can set a minimum Balance
 */
public class Checking extends BankAccount{
    private double minBalance;

    /**
     * Create a new account checking with all parameters
     * @param owner 
     * @param amount
     * @param minBalance
     */
    protected Checking(String owner, double amount, double minBalance){
        if(owner==null){
            error("An account have to be an owner");
            return;
        }
        if(amount<minBalance){
            error("Not enough money");
            return;
        }
        if(minBalance>0){
            error("Min balance can't be positive");
            return;
        }
        this.owner = owner;
        this.balance = amount;
        this.minBalance = minBalance;
    }

    /**
     * Set the minimum Balance
     * @param minBalance
     */
    protected void setMinBalance(double minBalance) {
        if(minBalance>0){
            error("Min balance can't be positive");
            return;
        }
        this.minBalance = minBalance;
    }

    /**
     * Get the minimum balance
     * @return the minimum balance
     */
    public double getMinBalance() {
        return minBalance;
    }


    /**
     * Specification : you can withdraw an amount to a minimum balance
     */
    @Override
    public boolean withdraw(double amount){
        if((balance-minBalance)<amount){
            return error("cannot withdraw this amount !");
        } 
        balance -= amount;
        return true;
    }
}
