package br.com.poo.residencia.sistema;

import java.io.IOException;
import java.security.KeyStore.Entry;

import br.com.poo.residencia.contas.Conta;
import br.com.poo.residencia.leituraescrita.LeituraEscrita;
import br.com.poo.residencia.menus.MenuLogin;


//Gerente;Natalie;Cruz;188.145.478-74;1234;5080
//Gerente;Bianca;Gall;188.122.478-74;1234;5081
//Gerente;James;Maclean;132.231.478-74;1234;5082
//Gerente;Matheus;Austin;188.404.478-74;1234;5083
//Diretor;Marcos;Haubrich;188.200.478-74;1234;5080;5083
//Diretor;Déby;Souza;999.999.999-99;1234;5081;5082
//Presidente;Zé;Souza;395.370.970-48;1234;5080;5083;5081;5082
//Cliente;João;Cláudio;315.257.940-35;1234;5080;12573;4000.00;Corrente
//Cliente;Esther;Nathália;349.651.120-67;1234;5080;12582;4212.52;Corrente
//Cliente;Yasmin;Conceição;298.712.530-52;1234;5081;12562;1214.50;Corrente
//Cliente;Simone;Peixoto;152.263.810-50;1234;5081;12523;10120.00;Corrente
//Cliente;Lucas;Galvão;979.338.620-71;1234;5082;125412;50214.00;Corrente
//Cliente;Luís;Real;315.223.250-35;1234;5080;225012;10154.00;Poupanca
//Cliente;Martin;De Paula;315.321.3-35;1234;5081;225141;1001.00;Poupanca
//Cliente;Benjamin;Jesus;315.257.944-35;1234;5083;225252;2205.00;Poupanca
//Cliente;Cristiane;Farias;345.257.940-35;1234;5082;225333;3022.00;Poupanca
//Cliente;Raul;Nascimento;315.357.941-35;1234;5083;225657;10451.00;Poupanca
//Cliente;Raul;Souza;315.205.204-35;1234;5083;225645;10451.00;Poupanca

public class SistemaInterno {

	public static void main(String[] args) throws IOException {

		LeituraEscrita.lerClientes();
		MenuLogin.logar();
		
		
		
		// VERIFICAR OS SCANNERS PARA UTILIZAR APENAS 1
		// VERIFICAR CÓDIGOS DUPLICADOS
		// VERIFICAR LOCALIZAÇÃO DE CADA CLASSE

//		
//		if(usrLogado.getTipoPessoa().equals("Diretor")) {
//			usrLogado.gerarRelatorioDiretor();
//		}

//		System.out.println("Relatório Gerente: ");
//		Pessoa gr1 = new Gerente();
//		gr1 = Pessoa.mapaPessoas.get("Natalie");
//		gr1.gerarRelatorioGerente();
//		
//     
//		System.out.println("\nRelatório Diretor: ");	
//		Pessoa pessoa = new Diretor();
//		pessoa = Pessoa.mapaPessoas.get("Déby");
//		pessoa.gerarRelatorioDiretor();
//		pessoa.gerarRelatorioGerente();
//
//		
//		
//		System.out.println("\nRelatório Presidente ");
//		Pessoa p1 = new Presidente();
//		p1 = Pessoa.mapaPessoas.get("Zé");
//		p1.gerarRelatorioPresidente();

	}

}
