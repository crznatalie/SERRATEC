package br.com.poo.residencia.funcionarios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import br.com.poo.residencia.contas.Conta;
import br.com.poo.residencia.leituraescrita.Data;
import br.com.poo.residencia.leituraescrita.LeituraEscrita;
import br.com.poo.residencia.menus.Utilitarios;
import br.com.poo.residencia.pessoas.Pessoa;

//a. Relatório do número contas na mesma agência em que este gerente
//trabalha

public class Gerente extends Pessoa {
	int contPoup = 0;
	int contCor = 0;
	protected int idFuncionario;

	public Gerente(String nome, String sobrenome, String cpf, String senha, int idAgencia) {
		super(nome, sobrenome, cpf, senha);
		this.tipoPessoa = "Gerente";
		super.getIdAgencia().add(idAgencia);
		this.idFuncionario = super.getIdPessoa();
		super.setIdPessoa(super.getIdPessoa() + 1);
	}

	public Gerente(String nome, String sobrenome, String cpf, String senha) {
		super(nome, sobrenome, cpf, senha);
	}

	public Gerente() {

	}

	public void gerarRelatorioGerente(Pessoa gerente) throws IOException {
		ArrayList<String> linhas = new ArrayList<>();
		Utilitarios.limparTela();
		Utilitarios.imprimeLinha();
		Map<Integer, Integer> contaAgencia = new HashMap<>();
		for (Entry<Integer, Conta> conta : Conta.contas.entrySet()) {
			Conta conta1 = conta.getValue();
			for (Integer id : gerente.getIdAgencia()) {
				if (conta1.getAgencia() == id && conta1.getTipoConta().equals("Corrente")) {
					if (contaAgencia.containsKey(id)) {
						int count = contaAgencia.get(id);
						contaAgencia.put(id, count + 1);
					} else {
						contaAgencia.put(id, 1);
					}

				} else if (conta1.getAgencia() == id && conta1.getTipoConta().equals("Poupanca")) {
					if (contaAgencia.containsKey(id)) {
						int count = contaAgencia.get(id);
						contaAgencia.put(id, count + 1);
					} else {
						contaAgencia.put(id, 1);
					}
				}
			}
		}
		for (Entry<Integer, Integer> totalConta : contaAgencia.entrySet()) {
			System.out.println("Total de " + totalConta.getValue() + " contas na Agência " + totalConta.getKey()
					+ " em: " + Data.getData());
			linhas.add("Total de " + totalConta.getValue() + " contas na Agência " + totalConta.getKey());
			LeituraEscrita.imprimirRelatorios(linhas, this);
		}
	}

	public void gerarRelatorioCliente(Pessoa gerente) {
		int cont = 1;
		int escolha;
		Scanner sc = new Scanner(System.in);
		Utilitarios.limparTela();
		Utilitarios.imprimeLinha();
		System.out.println("Clientes cadastrados na agência ");
		for (Integer idAgencia : this.idAgencia) {
			System.out.print(idAgencia + " ");
		}
		Map<Integer, Conta> contas = new HashMap<>();
		for (Entry<Integer, Conta> conta : Conta.contas.entrySet()) {
			Conta conta1 = conta.getValue();
			for (Integer idGerente : this.getIdAgencia()) {
				if (conta1.getAgencia() == idGerente) {
					System.out.println(
							"\n\n[" + cont + "] " + conta1.getNomeTitular() + "\nNum. Conta:\t\t" + conta1.getNumConta()
									+ "\nAgência:\t\t" + conta1.getAgencia() + "\nTipo:\t\t\t" + conta1.getTipoConta());
					contas.put(cont, conta1);
					cont++;
				}
			}
		}
		System.out.println("\nQual cliente deseja verificar? ");
		escolha = sc.nextInt();
		Utilitarios.limparTela();
		Utilitarios.imprimeLinha();

		if (contas.get(escolha).getTipoConta().equals("Corrente")) {
			Conta contaC = contas.get(escolha);
			System.out.println(contaC);
		} else if (contas.get(escolha).getTipoConta().equals("Poupanca")) {
			Conta contaP = contas.get(escolha);
			System.out.println(contaP);

		}

	}

	@Override
	public String toString() {
		return "Gerente [idAgencia=" + getIdAgencia() + ", nome=" + nome + ", sobrenome=" + sobrenome + ", tipoPessoa="
				+ tipoPessoa + "]";
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	@Override
	public int compareTo(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return 0;
	}

}
