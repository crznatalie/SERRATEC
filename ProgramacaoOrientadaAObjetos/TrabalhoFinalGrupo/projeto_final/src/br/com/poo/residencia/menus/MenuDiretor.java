package br.com.poo.residencia.menus;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import br.com.poo.residencia.pessoas.Pessoa;

public class MenuDiretor {

	public static void menu(Pessoa diretor) throws IOException {
		boolean opcaoValida = false;
		do {
			try {
				int escolha;
				Scanner sc = new Scanner(System.in);
				System.out.println("[1] - Gerar Relatório Diretor");
				System.out.println("[2] - Relatório Parcial de Gerente");
				System.out.println("[3] - Menu de Gerente");
				System.out.println("[9] - Mudar Senha");
				escolha = sc.nextInt();
				switch (escolha) {
				case 1:
					Utilitarios.limparTela();
					Utilitarios.imprimeLinha();
					diretor.gerarRelatorioDiretor(diretor);
					Utilitarios.imprimeLinha();
					Utilitarios.continuar(diretor);
					break;
				case 2:
					Utilitarios.limparTela();
					Utilitarios.imprimeLinha();
					diretor.relatorioParcialGerente(diretor);
					Utilitarios.imprimeLinha();
					Utilitarios.continuar(diretor);
					break;
				case 3:
					Utilitarios.limparTela();
					Utilitarios.imprimeLinha();
					MenuGerente.menu(diretor);
					Utilitarios.imprimeLinha();
					Utilitarios.continuar(diretor);
					break;
				case 9:
					diretor.mudarSenha(diretor);
					Utilitarios.imprimeLinha();
					Utilitarios.continuar(diretor);
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
