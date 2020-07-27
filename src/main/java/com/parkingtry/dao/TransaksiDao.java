package com.parkingtry.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.parkingtry.model.Transaksi;

@Repository
@Transactional
public class TransaksiDao extends CommonDao {
	
	
	@SuppressWarnings("unchecked")
	public HashMap<String, Long> getCountKendaraan(String merchant) {
		StringBuilder sql1 = new StringBuilder();
		HashMap<String, Long> ret = new HashMap<String, Long>();
		List<HashMap<String, String>> datas = new ArrayList<HashMap<String,String>>();
		sql1.append("SELECT DISTINCT jenisKendaraan from Transaksi");
		List<Object> obj = super.entityManager.createQuery(sql1.toString()).getResultList();
		System.out.println("haha"+obj);
		for(Object ob:obj) {
			HashMap<String, String> data = new HashMap<String, String>();
			data.put("jenisKendaraan",(String)ob);
			datas.add(data);
		}
		for(HashMap<String, String> os:datas) {
			String q ="SELECT count(*) FROM Transaksi where idjuru.merchantApiKey.merchantApiKey=:merchant and jenisKendaraan=:jenis";
			Object lstTarif = super.entityManager.createQuery(q).setParameter("merchant",merchant).setParameter("jenis", os.get("jenisKendaraan")).getSingleResult();
			Long count = (Long) lstTarif;

			ret.put(os.get("jenisKendaraan"),count);

		}
		
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public List<Transaksi> getReport(String startDate,String endDate,String merchant){
		System.out.println("st"+startDate);
		System.out.println("out"+endDate);
		StringBuilder sql = new StringBuilder();
		sql.append("FROM Transaksi");
			sql.append(" where enteredDate between :startDate  and :endDate");
			sql.append(" or exitDate  between :startDate and :endDate");
			sql.append(" and idjuru.merchantApiKey.merchantApiKey=:merchant ");
			
		List<Transaksi> data = super.entityManager.createQuery(sql.toString())
				.setParameter("startDate", startDate)
				.setParameter("endDate", endDate)
				.setParameter("merchant",merchant)
				.getResultList();
		System.out.println("data"+data.size());
		
		return data;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Transaksi> getReportByMechant(String merchant){
		StringBuilder sql = new StringBuilder();
		sql.append("FROM Transaksi");
		sql.append(" where idjuru.merchantApiKey.merchantApiKey=:merchant");
		List<Transaksi> data = super.entityManager.createQuery(sql.toString())
				.setParameter("merchant",merchant)
				.getResultList();
		System.out.println("data"+data.size());
		
		return data;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Transaksi> getReportByMechantStatus(String merchant,String status){
		StringBuilder sql = new StringBuilder();
		sql.append("FROM Transaksi");
		sql.append(" where idjuru.merchantApiKey.merchantApiKey=:merchant");
		status = status.trim();
		if(status!= null || status != "") {
			sql.append(" and lower(status) like:status");
		}
		System.out.println("qee" +sql.toString());
		List<Transaksi> data = super.entityManager.createQuery(sql.toString())
				.setParameter("merchant",merchant)
				.setParameter("status", "%"+status.toLowerCase()+"%")
				.getResultList();
		System.out.println("data"+data.size());
		
		return data;
		
	}
	
	

}
