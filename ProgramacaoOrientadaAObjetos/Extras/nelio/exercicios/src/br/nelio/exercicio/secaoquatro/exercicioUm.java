package br.nelio.exercicio.secaoquatro;

import java.util.Scanner;

public class exercicioUm {

	public static void main(String[] args) {
		
		int valor1, valor2, soma;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o primeiro valor:");
		valor1 = sc.nextInt();
		System.out.println("Informe o segundo valor:");
		valor2 = sc.nextInt();
		sc.close();
		soma = valor1 + valor2;
		System.out.println("A soma entre " +valor1+ " e " +valor2+ " é igual a: " +soma );

	}

}
