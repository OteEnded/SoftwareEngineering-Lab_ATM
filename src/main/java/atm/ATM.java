package atm;

/**
   An ATM that accesses a bank.
 */
public class ATM 
{  
	/**
      Constructs an ATM for a given bank.
      @param aBank the bank to which this ATM connects
	 */    
	public ATM(Bank aBank)
	{
		theBank = aBank;
		customerNumber = -1;
		currentAccount = null;
		state = START; 
	}

	/**
      Resets the ATM to the initial state.
	 */
	public void reset()
	{
		customerNumber = -1;
		currentAccount = null;
		state = START;             
	}

	/** 
      Finds customer in bank.
      If found sets state to ACCOUNT, else to START.
      (Precondition: state is PIN)
      @param pin the PIN of the current customer
	 */
	public void validateCustomer(int customerNum, int pin)
	{  
		assert state == START;

		if (theBank.findCustomer(customerNum) != null && 
				theBank.findCustomer(customerNum).match(pin)) {
			customerNumber = customerNum;
			currentCustomer = theBank.findCustomer(customerNumber);
			currentAccount = currentCustomer.getAccount();
			state = TRANSACT;
		} 
	}

	/** 
      Withdraws amount from current account. 
      (Precondition: state is TRANSACT)
      @param value the amount to withdraw
	 */
	public void withdraw(double value)
	{  
		assert state == TRANSACT;
		currentAccount.withdraw(value);
	}

	/** 
      Deposits amount to current account. 
      (Precondition: state is TRANSACT)
      @param value the amount to deposit
	 */
	public void deposit(double value)
	{  
		assert state == TRANSACT;
		currentAccount.deposit(value);
	}

	/** 
      Gets the balance of the current account. 
      (Precondition: state is TRANSACT)
      @return the balance
	 */
	public double getBalance()
	{  
		assert state == TRANSACT;
		return currentAccount.getBalance();
	}

	public void transfer(int customerNum, double amount) {
		assert state == TRANSACT;
		Customer receivingCustomer = theBank.findCustomer(customerNum);
		Account receivingAccount = receivingCustomer.getAccount();
		currentAccount.withdraw(amount);
		receivingAccount.deposit(amount);
	}

	/**
      Gets the current state of this ATM.
      @return the current state
	 */
	public int getState()
	{
		return state;
	}

	private int state;
	private int customerNumber;
	private Customer currentCustomer;
	private Account currentAccount;
	private Bank theBank;

	public static final int START = 1;
	public static final int TRANSACT = 2;
}
