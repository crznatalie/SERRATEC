package br.com.poo.residencia.menus;

import java.io.IOException;
import java.util.Scanner;

import br.com.poo.residencia.pessoas.Pessoa;

public class Utilitarios {

	public static void finalizar() {
		System.out.print("Finalizando o programa.");
		for (int i = 3; i > 0; i--) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(".");
		}
	}

	public static void continuar(Pessoa user) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Deseja continuar? ");
		System.out.println("Digite [S] para continuar ou [N] para sair");
		String continua;
		continua = sc.next();
		if (continua.equalsIgnoreCase("s")) {
			Utilitarios.limparTela();
			MenuPrincipal.apresentarMenu(user);
		} else {
			finalizar();
		}
	}

	public static void limparTela() {
		for (int i = 0; i < 30; i++) {
			System.out.println();
		}
	}
	public static void imprimeLinha() {
		System.out.println("---------------------------------------------------------------------------------------");

	}

}
