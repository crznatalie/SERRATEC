package br.com.api.faculdade.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "avaliacao")
public class Avaliacao {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="ava_cd_id")
	private Long avaliacaoId;
	
	@Column(name="ava_tx_nota")
	private Double nota;
	
	@OneToOne
	@JoinColumn(name="fk_alu_cd_id")
	private Aluno alunoRel;

	public Avaliacao(Long avaliacaoId, Double nota, Aluno alunoRel) {
		super();
		this.avaliacaoId = avaliacaoId;
		this.nota = nota;
		this.alunoRel = alunoRel;
	}

	public Long getAvaliacaoId() {
		return avaliacaoId;
	}

	public void setAvaliacaoId(Long avaliacaoId) {
		this.avaliacaoId = avaliacaoId;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Aluno getAlunoRel() {
		return alunoRel;
	}

	public void setAlunoRel(Aluno alunoRel) {
		this.alunoRel = alunoRel;
	}
	
	
	
}
