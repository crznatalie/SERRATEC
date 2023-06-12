package br.caelum.programa.dois;

public class porta {
	public boolean aberta;
	public String cor;
	public double dimensaoX;
	public double dimensaoY;
	public double dimensaoZ;
	
	public void abre() {
		aberta = true;
		System.out.println("A porta abriu!");
		
	}
	
	public void fecha() {
		aberta = false;
		System.out.println("A porta está fechou!");
	}
	
	public void pinta(String novaCor) {
		cor = novaCor;
		System.out.println("A porta agora é: " + novaCor);
		
	}
	
	public void alteraD (double x, double y, double z) {
		dimensaoX = x;
		dimensaoY = y;
		dimensaoZ = z;

	}
	
	public boolean estaAberta() {
		if (aberta == true) {
			System.out.println("A porta está aberta!");
			return true;
		}
		else {
			System.out.println("A porta está fechada!");
			return false;
		}
	}
	
	public String toString() {
		return "A cor da porta é: "
				+ cor
				+ ", As dimensões da porta são: "
				+ dimensaoX
				+ ", "
				+ dimensaoY
				+ ", "
				+ dimensaoZ
				+ ", "
				+ aberta;
				
	}

}
