package atm;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * A bank contains customers with bank accounts.
 */
public class Bank {

   private Map<Integer,Customer> customers;

   /**
    * Constructs a bank with no customers.
    */
   public Bank() {
      customers = new HashMap<Integer,Customer>();
   }
   
   /**
    * Reads the customer numbers and pins
    * and initializes the bank accounts.
    * @param filename the name of the customer file
    */
   public void readCustomers(String filename) throws IOException {
      Scanner in = new Scanner(new FileReader(filename));
      while (in.hasNext()) {
         int number = in.nextInt();
         int pin = in.nextInt();
         double currentBalance = in.nextDouble();
         Customer c = new Customer(number, pin, currentBalance);
         addCustomer(c);
      }
      in.close();
   }
   
   /**
    * Adds a customer to the bank.
    * @param c the customer to add
    */
   public void addCustomer(Customer c) {
      customers.put(c.getCustomerNumber(), c);
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
