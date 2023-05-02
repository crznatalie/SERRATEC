package br.com.residencia.poo.primeira.exercicio.dois;

public class Pessoas {
	private int idade;
	private int tempoVida = 0;
	
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public int getTempoVida() {
		return tempoVida;
	}
	public void somaIdade(int idade) {
		this.tempoVida += idade;
	}
	
	
	
}
