package br.com.api.faculdade.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "disciplina")
public class Disciplina {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="dis_cd_id")
	private Long disciplinaId;
	
	@Column(name="dis_tx_nome")
	private String nome;
	
	@ManyToMany(mappedBy="disciplinas")
	private List<Curso> cursos;

	public Disciplina(Long disciplinaId, String nome) {
		super();
		this.disciplinaId = disciplinaId;
		this.nome = nome;
	}

	public Long getDisciplinaId() {
		return disciplinaId;
	}

	public void setDisciplinaId(Long disciplinaId) {
		this.disciplinaId = disciplinaId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
