package system;

import java.util.Locale;
import java.util.Scanner;

import bank.account;

public class program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		account account;
		
		System.out.println("Enter account number: ");
		int number = sc.nextInt();
		System.out.println("Enter account holder: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println("Is there an initial deposit? (y/n)");
		char yesNo = sc.next().charAt(0);
		if (yesNo == 'y') {
			System.out.println("Enter initial deposit value: ");
			double initialDeposit = sc.nextDouble();
			account = new account(number, name, initialDeposit); 
		}
		else {
			account = new account(number, name);
		}
		
		
		System.out.println();
		System.out.println("Account data:");
		System.out.println(account);
		
		System.out.println("Enter a deposit value: ");
		double deposit = sc.nextDouble();
		account.deposit(deposit);
		System.out.println("Updated account data: ");
		System.out.println(account);
		
		System.out.println("Enter a withdraw value: ");
		double withdraw = sc.nextDouble();
		account.withdraw(withdraw);
		System.out.println("Updated account data: ");
		System.out.println(account);
		sc.close();
	}
}
