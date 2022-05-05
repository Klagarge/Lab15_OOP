package bank;

import hevs.utils.DateUtils;
import java.util.Date;

/**
 * 
 */
public class Savings extends BankAccount{
    private double interestRate;

    /**
     * 
     * @param owner
     * @param amount
     * @param interestRate
     */
    protected Savings(String owner, double amount, double interestRate){
        if(owner==null){
            error("An account have to be an owner");
            return;
        }
        if(amount<0) {
            error("A Saving account can't have a negative amount");
            return;
        }
        if(interestRate<0){
            error("cannot have interest negative");
            return;
        }
        this.owner = owner;
        this.balance = amount;
        this.interestRate = interestRate;
    }
    
    /**
     * 
     * @param a
     * @param b
     * @return
     */
    protected double calcInterest(Date a, Date b){
        double days = DateUtils.nDays(a, b);
        return balance * interestRate * (days/360.0);
    }
}
