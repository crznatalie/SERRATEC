package br.com.residencia.poo.primeiralista;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExercicioTres {

	public static void main(String[] args) {
		
		Integer n1, n2, soma, sub, mult, div;
		Scanner n = new Scanner(System.in);
	
		try {
		System.out.println("Número 1: ");
		n1 = n.nextInt();
		//System.out.println(n);
		}
		catch (InputMismatchException e) {
			System.out.println("Valor inserido diferene de número. ");
			n.reset();
			n1 = n.nextInt();
		}
	
		System.out.println("Número 2: ");
		n2 = n.nextInt();
		
		
		n.close();
		soma = n1 + n2;
		System.out.println("Soma: " + soma);
		sub = n1 - n2;
		System.out.println("Subtração: " + sub);
		mult = n1 * n2;
		System.out.println("Multiplicação: " + mult);
		div = n1 / n2;
		System.out.println("Divisão: " + div);
	}

	}

