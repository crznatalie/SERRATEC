package br.com.residencia.poo.primeiralista;

import java.util.Scanner;

public class ExercicioDois {

	public static void main(String[] args) {
		int idade, soma;
		Scanner n = new Scanner(System.in);
		
		System.out.println("Olá, eu sou o programa tempo de vida!");
		System.out.println("Agora eu vou te fazer duas perguntas:");
		soma = 0;
		for (int i = 0; i < 2; i++) {
			System.out.println("Qual a idade do "+(i+1)+"o colega?");
			idade = n.nextInt();
			soma += idade;
		}
		
		System.out.println("Qual é a minha idade?");
		idade = n.nextInt();
		n.close();
		soma += idade;
		System.out.println("O tempo de vida meu e dos meus colegas é " + soma);
		

	}

}
