package projeto.contas;

public class conta {
	
	int numero;
	double saldo;
	String titular;
	
	//construtor
	conta() {
		System.out.println("Construindo uma conta");
	}
	
	conta(String titular) {
		this.titular = titular;
	}
	
	//saca um valor da conta
	boolean saca(double valor) {
		if (this.saldo < valor) {
			return false;
		}
		else {
			this.saldo = this.saldo - valor;
			return true;
		}
	}
	
	//deposita um valor na conta
	void deposita(double quantidade) {
		this.saldo += quantidade;
	}
	
	//transfere
	boolean transfere (conta destino, double valor) {
		boolean retirou = this.saca(valor);
		if (retirou == false){
			return false;
		}
		else {
			destino.deposita(valor);
			return true;
		}
	}
	
	
	
	
	
}
