package br.com.poo.residencia.leituraescrita;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.com.poo.residencia.clientes.Cliente;
import br.com.poo.residencia.contas.Conta;
import br.com.poo.residencia.contas.ContaCorrente;
import br.com.poo.residencia.contas.ContaPoupanca;
import br.com.poo.residencia.contas.SeguroVida;
import br.com.poo.residencia.funcionarios.Diretor;
import br.com.poo.residencia.funcionarios.Gerente;
import br.com.poo.residencia.funcionarios.OperadorDeCaixa;
import br.com.poo.residencia.funcionarios.Presidente;
import br.com.poo.residencia.pessoas.Pessoa;

public abstract class LeituraEscrita {
	public static final String PATH_BASICO = ".\\temp\\";
	public static final String EXTENSAO = ".txt";

	public static void lerClientes() throws IOException {
		String path = "ler_Clientes";
		BufferedReader br = new BufferedReader(new FileReader(PATH_BASICO + path + EXTENSAO));
		String linha = "";

		while (linha != null) {
			linha = br.readLine();
			if (linha != null && !linha.isEmpty()) {
				String[] dados = linha.split(";");
				if (dados[0].equals("Cliente")) {
					if (dados[8].equals("Poupanca")) {
						Cliente cliente = new Cliente(dados[1], dados[2], dados[3], dados[4]);
						ContaPoupanca contaP = new ContaPoupanca(dados[1] + " " + dados[2], dados[3], dados[8],
								Integer.parseInt(dados[5]), Integer.parseInt(dados[6]), Double.parseDouble(dados[7]),
								cliente.getIdCliente());
						Pessoa.mapaPessoas.put(cliente.getIdCliente(), cliente);
						Conta.contas.put(contaP.getIdCliente(), contaP);
					} else {

						Cliente cliente = new Cliente(dados[1], dados[2], dados[3], dados[4]);
						ContaCorrente contaC = new ContaCorrente(dados[1] + " " + dados[2], dados[3], dados[8],
								Integer.parseInt(dados[5]), Integer.parseInt(dados[6]), Double.parseDouble(dados[7]),
								cliente.getIdCliente());
						Pessoa.mapaPessoas.put(cliente.getIdCliente(), cliente);
						Conta.contas.put(contaC.getIdCliente(), contaC);
					}

				} else if (dados[0].equals("Gerente")) {
					Gerente gerente = new Gerente(dados[1], dados[2], dados[3], dados[4], Integer.parseInt(dados[5]));
					Pessoa.mapaPessoas.put(gerente.getIdFuncionario(), gerente);
				} else if (dados[0].equals("Presidente")) {
					Presidente presidente = new Presidente(dados[1], dados[2], dados[3], dados[4]);
					Pessoa.mapaPessoas.put(presidente.getIdFuncionario(), presidente);

				} else if (dados[0].equals("Operador de Caixa")) {
					OperadorDeCaixa opCaixa = new OperadorDeCaixa(dados[1], dados[2], dados[3], dados[4]);
					Pessoa.mapaPessoas.put(opCaixa.getIdFuncionario(), opCaixa);
				} else if (dados[0].equals("Diretor")) {
					Diretor diretor = new Diretor(dados[1], dados[2], dados[3], dados[4], Integer.parseInt(dados[5]),
							Integer.parseInt(dados[6]));
					Pessoa.mapaPessoas.put(diretor.getIdFuncionario(), diretor);
				}

			}

		}

		br.close();

	}

