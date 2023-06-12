package br.caelum.programa.dois;

public class program {

	public static void main(String[] args) {

		porta p = new porta();
		
		
		
		p.estaAberta();
		p.abre();
		p.estaAberta();
		
		p.pinta("verde");
		p.pinta("azul");
		
		p.alteraD(2.0, 3.0, 2.2);
	    
		System.out.println(p);

	}

}

