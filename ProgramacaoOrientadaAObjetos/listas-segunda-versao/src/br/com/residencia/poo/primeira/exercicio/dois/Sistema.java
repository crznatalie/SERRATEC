package br.com.residencia.poo.primeira.exercicio.dois;

import java.util.Scanner;

public class Sistema {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Pessoas ano = new Pessoas();
		
		
		System.out.println("Olá, eu sou o programa tempo de vida!");
		System.out.println("Agora eu vou te fazer três perguntas:");
		for (int i = 0; i<2; i++) {
			System.out.println("Qual é a idade do " +(i+1)+ "o colega?");
			//ano.setIdade(sc.nextInt());
			ano.somaIdade(sc.nextInt());
		}
		
		System.out.println("Qual a sua idade?");
		ano.somaIdade(sc.nextInt());
		sc.close();
		System.out.println("O seu tempo de vida junto com o de seus colegas é de: " + ano.getTempoVida()+ " anos." );
		
	}
}
