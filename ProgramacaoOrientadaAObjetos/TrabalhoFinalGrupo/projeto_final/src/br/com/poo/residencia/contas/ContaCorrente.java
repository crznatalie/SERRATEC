package br.com.poo.residencia.contas;

import java.io.IOException;
import java.util.Locale;

import br.com.poo.residencia.leituraescrita.LeituraEscrita;



public class ContaCorrente extends Conta {	

	public static final Double TAXA_T = 0.20;
	public static final Double TAXA = 0.10;
	
	public  ContaCorrente() {
	}
	
	public ContaCorrente(String nomeTitular, String cpfTitular, String tipoConta, int agencia, int numConta,
			Double valor, Integer idCliente) {
		super(nomeTitular, cpfTitular, tipoConta, agencia, numConta, valor);
		this.idCliente = idCliente;

	}
	
	public int ContaCor() {
		return this.agencia;
	}
	
	@Override
	public boolean sacar(Double valor) throws IOException {
		Locale.setDefault(Locale.US);
		if (this.saldo < (valor + TAXA)) {
			System.out.println("Não foi possível realizar operação");
			return false;
		} else {
			this.saldo -= (valor + TAXA);
			System.out.println("Operação realizada com sucesso :)");
			totalSaque ++;
			totalOperacoes ++;
			super.atualizarSaldo(this.idCliente,this.saldo);
			LeituraEscrita.comprovanteSaque(this, valor);
			LeituraEscrita.extrato(this.idCliente, valor, "Saque", this);
			return true;
		}
	}
	
	@Override
	public boolean depositar(Double valor) throws IOException {
		Locale.setDefault(Locale.US);
		if (this.saldo == null) {
			this.saldo = TAXA;
		}
		this.saldo += (valor - TAXA);
		totalDeposito ++;
		totalOperacoes ++;
		System.out.println("Operaçao realizada com sucesso!");
		Conta.atualizarSaldo(this.idCliente,this.saldo);
		LeituraEscrita.comprovanteDeposito(this, valor);
		LeituraEscrita.extrato(this.idCliente, valor, "Depósito", this);
		return true;
		}

	
	@Override
	public boolean transferir(Double valor, Conta destino) throws IOException {
		Locale.setDefault(Locale.US);
		if (this.saldo < (valor + TAXA_T)) {
			System.out.println("Não foi possível realizar operação");
			return false;
		} else {
			this.saldo -= (valor + TAXA_T);
			destino.saldo += valor;
			totalTransferencia ++;
			totalOperacoes ++;
			System.out.println("Operação realizada com sucesso :)");
			super.atualizarSaldo(this.idCliente,this.saldo);
			Conta.atualizarSaldo(destino.idCliente,destino.saldo);
			LeituraEscrita.comprovanteTransferencia(this, destino, valor);
			LeituraEscrita.extrato(this.idCliente, valor, "Transferência", destino);
			return true;
		}
	}
	
	public Double totalGasto() {
		Locale.setDefault(Locale.US);
		totalGasto += ((this.getTotalDeposito()*TAXA) + (this.getTotalSaque()*TAXA) + (this.getTotalTransferencia()*TAXA_T));
		return totalGasto;
	}

	public int getIdCliente() {
		return idCliente;
	}




}