package br.com.poo.residencia.menus;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.poo.residencia.pessoas.Pessoa;

public class MenuPresidente {

	static void menu(Pessoa presidente) throws IOException {
		boolean opcaoValida = false;

		do {
			try {
				int escolha;
				Scanner sc = new Scanner(System.in);
				System.out.println("[1] - Gerar Relatório de Presidente");
				System.out.println("[2] - Relatório Parcial de cada Diretor");
				System.out.println("[3] - Menu de Diretor");
				System.out.println("[4] - Menu de Gerente");
				System.out.println("[9] - Mudar Senha");
				escolha = sc.nextInt();
				switch (escolha) {
				case 1:
					Utilitarios.limparTela();
					Utilitarios.imprimeLinha();
					presidente.gerarRelatorioPresidente(presidente);
					Utilitarios.imprimeLinha();
					Utilitarios.continuar(presidente);
					opcaoValida = true;
					break;
				case 2:
					Utilitarios.limparTela();
					Utilitarios.imprimeLinha();
					presidente.relatorioParcialDiretor(presidente);
					Utilitarios.imprimeLinha();
					Utilitarios.continuar(presidente);
					opcaoValida = true;
					break;
				case 3:
					Utilitarios.limparTela();
					Utilitarios.imprimeLinha();
					MenuDiretor.menu(presidente);
					Utilitarios.imprimeLinha();
					Utilitarios.continuar(presidente);
					opcaoValida = true;
					break;
				case 4:
					Utilitarios.limparTela();
					Utilitarios.imprimeLinha();
					MenuGerente.menu(presidente);
					Utilitarios.imprimeLinha();
					Utilitarios.continuar(presidente);
					opcaoValida = true;
					break;
				case 9:
					presidente.mudarSenha(presidente);
					Utilitarios.imprimeLinha();
					Utilitarios.continuar(presidente);
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
