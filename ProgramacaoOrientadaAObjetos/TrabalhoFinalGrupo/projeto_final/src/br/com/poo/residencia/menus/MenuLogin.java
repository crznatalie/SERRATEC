package br.com.poo.residencia.menus;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.Scanner;

import br.com.poo.residencia.pessoas.Pessoa;

public class MenuLogin {
	private static String login;
	private static String senha;
	private static boolean loginValido = false;

	public static void logar() throws IOException {
		Scanner sc = new Scanner(System.in);
		Utilitarios.limparTela();
		Utilitarios.imprimeLinha();
		do {
			System.out.println("Login: ");
			login = sc.next();
			System.out.println("Senha: ");
			senha = sc.next();

			for (Entry<Integer, Pessoa> pessoas : Pessoa.mapaPessoas.entrySet()) {
				Pessoa user = pessoas.getValue();
				if (user.getCpf().equals(login) && user.getSenha().equals(senha)) {
					Utilitarios.limparTela();
					Utilitarios.imprimeLinha();
					System.out.println("Logado com sucesso :)");
					loginValido = true;
					MenuPrincipal.apresentarMenu(user);
				}

			}
			if (!loginValido) {
				System.out.println("Login ou senha inválidos");
				loginValido = false;
			}
		} while (loginValido == false);
	
	}

}
