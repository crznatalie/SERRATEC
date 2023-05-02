package br.com.residencia.poo.segundalista;

import java.util.Scanner;

public class ExercicioTres {

	public static void main(String[] args) {
		Integer num;
		Scanner produtos = new Scanner(System.in);
	
		System.out.println("Quantos produtos você vai comprar?");
		num = produtos.nextInt();
		produtos.close();
		System.out.println("Parabéns por comprar " + num + " produtos!");
	}
}
