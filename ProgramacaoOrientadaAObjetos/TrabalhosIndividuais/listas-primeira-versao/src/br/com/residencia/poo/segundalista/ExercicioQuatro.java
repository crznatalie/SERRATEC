package br.com.residencia.poo.segundalista;

import java.util.Scanner;

public class ExercicioQuatro {

	public static void main(String[] args) {
		
		String nome1;
		Scanner n = new Scanner(System.in);
		
		System.out.println("Qual é o seu nome?");
		nome1 = n.nextLine();
		System.out.println("Como você gostaria de ser chamado?");
		nome1 = n.next();
		n.close();
		System.out.println("Olá, " + nome1);

	}

}
