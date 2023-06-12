package projeto.contas;

public class cliente {
	private String nome;
	private String sobrenome;
	private String cpf;
	private int idade;
	
	public void mudaCPF (String cpf ) {
		if (this.idade <= 60 ) {
		validaCPF(cpf);
		}
		this.cpf = cpf;
	}
	
	private void validaCPF (String cpf) {
		
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
