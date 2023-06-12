package br.com.poo.residencia.contas;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.com.poo.residencia.menus.MenuCliente;
import br.com.poo.residencia.pessoas.Pessoa;

public class SeguroVida {
	protected int idConta;
	protected Double valorSeguro;
	protected Double valorDesconto;
	public static Map<Integer, SeguroVida> mapaSeguroVida = new HashMap<>();

	public SeguroVida(int idConta, Double valorSeguro, Double valorDesconto) {
		this.idConta = idConta;
		this.valorSeguro = valorSeguro;
		this.valorDesconto = valorDesconto;
	}
	
	public Double getValorSeguro() {
		return valorSeguro;
	}

	public Double getValorDesconto() {
		return valorDesconto;
	}

	public static boolean contratarSeguro(Conta conta) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Simulação do seu seguro de vida/n");
		System.out.println("Qual valor deseja segurar?");

		Double valorSeguro = sc.nextDouble();
		Double valorDesconto = valorSeguro * 0.2;
//		System.out.println("Seu saldo: " + conta.getSaldo() + " menos 20%.");
		System.out.printf("O valor de contratação de seguro é de:  %.2f", valorSeguro);
		System.out.println("\n\nDeseja contratar seguro de vida? (S/N)");
		String contrato = sc.next();
		if (contrato.equalsIgnoreCase("S")) {
			if (conta.getSaldo() < valorSeguro) {
				System.out.println("Valor insuficiente");
				return false;
			} else {
				System.out.println("Seu seguro de vida foi contratado com sucesso.");
				System.out.println("Valor antes de contratar: " + conta.getSaldo());
				conta.saldo -= valorDesconto;
				SeguroVida seguro = new SeguroVida(conta.getIdCliente(),valorSeguro,valorDesconto);
				mapaSeguroVida.put(conta.getIdCliente(), seguro);
				System.out.println("Valor depois de contratar: " + conta.getSaldo());
				return true;
			}
		} else {
			return false;
		}

	}

}
