package br.caelum.programa.tres;

public class program {

	public static void main(String[] args) {
		
		casa c = new casa();
		
		c.abre1();
		c.abre2();
		c.abre3();
		
		c.pinta("amarela");
		System.out.println("A cor da casa é: " + c.cor);
		c.quantasPortasEstaoAbertas();
		

	}

}
