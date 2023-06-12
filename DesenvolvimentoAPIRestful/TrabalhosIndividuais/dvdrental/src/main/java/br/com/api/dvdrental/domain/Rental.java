package br.com.api.dvdrental.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Rental")
public class Rental {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ren_cd_id")
	private Long id;
	
	@NotNull
	@Column(name="ren_dt_date")
	private LocalDate date;
	
	@Column(name="ren_dt_returnDate")
	private LocalDate returnDate;
	
	@NotNull
	@Column(name="ren_dt_lastUpdate")
	private LocalDateTime lastUpdate;

	//fk de INVENTORY CUSTOMER STAFF

	public Rental(Long id, @NotNull LocalDate date, LocalDate returnDate, @NotNull LocalDateTime lastUpdate) {
		super();
		this.id = id;
		this.date = date;
		this.returnDate = returnDate;
		this.lastUpdate = lastUpdate;
	}

	public Rental() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	
	
}
