package br.com.poo.residencia.contas;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

import br.com.poo.residencia.leituraescrita.LeituraEscrita;

public class ContaPoupanca extends Conta {
	public ContaPoupanca(String nomeTitular, String cpfTitular, String tipoConta, int agencia, int numConta,
			Double valor,Integer idCliente) {
		super(nomeTitular, cpfTitular, tipoConta, agencia, numConta, valor);
		this.idCliente = idCliente;
	}

	public void rendimento() throws IOException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		GregorianCalendar calendario = new GregorianCalendar();
		String data;
		String dataF;

		System.out.println("*******************************************************");
		System.out.print("Digite o valor em reais: ");
		double valorInicial = sc.nextDouble();
		System.out.print("Digite a quantidade de meses que pretende simular: ");
		int meses = sc.nextInt();
		data = sdf.format(calendario.getTime());
		System.out.println("*******************************************************");
		System.out.printf("Valor em " + data + ": R$%.2f%n", valorInicial);
		calendario.add(Calendar.MONTH, meses);
		dataF = sdf.format(calendario.getTime());
		double txMensal = 0.005;
		double valorFinal = valorInicial * Math.pow((1 + txMensal), meses);
		double rendimento = valorFinal - valorInicial;

		System.out.printf("Valor em " + dataF + ": R$%.2f%n", valorFinal);
		System.out.printf("Rendimento do valor informado em " + meses + " meses: R$%.2f%n", rendimento);
		System.out.println("*******************************************************");
		LeituraEscrita.comprovanteSimulacao(this, valorFinal, valorInicial, rendimento, dataF, meses);
		sc.close();

	}

}