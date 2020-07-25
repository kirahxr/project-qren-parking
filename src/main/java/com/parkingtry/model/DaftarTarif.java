package com.parkingtry.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "\"daftarTarif\"")
public class DaftarTarif {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="\"idDaftar\"",nullable = false)
	private Long idDaftar;
	
	
	
	@ManyToOne(optional = false)
	@JoinColumn( name = "\"idTarif\"")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Tarif idTarif;
	
	
	
	@OneToOne(optional = false)
	@JoinColumn( name = "\"merchantApiKey\"")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Merchant merchantApiKey;



	public Long getIdDaftar() {
		return idDaftar;
	}



	public void setIdDaftar(Long idDaftar) {
		this.idDaftar = idDaftar;
	}



	public Tarif getIdTarif() {
		return idTarif;
	}



	public void setIdTarif(Tarif idTarif) {
		this.idTarif = idTarif;
	}



	public Merchant getMerchantApiKey() {
		return merchantApiKey;
	}



	public void setMerchantApiKey(Merchant merchantApiKey) {
		this.merchantApiKey = merchantApiKey;
	}




}
