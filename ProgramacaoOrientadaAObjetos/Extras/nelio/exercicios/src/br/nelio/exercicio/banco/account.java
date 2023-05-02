package br.nelio.exercicio.banco;

public class account {

		private int accNum;
		private String name;
		private double balance;
		
		public account(int accNum, String name) {
			this.accNum = accNum;
			this.name = name;
			
		}
		
		public account(int accNum, String name, double initialDeposit) {
			this.accNum = accNum;
			this.name = name;
			deposit(initialDeposit);
		}
		
		public int getAccNum() {
			return accNum;
		}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getBalance() {
			return balance;
		}
		
		public void deposit(double amount) {
			balance += amount;
		}
		
		public void withdraw(double amount) {
			balance -= amount + 5.0;
		}
		
		public String toString() {
			return "Account: "
					+ accNum
					+ ", Holder: "
					+ name
					+ ", Balance: $"
					+ String.format("%.2f", balance);
		}
		
		
	}

