package SOLID.LSP;

// 🏢 Industry Level Example: Banking Account System
// একটি রিয়েল ওয়ার্ল্ড সিস্টেমে আমরা উইথড্র (Withdraw) করার লজিক দেখবো।

// ১. বেসিক অ্যাকাউন্ট: এখান থেকে টাকা তোলা যায় না (যেমন Fixed Deposit)
abstract class Account {
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}

// ২. উইথড্র করা যায় এমন অ্যাকাউন্ট (Saving, Current)
abstract class WithdrawableAccount extends Account {
    public WithdrawableAccount(double balance) {
        super(balance);
    }

    public abstract void withdraw(double amount);
}

// ৩. Savings Account: উইথড্র করতে পারে
class SavingsAccount extends WithdrawableAccount {
    public SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn " + amount + " from Savings Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance in Savings Account!");
        }
    }
}

// ৪. Fixed Deposit Account: এখান থেকে টাকা উইথড্র করা যায় না!
// তাই এটি WithdrawableAccount কে এক্সটেন্ড না করে শুধু Account কে এক্সটেন্ড করেছে।
// এতে করে LSP ব্রেক হলো না।
class FixedDepositAccount extends Account {
    public FixedDepositAccount(double balance) {
        super(balance);
    }

    // এখানে withdraw() মেথড নেই, কারণ FD অ্যাকাউন্ট থেকে ম্যাচিওরিটির আগে টাকা তোলা যায় না।
    public void checkMaturity() {
        System.out.println("Fixed Deposit balance is: " + balance + ". Cannot withdraw before maturity.");
    }
}

public class IndustryExample {
    public static void main(String[] args) {
        // Savings Account (Withdrawable)
        WithdrawableAccount mySavings = new SavingsAccount(5000);
        mySavings.withdraw(2000);

        // Fixed Deposit (Not withdrawable)
        Account myFD = new FixedDepositAccount(10000);
        System.out.println("FD Balance: " + myFD.getBalance());
        
        // এখানে myFD.withdraw() কল করার কোনো সুযোগই নেই, 
        // তাই Exception থ্রো হওয়ার চান্স ০%। এটিই LSP এর আসল পাওয়ার!
    }
}
