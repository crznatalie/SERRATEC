package br.com.api.faculdade.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Faculdade {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="facul_cd_id")
	private Long faculdadeId;
	
	@Column(name="facul_tx_nome")
	private String nome;

	@OneToMany(mappedBy="faculdadeRel")
	private List<Aluno> alunos;
	
	public Faculdade(Long faculdadeId, String nome) {
		super();
		this.faculdadeId = faculdadeId;
		this.nome = nome;
	}

	public Long getFaculdadeId() {
		return faculdadeId;
	}

	public void setFaculdadeId(Long faculdadeId) {
		this.faculdadeId = faculdadeId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
