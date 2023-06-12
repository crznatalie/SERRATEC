package br.com.poo.residencia.menus;

import java.io.IOException;

import br.com.poo.residencia.pessoas.Pessoa;

public class MenuPrincipal {

	public MenuPrincipal(Pessoa user) {
	}

	public static void apresentarMenu(Pessoa user) throws IOException {
		Utilitarios.imprimeLinha();

		System.out.println("Bem vindo , " + user.getNome() + " " + user.getSobrenome());
		Utilitarios.imprimeLinha();

		System.out.println("O que você deseja fazer?");
		Utilitarios.imprimeLinha();

		if (user.getTipoPessoa().equalsIgnoreCase("Diretor")) {
			MenuDiretor.menu(user);
		} else if (user.getTipoPessoa().equalsIgnoreCase("Presidente")) {
			MenuPresidente.menu(user);
		} else if (user.getTipoPessoa().equalsIgnoreCase("Gerente")) {
			MenuGerente.menu(user);
		} else if (user.getTipoPessoa().equalsIgnoreCase("Cliente")) {
			MenuCliente.menu(user);
		}
	}
}
