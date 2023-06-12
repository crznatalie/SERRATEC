package br.com.api.dvdrental.domain;

import java.sql.Time;
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
@Table(name="Film")
public class Film {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fil_cd_id")
	private Long id;
	
	@NotNull
	@Column(name="fil_tx_title")
	private String name;
	
	@Column(name="fil_tx_description")
	private String description;
	
	@Column(name="fil_nm_year")
	private LocalDate year;
	
	@NotNull
	@Column(name="fil_nm_duration")
	private Integer duration;
	
	@NotNull
	@Column(name="fil_nm_rate")
	private Integer rate;
	
	@Column(name="fil_dt_length")
	private Time length;
	
	@Column(name="fil_nm_replacementCost")
	private Double replacementCost;
	
	@Column(name="fil_tx_rating")
	private String rating;
	
	@NotNull
	@Column(name="fil_dt_lastUpdate")
	private LocalDateTime lastUpdate;
	
	@Column(name="fil_tx_specialFeatures")
	private String specialFeatures;
	
	@NotNull
	@Column(name="fil_tx_fulltext")
	private String fulltext;

	//Language = fk de language

	public Film(Long id, @NotNull String name, String description, LocalDate year, @NotNull Integer duration,
			@NotNull Integer rate, Time length, Double replacementCost, String rating,
			@NotNull LocalDateTime lastUpdate, String specialFeatures, @NotNull String fulltext) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.year = year;
		this.duration = duration;
		this.rate = rate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.lastUpdate = lastUpdate;
		this.specialFeatures = specialFeatures;
		this.fulltext = fulltext;
	}

	public Film() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getYear() {
		return year;
	}

	public void setYear(LocalDate year) {
		this.year = year;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public Time getLength() {
		return length;
	}

	public void setLength(Time length) {
		this.length = length;
	}

	public Double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(Double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public String getFulltext() {
		return fulltext;
	}

	public void setFulltext(String fulltext) {
		this.fulltext = fulltext;
	}
	
	
	
}
