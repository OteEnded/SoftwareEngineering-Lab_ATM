package atm;

/**
   A bank customer with a checking and a savings account.
*/
public class Customer
{  
   /**
      Constructs a customer with a given number and PIN.
      @param aNumber the customer number
      @param aPin the personal identification number
   */
   public Customer(int aNumber, int aPin, double currentBalance)
   {  
      customerNumber = aNumber;
      pin = aPin;
      account = new Account(currentBalance);
   }
   
   public int getCustomerNumber() {
	   return customerNumber;
   }
   
   /** 
      Tests if this customer matches a customer number 
      and PIN.
      @param aNumber a customer number
      @param aPin a personal identification number
      @return true if the customer number and PIN match
   */
   public boolean match(int aPin)
   {  
      return pin == aPin;
   }
      
   /** 
      Gets the account of this customer.
      @return the account
   */
   public Account getAccount()
   {  
      return account;
   }
   
   private int customerNumber;
   private int pin;
   private Account account;
}
