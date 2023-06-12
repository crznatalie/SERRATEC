package br.caelum.programa.um;

public class programa {

	public static void main(String[] args) {
		
		pessoa p = new pessoa();
		
		p.nome = "Ana";
		p.idade = 15;
		
		
		System.out.println(p);
		p.fazAniversario();
		System.out.println(p);
		p.fazAniversario();
		System.out.println(p);
		p.fazAniversario();
		System.out.println(p);
		p.fazAniversario();
		System.out.println(p);
		p.fazAniversario();
		System.out.println(p);
	}

}
