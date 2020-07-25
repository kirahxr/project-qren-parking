package com.parkingtry.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"tarif\"")
public class Tarif {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false,name ="\"idTarif\"")
	private Long idTarif;
	
	@Column(nullable = false,name = "\"motor\"")
	private Integer motor;
	
	@Column(nullable = false,name = "\"mobil\"")
	private Integer mobil;
	 
	@Column(nullable = false,name = "\"truk\"")
	private Integer truk;
	
	@Column(nullable = false,name = "\"noTicket\"")
	private Integer noTicket;

	public Long getIdTarif() {
		return idTarif;
	}

	public void setIdTarif(Long idtarif) {
		this.idTarif = idtarif;
	}

	public Integer getMotor() {
		return motor;
	}

	public void setMotor(Integer motor) {
		this.motor = motor;
	}

	public Integer getMobil() {
		return mobil;
	}

	public void setMobil(Integer mobil) {
		this.mobil = mobil;
	}

	public Integer getTruk() {
		return truk;
	}

	public void setTruk(Integer truk) {
		this.truk = truk;
	}

	public Integer getNoTicket() {
		return noTicket;
	}

	public void setNoTicket(Integer notTicket) {
		this.noTicket = notTicket;
	}
	
	
	
	
	

}
