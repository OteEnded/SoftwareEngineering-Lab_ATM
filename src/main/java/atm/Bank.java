package atm;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * A bank contains customers with bank accounts.
 */
public class Bank {

   private String name;
   private Map<Integer,Customer> customers;
   private DataSourceDB dataSource;

   /**
    * Constructs a bank with no customers.
    */
   public Bank(String name) {
      this.name = name;
      this.dataSource = new DataSourceDB();
      this.customers = dataSource.readCustomers();
   }

   /**
    * Adds a customer to the bank.
    * @param c the customer to add
    */
   public void addCustomer(Customer c) {
      customers.put(c.getId(), c);
   }
   
   /** 
    * Finds a customer in the bank.
    * @param number a customer number
    * @return the matching customer, or null if no customer
    * matches
    */
   public Customer findCustomer(int number) {
	  return customers.get(number);
   }
}
