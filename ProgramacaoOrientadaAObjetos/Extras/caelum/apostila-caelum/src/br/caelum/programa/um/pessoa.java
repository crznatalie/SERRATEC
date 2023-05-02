package br.caelum.programa.um;

public class pessoa {
	public String nome;
	public int idade;
	
	public void fazAniversario() {
		idade += 1;
	}
	
	public String toString() {
		return "Nome: "
				+ nome
				+ ", Idade: "
				+ idade;
	}
}
