package com.parkingtry.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "transaksi")
public class Transaksi {

	
	@Id
	@Column(name = "\"invoiceId\"")
	private String invoiceId;
	
	
	@Column(name = "\"platNo\"")
	private String platNo;
	
	
	@Column(name = "\"status\"")
	private String status;
	
	
	
	@Column(name ="\"enteredDate\"")
	private String enteredDate;
	
	
	@Column(name = "\"exitDate\"")
	private String exitDate;
	
	
	
	@Column(name = "amount")
	private Integer amount;
	
	
	@Column(name = "\"qrenInvoice\"")
	private String qrenInvoice;
	
	
	
	@Column(name = "\"paymentMethod\"")
	private String paymentMethod;
	
	
	@Column(name = "kendaraan")
	private String kendaraan;
	
	@Column(name = "\"jenisKendaraan\"")
	private String jenisLendaraan;
	
	
	
	public String getJenisLendaraan() {
		return jenisLendaraan;
	}


	public void setJenisLendaraan(String jenisLendaraan) {
		this.jenisLendaraan = jenisLendaraan;
	}


	@Column(name = "\"sourceOfFund\"")
	private String sourceOfFund;
	
	
	@ManyToOne(optional = false)
	@JoinColumn( name = "\"idJuru\"")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private JuruParkir idjuru;
	
	
	@ManyToOne(optional = false)
	@JoinColumn( name = "\"idDaftar\"")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private DaftarTarif iddaftar;


	public String getInvoiceId() {
		return invoiceId;
	}


	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}


	public String getPlatNo() {
		return platNo;
	}


	public void setPlatNo(String platNo) {
		this.platNo = platNo;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getEnteredDate() {
		return enteredDate;
	}


	public void setEnteredDate(String enteredDate) {
		this.enteredDate = enteredDate;
	}


	public String getExitDate() {
		return exitDate;
	}


	public void setExitDate(String exitDate) {
		this.exitDate = exitDate;
	}


	public Integer getAmount() {
		return amount;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	public String getQrenInvoice() {
		return qrenInvoice;
	}


	public void setQrenInvoice(String qrenInvoice) {
		this.qrenInvoice = qrenInvoice;
	}


	public String getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	public String getKendaraan() {
		return kendaraan;
	}


	public void setKendaraan(String kendaraan) {
		this.kendaraan = kendaraan;
	}


	public String getSourceOfFund() {
		return sourceOfFund;
	}


	public void setSourceOfFund(String sourceOfFund) {
		this.sourceOfFund = sourceOfFund;
	}


	public JuruParkir getIdjuru() {
		return idjuru;
	}


	public void setIdjuru(JuruParkir idjuru) {
		this.idjuru = idjuru;
	}


	public DaftarTarif getIddaftar() {
		return iddaftar;
	}


	public void setIddaftar(DaftarTarif iddaftar) {
		this.iddaftar = iddaftar;
	}
	
	
}
