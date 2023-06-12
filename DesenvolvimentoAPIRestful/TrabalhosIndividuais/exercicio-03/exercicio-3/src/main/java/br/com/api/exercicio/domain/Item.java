package br.com.api.exercicio.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="item")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="it_cd_id")
	private Integer id;
	
	@Column(name="it_tx_item", nullable=false)
	private String item;
	
	@Column(name="it_tx_type", nullable=false)
	private String type;
	
	@Column(name="it_tx_material", nullable=false)
	private String material;
	
	@Column(name="it_tx_color", nullable=false)
	private String color;
	
	@Column(name="it_tx_brand")
	private String brand;
	
	@Column(name="it_bl_favorite", nullable=false)
	private boolean favorite;

	public Item() {

	}
	
	public Item(Integer id, String item, String type, String material, String color, String brand, boolean favorite) {
		this.id = id;
		this.item = item;
		this.type = type;
		this.material = material;
		this.color = color;
		this.brand = brand;
		this.favorite = favorite;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}
	
	
	
}
