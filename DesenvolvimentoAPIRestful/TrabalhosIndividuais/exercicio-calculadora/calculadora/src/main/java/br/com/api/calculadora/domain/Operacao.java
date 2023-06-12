package br.com.api.calculadora.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Operacao")
public class Operacao {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="op_cd_id")
private Long id; 


@NotNull
@Column(name="op_nm_n1")
private Double num1;


@NotNull
@Column(name="op_nm_n2")
private Double num2;

@Column(name="op_nm_res")
private Double result;

@Column(name="op_tx_tip")
private String tipo;


public Operacao(Long id, Double num1, Double num2, Double result, String tipo) {
	super();
	this.id = id;
	this.num1 = num1;
	this.num2 = num2;
	this.result = result;
	this.tipo = tipo;
}

public Operacao() {
	super();
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Double getNum1() {
	return num1;
}

public void setNum1(Double num1) {
	this.num1 = num1;
}

public Double getNum2() {
	return num2;
}

public void setNum2(Double num2) {
	this.num2 = num2;
}

public Double getResult() {
	return result;
}

public void setResult(Double result) {
	this.result = result;
}

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}
}
