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
@Table(name="Address")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="adr_cd_id")
	private Long id;
	
	@NotNull
	@Column(name="adr_tx_address", length=50)
	private String address;
	
	@Column(name="adr_tx_address2", length=50)
	private String address2;
	
	@NotNull
	@Column(name="adr_tx_district", length=20)
	private String district;
	
	@Column(name="adr_tx_postalCode", length=10)
	private String postalCode;
	
	@NotNull
	@Column(name="adr_tx_phone", length=20)
	private String phone;
	
	@NotNull
	@Column(name="adr_tx_lastUpdate")
	private LocalDateTime lastUpdate;

	//fk ADDRESS CITY

	public Address(Long id, @NotNull String address, String address2, @NotNull String district, String postalCode,
			@NotNull String phone, @NotNull LocalDateTime lastUpdate) {
		super();
		this.id = id;
		this.address = address;
		this.address2 = address2;
		this.district = district;
		this.postalCode = postalCode;
		this.phone = phone;
		this.lastUpdate = lastUpdate;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	} 
	
	
	
}
