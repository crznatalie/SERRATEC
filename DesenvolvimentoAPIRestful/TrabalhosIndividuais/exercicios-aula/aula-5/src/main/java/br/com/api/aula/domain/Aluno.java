package br.com.api.aula.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="aluno")
public class Aluno {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="alu_cd_id")
	private Integer id;
	
	@Column(name="alu_nm_matricula", nullable =false, unique=true)
	private Long matricula;
	
	@Size(min=10, max=20)
	@Column(name="alu_nm_nome", nullable=false)
	private String nome;
	
	@Column(name="alu_tx_tel", length=9)
	private String telefone;
	
	@Column(name="alu_bl_ativo", nullable=false)
	private boolean ativo;
	
	public Aluno() {
	}

	public Aluno(Integer id, Long matricula, String nome, String telefone, boolean ativo) {
		super();
		this.id=id;
		this.matricula = matricula;
		this.nome = nome;
		this.telefone = telefone;
		this.ativo = ativo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public boolean isAtivo() {
		return ativo;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
