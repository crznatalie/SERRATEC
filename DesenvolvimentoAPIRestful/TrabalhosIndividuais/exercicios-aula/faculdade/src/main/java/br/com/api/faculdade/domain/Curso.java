package br.com.api.faculdade.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="cur_cd_id")
	private Long cursoId;
	
	@Column(name="cur_tx_nome")
	private String nome;
	
	//tabelaintermediaria
	@ManyToMany
	@JoinTable(name="curso_disciplina",
			joinColumns=
				@JoinColumn(name="fk_cur_cd_id"),
			inverseJoinColumns=
				@JoinColumn(name="fk_dis_cd_id")
			)
	private List<Disciplina> disciplinas;

	public Curso(Long cursoId, String nome) {
		super();
		this.cursoId = cursoId;
		this.nome = nome;
	}

	public Long getCursoId() {
		return cursoId;
	}

	public void setCursoId(Long cursoId) {
		this.cursoId = cursoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
