package br.com.residencia.poo.primeira.exercicio.tres;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Funcionalidades {

	Scanner sc = new Scanner(System.in);
	Operacoes op = new Operacoes();
	
	public void insereNumeros() {
		try {
		System.out.println("Digite o primeiro número: ");
		op.setNum1(sc.nextDouble());
		}
		catch (InputMismatchException e) {
			System.out.println("Valor inválido!");
			finalizar();
		}
		try {
		System.out.println("Digite o segundo número: ");
		op.setNum2(sc.nextDouble());
		}
		catch (InputMismatchException e) {
			System.out.println("Valor inválido!");
			finalizar();
		}
		escolheOperacao();
	}

	public void escolheOperacao() {



		System.out.println("**************************");
		System.out.println("-Selecione uma operação-");
		System.out.println("**************************");
		System.out.println("[1] Soma");
		System.out.println("[2] Subtração");
		System.out.println("[3] Multiplicação");
		System.out.println("[4] Divisão");
		System.out.println("[5] Fechar calculadora");
		
		try {
		int choice = sc.nextInt();
		
		switch (choice) {

		case 1:
			op.soma(op.getNum1(), op.getNum2());
			break;

		case 2:
			op.sub(op.getNum1(), op.getNum2());
			break;

		case 3:
			op.mult(op.getNum1(), op.getNum2());
			break;

		case 4:
			op.div(op.getNum1(), op.getNum2());
			break;

		case 5:
			finalizar();
			break;
			
		default:
			System.out.println("Opção inválida. Por favor, tente novamente!");
			escolheOperacao();
			break;
		}
		}
		catch (InputMismatchException e) {
			System.out.println("Opção inválida!");
			finalizar();
		}
	}

	public void finalizar() {
		System.out.println("Obrigada por utilizar a mini-calculadora!");
		System.exit(1);
	}

	public void novaOperacao() {

		System.out.println("\nO que gostaria de fazer agora?");
		System.out.println("[1] Iniciar nova operação");
		System.out.println("[2] Fechar calculadora");
		try {
		int choice = sc.nextInt();

		switch (choice) {

		case 1:
			insereNumeros();
			break;

		case 2:
			finalizar();
			break;
			
		default:
			System.out.println("Opção inválida. Por favor, tente novamente!");
			novaOperacao();
			break;
		}
		}
		catch (InputMismatchException e) {
			System.out.println("Valor inválido!");
			finalizar();
		}
	} 
    
	public boolean verificaNumero(double num) {
		if (num*10%10 == 0) {
			//int numInt = (int) num;
			return true;
		}
		return false;
	}
	
}