package atm;

/**
 * A bank account has a balance that can be changed by
 * deposits and withdrawals.
 */
public class BankAccount {
   private int id;
   private String name;
   private double balance;

   /**
    * Constructs a bank account with a zero balance.
    */
   public BankAccount(int id, String name) {
      this(id, name, 0);
   }

   /**
    * Constructs a bank account with a given balance.
    * @param initialBalance the initial balance
    */
   public BankAccount(int id, String name, double initialBalance) {
      this.id = id;
      this.name = name;
      this.balance = initialBalance;
   }
 
   /** 
    * Deposits money into the account.
    * @param amount the amount of money to withdraw
    */
   public void deposit(double amount) {
      balance = balance + amount;
   }

   /** 
    * Withdraws money from the account.
    * @param amount the amount of money to deposit
    */
   public void withdraw(double amount) {
      balance = balance - amount;
   }

   /** 
    * Gets the account balance.
    * @return the account balance
    */
   public double getBalance() {
      return balance; 
   }
}

