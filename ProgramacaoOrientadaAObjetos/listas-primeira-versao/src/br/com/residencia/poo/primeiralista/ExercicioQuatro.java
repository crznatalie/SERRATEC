package br.com.residencia.poo.primeiralista;

import java.util.Scanner;

public class ExercicioQuatro {

	public static void main(String[] args) {
		Integer c;
		Scanner cel = new Scanner(System.in);
		
		System.out.println("Temperatura em °C: ");
		c = cel.nextInt();
		cel.close();
		System.out.print("Temperatura em °F: " + (c * 1.8 + 32));

	}

}
