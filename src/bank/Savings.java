package bank;

import hevs.utils.DateUtils;
import java.util.Date;

public class Savings extends BankAccount{
    private double interestRate;
    Savings(String owner, double amount, double interestRate){
        this.owner = owner;
        this.balance = amount;
        this.interestRate = interestRate;
    }
    public double calcInterest(Date a, Date b){
        int day = DateUtils.nDays(a, b);
        return interestRate * (day/360.0);
    }
}
