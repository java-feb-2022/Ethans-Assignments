import java.util.Random;
public class BankAccount {
    private String AccountNumber;
    private double CheckingBalance = 0.0;
    private double SavingsBalance = 0.0;
    private static int NumberOfAccounts;
    private static double AllMoney;
    public BankAccount(){
        NumberOfAccounts++;
        this.AccountNumber = AccountNumber();
    }
    public double getCheckingBalance(){
        return this.CheckingBalance;
    }
    public double getSavingsBalance(){
        return this.SavingsBalance;
    }
    public void deposit(double amountChecking, double amountSavings){
        this.CheckingBalance += amountChecking;
        this.SavingsBalance += amountSavings;
        AllMoney += amountChecking + amountSavings;
    }
    public double withdrawlChecking(double amount){
        if(amount <= this.CheckingBalance) {
            this.CheckingBalance -= amount;
            AllMoney -= amount;
            return amount;
        }
        return 0.0;
    }
    public double withdrawlSavings(double amount){
        if(amount <= this.SavingsBalance) {
            this.SavingsBalance -= amount;
            AllMoney -= amount;
            return amount;
        }
        return 0.0;
    } 
    public double totalBalance(){
        return this.SavingsBalance + this.CheckingBalance;
    }
    private String AccountNumber(){
        Random random = new Random();
        return String.format("%s", random.nextInt(1000000000,2000000000));
    }
}
