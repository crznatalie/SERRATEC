package br.com.residencia.poo.segunda.exercicio.quatro;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Nome n = new Nome();
		
		System.out.println("Qual é o seu nome?");
		n.setNome(sc.nextLine());
		System.out.println(n.getNome()+ ", como você prefere ser chamado(a)?");
		n.setNome(sc.nextLine());
		sc.close();
		System.out.println("Olá, " +n.getNome()+ ".");

	}

}
