package atm;

import java.io.IOException;
import java.util.Scanner;

/**
   A text-based simulation of an automatic teller machine.
 */
public class ATMSimulator {

	private ATM atm;
	private Bank bank;

	public ATMSimulator() {
		bank = new Bank();
		atm = new ATM(bank);
	}

	public void run() {
		try {
			bank.readCustomers("customers.txt");
		}
		catch(IOException e) {
			System.out.println("Error opening accounts file.");
			return;
		}

		Scanner in = new Scanner(System.in);

		while (true) {
			int state = atm.getState();

			if (state == ATM.START) {
				System.out.print("Enter customer number: ");
				int number = in.nextInt();
				System.out.print("Enter PIN: ");
				int pin = in.nextInt();
				atm.validateCustomer(number, pin);
			}
			else if (state == ATM.TRANSACT) {
				System.out.println("Balance=" + atm.getBalance());
				System.out.print("A=Deposit, B=Withdrawal, C=Transfer, D=Done, E=Exit: ");
				String command = in.next();

				if (command.equalsIgnoreCase("A")) {
					System.out.print("Amount: ");
					double amount = in.nextDouble();
					atm.deposit(amount);
				}
				else if (command.equalsIgnoreCase("B")) {
					System.out.print("Amount: ");
					double amount = in.nextDouble();
					atm.withdraw(amount);
				}
				else if (command.equalsIgnoreCase("C")) {
					System.out.print("Transfer To: ");
					int transferTo = in.nextInt();
					System.out.print("Amount: ");
					double amount = in.nextDouble();
					atm.transfer(transferTo, amount);
				}
				else if (command.equalsIgnoreCase("D")) {
					atm.reset();
				}
				else if (command.equalsIgnoreCase("E"))
					System.exit(0);
				else
					System.out.println("Illegal input!");                                    
			}         
		}
	}
}

