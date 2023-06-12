package br.com.poo.residencia.menus;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map.Entry;
import java.util.Scanner;

import br.com.poo.residencia.contas.Conta;
import br.com.poo.residencia.leituraescrita.LeituraEscrita;
import br.com.poo.residencia.pessoas.Pessoa;

public class MenuCliente {
	public static void menu(Pessoa cliente) throws IOException {
		int escolha;
		Conta contaCliente = Conta.contas.get(cliente.getIdCliente());
		boolean opcaoValida = false;
		do {
			try {
			Scanner sc = new Scanner(System.in);
			System.out.println("[1] - Operações");
			System.out.println("[2] - Gerar Relatórios");
			System.out.println("[3] - Seguro de vida");
			System.out.println("[9] - Mudar Senha");
			escolha = sc.nextInt();
			switch (escolha) {
			case 1:
				Utilitarios.limparTela();
				System.out.println("Qual operação gostaria de realizar?");
				Utilitarios.imprimeLinha();
				System.out.println("[1] - Saque");
				System.out.println("[2] - Depósito");
				System.out.println("[3] - Transferência");
				escolha = sc.nextInt();
				switch (escolha) {
				case 1:
					Utilitarios.limparTela();
					System.out.println("Digite o valor que deseja sacar:");
					Utilitarios.imprimeLinha();
					double valor = sc.nextDouble();
					Utilitarios.imprimeLinha();
					contaCliente.sacar(valor);
					opcaoValida = true;
					Utilitarios.imprimeLinha();
					Utilitarios.continuar(cliente);
					break;
				case 2:
					Utilitarios.limparTela();
					System.out.println("Digite o valor que deseja depositar:");
					Utilitarios.imprimeLinha();
					valor = sc.nextDouble();
					Utilitarios.imprimeLinha();
					contaCliente.depositar(valor);
					opcaoValida = true;
					Utilitarios.imprimeLinha();
					Utilitarios.continuar(cliente);
					break;
				case 3:
					Utilitarios.limparTela();
					System.out.println("Digite o número da conta destino: ");
					Utilitarios.imprimeLinha();
					int contaDestino = sc.nextInt();
					Utilitarios.imprimeLinha();
					for (Entry<Integer, Conta> contas : Conta.contas.entrySet()) {
						if (contas.getValue().getNumConta() == contaDestino) {
							Conta conta = contas.getValue();
							System.out.println("Digite o valor que quer transferir para " + conta.getNomeTitular());
							valor = sc.nextDouble();
							contaCliente.transferir(valor, conta);
						}
					}
					Utilitarios.imprimeLinha();
					Utilitarios.continuar(cliente);
					opcaoValida = true;
					break;
				default:
					Utilitarios.limparTela();
					System.out.println("Opção invalida");
					Utilitarios.imprimeLinha();
					opcaoValida = false;
					break;
				}
				opcaoValida = true;
				break;
			case 2:
				Utilitarios.limparTela();
				Utilitarios.imprimeLinha();
				System.out.println("[1] - Verificar saldo");
				System.out.println("[2] - Relatório de Tributos");
				if (contaCliente.getTipoConta().equals("Poupanca")) {
					System.out.println("[3] - Rendimento da Poupança");
				}
				
				escolha = sc.nextInt();
				
				if (escolha == 2) {
					LeituraEscrita.relatorioTributacao(contaCliente);
					System.out.println("Relatório gerado com sucesso!");
				}
				
				if (escolha == 3) {
					contaCliente.rendimento();
				}
				
				opcaoValida = true;
				break;
			case 3:
				Utilitarios.limparTela();
				Utilitarios.imprimeLinha();
				contaCliente.contratarSeguro();
				Utilitarios.imprimeLinha();
				Utilitarios.continuar(cliente);
				opcaoValida = true;
				break;
			case 9:
				Utilitarios.limparTela();
				Utilitarios.imprimeLinha();
				cliente.mudarSenha(cliente);
				Utilitarios.imprimeLinha();
				Utilitarios.continuar(cliente);
				opcaoValida = true;
				break;
			default:
				Utilitarios.limparTela();
				System.out.println("Opção invalida");
				Utilitarios.imprimeLinha();
				opcaoValida = false;
				break;

			}
			} catch (InputMismatchException e) {
				Utilitarios.limparTela();
				System.out.println("Opção invalida");
				Utilitarios.imprimeLinha();
				opcaoValida = false;
			}
		} while (!opcaoValida);
	}

}
