package projeto.contas.exercicio;

public class conta {
	String titular;
	String agencia;
	int numero;
	double saldo;
	data dataDeAbertura;
	
	void saca(double valor) {
		this.saldo -= valor;
		System.out.println("Saque realizado com sucesso!");
	}
	
	void deposito(double valor) {
		this.saldo += valor;
		System.out.println("Depósito realizado com sucesso!");
	}
	
	void calculaRendimento() {
		double rendimento = this.saldo*0.1;
		this.saldo += rendimento;
		System.out.printf("O rendimento é de: %.2f", rendimento);
		System.out.println();
	}
	
	public String toString() { 
		return "Titular: "
				+ titular
				+ ", Número da conta: "
				+ numero
				+ ", Agência: "
				+ agencia
				+ ", Data de abertura: "
				+ dataDeAbertura
				+ ", Saldo: "
				+ String.format("%.2f", saldo);
	}
}
