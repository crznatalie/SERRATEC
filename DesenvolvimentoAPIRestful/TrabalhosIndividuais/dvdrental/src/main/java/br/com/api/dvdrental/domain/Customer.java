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
@Table(name="Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cus_cd_id")
	private Long id;
	
	@NotNull
	@Column(name="cus_tx_firstName", length=45)
	private String firstName;
	
	@Column(name="cus_tx_lastName", length=45)
	private String lastName;
	
	@Column(name="cus_tx_email", length=50)
	private String email;
	
	@Column(name="cus_bl_activeBool")
	private boolean activeBool;
	
	@Column(name="cus_dt_createDate")
	private LocalDate createDate;
	
	@Column(name="cus_dt_lastUpdate")
	private LocalDateTime lastUpdate;
	
	@Column(name="cus_tx_active")
	private String active;

	//fk STORE ADDRESS

	public Customer(Long id, @NotNull String firstName, String lastName, String email, boolean activeBool,
			LocalDate createDate, LocalDateTime lastUpdate, String active) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.activeBool = activeBool;
		this.createDate = createDate;
		this.lastUpdate = lastUpdate;
		this.active = active;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActiveBool() {
		return activeBool;
	}

	public void setActiveBool(boolean activeBool) {
		this.activeBool = activeBool;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
	
	
	

}
