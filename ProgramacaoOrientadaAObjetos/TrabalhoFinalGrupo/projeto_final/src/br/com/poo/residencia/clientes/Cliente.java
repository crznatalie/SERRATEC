package br.com.poo.residencia.clientes;

import br.com.poo.residencia.pessoas.Pessoa;

public class Cliente extends Pessoa {
	protected int idCliente;

	public Cliente() {
	}

	public Cliente(String nome, String sobrenome, String cpf, String senha) {
		super(nome, sobrenome, cpf, senha);
		this.tipoPessoa = "Cliente";
		this.idCliente = super.getIdPessoa();
		super.setIdPessoa(super.getIdPessoa()+1);
	}

	public int getIdCliente() {
		return idCliente;
	}

	@Override
	public int compareTo(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return 0;
	}

}
