package br.com.api.exercicio.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="player")
public class Player {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pl_cd_id")
	private Integer id;
	
	@Size(min=4, max=20)
	@Column(name="pl_tx_username", nullable=false, unique=true)
	private String username;
	
	@Column(name="pl_tx_class", nullable=false, length=3)
	private String pclass;
	
	@Column(name="pl_bl_alive", nullable=false)
	private boolean alive;
	
	@Column(name="pl_cd_team", nullable=false, length=1)
	private Integer team;
	
	@Column(name="pl_bl_inMatch", nullable=false)
	private boolean inMatch;
	
	@Column(name="pl_cd_deaths", nullable=false)
	private Integer deaths;
	
	@Column(name="pl_cd_kills", nullable=false)
	private Integer kills;


	public Player(Integer id, String username, String pclass, boolean alive, Integer team, boolean inMatch, Integer deaths, Integer kills) {
		super();
		this.id = id;
		this.username = username;
		this.pclass = pclass;
		this.alive = alive;
		this.team = team;
		this.inMatch = inMatch;
		this.deaths = deaths;
		this.kills = kills;
	}
	
	public Player() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPclass() {
		return pclass;
	}

	public void setPclass(String pclass) {
		this.pclass = pclass;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public Integer getTeam() {
		return team;
	}

	public void setTeam(Integer team) {
		this.team = team;
	}

	public boolean isInMatch() {
		return inMatch;
	}

	public void setInMatch(boolean inMatch) {
		this.inMatch = inMatch;
	}

	public Integer getDeaths() {
		return deaths;
	}

	public void setDeaths(Integer deaths) {
		this.deaths = deaths;
	}

	public Integer getKills() {
		return kills;
	}

	public void setKills(Integer kills) {
		this.kills = kills;
	}
	
	
}
