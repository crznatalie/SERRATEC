package br.com.poo.residencia.funcionarios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.TreeMap;
import br.com.poo.residencia.clientes.Cliente;
import br.com.poo.residencia.contas.Conta;
import br.com.poo.residencia.leituraescrita.LeituraEscrita;
import br.com.poo.residencia.pessoas.Pessoa;

public class Diretor extends Gerente {
	public Diretor(String nome, String sobrenome, String cpf, String senha, int idAgencia1, int idAgencia2) {
		super(nome, sobrenome, cpf, senha);
		super.getIdAgencia().add(idAgencia1);
		super.getIdAgencia().add(idAgencia2);
		this.tipoPessoa = "Diretor";
		this.idFuncionario = super.getIdPessoa();
		super.setIdPessoa(super.getIdPessoa() + 1);
	}

	public Diretor() {

	}

	public Diretor(String nome, String sobrenome, String cpf, String senha) {
		super(nome, sobrenome, cpf, senha);
	}

	// a. Relatório com as informações de Nome, CPF e Agência de todos os
	// clientes do sistema em ordem alfabética

	public void gerarRelatorioDiretor(Pessoa diretor) throws IOException {
		ArrayList<String> linhas = new ArrayList<>();

		Map<Integer, Pessoa> treeMap = new TreeMap<>(new Comparator<Integer>() {
			public int compare(Integer pessoa1, Integer pessoa2) {
				return Pessoa.mapaPessoas.get(pessoa1).getNome().compareTo(Pessoa.mapaPessoas.get(pessoa2).getNome());
			}
		});

		System.out.print("Contas cadastradas nas agências ");
		for (Integer id : diretor.getIdAgencia()) {
			System.out.print(id + " ");
		}
		System.out.println();

		// Adicionando todos os elementos do HashMap ao TreeMap usando putAll()
		treeMap.putAll(Pessoa.mapaPessoas);
		for (Entry<Integer, Pessoa> clientes : treeMap.entrySet()) {
			Pessoa c1 = clientes.getValue();
			if (c1.getTipoPessoa().equals("Cliente")) {
				Pessoa cliente = new Cliente();
				cliente = Pessoa.mapaPessoas.get(c1.getIdCliente());
				Conta conta = Conta.contas.get(cliente.getIdCliente());
				for (Integer idAg : diretor.getIdAgencia()) {
					if (conta.getAgencia() == idAg) {
						System.out.println("\nNome: " + conta.getNomeTitular() + "\nCPF: " + conta.getCpfTitular() + "\tAG: "
								+ conta.getAgencia() + "\tTipo: " + conta.getTipoConta());
						
						
						linhas.add("\n" + conta.getNomeTitular() + "\n" + conta.getCpfTitular() + "\t"
								+ conta.getAgencia() + "\t" + conta.getTipoConta());
				LeituraEscrita.imprimirRelatorios(linhas, diretor);
					}
				}

			}

		}
	}

	public void relatorioParcialGerente(Pessoa diretor) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Qual gerente você gostaria de verificar o Relatório?");
		int cont = 1;
		int opc;
		Map<Integer, Pessoa> gerentes = new HashMap<>();
		for (Entry<Integer, Pessoa> mapa : Pessoa.mapaPessoas.entrySet()) {
			Pessoa gerente = mapa.getValue();
			for (Integer idDiretor : diretor.getIdAgencia()) {
				for (Integer idGerente : gerente.getIdAgencia()) {
					if (gerente.getTipoPessoa().equals("Gerente") && idDiretor.equals(idGerente)) {
						for (Integer id : gerente.getIdAgencia()) {
							System.out.println("[" + cont + "]" + " " + gerente.getNome() + " " + gerente.getSobrenome()
									+ " \tAG: " + id);
							gerentes.put(cont, gerente);
							cont++;
						}
					}

				}
			}
		}
		opc = sc.nextInt();
		Pessoa gerente = new Gerente();
		switch (opc) {
		case 1:
			gerente = gerentes.get(1);
			diretor.gerarRelatorioGerente(gerente);
			break;
		case 2:
			gerente = gerentes.get(2);
			diretor.gerarRelatorioGerente(gerente);
			break;
		case 3:
			gerente = gerentes.get(3);
			diretor.gerarRelatorioGerente(gerente);
			break;
		case 4:
			gerente = gerentes.get(4);
			diretor.gerarRelatorioGerente(gerente);
			break;
		}

	}
}