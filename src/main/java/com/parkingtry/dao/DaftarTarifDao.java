package com.parkingtry.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.parkingtry.model.DaftarTarif;
import com.parkingtry.model.JuruParkir;

@Transactional
@Repository("daftarTarif")
public class DaftarTarifDao extends CommonDao {
	
	
	@Transactional
	public void saveDaftarTarif(DaftarTarif daftar) {
		super.entityManager.merge(daftar);
		
	}
	@Transactional
	@SuppressWarnings("unchecked")
	public DaftarTarif findById(Long id) {
		List<DaftarTarif> lstTarif = super.entityManager.createQuery(""+
				"FROM DaftarTarif where idDaftar=:idtarif").setParameter("idtarif", id).getResultList();
		if(lstTarif.size() == 0) {
			return new DaftarTarif();
		}
		else {
			return lstTarif.get(0);
		}
		
	}
	
	@Transactional
	public DaftarTarif getAllMerchant(String merchant) {
		StringBuilder sql = new StringBuilder();
		sql.append("FROM DaftarTarif ");
		if(merchant != null || merchant =="") {
			sql.append(" where merchantApiKey.merchantApiKey =:merchant");
		}
		Object lstTarif = super.entityManager.createQuery(sql.toString()).setParameter("merchant",merchant).getSingleResult();
		DaftarTarif daf = (DaftarTarif) lstTarif;
		
		return daf;
		
	}

	
	@Transactional
	public void delete(Long id) throws Exception {
		DaftarTarif mer = findById(id);
		if(mer.getMerchantApiKey()!= null) {
			super.entityManager.remove(mer);
		}
		else {
			throw new Exception("Delete Gagal");
		}
	}
	
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<DaftarTarif> getAll() {
		List<DaftarTarif> lstTarif = super.entityManager.createQuery(""+
				"FROM DaftarTarif ").getResultList();
		if(lstTarif.size() == 0) {
			return lstTarif;
		}
		else {
			return lstTarif;
		}
		
	}
	
	


}
