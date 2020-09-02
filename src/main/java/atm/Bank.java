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
    * @param customer the customer to add
    */
   public void registerCustomer(Customer customer) {
      customers.put(customer.getId(), customer);
   }
   
   /** 
    * Finds a customer in the bank.
    * @param id a customer id
    * @return the matching customer, or null if no customer
    * matches
    */
   public Customer findCustomer(int id) {
	  return customers.get(id);
   }
}
