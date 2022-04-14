package bank;

public class Checking extends BankAccount{
    private double minBalance;

    Checking(String owner, double amount, double minBalance){
        this.owner = owner;
        this.balance = amount;
        this.minBalance = minBalance;
    }
    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
    public double getMinBalance() {
        return minBalance;
    }
}
