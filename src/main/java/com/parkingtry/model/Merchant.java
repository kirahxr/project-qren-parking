package com.parkingtry.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "merchant")
public class Merchant {

	@Id
	@Column(name ="\"merchantApiKey\"",nullable = false,unique = true)
	private String merchantApiKey;
	
	
	@Column(name = "\"emailMerchant\"",nullable = false)
	private String email;
	
	
	@Column(name ="\"namaMerchant\"")
	private String nama;
	
	
	@Column(name = "\"passwordMerchant\"")
	private String password;
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Column(name = "token")
	private String token;


	public String getMerchantApiKey() {
		return merchantApiKey;
	}


	public String getnama() {
		return nama;
	}


	public void setnama(String nama) {
		this.nama = nama;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setMerchantApiKey(String merchantApiKey) {
		this.merchantApiKey = merchantApiKey;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


}
