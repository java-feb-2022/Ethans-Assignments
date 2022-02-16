public class BankTest {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        account1.deposit(0.0, 9.5);
        account1.deposit(8.1, 4.0);
        System.out.println(account1.getCheckingBalance());
        System.out.println(account1.getSavingsBalance());
        account1.withdrawlChecking(3.5);
        account1.withdrawlSavings(10.0);
        System.out.println(account1.getSavingsBalance());
        System.out.println(account1.getCheckingBalance());
        System.out.println(account1.totalBalance());
    }
}
