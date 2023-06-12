package br.com.residencia.poo.segunda.exercicio.tres;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Produtos num = new Produtos();
		
		System.out.println("Quantos produtos você vai comprar?");
		num.setN(sc.nextInt());
		sc.close();
		System.out.println("Parabéns por comprar " + num.getN() + " produtos.");
	}

}
