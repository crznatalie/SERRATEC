package br.com.poo.residencia.contas;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import br.com.poo.residencia.leituraescrita.LeituraEscrita;


public abstract class Conta {
	protected int agencia;
	protected int numConta;
	protected String cpfTitular;
	protected String nomeTitular;
	protected Double saldo;
	protected String tipoConta;
	protected Double totalGasto = 0.0;
	protected Double rendimento;
	protected Integer totalSaque = 0;
	protected Integer totalDeposito = 0;
	protected Integer totalTransferencia = 0;
	protected Integer totalOperacoes = 0;
	protected int idCliente;
	protected boolean temSeguro = false;
	public static Map<Integer, Conta> contas = new HashMap<>();
	
	

public Conta() {}

	public Conta(String nomeTitular, String cpfTitular, String tipoConta, int agencia, int numConta, Double valor) {
		this.saldo = valor;
		this.nomeTitular = nomeTitular;
		this.cpfTitular = cpfTitular;
		this.agencia = agencia;
		this.numConta = numConta;
		this.tipoConta = tipoConta;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public int getNumConta() {
		return numConta;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public int getAgencia() {
		return agencia;
	}
	
	
	
	public boolean isTemSeguro() {
		return temSeguro;
	}

	public Integer getTotalOperacoes() {
		return totalOperacoes;
	}

	public void rendimento() throws IOException {
		
	}
	
	

	public boolean sacar(Double valor) throws IOException {
		Locale.setDefault(Locale.US);
		if (this.saldo < valor) {
			System.out.println("Não foi possível realizar operação");
			return false;
		} else {
			this.saldo -= valor;
			System.out.println("Operaçao realizada com sucesso!");
			Conta.atualizarSaldo(this.idCliente,this.saldo);
			LeituraEscrita.comprovanteSaque(Conta.this, valor);
			//LeituraEscrita.extrato(this.idCliente, valor, "Saque");
			return true;
		}
	}

	public boolean depositar(Double valor) throws IOException {
		Locale.setDefault(Locale.US);
		if (this.saldo == null) {
			this.saldo = 0.0;
		}
		this.saldo += valor;
		System.out.println("Operaçao realizada com sucesso!");
		Conta.atualizarSaldo(this.idCliente, this.saldo);
		LeituraEscrita.comprovanteDeposito(Conta.this, valor);
		//LeituraEscrita.extrato(this.idCliente, valor, "Depósito");
		return true;
	}

	public boolean transferir(Double valor, Conta destino) throws IOException {
		Locale.setDefault(Locale.US);
		if (this.saldo < (valor)) {
			System.out.println("Não foi possível realizar operação");
			return false;
		} else {
			this.saldo -= (valor);
			destino.saldo += valor;
			System.out.println("Operação realizada com sucesso :)");
			Conta.atualizarSaldo(this.idCliente,this.saldo);
			Conta.atualizarSaldo(destino.idCliente,destino.saldo);
			LeituraEscrita.comprovanteTransferencia(Conta.this, destino, valor);
			//LeituraEscrita.extrato(this.idCliente, valor, "Transferência", destino);
			return true;
		}
		
		
	}
	
	public Double totalGasto() {
		return totalGasto;
	}
	
	
	public Integer getTotalSaque() {
		return totalSaque;
	}

	public Integer getTotalDeposito() {
		return totalDeposito;
	}

	public Integer getTotalTransferencia() {
		return totalTransferencia;
	}

	public String getCpfTitular() {
		return this.cpfTitular;
	}
	public static void atualizarSaldo(Integer idConta, Double saldoNovo) throws IOException {
		String path = "ler_Clientes";
		BufferedReader br = new BufferedReader(
				new FileReader(LeituraEscrita.PATH_BASICO + path + LeituraEscrita.EXTENSAO));
		String linha = "";
		String nome = "ler_Clientes" + ".tmp";
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(LeituraEscrita.PATH_BASICO + nome));
		Conta conta = Conta.contas.get(idConta);
		while (linha != null) {
			linha = br.readLine();
			if (linha != null && !linha.isEmpty()) {
				String[] dados = linha.split(";");
				if (dados[3].equals(conta.cpfTitular)&& dados[0].equals("Cliente")) {
					String novoSaldo = String.valueOf(saldoNovo);
					dados[7] = novoSaldo;
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
	}

	@Override
	public String toString() {
		return "Agencia = " + agencia + ", numConta = " + numConta + ", cpfTitular = " + cpfTitular + ", nomeTitular = "
				+ nomeTitular + ", saldo = " + saldo + ", tipoConta = " + tipoConta;
	}

	public int getIdCliente() {
		return idCliente;
	}
	
	public void contratarSeguro() throws IOException {
        if (this.temSeguro == false) {
            this.temSeguro = SeguroVida.contratarSeguro(this);
        } else {
            System.out.println("Você já tem um seguro contratado");
            System.out.println("Deseja visualizar os detalhes do seguro?");
            Scanner sc = new Scanner(System.in);
            int opcao = sc.nextInt();
            if(opcao==1) {
                SeguroVida v = SeguroVida.mapaSeguroVida.get(this.getIdCliente());
                System.out.println("Valor descontado: "+ v.valorDesconto + "\nValor segurado: "+ v.valorSeguro);
            }
        }

    }

}