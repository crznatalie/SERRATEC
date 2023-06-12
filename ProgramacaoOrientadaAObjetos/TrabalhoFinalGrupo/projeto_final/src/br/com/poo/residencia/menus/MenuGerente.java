package br.com.poo.residencia.menus;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.poo.residencia.pessoas.Pessoa;

public class MenuGerente {
	public static void menu(Pessoa gerente) throws IOException {

		boolean opcaoValida = false;

		do {
			try {
				int opc;
				Scanner sc = new Scanner(System.in);
				System.out.println("[1] - Gerar Relatório de Gerente");
				System.out.println("[2] - Gerar Relatório de cada cliente");
				System.out.println("[9] - Mudar senha");
				opc = sc.nextInt();
				switch (opc) {
				case 1:
					gerente.gerarRelatorioGerente(gerente);
					Utilitarios.imprimeLinha();
					Utilitarios.continuar(gerente);
					opcaoValida = true;
					break;
				case 2:
					gerente.gerarRelatorioCliente(gerente);
					Utilitarios.imprimeLinha();
					Utilitarios.continuar(gerente);
					opcaoValida = true;
					break;
				case 9:
					gerente.mudarSenha(gerente);
					Utilitarios.imprimeLinha();
					Utilitarios.continuar(gerente);
					opcaoValida = true;
					break;
				default:
					Utilitarios.limparTela();
					System.out.println("Opção invalida");
					Utilitarios.imprimeLinha();
					opcaoValida = false;
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
