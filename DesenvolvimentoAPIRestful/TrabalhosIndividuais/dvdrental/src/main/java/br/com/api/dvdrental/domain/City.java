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
@Table(name="City")
public class City {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cit_cd_id")
	private Long id;
	
	@NotNull
	@Column(name="cit_tx_city", length=50)
	private String city;
	
	@NotNull
	@Column(name="cit_tx_lastUpdate")
	private LocalDateTime lastUpdate;

	//fk country ID

	public City(Long id, @NotNull String city, @NotNull LocalDateTime lastUpdate) {
		super();
		this.id = id;
		this.city = city;
		this.lastUpdate = lastUpdate;
	}

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	

	

	

	
}
