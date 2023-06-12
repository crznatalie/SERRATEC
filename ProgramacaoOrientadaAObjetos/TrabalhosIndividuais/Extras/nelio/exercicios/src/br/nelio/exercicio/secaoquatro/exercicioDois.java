package br.nelio.exercicio.secaoquatro;

import java.util.Scanner;
import java.util.Locale;

public class exercicioDois {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in); 
		double raio, result;
		
		System.out.println("Informe o valor do raio: ");
		raio = sc.nextDouble();
		sc.close();
		result = 3.14159 * (Math.pow(raio, 2));
		System.out.printf("A área do círculo é igual a: %.4f%n", result);
		

	}

}
