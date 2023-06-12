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
@Table(name="Country")
public class Country {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cou_cd_id")
	private Long id;
	
	@NotNull
	@Column(name="cou_tx_country")
	private String country;
	
	@NotNull
	@Column(name="cou_tx_lastUpdate")
	private LocalDateTime lastUpdate;

	public Country(Long id, @NotNull String country, @NotNull LocalDateTime lastUpdate) {
		super();
		this.id = id;
		this.country = country;
		this.lastUpdate = lastUpdate;
	}

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	} 
	
	
	
}
