package br.com.residencia.poo.primeira.exercicio.cinco;

public class Operacao {

	private int respA;
	private int respB;

	public void getRespA() {
		respA =  2 + 3 - 5 * 8 - 4 + 354 - 521 + 7 * 66;
		System.out.println("A resultado da expressão é: " + respA);
	}
	
	public void getRespB() {
		respB =  2 + 7 * (14 - 21) + 28 * 3 * 42 + 740 - (156 + 4 + 40) * 9;
		System.out.println("A resultado da expressão é: " + respB);
	}

	
}
