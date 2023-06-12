package br.com.poo.residencia.funcionarios;


import br.com.poo.residencia.pessoas.Pessoa;

public class OperadorDeCaixa extends Pessoa {
	protected int idFuncionario;

	public OperadorDeCaixa(String nome, String sobrenome, String cpf, String senha) {
		super(nome, sobrenome, cpf, senha);
		this.tipoPessoa = "Operador de Caixa";
		this.idFuncionario = super.getIdPessoa();
		super.setIdPessoa(super.getIdPessoa()+1);

	}

	@Override
	public int compareTo(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return 0;
	}

}
