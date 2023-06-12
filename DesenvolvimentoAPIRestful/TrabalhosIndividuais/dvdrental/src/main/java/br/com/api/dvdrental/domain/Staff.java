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
@Table(name="Staff")
public class Staff {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sta_cd_id")
	private Long id;
	
	@NotNull
	@Column(name="sta_tx_firstName", length=45)
	private String firstName;
	
	@NotNull
	@Column(name="sta_tx_lastName", length=45)
	private String lastName;
	
	@Column(name="sta_tx_email", length=50)
	private String email;
	
	@NotNull
	@Column(name="sta_bl_active")
	private boolean active;
	
	@NotNull
	@Column(name="sta_tx_username", length=16)
	private String username;
	
	@Column(name="sta_tx_password", length=40)
	private String password;
	
	@NotNull
	@Column(name="sta_tx_lastUpdate")
	private LocalDateTime lastUpdate; 
	
	@Column(name="sta_bt_picture")
	private byte[] picture;

	//FK ADDRESS STORE
	

	public Staff(Long id, @NotNull String firstName, @NotNull String lastName, String email, @NotNull boolean active,
			@NotNull String username, String password, @NotNull LocalDateTime lastUpdate, byte[] picture) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.active = active;
		this.username = username;
		this.password = password;
		this.lastUpdate = lastUpdate;
		this.picture = picture;
	}

	public Staff() {
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
	
	
	
}
