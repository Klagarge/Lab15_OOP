package bank;

import hevs.utils.DateUtils;
import java.util.Date;

/**
 * Create a bank account with specification : compte épargne
 *      - you have some interest for the money you have on this account
 */
public class Savings extends BankAccount{
    private double interestRate;

    /**
     * Create a new saving account with all parameters
     * @param owner The people who have the bank account
     * @param amount The amount on this bank account at the time of opening
     * @param interestRate the interest rate for this account
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
     * Calculates how much interest is charged over a given period of time
     * @param a Initial date for counting interest
     * @param b Final date for counting interest
     * @return The interest earned during the period
     */
    protected double calcInterest(Date a, Date b){
        double days = DateUtils.nDays(a, b);
        return balance * interestRate * (days/360.0);
    }
}
