package atm;

public class Main {
    public static void main(String[] args) {

        DataSourceFile dataSourceFile = new DataSourceFile("customers.txt");
        DataSourceDB dataSourceDB = new DataSourceDB();
        Bank bank = new Bank("KU Bank", dataSourceFile);
        ATM atm = new ATM(bank);

        AtmUI atmUI = new AtmUI(atm);
        atmUI.run();
    }
}
