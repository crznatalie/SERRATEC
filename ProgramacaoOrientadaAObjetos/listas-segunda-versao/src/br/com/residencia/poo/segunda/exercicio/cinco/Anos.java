package br.com.residencia.poo.segunda.exercicio.cinco;

public class Anos {
	private int idadeP = 180;
	private int idadeE = 26;
	
//	public int getIdadeP() {
//		return idadeP;
//	}
//	public int getIdadeE() {
//		return idadeE;
//	}
//	
//	
	public int semMim() {
		return idadeP - idadeE;
	}
	
	public String toString() {
		return "Petrópolis tem "
		       + idadeP
		       +" anos. Desses, "
		       + semMim()
		       +" foram antes de mim. Mas os últimos "
		       + idadeE
		       +" anos contaram comigo!";
				
	}
	
}
