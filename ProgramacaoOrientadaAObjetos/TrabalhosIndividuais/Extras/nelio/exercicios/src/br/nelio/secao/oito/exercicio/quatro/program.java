package br.nelio.secao.oito.exercicio.quatro;

import java.util.Locale;
import java.util.Scanner;

public class program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What is the dollar price? ");
		dolar.dolarP = sc.nextDouble();
		System.out.println("How many dollars will be bought? ");
		dolar.dolarB = sc.nextDouble();
		sc.close();
		
		System.out.printf("Amount to be paid in reais = %.2f%n", dolar.convert());

	}

}
