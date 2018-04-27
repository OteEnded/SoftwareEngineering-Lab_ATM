package atm;

import java.io.IOException;
import java.util.Scanner;

/**
   A text-based simulation of an automatic teller machine.
 */
public class ATMSimulator
{  
	public static void main(String[] args)
	{  
		ATM theATM;
		try
		{  
			Bank theBank = new Bank();
			theBank.readCustomers("customers.txt");
			theATM = new ATM(theBank);
		}
		catch(IOException e)
		{  
			System.out.println("Error opening accounts file.");
			return;
		}

		Scanner in = new Scanner(System.in);

		while (true)
		{
			int state = theATM.getState();
			if (state == ATM.START)
			{
				System.out.print("Enter customer number: ");
				int number = in.nextInt();
				System.out.print("Enter PIN: ");
				int pin = in.nextInt();
				theATM.validateCustomer(number, pin);
			}
			else if (state == ATM.TRANSACT)
			{
				System.out.println("Balance=" + theATM.getBalance());
				System.out.print("A=Deposit, B=Withdrawal, C=Transfer, D=Done, E=Exit: ");
				String command = in.next();
				if (command.equalsIgnoreCase("A"))
				{
					System.out.print("Amount: ");
					double amount = in.nextDouble();
					theATM.deposit(amount);
				}
				else if (command.equalsIgnoreCase("B"))
				{
					System.out.print("Amount: ");
					double amount = in.nextDouble();
					theATM.withdraw(amount);
				}
				else if (command.equalsIgnoreCase("C"))
				{
					System.out.print("Transfer To: ");
					int transferTo = in.nextInt();
					System.out.print("Amount: ");
					double amount = in.nextDouble();
					theATM.transfer(transferTo, amount);
				}
				else if (command.equalsIgnoreCase("D"))
				{
					theATM.reset();
				}
				else if (command.equalsIgnoreCase("E"))
					System.exit(0);
				else
					System.out.println("Illegal input!");                                    
			}         
		}
	}
}

