package br.com.residencia.poo.primeira.exercicio.um;

import java.util.Scanner;

public class Sistema {

	public static void main(String[] args) {
	
		Scanner n = new Scanner(System.in);
		Dado pessoa = new Dado();
		
		System.out.println("Olá, eu sou o programa bem-vindo!");
		System.out.println("Agora vou te fazer duas perguntas:");
		System.out.println("Qual o seu nome?");
		pessoa.setNome(n.nextLine());
		System.out.println("E sobrenome?");
		pessoa.setSobrenome(n.nextLine());
		n.close();
		//System.out.println("Olá " +pessoa.getNome()+ " " +pessoa.getSobrenome()+", seja bem-vindo(a) ao mundo da programação!" );
		System.out.println(pessoa);

	}

}
