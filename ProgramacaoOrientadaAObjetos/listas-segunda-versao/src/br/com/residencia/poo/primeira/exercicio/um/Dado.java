package br.com.residencia.poo.primeira.exercicio.um;

public class Dado {

	private String nome;
	private String sobrenome;
	
	
	public String getNome() {
		return nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String toString() {
		return "Olá "
				+ nome
				+ " "
				+ sobrenome
				+ ", seja bem-vindo(a) ao mundo da programação!";
	}
}