	public static void comprovanteSaque(Conta conta, Double valorSaque) throws IOException {
		String nomeArquivo = conta.getCpfTitular() + "_" + conta.getAgencia() + "_saque";

		DecimalFormat df = new DecimalFormat("#.00");

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO));

		String linha = "********************* SAQUE ***********************";
		buffWrite.append(linha + "\n");

		linha = "\nNome: " + conta.getNomeTitular();
		buffWrite.append(linha + "\n");

		linha = "CPF: " + conta.getCpfTitular();
		buffWrite.append(linha + "\n");

		linha = "Agência: " + conta.getAgencia();
		buffWrite.append(linha + "\n");

		if (conta.getTipoConta().equals("Corrente")) {
			linha = "Conta Corrente: " + conta.getNumConta();
			buffWrite.append(linha + "\n");

			linha = "Valor do saque: R$" + df.format(valorSaque);
			buffWrite.append(linha + "\n");

			linha = "Taxa de saque: R$00.10";
			buffWrite.append(linha + "\n");
		} else {
			linha = "Conta Poupança: " + conta.getNumConta();
			buffWrite.append(linha + "\n");

			linha = "Valor do saque: R$" + df.format(valorSaque);
			buffWrite.append(linha + "\n");
		}

		linha = "Saldo em conta: R$" + df.format(conta.getSaldo());
		buffWrite.append(linha + "\n");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "Operação realizada em: " + sdf.format(date);
		buffWrite.append(linha + "\n");

		linha = "\n******************* FIM SAQUE **********************";
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}

	public static void comprovanteDeposito(Conta conta, Double valorDeposito) throws IOException {
		String nomeArquivo = conta.getCpfTitular() + "_" + conta.getAgencia() + "_deposito";

		DecimalFormat df = new DecimalFormat("#.00");

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO));
		String linha = "******************** DEPÓSITO *********************";
		buffWrite.append(linha + "\n");

		linha = "\nNome: " + conta.getNomeTitular();
		buffWrite.append(linha + "\n");

		linha = "CPF: " + conta.getCpfTitular();
		buffWrite.append(linha + "\n");

		linha = "Agência: " + conta.getAgencia();
		buffWrite.append(linha + "\n");

		if (conta.getTipoConta().equals("Corrente")) {
			linha = "Conta Corrente: " + conta.getNumConta();
			buffWrite.append(linha + "\n");

			linha = "Valor do depósito: R$" + df.format(valorDeposito);
			buffWrite.append(linha + "\n");

			linha = "Taxa de depósito: R$00.10";
			buffWrite.append(linha + "\n");
		} else {
			linha = "Conta Poupança: " + conta.getNumConta();
			buffWrite.append(linha + "\n");

			linha = "Valor do depósito: R$" + df.format(valorDeposito);
			buffWrite.append(linha + "\n");
		}

		linha = "Saldo em conta: R$" + df.format(conta.getSaldo());
		buffWrite.append(linha + "\n");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "Operação realizada em: " + sdf.format(date);
		buffWrite.append(linha + "\n");

		linha = "\n****************** FIM DEPÓSITO *******************";
		buffWrite.append(linha + "\n");

		buffWrite.close();

	}

	public static void comprovanteTransferencia(Conta conta, Conta destino, Double valorTransferencia)
			throws IOException {
		String nomeArquivo = conta.getCpfTitular() + "_" + conta.getAgencia() + "_transferencia";

		DecimalFormat df = new DecimalFormat("#.00");

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO));
		String linha = "****************** TRANSFERÊNCIA ******************";
		buffWrite.append(linha + "\n");

		linha = "\n                     -CLIENTE-                     ";
		buffWrite.append(linha + "\n");

		linha = "\nNome: " + conta.getNomeTitular();
		buffWrite.append(linha + "\n");

		linha = "CPF: " + conta.getCpfTitular();
		buffWrite.append(linha + "\n");

		linha = "Agência: " + conta.getAgencia();
		buffWrite.append(linha + "\n");

		if (conta.getTipoConta().equals("Corrente")) {
			linha = "Conta Corrente: " + conta.getNumConta();
			buffWrite.append(linha + "\n");

			linha = "Taxa de transferência: R$00.20";
			buffWrite.append(linha + "\n");

			linha = "Valor transferido: R$" + df.format(valorTransferencia);
			buffWrite.append(linha + "\n");
		} else {
			linha = "Conta Poupança: " + conta.getNumConta();
			buffWrite.append(linha + "\n");

			linha = "Valor transferido: R$" + df.format(valorTransferencia);
			buffWrite.append(linha + "\n");
		}

		linha = "Saldo em conta: R$" + df.format(conta.getSaldo());
		buffWrite.append(linha + "\n");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "Operação realizada em: " + sdf.format(date);
		buffWrite.append(linha + "\n");

		linha = "\n---------------------------------------------------";
		buffWrite.append(linha + "\n");

		linha = "                    -FAVORECIDO-                   ";
		buffWrite.append(linha + "\n");

		linha = "Nome: " + destino.getNomeTitular();
		buffWrite.append(linha + "\n");

		linha = "CPF: " + destino.getCpfTitular();
		buffWrite.append(linha + "\n");

		linha = "Agência: " + destino.getAgencia();
		buffWrite.append(linha + "\n");

		if (destino.getTipoConta().equals("Corrente")) {
			linha = "Conta Corrente: " + destino.getNumConta();
			buffWrite.append(linha + "\n");

			linha = "Valor recebido: R$" + df.format(valorTransferencia);
			buffWrite.append(linha + "\n");
		} else {
			linha = "Conta Poupança: " + destino.getNumConta();
			buffWrite.append(linha + "\n");

			linha = "Valor recebido: R$" + df.format(valorTransferencia);
			buffWrite.append(linha + "\n");
		}

		linha = "\n**************** FIM TRANSFERÊNCIA ****************";
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}

	public static void comprovanteSimulacao(ContaPoupanca conta, Double valorFinal, Double valorInicial,
			Double valorRendimento, String dataF, int meses) throws IOException {
		String nomeArquivo = conta.getCpfTitular() + "_" + conta.getAgencia() + "_simulacao";

		DecimalFormat df = new DecimalFormat("#.00");

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO));
		String linha = "*************** SIMULAÇÃO RENDIMENTO **************";
		buffWrite.append(linha + "\n");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "\n               -" + sdf.format(date) + "-               ";
		buffWrite.append(linha + "\n");

		linha = "\nNome: " + conta.getNomeTitular();
		buffWrite.append(linha + "\n");

		linha = "CPF: " + conta.getCpfTitular();
		buffWrite.append(linha + "\n");

		linha = "Agência: " + conta.getAgencia();
		buffWrite.append(linha + "\n");

		linha = "Conta: " + conta.getNumConta();
		buffWrite.append(linha + "\n");

		SimpleDateFormat sdfSim = new SimpleDateFormat("dd/MM/yyyy");
		linha = "\nValor em " + sdfSim.format(date) + ": R$" + df.format(valorInicial);
		buffWrite.append(linha + "\n");

		linha = "Valor em " + dataF + ": R$" + df.format(valorFinal);
		buffWrite.append(linha + "\n");

		linha = "Rendimento simulado em " + meses + " meses: R$" + df.format(valorRendimento);
		buffWrite.append(linha + "\n");

		linha = "\n****************** FIM SIMULACAO ******************";
		buffWrite.append(linha + "\n");

		buffWrite.close();

	}

	public static void relatorioTributacao(Conta conta) throws IOException {
		String nomeArquivo = conta.getCpfTitular() + "_" + conta.getAgencia() + "_tributacao";

		DecimalFormat df = new DecimalFormat("00.00");

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO));
		String linha = "******************* TRIBUTAÇÃO ********************";
		buffWrite.append(linha + "\n");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "\n               -" + sdf.format(date) + "-               ";
		buffWrite.append(linha + "\n");

		linha = "\nNome: " + conta.getNomeTitular();
		buffWrite.append(linha + "\n");

		linha = "CPF: " + conta.getCpfTitular();
		buffWrite.append(linha + "\n");

		linha = "Depósitos: " + conta.getTotalDeposito();
		buffWrite.append(linha + "\n");

		linha = "Saques: " + conta.getTotalSaque();
		buffWrite.append(linha + "\n");

		linha = "Transferências: " + conta.getTotalTransferencia();
		buffWrite.append(linha + "\n");


		if (conta.isTemSeguro()) {
	
			SeguroVida sv = SeguroVida.mapaSeguroVida.get(conta.getIdCliente());
			linha = "Seguro de vida contratado no valor de R$" + sv.getValorSeguro();
			buffWrite.append(linha + "\n");
			
			linha = "Total tributado: R$" + (df.format(conta.totalGasto() + sv.getValorDesconto()));
			buffWrite.append(linha + "\n");
			
			linha = "\n*************************************************** \nTaxa de saque: R$00.10\nTaxa de depósito: R$00.10\nTaxa de transferência: R$00.20\nTaxa de contratação do seguro de vida: R$" 
					+ df.format(sv.getValorDesconto())
					+ "\n***************************************************";
			buffWrite.append(linha + "\n");
			
		}
		else {
		linha = "Total tributado: R$" + df.format(conta.totalGasto());
		buffWrite.append(linha + "\n");
			
		linha = "\n***************************************************\nTaxa de saque: R$00.10 \nTaxa de depósito: R$00.10 \nTaxa de transferência: R$00.20\n***************************************************";
		buffWrite.append(linha + "\n");
		}
		
		buffWrite.close();

	}

	public static void cabecalho(BufferedWriter buffWrite, Conta conta) throws IOException {

		DecimalFormat df = new DecimalFormat("#.00");
		String linha = "*********************************************************";
		buffWrite.append(linha + "\n");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "                  -" +sdf.format(date)+ "-                  ";
		buffWrite.append(linha + "\n");

		linha = "Nome: " + conta.getNomeTitular();
		buffWrite.append(linha + "\n");

		linha = "CPF: " + conta.getCpfTitular();
		buffWrite.append(linha + "\n");

		linha = "Agência: " + conta.getAgencia();
		buffWrite.append(linha + "\n");

		if (conta.getTipoConta().equals("Corrente")) {
			linha = "Conta Corrente: " + conta.getNumConta();
			buffWrite.append(linha + "\n");
		} else {
			linha = "Conta Poupança: " + conta.getNumConta();
			buffWrite.append(linha + "\n");
		}

		linha = "Saldo atual: R$" + df.format(conta.getSaldo());
		buffWrite.append(linha + "\n");

		linha = "\n*********************** HISTÓRICO ***********************\n";
		buffWrite.append(linha + "\n");
	}
	
	public static void extrato(int idConta, Double valor, String operacao, Conta destino) throws IOException {
		Conta conta = Conta.contas.get(idConta);
		String nomeArquivo = conta.getCpfTitular() + "_" + conta.getAgencia() + "_extrato";

		BufferedWriter bf = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO, true));
		if (conta.getTotalOperacoes() == 1) {
			cabecalho(bf, conta);	
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		
		
		if (operacao.equals("Saque") || operacao.equals("Depósito") && conta.getTipoConta().equals("Corrente")) {
			String l = "Tipo de operação: " + operacao + "\nValor: R$" + valor
					+ "\nTaxa: R$00.10 \nOperação realizada em: " + sdf.format(date) + "\n---------------------------------------------------------\n";
			bf.append(l + "\n");
		} else if (operacao.equals("Saque") || operacao.equals("Depósito") && conta.getTipoConta().equals("Poupança")){
			String l = "Tipo de operação: " + operacao + "\nValor: R$" + valor + "\nOperação realizada em: "
					+ sdf.format(date) + "\n---------------------------------------------------------\n";
			bf.append(l + "\n");
		}
		else if (operacao.equals("Transferência") && conta.getTipoConta().equals("Corrente")) {
			String l = "Tipo de operação: " + operacao + "\nFavorecido: " + destino.getNomeTitular() + "\nValor: R$"
					+ valor + "\nTaxa: R$00.20 \nOperação realizada em: " + sdf.format(date) + "\n---------------------------------------------------------\n";
			bf.append(l + "\n");
		} 
		else if (operacao.equals("Transferência") && conta.getTipoConta().equals("Poupança")){
			String l = "Tipo de operação: " + operacao + "\nFavorecido: " + destino.getNomeTitular() + "\nValor: R$"
					+ valor + "\nOperação realizada em: " + sdf.format(date) + "\n---------------------------------------------------------\n";
			bf.append(l + "\n");
		}
		bf.close();

	}

	public static void imprimirRelatorios(ArrayList<String> linhas, Pessoa p) throws IOException {
		String nomeArquivo = p.getNome() + " " + p.getSobrenome() + "_" + p.getTipoPessoa() + "_relatório";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO, true));
		String linha;

		if (p.getTipoPessoa().equals("Gerente")) {
			linha = "******************* RELATÓRIO GERENTE *******************";
			buffWrite.append(linha + "\n");
		} else if (p.getTipoPessoa().equals("Diretor")) {
			linha = "******************* RELATÓRIO DIRETOR *******************";
			buffWrite.append(linha + "\n");
		}

		else if (p.getTipoPessoa().equals("Presidente")) {
			linha = "***************** RELATÓRIO PRESIDENTE ******************";
			buffWrite.append(linha + "\n");
		}

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "                  -" + sdf.format(date) + "-                  \n";
		buffWrite.append(linha + "\n");

		for (String escreve : linhas) {
			buffWrite.append(escreve + "\n");
		}
		linha = "\n*********************************************************";
		buffWrite.append(linha + "\n");

//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//		Date date = new Date();
		linha = "\nOperação realizada em: " + sdf.format(date);
		buffWrite.append(linha + "\n");
		buffWrite.close();

	}
}
