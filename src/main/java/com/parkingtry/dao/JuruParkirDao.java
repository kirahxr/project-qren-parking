package com.parkingtry.dao;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.parkingtry.model.JuruParkir;

@Repository("juruParkir")
@Transactional
public class JuruParkirDao extends CommonDao {

	
	
	@Transactional
	public void saveJuruParkir(JuruParkir daftar) {
		super.entityManager.merge(daftar);
		
	}
	@Transactional
	@SuppressWarnings("unchecked")
	public JuruParkir findById(Long id) {
		List<JuruParkir> lstTarif = super.entityManager.createQuery(""+
				"FROM JuruParkir where idJuru=:idtarif").setParameter("idtarif", id).getResultList();
		if(lstTarif.size() == 0) {
			return new JuruParkir();
		}
		else {
			return lstTarif.get(0);
		}
		
	}
	
	@Transactional
	public void delete(Long id) throws Exception {
		JuruParkir mer = findById(id);
		if(mer.getMerchantApiKey()!= null) {
			super.entityManager.remove(mer);
		}
		else {
			throw new Exception("Delete Gagal");
		}
	}
	
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<JuruParkir> getAll() {
		List<JuruParkir> lstTarif = super.entityManager.createQuery(""+
				"FROM JuruParkir ").getResultList();
		if(lstTarif.size() == 0) {
			return lstTarif;
		}
		else {
			return lstTarif;
		}
		
	}
	
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<JuruParkir> getAllMerchant(String merchant,int page,int limit) {
		StringBuilder sql = new StringBuilder();
		sql.append("FROM JuruParkir ");
		if(merchant != null || merchant =="") {
			sql.append(" where merchantApiKey.merchantApiKey like:merchant");
		}
		List<JuruParkir> lstTarif = super.entityManager.createQuery(sql.toString()).setParameter("merchant","%"+merchant+"%").setFirstResult((page -1)*limit).setMaxResults(limit).getResultList();
		if(lstTarif.size() == 0) {
			return lstTarif;
		}
		else {
			return lstTarif;
		}
		
	}

	@Transactional
	public Long getCunt(String merchant) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT count(*) FROM JuruParkir");
		if(merchant != null || merchant =="") {
			sql.append(" where merchantApiKey.merchantApiKey like:merchant");
		}
		Object lstTarif = super.entityManager.createQuery(sql.toString()).setParameter("merchant","%"+merchant+"%").getSingleResult();
		Long count = (Long) lstTarif;
		return count;
		
	}

	

	
}
