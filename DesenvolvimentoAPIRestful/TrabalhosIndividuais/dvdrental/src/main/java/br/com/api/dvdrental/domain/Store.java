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
@Table(name="Store")
public class Store {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sto_cd_id")
	private Long id;
	
	@NotNull
	@Column(name="sto_tx_lastUpdate")
	private LocalDateTime lastUpdate;

	//fk manager_staff_id, address

	public Store(Long id, @NotNull LocalDateTime lastUpdate) {
		super();
		this.id = id;
		this.lastUpdate = lastUpdate;
	}

	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	} 
	
	
	
}
