package br.com.residencia.poo.primeira.exercicio.tres;

public class Operacoes {

	private double result;
	private double num1;
	private double num2;

	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}

	public double getResult() {
		return result;
	}

	public void soma(double num1, double num2) {
		Funcionalidades f = new Funcionalidades();
		result = this.num1 + this.num2;
		if (f.verificaNumero(num1) && f.verificaNumero(num2) == true) {
			int numInt1 = (int) num1;
			int numInt2 = (int) num2;
			int resultInt = (int) result;
			System.out.println("O resultado de: " + numInt1 + " + " + numInt2 + " = " +resultInt);
		}
		else if (f.verificaNumero(num1) == true) {
			int numInt = (int) num1;
			System.out.printf("O resultado de: " + numInt + " + " + num2 + " = %.2f", result);
		} 
		else if (f.verificaNumero(num2) == true) {
			int numInt = (int) num2;
			System.out.printf("O resultado de: " + num1 + " + " + numInt + " = %.2f", result);
		} else {
			if (f.verificaNumero(result) == true) {
				int resultInt = (int) result;
				System.out.println("O resultado de: " + num1 + " + " + num2 + " = " + resultInt);
			}
			else {
			System.out.printf("O resultado de: " + num1 + " + " + num2 + " = %.2f", result);
			}
		}
		f.novaOperacao();

	}

	public void sub(double num1, double num2) {
		Funcionalidades f = new Funcionalidades();
		result = num1 - num2;
		if (f.verificaNumero(num1) && f.verificaNumero(num2) == true) {
			int numInt1 = (int) num1;
			int numInt2 = (int) num2;
			int resultInt = (int) result;
			System.out.println("O resultado de: " + numInt1 + " - " + numInt2 + " = " + resultInt);
		}
		else if (f.verificaNumero(num1) == true) {
			int numInt = (int) num1;
			System.out.printf("O resultado de: " + numInt + " - " + num2 + " = %.2f", result);
		} 
		else if (f.verificaNumero(num2) == true) {
			int numInt = (int) num2;
			System.out.printf("O resultado de: " + num1 + " - " + numInt + " = %.2f ", result);
		} else {
			if (f.verificaNumero(result) == true) {
				int resultInt = (int) result;
				System.out.println("O resultado de: " + num1 + " - " + num2 + " = " + resultInt);
			}
			else {
			System.out.printf("O resultado de: " + num1 + " - " + num2 + " = %.2f", result);
			}
		}
		f.novaOperacao();
	}

	public void mult(double num1, double num2) {
		Funcionalidades f = new Funcionalidades();
		result = this.num1 * this.num2;
		
		if (f.verificaNumero(num1) == true) {
			int numInt = (int) num1;
			if (f.verificaNumero(result) == true) {
				int resultInt = (int) result;
				System.out.println("O resultado de: " + numInt + " * " + num2 + " = " + resultInt);
			} else {
				System.out.printf("O resultado de: " + numInt + " * " + num2 + " = %.2f", result);
			}
		}
		else if (f.verificaNumero(num2) == true) {
			int numInt = (int) num2;
			if (f.verificaNumero(result) == true) {
				int resultInt = (int) result;
				System.out.println("O resultado de:  " + num1 + " * " + numInt + " = " + resultInt);
			} else {
				System.out.printf("O resultado de: " + num1 + " * " + numInt + " = %.2f", result);
			}
		}
		else if (f.verificaNumero(num1) && f.verificaNumero(num2) == true) {
			int numInt1 = (int) num1;
			int numInt2 = (int) num2;
			if (f.verificaNumero(result) == true) {
				int resultInt = (int) result;
				System.out.println("O resultado de: " + numInt1 + " * " + numInt2 + " = " + resultInt);
			} else {
				System.out.printf("O resultado de: " + numInt1 + " * " + numInt2 + " = %.2f", result);
			}
		}
		f.novaOperacao();

	}

	public void div(double num1, double num2) {
		Funcionalidades f = new Funcionalidades();
		if (this.num2 <= 0) {
			System.out.println("Valores inválidos para esta operação. Por favor, tente novamente.");
			f.insereNumeros();
		} else {
			result = this.num1 / this.num2;
			if (f.verificaNumero(num1) == true) {
				int numInt = (int) num1;
				if (f.verificaNumero(result) == true) {
					int resultInt = (int) result;
					System.out.println("O resultado de: " + numInt + " / " + num2 + " = " + resultInt);
				} else {
					System.out.printf("O resultado de: " + numInt + " / " + num2 + " = %.2f", result);
				}
			}
			else if (f.verificaNumero(num2) == true) {
				int numInt = (int) num2;
				if (f.verificaNumero(result) == true) {
					int resultInt = (int) result;
					System.out.println("O resultado de:  " + num1 + " / " + numInt + " = " + resultInt);
				} else {
					System.out.printf("O resultado de: " + num1 + " / " + numInt + " = %.2f", result);
				}
			}
			else if (f.verificaNumero(num1) && f.verificaNumero(num2) == true) {
				int numInt1 = (int) num1;
				int numInt2 = (int) num2;
				if (f.verificaNumero(result) == true) {
					int resultInt = (int) result;
					System.out.println("O resultado de: " + numInt1 + " / " + numInt2 + " = " + resultInt);
				} else {
					System.out.printf("O resultado de: " + numInt1 + " / " + numInt2 + " = %.2f", result);
				}
			}
			f.novaOperacao();
		}
	}

}
