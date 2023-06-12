package br.caelum.programa.tres;

public class casa {
	 public String cor;
	 public boolean porta1;
	 public boolean porta2;
	 public boolean porta3;
	 
	 public void abre1() {
		 porta1 = true;
		 
	 }
	 
	 public void fecha1() {
		 porta1 = false;
	 }
	 
	 public void abre2() {
		 porta2 = true;
		 
	 }
	 
	 public void fecha2() {
		 porta2 = false;
	 }
	 
	 public void abre3() {
		 porta3 = true;
		 
	 }
	 
	 public void fecha3() {
		 porta3 = false;
	 }
	 
	 public void pinta(String novaCor) {
		 cor = novaCor;
	 }
	 
	 int quantasPortasEstaoAbertas() {
		 int cont = 0;
		 if (this.porta1 == true) {
			 cont++;
		 }
		 if (this.porta2 == true) {
			cont++; 
		 }
		 if (this.porta3 == true) {
			 cont++;
		 }
		 System.out.println("Estão abertas " +cont+ " portas.");
		 return cont;
	 }
}
