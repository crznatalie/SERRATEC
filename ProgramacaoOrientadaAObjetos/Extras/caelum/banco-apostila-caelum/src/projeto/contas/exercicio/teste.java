package projeto.contas.exercicio;

public class teste {

	public static void main(String[] args) {
		
		//criação de contas
		conta c1 = new conta ();
		data d = new data();
		d.ano = 2023;
		d.mes = 04;
		d.dia = 12;
		c1.titular = "Jon";
		c1.numero = 1234;
		c1.agencia = "Dois";
		c1.saldo = 200.0;
		c1.dataDeAbertura = d;
		
		
		
//		System.out.println(c1);
//		
//		c1.deposito(1300);
//		
//		System.out.println(c1);
//		
//		c1.saca(300);
//		System.out.println(c1);
//		
//		c1.calculaRendimento();
	System.out.println(c1);
	}

}
