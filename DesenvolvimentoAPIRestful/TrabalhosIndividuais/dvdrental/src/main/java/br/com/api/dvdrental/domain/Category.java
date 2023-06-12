package br.com.api.dvdrental.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Category")
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cat_cd_id")
	private Long id;
	
	@NotNull
	@Column(name="cat_tx_name")
	private String name;
	
	@NotNull
	@Column(name="cat_dt_lastUpdate")
	private LocalDateTime lastUpdate;

	public Category(Long id, @NotNull String name, @NotNull LocalDateTime lastUpdate) {
		super();
		this.id = id;
		this.name = name;
		this.lastUpdate = lastUpdate;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	
}
