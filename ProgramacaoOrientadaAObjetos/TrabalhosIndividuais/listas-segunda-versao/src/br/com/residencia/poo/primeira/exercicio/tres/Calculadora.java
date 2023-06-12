package br.com.residencia.poo.primeira.exercicio.tres;

import java.util.Scanner;



public class Calculadora {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Funcionalidades func = new Funcionalidades();
		
		System.out.println("**************************\n");
		System.out.println("-----mini-calculadora-----\n");
		System.out.println("**************************\n");
		
		func.insereNumeros();	
		
		sc.close();
		
		
		
		
	}

}
