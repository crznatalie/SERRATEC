package br.com.residencia.poo.primeiralista;

import java.util.Scanner;

public class ExercicioUm {

	public static void main(String[] args) {
		
		String nome, sobrenome;
		Scanner n = new Scanner(System.in);
		
		System.out.println("Olá, eu sou o programa bem-vindo!");
		System.out.println("Agora vou te fazer duas perguntas:");
		System.out.println("Qual o seu nome?");
		nome = n.nextLine();
		System.out.println("E sobrenome?");
		sobrenome = n.next();
		n.close();
		System.out.println("Olá " + nome + " " + sobrenome + ", seja bem-vindo ao mundo da programação!");

	}

}
