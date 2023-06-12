package br.com.poo.residencia.funcionarios;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import br.com.poo.residencia.contas.Conta;
import br.com.poo.residencia.leituraescrita.LeituraEscrita;
import br.com.poo.residencia.menus.Utilitarios;
import br.com.poo.residencia.pessoas.Pessoa;

//a. Relatório com o valor total do capital armazenado no banco.

public class Presidente extends Diretor {
	private Double capitalTotal = 0.0;

	public Presidente() {

	}

	public Presidente(String nome, String sobrenome, String cpf, String senha) {
		super(nome, sobrenome, cpf, senha);
		super.getIdAgencia().add(5080);
		super.getIdAgencia().add(5081);
		super.getIdAgencia().add(5082);
		super.getIdAgencia().add(5083);
		this.tipoPessoa = "Presidente";
		this.idFuncionario = super.getIdPessoa();
		super.setIdPessoa(super.getIdPessoa()+1);
	}

	public void gerarRelatorioPresidente(Pessoa presidente) throws IOException {
		ArrayList<String> linhas = new ArrayList<>();
		for (Entry<Integer, Conta> mapaPresidente : Conta.contas.entrySet()) {
			Conta conta1 = mapaPresidente.getValue();
			capitalTotal = capitalTotal + conta1.getSaldo();
		}
		linhas.add("Capital total: " + capitalTotal);
		System.out.println("Capital total: " + capitalTotal);
		LeituraEscrita.imprimirRelatorios(linhas, presidente);
	}

	public void relatorioParcialDiretor(Pessoa presidente) throws IOException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Qual diretor você gostaria de verificar o Relatório?");
		int cont = 1;
		int opc;
		Map <Integer,Pessoa> diretores = new HashMap<>();
		for (Entry<Integer,Pessoa> pessoas : Pessoa.mapaPessoas.entrySet()) {
			Pessoa dr = pessoas.getValue();
			if(dr.getTipoPessoa().equalsIgnoreCase("Diretor")) {
				System.out.println("["+cont+"] "+dr.getNome()+" "+dr.getSobrenome());
				diretores.put(cont,dr);
				cont++;
			}
		}
		
		opc = sc.nextInt();
		Pessoa diretor = new Diretor();
		switch (opc) {
		case 1:
			Utilitarios.limparTela();
			Utilitarios.imprimeLinha();
			diretor = diretores.get(1);
			presidente.gerarRelatorioDiretor(diretor);
			break;
		case 2:
			Utilitarios.limparTela();
			Utilitarios.imprimeLinha();
			diretor = diretores.get(2);
			presidente.gerarRelatorioDiretor(diretor);
			break;
		}
	}

}
