package br.nelio.secao.oito.exercicio.um;


import java.util.Locale;
import java.util.Scanner;


public class program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		rectangle rect = new rectangle();
		
		System.out.println("Enter rectangle width and height: ");
		rect.width = sc.nextDouble();
		rect.height =sc.nextDouble();
		sc.close();
		
		System.out.printf("AREA = %.2f%n", rect.area());
		System.out.printf("PERIMETER= %.2f%n", rect.perimeter());
		System.out.printf("DIAGONAL= %.2f%n", rect.diagonal());
		
	}

}
