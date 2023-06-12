package br.com.api.faculdade.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Aluno {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="alu_cd_id")
	private Long faculdadeId;
	
	@Column(name="alu_tx_nome")
	private String nome;
	
	@Column(name="alu_tx_email")
	private String email;
	
	
	//Muitos pra um
	//Primeiro nome na notação faz referência à classe onde está inserida
	@ManyToOne
	@JoinColumn(name="fk_facul_cd_id")
	private Faculdade faculdadeRel;
	//define o dono do relacionamento então por isso que passamos ele lá no domain faculdade
	
	
	//Só colocar lista se for plural, onetoone não precisa
	@OneToOne(mappedBy="alunoRel")
	private Avaliacao avaliacao;
	
	public Aluno() {
		
	}
	
	public Aluno(Long faculdadeId, String nome, String email) {
		this.faculdadeId = faculdadeId;
		this.nome = nome;
		this.email = email;
	}

	public Long getId() {
		return faculdadeId;
	}

	public void setId(Long id) {
		this.faculdadeId = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
