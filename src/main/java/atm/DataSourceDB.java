package atm;

import java.util.HashMap;
import java.util.Map;

public class DataSourceDB {

    /**
     * Simulate reading customer information from database
     */
    public Map<Integer,Customer> readCustomers() {
        Map<Integer,Customer> customers = new HashMap<>();

        customers.put(1,new Customer(1,"ปีเตอร์",1234,1000));
        customers.put(2,new Customer(2,"แคทเทอรีน",2345,2000));
        customers.put(3,new Customer(3,"คริส",3456,3000));

        return customers;
    }
}
