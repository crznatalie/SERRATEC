package br.com.residencia.poo.primeira.exercicio.quatro;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Conversao tempF = new Conversao();
		
		System.out.println("Informe uma temperatura em °C para conversão.");
		tempF.conversao(sc.nextInt());
		sc.close();
		System.out.println("Temperatura em °F: " + tempF.getTempF());
		
		
		

	}

}
