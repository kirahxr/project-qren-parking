package com.parkingtry.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "\"juruParkir\"")
public class JuruParkir {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"idJuru\"",nullable = false)
	private Long idJuru;
	
	@Column(name = "\"nama\"",nullable = false)
	private String nama;
	
	@Column(name = "\"password\"",nullable = false)
	private String password;
	
	
	@Column(name = "\"email\"",nullable = false)
	private String email;
	
	@Column(name = "\"token\"",nullable = false)
	private String token;
	
	
	
	@ManyToOne(optional = false)
	@JoinColumn( name = "\"merchantApiKey\"")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Merchant merchantApiKey;


	public Long getIdJuru() {
		return idJuru;
	}



	public void setIdJuru(Long idJruru) {
		this.idJuru = idJruru;
	}



	public String getNama() {
		return nama;
	}



	public void setNama(String nama) {
		this.nama = nama;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getToken() {
		return token;
	}



	public void setToken(String token) {
		this.token = token;
	}



	public Merchant getMerchantApiKey() {
		return merchantApiKey;
	}



	public void setMerchantApiKey(Merchant merchantApiKey) {
		this.merchantApiKey = merchantApiKey;
	}


}
