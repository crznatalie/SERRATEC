package br.com.poo.residencia.leituraescrita;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Data {
	static LocalDateTime agora = LocalDateTime.now();
	static DateTimeFormatter dataCompleta = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	static String data = agora.format(dataCompleta);
	
	
	public static String getData() {
		return data;
	}
}
