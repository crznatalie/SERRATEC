package br.com.poo.residencia.pessoas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.com.poo.residencia.clientes.Cliente;
import br.com.poo.residencia.leituraescrita.LeituraEscrita;

public abstract class Pessoa {
	protected String nome;
	protected String sobrenome;
	protected String cpf;
	protected String senha;
	protected String tipoPessoa;
	protected static int idPessoa = 1001;
	protected ArrayList<Integer> idAgencia = new ArrayList<>();

	public static Map<Integer, Pessoa> mapaPessoas = new HashMap<>();

	public Pessoa() {
	}

	public void gerarRelatorioDiretor(Pessoa p) throws IOException {
		System.out.println("Você não é Diretor");
	}

	public void gerarRelatorioGerente(Pessoa gr) throws IOException {
		System.out.println("Você não é Gerente!");
	}

	public void gerarRelatorioPresidente(Pessoa p) throws IOException {
		System.out.println("Você não é Presidente!");
	}

	public void relatorioParcialGerente(Pessoa gr) throws IOException {
		System.out.println("Você não é Diretor!");
	}

	public void relatorioParcialDiretor(Pessoa gr) throws IOException {
		System.out.println("Você não é Presidente!");
	}

	public void gerarRelatorioCliente(Pessoa gr) {
		System.out.println("Você não é Presidente!");
	}

	public Pessoa(String nome, String sobrenome, String cpf, String senha) {
		this.setNome(nome);
		this.setSobrenome(sobrenome);
		this.cpf = cpf;
		this.setSenha(senha);
		this.tipoPessoa = "Pessoa";

	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public ArrayList<Integer> getIdAgencia() {
		return idAgencia;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		Pessoa.idPessoa = idPessoa;
	}

	public int getIdCliente() {
		return 0;

	}

	public int getIdFuncionario() {
		return 0;

	}

	public void mudarSenha(Pessoa cliente) throws IOException {
		String path = "ler_Clientes";
		BufferedReader br = new BufferedReader(
				new FileReader(LeituraEscrita.PATH_BASICO + path + LeituraEscrita.EXTENSAO));
		String linha = "";
		String nome = "ler_Clientes" + ".tmp";
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(LeituraEscrita.PATH_BASICO + nome));

		while (linha != null) {
			linha = br.readLine();
			if (linha != null && !linha.isEmpty()) {
				String[] dados = linha.split(";");
				if (dados[3].equals(cliente.getCpf())) {
					System.out.println("Digite a nova senha");
					Scanner sc = new Scanner(System.in);
					String novaSenha = sc.next();
					dados[4] = novaSenha;
					linha = String.join(";", dados);
				}
				buffWrite.write(linha + "\n");
			}
		}

		// Fechar os arquivos
		br.close();
		buffWrite.close();
		File arquivoAntigo = new File(LeituraEscrita.PATH_BASICO + path + LeituraEscrita.EXTENSAO);
		File arquivoNovo = new File(LeituraEscrita.PATH_BASICO + path + ".tmp");
		arquivoAntigo.delete();
		arquivoNovo.renameTo(arquivoAntigo);

		System.out.println("Senha alterada com sucesso!");

	}

	public abstract int compareTo(Pessoa pessoa);

}
