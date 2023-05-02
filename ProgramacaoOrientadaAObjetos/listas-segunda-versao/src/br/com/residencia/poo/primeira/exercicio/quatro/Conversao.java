package br.com.residencia.poo.primeira.exercicio.quatro;

public class Conversao {

	private int tempC;
	private int tempF;

	public int getTempC() {
		return tempC;
	}

	public void setTempC(int tempC) {
		this.tempC = tempC;
	}
	
	public int getTempF() {
		return tempF;
	}

	public void conversao(int tempC) {
		tempF = (int) (tempC * 1.8 + 32);
		
		
	}
}
