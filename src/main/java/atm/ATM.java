package atm;

/**
 * An ATM that accesses a bank.
 */
public class ATM {
	private Bank bank;
	private Customer currentCustomer;

	/**
     * Constructs an ATM for a bank.
	 */
	public ATM() {
		this.bank = new Bank("My Bank");
		this.currentCustomer = null;
	}

	/**
     * Finds customer in bank.
     * If found sets state to ACCOUNT, else to START.
     * (Precondition: state is PIN)
	 * @param id current customer number
     * @param pin pin being inputted
	 */
	public String validateCustomer(int id, int pin) {

		if (bank.findCustomer(id) != null &&
				bank.findCustomer(id).checkPin(pin)) {
			currentCustomer = bank.findCustomer(id);
			return currentCustomer.getName();
		}
		return null;
	}

	/**
     * Withdraws amount from current account.
     * (Precondition: state is TRANSACT)
     * @param value the amount to withdraw
	 */
	public void withdraw(double value) {
		currentCustomer.getAccount().withdraw(value);
	}

	/**
     * Deposits amount to current account.
     * (Precondition: state is TRANSACT)
     * @param value the amount to deposit
	 */
	public void deposit(double value) {
		currentCustomer.getAccount().deposit(value);
	}

	/**
     * Gets the balance of the current account.
     * (Precondition: state is TRANSACT)
     * @return the balance
	 */
	public double getBalance() {
		return currentCustomer.getAccount().getBalance();
	}

	/**
	 * Transfer from current customer to the customer with
	 * customer number in the parameter
	 * @param customerNum receiver customer
	 * @param amount amount to be transferred
	 */
	public void transfer(int customerNum, double amount) {
		Customer receivingCustomer = bank.findCustomer(customerNum);
		currentCustomer.getAccount().withdraw(amount);
		receivingCustomer.getAccount().deposit(amount);
	}


	/**
	 * Resets the ATM to the initial state.
	 */
	public void end() {
		currentCustomer = null;
	}

}
