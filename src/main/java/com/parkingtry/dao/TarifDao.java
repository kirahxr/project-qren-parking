package com.parkingtry.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.parkingtry.model.Tarif;

@Repository("tarif")
@Transactional
public class TarifDao extends CommonDao {
	@Transactional
	public Tarif saveTarif(Tarif tarif) {
		
		return super.entityManager.merge(tarif);
	}
	@Transactional
	@SuppressWarnings("unchecked")
	public Tarif findById(Long id) {
		List<Tarif> lstTarif = super.entityManager.createQuery(""+
				"FROM Tarif where idTarif=:idtarif").setParameter("idtarif", id).getResultList();
		if(lstTarif.size() == 0) {
			return new Tarif();
		}
		else {
			return lstTarif.get(0);
		}
	}
	
	public void deleteTarif(Long id) throws Exception {
		Tarif tar = findById(id);
		if(tar.getIdTarif()!= null) {
			super.entityManager.remove(tar);
		}
		else {
			throw new Exception("Delete Gagal");
		}
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Tarif> getAll() {
		List<Tarif> lstTarif = super.entityManager.createQuery(""+
				"FROM Tarif").getResultList();
		if(lstTarif.size() == 0) {
			return lstTarif;
		}
		else {
			return lstTarif;
		}
	}
}
