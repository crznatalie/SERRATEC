package br.com.api.calculadora.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ErroResposta {
	private String titulo;
	private LocalDateTime dataHora;
	private Integer status;
	private List<String> erros;

	public ErroResposta(Integer status, String titulo, LocalDateTime dataHora, List<String> erros) {
		this.status = status;
		this.titulo = titulo;
		this.dataHora = dataHora;
		this.erros = erros;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}
	
	
}
